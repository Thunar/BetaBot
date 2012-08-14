package com.rsfriend.script.internal.wrappers;

class StatusQueue {

	private final com.rsfriend.client.StatusNodeList nl;
	private com.rsfriend.client.StatusNode c_node;

	public StatusQueue(final com.rsfriend.client.StatusNodeList nl) {
		this.nl = nl;
	}

	public com.rsfriend.client.StatusNode getFirst() {
		final com.rsfriend.client.StatusNode node = nl.getHead().getNext();

		if (node == nl.getHead()) {
			c_node = null;
			return null;
		}
		c_node = node.getNext();

		return node;
	}

	public com.rsfriend.client.StatusNode getLast() {
		final com.rsfriend.client.StatusNode node = nl.getHead().getPrevious();

		if (node == nl.getHead()) {
			c_node = null;
			return null;
		}
		c_node = node.getPrevious();

		return node;
	}

	public com.rsfriend.client.StatusNode getNext() {
		final com.rsfriend.client.StatusNode node = c_node;

		if (node == nl.getHead() || node == null) {
			c_node = null;
			return null;
		}
		c_node = node.getNext();

		return node;
	}

	public com.rsfriend.client.StatusNode getPrevious() {
		final com.rsfriend.client.StatusNode node = c_node;

		if (node == nl.getHead() || node == null) {
			c_node = null;
			return null;
		}
		c_node = node.getNext();

		return node;
	}

	public int size() {
		int size = 0;
		com.rsfriend.client.StatusNode node = nl.getHead().getPrevious();

		while (node != nl.getHead()) {
			node = node.getPrevious();
			size++;
		}

		return size;
	}

}
