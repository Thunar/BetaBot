package com.rsfriend.script.internal.event;

import com.rsfriend.script.Script;
import com.rsfriend.script.internal.ScriptHandler;

import com.rsfriend.bot.Bot;

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
