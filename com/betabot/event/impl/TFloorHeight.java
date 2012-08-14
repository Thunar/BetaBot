package com.betabot.event.impl;

import com.betabot.script.api.Game;
import com.betabot.utils.StringUtil;

import com.betabot.bot.Bot;
import com.betabot.event.listeners.TextPaintListener;

import java.awt.*;

public class TFloorHeight implements TextPaintListener {

	private final Game game;

	public TFloorHeight(Bot bot) {
		game = bot.getMethodContext().game;
	}

	public int drawLine(final Graphics render, int idx) {
		final int floor = game.getPlane();
		StringUtil.drawLine(render, idx++, "Floor " + floor);
		return idx;
	}

}
