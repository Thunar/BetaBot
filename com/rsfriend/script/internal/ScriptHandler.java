package com.rsfriend.script.internal;

import com.rsfriend.script.Script;
import com.rsfriend.script.ScriptManifest;
import com.rsfriend.script.internal.event.ScriptListener;
import com.rsfriend.script.randoms.*;
import com.rsfriend.bot.Bot;


import java.util.*;

public class ScriptHandler {

	private final ArrayList<com.rsfriend.script.Random> randoms = new ArrayList<com.rsfriend.script.Random>();
	private final HashMap<Integer, Script> scripts = new HashMap<Integer, Script>();
	private final HashMap<Integer, Thread> scriptThreads = new HashMap<Integer, Thread>();

	private final Set<ScriptListener> listeners = Collections.synchronizedSet(new HashSet<ScriptListener>());

	private final Bot bot;

	public ScriptHandler(Bot bot) {
		this.bot = bot;
	}

	public void addScriptListener(ScriptListener l) {
		listeners.add(l);
	}

	public void removeScriptListener(ScriptListener l) {
		listeners.remove(l);
	}

	private void addScriptToPool(Script ss, Thread t) {
		for (int off = 0; off < scripts.size(); ++off) {
			if (!scripts.containsKey(off)) {
				scripts.put(off, ss);
				ss.setID(off);
				scriptThreads.put(off, t);
				return;
			}
		}
		ss.setID(scripts.size());
		scripts.put(scripts.size(), ss);
		scriptThreads.put(scriptThreads.size(), t);
	}

	public Bot getBot() {
		return bot;
	}

	public Collection<com.rsfriend.script.Random> getRandoms() {
		return randoms;
	}

	public Map<Integer, Script> getRunningScripts() {
		return Collections.unmodifiableMap(scripts);
	}

	public void pauseScript(int id) {
		Script s = scripts.get(id);
		s.setPaused(!s.isPaused());
		if (s.isPaused()) {
			for (ScriptListener l : listeners) {
				l.scriptPaused(this, s);
			}
		} else {
			for (ScriptListener l : listeners) {
				l.scriptResumed(this, s);
			}
		}
	}

	public void stopScript(int id) {
		Script script = scripts.get(id);
		if (script != null) {
			script.deactivate(id);
			scripts.remove(id);
			scriptThreads.remove(id);
			for (ScriptListener l : listeners) {
				l.scriptStopped(this, script);
			}
		}
	}

	public boolean onBreak(int id) {
		Script script = scripts.get(id);
		return script != null && script.onBreakStart();
	}

	public void onBreakConclude(int id) {
		Script script = scripts.get(id);
		if (script != null) {
			script.onBreakFinish();
		}
	}

	public void runScript(Script script) {
		script.init(bot.getMethodContext());
		for (ScriptListener l : listeners) {
			l.scriptStarted(this, script);
		}
		ScriptManifest prop = script.getClass().getAnnotation(ScriptManifest.class);
		Thread t = new Thread(script, "Script-" + prop.name());
		addScriptToPool(script, t);
		t.start();
	}

	public void stopAllScripts() {
		for (int i : scripts.keySet()) {
			stopScript(i);
		}
	}

	public void stopScript() {
		Thread curThread = Thread.currentThread();
		for (int i = 0; i < scripts.size(); i++) {
			Script script = scripts.get(i);
			if (script != null && script.isRunning()) {
				if (scriptThreads.get(i) == curThread) {
					stopScript(i);
				}
			}
		}
		if (curThread == null) {
			throw new ThreadDeath();
		}
	}

	public boolean onBreak() {
		Thread curThread = Thread.currentThread();
		for (int i = 0; i < scripts.size(); i++) {
			Script script = scripts.get(i);
			if (script != null && script.isRunning()) {
				if (scriptThreads.get(i) == curThread) {
					return onBreak(i);
				}
			}
		}
		if (curThread == null) {
			throw new ThreadDeath();
		}
		return false;
	}

	public void onBreakResume() {
		Thread curThread = Thread.currentThread();
		for (int i = 0; i < scripts.size(); i++) {
			Script script = scripts.get(i);
			if (script != null && script.isRunning()) {
				if (scriptThreads.get(i) == curThread) {
					onBreakConclude(i);
					return;
				}
			}
		}
		if (curThread == null) {
			throw new ThreadDeath();
		}
	}

	public void updateInput(Bot bot, int mask) {
		for (ScriptListener l : listeners) {
			l.inputChanged(bot, mask);
		}
	}

}
