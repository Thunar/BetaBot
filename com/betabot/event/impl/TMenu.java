package com.betabot.event.impl;

import com.betabot.utils.StringUtil;

import com.betabot.bot.Bot;
import com.betabot.client.Client;
import com.betabot.event.listeners.TextPaintListener;

import java.awt.*;

public class TMenu implements TextPaintListener {

	private final Client client;

	public TMenu(Bot bot) {
		client = bot.getClient();
	}

	public int drawLine(Graphics render, int idx) {
		StringUtil.drawLine(render, idx++, "Menu " + (client.isMenuOpen() ? "Open" : "Closed") +
				" & " + (client.isMenuCollapsed() ? "Collapsed" : "Expanded"));
		StringUtil.drawLine(render, idx++, "Menu Location: (" +
				client.getMenuX() + "," + client.getMenuY() + ")");
		StringUtil.drawLine(render, idx++, "Sub-Menu Location: (" +
				client.getSubMenuX() + "," + client.getSubMenuY() + ")");
		StringUtil.drawLine(render, idx++, "Sub-Menu Width: " + client.getSubMenuWidth());
		return idx;
	}
}
