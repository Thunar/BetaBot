package com.betabot.event.listeners;

import com.betabot.event.events.ServerMessageEvent;

import java.util.EventListener;

@Deprecated
public interface ServerMessageListener extends EventListener {
	abstract void serverMessageRecieved(ServerMessageEvent e);
}
