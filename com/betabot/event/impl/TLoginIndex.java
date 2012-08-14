package com.betabot.event.impl;

import com.betabot.script.api.Game;
import com.betabot.utils.StringUtil;

import com.betabot.bot.Bot;
import com.betabot.event.listeners.TextPaintListener;

import java.awt.*;

public class TLoginIndex implements TextPaintListener {

	private final Game game;

	public TLoginIndex(Bot bot) {
		game = bot.getMethodContext().game;
	}

	public int drawLine(final Graphics render, int idx) {
		StringUtil.drawLine(render, idx++, "Client State: " + game.getClientState());
		return idx;
	}

}
