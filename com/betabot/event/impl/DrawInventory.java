package com.betabot.event.impl;

import com.betabot.script.api.Game;
import com.betabot.script.api.MethodContext;
import com.betabot.script.wrappers.RSItem;

import com.betabot.bot.Bot;
import com.betabot.event.listeners.PaintListener;

import java.awt.*;

public class DrawInventory implements PaintListener {

	private final MethodContext ctx;

	public DrawInventory(Bot bot) {
		ctx = bot.getMethodContext();
	}

	public void onRepaint(final Graphics render) {
		if (!ctx.game.isLoggedIn()) {
			return;
		}

		if (ctx.game.getCurrentTab() != Game.TAB_INVENTORY) {
			return;
		}

		render.setColor(Color.WHITE);
		final RSItem[] inventoryItems = ctx.inventory.getItems();

		for (RSItem inventoryItem : inventoryItems) {
			if (inventoryItem.getID() != -1) {
				final Point location = inventoryItem.getComponent().getCenter();
				render.drawString("" + inventoryItem.getID(), location.x, location.y);
			}
		}
	}
}
