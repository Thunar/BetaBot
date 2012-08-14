package com.betabot.script.wrappers;

import com.betabot.client.Model;
import com.betabot.client.RSObject;
import com.betabot.script.api.MethodContext;

class RSObjectModel extends RSModel {

	private final RSObject object;

	RSObjectModel(MethodContext ctx, Model model, RSObject object) {
		super(ctx, model);
		this.object = object;
	}

	protected void update() {

	}

	@Override
	protected int getLocalX() {
		return object.getX();
	}

	@Override
	protected int getLocalY() {
		return object.getY();
	}

}
