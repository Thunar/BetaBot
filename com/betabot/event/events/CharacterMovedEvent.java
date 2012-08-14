package com.betabot.event.events;

import com.betabot.script.api.MethodContext;

import com.betabot.event.EventMulticaster;
import com.betabot.event.listeners.CharacterMovedListener;

import java.util.EventListener;

/**
 * A character moved event.
 */
public class CharacterMovedEvent extends RSEvent {

	private static final long serialVersionUID = 8883312847545757405L;

	private final MethodContext ctx;
	private final com.betabot.client.RSCharacter character;
	private final int direction;
	private com.betabot.script.wrappers.RSCharacter wrapped;

	public CharacterMovedEvent(final MethodContext ctx, final com.betabot.client.RSCharacter character, final int direction) {
		this.ctx = ctx;
		this.character = character;
		this.direction = direction;
	}

	@Override
	public void dispatch(final EventListener el) {
		((CharacterMovedListener) el).characterMoved(this);
	}

	public com.betabot.script.wrappers.RSCharacter getCharacter() {
		if (wrapped == null) {
			if (character instanceof com.betabot.client.RSNPC) {
				final com.betabot.client.RSNPC npc = (com.betabot.client.RSNPC) character;
				wrapped = new com.betabot.script.wrappers.RSNPC(ctx, npc);
			} else if (character instanceof com.betabot.client.RSPlayer) {
				final com.betabot.client.RSPlayer player = (com.betabot.client.RSPlayer) character;
				wrapped = new com.betabot.script.wrappers.RSPlayer(ctx, player);
			}
		}
		return wrapped;
	}

	/**
	 * 0 = NW
	 * 1 = N
	 * 2 = NE
	 * 3 = W
	 * 4 = E
	 * 5 = SW
	 * 6 = S
	 * 7 = SE
	 *
	 * @return Returns the direction of the character movement event.
	 */
	public int getDirection() {
		return direction;
	}

	@Override
	public long getMask() {
		return EventMulticaster.CHARACTER_MOVED_EVENT;
	}
}
