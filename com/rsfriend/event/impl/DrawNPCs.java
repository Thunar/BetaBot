package com.rsfriend.event.impl;

import com.rsfriend.script.api.MethodContext;
import com.rsfriend.script.wrappers.RSNPC;

import com.rsfriend.bot.Bot;
import com.rsfriend.client.Node;
import com.rsfriend.client.RSNPCNode;
import com.rsfriend.event.listeners.PaintListener;

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
