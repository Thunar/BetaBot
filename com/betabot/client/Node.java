package com.betabot.client;

public interface Node {

	long getID();

	Node getNext();

	Node getPrevious();

}
