package com.rsfriend.event.impl;

import com.rsfriend.script.api.Menu;
import com.rsfriend.utils.StringUtil;

import com.rsfriend.bot.Bot;
import com.rsfriend.event.listeners.TextPaintListener;

import java.awt.*;

public class TMenuActions implements TextPaintListener {

	private final Menu menu;

	public TMenuActions(Bot bot) {
		menu = bot.getMethodContext().menu;
	}

	public int drawLine(final Graphics render, int idx) {
		final String[] items = menu.getItems();
		int i = 0;
		for (final String item : items) {
			StringUtil.drawLine(render, idx++, i++ + ": [red]" + item);
		}
		return idx;
	}
}
