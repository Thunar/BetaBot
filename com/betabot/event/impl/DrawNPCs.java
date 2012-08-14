package com.betabot.event.impl;

import com.betabot.script.api.MethodContext;
import com.betabot.script.wrappers.RSNPC;

import com.betabot.bot.Bot;
import com.betabot.client.Node;
import com.betabot.client.RSNPCNode;
import com.betabot.event.listeners.PaintListener;

import java.awt.*;

public class DrawNPCs implements PaintListener {

	private final MethodContext ctx;

	public DrawNPCs(Bot bot) {
		ctx = bot.getMethodContext();
	}

	public void onRepaint(final Graphics render) {
		if (!ctx.game.isLoggedIn()) {
			return;
		}

		final FontMetrics metrics = render.getFontMetrics();
		for (int element : ctx.client.getRSNPCIndexArray()) {
			Node node = ctx.nodes.lookup(ctx.client.getRSNPCNC(), element);
			if (node == null || !(node instanceof RSNPCNode)) {
				continue;
			}
			final RSNPC npc = new RSNPC(ctx, ((RSNPCNode) node).getRSNPC());
			final Point location = ctx.calc.tileToScreen(npc.getLocation(), npc.getHeight() / 2);
			if (!ctx.calc.pointOnScreen(location)) {
				continue;
			}
			render.setColor(Color.RED);
			render.fillRect((int) location.getX() - 1, (int) location.getY() - 1, 2, 2);
			String s = "" + npc.getID();
			render.setColor(npc.isInCombat() ? Color.red : npc.isMoving() ? Color.green : Color.WHITE);
			render.drawString(s, location.x - metrics.stringWidth(s) / 2, location.y - metrics.getHeight() / 2);
			// int x = element.getX();
			// x -= ((int)(x >> 7)) << 7;
			if (npc.getAnimation() != -1 || npc.getGraphic() != -1) {
				s = "(A: " + npc.getAnimation() + " | G: " + npc.getGraphic() + " | L: " + npc.getLevel() +")";
				render.drawString(s, location.x - metrics.stringWidth(s) / 2, location.y - metrics.getHeight() * 3 / 2);
			}
			// s = "" + element.isMoving();
			// render.drawString(s, location.x - metrics.stringWidth(s) / 2,
			// location.y - metrics.getHeight() * 5 / 2);
		}
	}
}
