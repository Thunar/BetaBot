package com.betabot.event.impl;

import com.betabot.script.api.Players;
import com.betabot.script.wrappers.RSTile;
import com.betabot.utils.StringUtil;

import com.betabot.bot.Bot;
import com.betabot.event.listeners.TextPaintListener;

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
