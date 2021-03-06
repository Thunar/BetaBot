package com.betabot.script.wrappers;

/**
 * An item definition.
 */
public class RSItemDef {
	private final com.betabot.client.RSItemDef id;

	public RSItemDef(final com.betabot.client.RSItemDef id) {
		this.id = id;
	}

	public String[] getActions() {
		return id.getActions();
	}

	public String[] getGroundActions() {
		return id.getGroundActions();
	}

	public String getName() {
		return id.getName();
	}

	public boolean isMembers() {
		return id.isMembersObject();
	}

}
