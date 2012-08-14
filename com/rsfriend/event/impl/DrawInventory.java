package com.rsfriend.event.impl;

import com.rsfriend.script.api.Game;
import com.rsfriend.script.api.MethodContext;
import com.rsfriend.script.wrappers.RSItem;

import com.rsfriend.bot.Bot;
import com.rsfriend.event.listeners.PaintListener;

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
