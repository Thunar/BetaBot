package com.rsfriend.event.impl;

import com.rsfriend.utils.StringUtil;

import com.rsfriend.bot.Bot;
import com.rsfriend.client.Client;
import com.rsfriend.event.listeners.TextPaintListener;

import java.awt.*;

public class TCamera implements TextPaintListener {

	private final Client client;

	public TCamera(Bot bot) {
		client = bot.getClient();
	}

	public int drawLine(final Graphics render, int idx) {
		final String camPos = "Camera Position (x,y,z): (" + client.getCamPosX() + ", " + client.getCamPosY() + ", " + client.getCamPosZ() + ")";
		final String camAngle = "Camera Angle (pitch, yaw): (" + client.getCameraPitch() + ", " + client.getCameraYaw() + ")";
		//final String detailLvl = "Detail lvl: " + (client.getDetailInfo() != null ? client.getDetailInfo().getDetailLevel() : "null");

		StringUtil.drawLine(render, idx++, camPos);
		StringUtil.drawLine(render, idx++, camAngle);
		//Methods.drawLine(render, idx++, detailLvl);
		return idx;
	}
}
