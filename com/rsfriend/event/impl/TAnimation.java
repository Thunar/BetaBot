package com.rsfriend.event.impl;

import com.rsfriend.script.api.MethodContext;
import com.rsfriend.utils.StringUtil;

import com.rsfriend.bot.Bot;
import com.rsfriend.event.listeners.TextPaintListener;

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
