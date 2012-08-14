package com.BetaBot.client;

public interface Cache {

	HashTable getTable();

	int getInitialCount();

	int getSpaceLeft();

	NodeSubQueue getList();
}
