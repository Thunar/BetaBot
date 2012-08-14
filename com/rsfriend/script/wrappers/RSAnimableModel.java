package com.rsfriend.script.wrappers;

import com.rsfriend.client.Model;
import com.rsfriend.client.RSAnimable;
import com.rsfriend.script.api.MethodContext;

/**
 * @author Jacmob
 */
class RSAnimableModel extends RSModel {

	private final RSAnimable animable;

	RSAnimableModel(MethodContext ctx, Model model, RSAnimable animable) {
		super(ctx, model);
		this.animable = animable;
	}

	protected void update() {

	}

	@Override
	protected int getLocalX() {
		return animable.getX();
	}

	@Override
	protected int getLocalY() {
		return animable.getY();
	}

}
