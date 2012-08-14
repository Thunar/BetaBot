package com.rsfriend.script.wrappers;

import com.rsfriend.client.Model;
import com.rsfriend.client.RSObject;
import com.rsfriend.script.api.MethodContext;

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
