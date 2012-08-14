package com.betabot.client;

public interface Cache {

	HashTable getTable();

	int getInitialCount();

	int getSpaceLeft();

	NodeSubQueue getList();
}
