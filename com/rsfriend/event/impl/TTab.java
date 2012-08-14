package com.rsfriend.event.impl;

import com.rsfriend.script.api.Game;
import com.rsfriend.utils.StringUtil;

import com.rsfriend.bot.Bot;
import com.rsfriend.event.listeners.TextPaintListener;

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
