package com.rsfriend.event.impl;


import com.rsfriend.event.events.CharacterMovedEvent;
import com.rsfriend.event.listeners.CharacterMovedListener;

import java.util.logging.Logger;

public class CharacterMovedLogger implements CharacterMovedListener {

	private final Logger log = Logger.getLogger(CharacterMovedLogger.class.getName());

	public void characterMoved(final CharacterMovedEvent e) {
		log.info("Character Moved: " + String.format("%2d %s", e.getDirection(), e.getCharacter().toString()));
	}
}
