package com.betabot.event.impl;

import com.betabot.script.api.MethodContext;
import com.betabot.utils.StringUtil;

import com.betabot.bot.Bot;
import com.betabot.event.listeners.TextPaintListener;

import java.awt.*;

public class TAnimation implements TextPaintListener {

	private final MethodContext ctx;

	public TAnimation(Bot bot) {
		ctx = bot.getMethodContext();
	}

	public int drawLine(final Graphics render, int idx) {
		int animation;
		if (ctx.game.isLoggedIn()) {
			animation = ctx.players.getMyPlayer().getAnimation();
		} else {
			animation = -1;
		}
		StringUtil.drawLine(render, idx++, "Animation " + animation);
		return idx;
	}

}
