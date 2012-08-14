package com.rsfriend.event.impl;

import com.rsfriend.script.api.Players;
import com.rsfriend.script.wrappers.RSTile;
import com.rsfriend.utils.StringUtil;

import com.rsfriend.bot.Bot;
import com.rsfriend.event.listeners.TextPaintListener;

import java.awt.*;

public class TPlayerPosition implements TextPaintListener {

	private final Players players;

	public TPlayerPosition(Bot bot) {
		players = bot.getMethodContext().players;
	}

	public int drawLine(final Graphics render, int idx) {
		final RSTile position = players.getMyPlayer().getLocation();
		StringUtil.drawLine(render, idx++, "Position: " + position);
		return idx;
	}

}
