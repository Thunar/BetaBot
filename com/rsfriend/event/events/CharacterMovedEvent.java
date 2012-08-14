package com.rsfriend.event.events;

import com.rsfriend.script.api.MethodContext;

import com.rsfriend.event.EventMulticaster;
import com.rsfriend.event.listeners.CharacterMovedListener;

import java.util.EventListener;

/**
 * A character moved event.
 */
public class CharacterMovedEvent extends RSEvent {

	private static final long serialVersionUID = 8883312847545757405L;

	private final MethodContext ctx;
	private final com.rsfriend.client.RSCharacter character;
	private final int direction;
	private com.rsfriend.script.wrappers.RSCharacter wrapped;

	public CharacterMovedEvent(final MethodContext ctx, final com.rsfriend.client.RSCharacter character, final int direction) {
		this.ctx = ctx;
		this.character = character;
		this.direction = direction;
	}

	@Override
	public void dispatch(final EventListener el) {
		((CharacterMovedListener) el).characterMoved(this);
	}

	public com.rsfriend.script.wrappers.RSCharacter getCharacter() {
		if (wrapped == null) {
			if (character instanceof com.rsfriend.client.RSNPC) {
				final com.rsfriend.client.RSNPC npc = (com.rsfriend.client.RSNPC) character;
				wrapped = new com.rsfriend.script.wrappers.RSNPC(ctx, npc);
			} else if (character instanceof com.rsfriend.client.RSPlayer) {
				final com.rsfriend.client.RSPlayer player = (com.rsfriend.client.RSPlayer) character;
				wrapped = new com.rsfriend.script.wrappers.RSPlayer(ctx, player);
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
