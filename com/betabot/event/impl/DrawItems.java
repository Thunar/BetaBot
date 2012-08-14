package com.betabot.event.impl;

import com.betabot.script.api.MethodContext;
import com.betabot.script.wrappers.RSGroundItem;
import com.betabot.script.wrappers.RSModel;
import com.betabot.script.wrappers.RSPlayer;
import com.betabot.script.wrappers.RSTile;

import com.betabot.bot.Bot;
import com.betabot.event.listeners.PaintListener;

import java.awt.*;

public class DrawItems implements PaintListener {

	private final MethodContext ctx;

	public DrawItems(Bot bot) {
		ctx = bot.getMethodContext();
	}

	public void onRepaint(final Graphics render) {
		if (!ctx.game.isLoggedIn()) {
			return;
		}
		final RSPlayer player = ctx.players.getMyPlayer();
		if (player == null) {
			return;
		}
		final FontMetrics metrics = render.getFontMetrics();
		final RSTile location = player.getLocation();
		final int locX = location.getX();
		final int locY = location.getY();
		final int tHeight = metrics.getHeight();
		for (int x = locX - 25; x < locX + 25; x++) {
			for (int y = locY - 25; y < locY + 25; y++) {
				final Point screen = ctx.calc.tileToScreen(new RSTile(x, y));
				if (!ctx.calc.pointOnScreen(screen)) {
					continue;
				}
				final RSGroundItem[] items = ctx.groundItems.getAllAt(x, y);
				if (items.length > 0) {
					RSModel model = items[0].getModel();
					if (model != null) {
						render.setColor(Color.BLUE);
						for (Polygon polygon : model.getTriangles()) {
							render.drawPolygon(polygon);
						}
					}
				}
				for (int i = 0; i < items.length; i++) {
					render.setColor(Color.RED);
					render.fillRect((int) screen.getX() - 1, (int) screen.getY() - 1, 2, 2);
					final String s = "" + items[i].getItem().getID();
					final int ty = screen.y - tHeight * (i + 1) + tHeight / 2;
					final int tx = screen.x - metrics.stringWidth(s) / 2;
					render.setColor(Color.green);
					render.drawString(s, tx, ty);
				}
			}
		}
	}
}
