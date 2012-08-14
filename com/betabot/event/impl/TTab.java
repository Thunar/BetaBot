package com.betabot.event.impl;

import com.betabot.script.api.Game;
import com.betabot.utils.StringUtil;

import com.betabot.bot.Bot;
import com.betabot.event.listeners.TextPaintListener;

import java.awt.*;

public class TTab implements TextPaintListener {

	private final Game game;

	public TTab(Bot bot) {
		game = bot.getMethodContext().game;
	}

	public int drawLine(final Graphics render, int idx) {
		final int cTab = game.getCurrentTab();
		StringUtil.drawLine(render, idx++,
				"Current Tab: " + cTab + (cTab != -1 ? " (" + Game.TAB_NAMES[cTab] + ")" : ""));
		return idx;
	}

}
