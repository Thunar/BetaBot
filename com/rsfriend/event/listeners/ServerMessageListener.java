package com.rsfriend.event.listeners;

import com.rsfriend.event.events.ServerMessageEvent;

import java.util.EventListener;

@Deprecated
public interface ServerMessageListener extends EventListener {
	abstract void serverMessageRecieved(ServerMessageEvent e);
}
