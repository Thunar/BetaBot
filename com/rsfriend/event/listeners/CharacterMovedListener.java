/**
 *
 */
package com.rsfriend.event.listeners;

import com.rsfriend.event.events.CharacterMovedEvent;

import java.util.EventListener;

/**
 * @author Qauters
 */
public interface CharacterMovedListener extends EventListener {
	public void characterMoved(CharacterMovedEvent e);
}
