package com.betabot.service;

import com.betabot.script.Script;

import java.util.List;

/**
 * @author Jacmob
 */
public interface ScriptSource {

	List<ScriptDefinition> list();

	Script load(ScriptDefinition def) throws ServiceException;

}
