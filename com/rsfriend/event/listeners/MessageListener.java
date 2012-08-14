package com.rsfriend.event.listeners;

import com.rsfriend.event.events.MessageEvent;

import java.util.EventListener;

public interface MessageListener extends EventListener {
	abstract void messageReceived(MessageEvent e);
}
