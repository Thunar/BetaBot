package com.rsfriend.event.impl;

import com.rsfriend.utils.StringUtil;

import com.rsfriend.bot.Bot;
import com.rsfriend.client.Client;
import com.rsfriend.event.listeners.TextPaintListener;

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
