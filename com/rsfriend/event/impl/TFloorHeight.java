package com.rsfriend.event.impl;

import com.rsfriend.script.api.Game;
import com.rsfriend.utils.StringUtil;

import com.rsfriend.bot.Bot;
import com.rsfriend.event.listeners.TextPaintListener;

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
