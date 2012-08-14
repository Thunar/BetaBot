package com.betabot.script.internal.wrappers;

class StatusQueue {

	private final com.betabot.client.StatusNodeList nl;
	private com.betabot.client.StatusNode c_node;

	public StatusQueue(final com.betabot.client.StatusNodeList nl) {
		this.nl = nl;
	}

	public com.betabot.client.StatusNode getFirst() {
		final com.betabot.client.StatusNode node = nl.getHead().getNext();

		if (node == nl.getHead()) {
			c_node = null;
			return null;
		}
		c_node = node.getNext();

		return node;
	}

	public com.betabot.client.StatusNode getLast() {
		final com.betabot.client.StatusNode node = nl.getHead().getPrevious();

		if (node == nl.getHead()) {
			c_node = null;
			return null;
		}
		c_node = node.getPrevious();

		return node;
	}

	public com.betabot.client.StatusNode getNext() {
		final com.betabot.client.StatusNode node = c_node;

		if (node == nl.getHead() || node == null) {
			c_node = null;
			return null;
		}
		c_node = node.getNext();

		return node;
	}

	public com.betabot.client.StatusNode getPrevious() {
		final com.betabot.client.StatusNode node = c_node;

		if (node == nl.getHead() || node == null) {
			c_node = null;
			return null;
		}
		c_node = node.getNext();

		return node;
	}

	public int size() {
		int size = 0;
		com.betabot.client.StatusNode node = nl.getHead().getPrevious();

		while (node != nl.getHead()) {
			node = node.getPrevious();
			size++;
		}

		return size;
	}

}
