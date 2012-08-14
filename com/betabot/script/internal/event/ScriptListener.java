package com.betabot.script.internal.event;

import com.betabot.script.Script;
import com.betabot.script.internal.ScriptHandler;

import com.betabot.bot.Bot;

/**
 * @author Jacmob
 */
public interface ScriptListener {

	public void scriptStarted(ScriptHandler handler, Script script);

	public void scriptStopped(ScriptHandler handler, Script script);

	public void scriptResumed(ScriptHandler handler, Script script);

	public void scriptPaused(ScriptHandler handler, Script script);

	public void inputChanged(Bot bot, int mask);

}
