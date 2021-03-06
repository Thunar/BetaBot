package com.betabot.event.impl;

import com.betabot.utils.StringUtil;

import com.betabot.bot.Bot;
import com.betabot.client.Client;
import com.betabot.client.input.Mouse;
import com.betabot.event.listeners.TextPaintListener;

import java.awt.*;

public class TMousePosition implements TextPaintListener {

	private final Client client;

	public TMousePosition(Bot bot) {
		client = bot.getClient();
	}

	public int drawLine(final Graphics render, int idx) {
		final Mouse mouse = client.getMouse();
		if (mouse != null) {
			final int mouse_x = mouse.getX();
			final int mouse_y = mouse.getY();
			String off = mouse.isPresent() ? "" : " (off)";
			StringUtil.drawLine(render, idx++, "Mouse Position: (" + mouse_x + "," + mouse_y + ")" + off);
		}

		return idx;
	}
}
