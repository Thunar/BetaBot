package com.betabot.script.internal.wrappers;

import com.betabot.client.NodeDeque;

@SuppressWarnings("unchecked")
public class Deque<N> {

	private final NodeDeque nl;
	private com.betabot.client.Node current;

	public Deque(NodeDeque nl) {
		this.nl = nl;
	}

	public int size() {
		int size = 0;
		com.betabot.client.Node node = nl.getTail().getPrevious();

		while (node != nl.getTail()) {
			node = node.getPrevious();
			size++;
		}

		return size;
	}

	public N getHead() {
		com.betabot.client.Node node = nl.getTail().getNext();

		if (node == nl.getTail()) {
			current = null;
			return null;
		}
		current = node.getNext();

		return (N) node;
	}

	public N getTail() {
		com.betabot.client.Node node = nl.getTail().getPrevious();

		if (node == nl.getTail()) {
			current = null;
			return null;
		}
		current = node.getPrevious();

		return (N) node;
	}

	public N getNext() {
		com.betabot.client.Node node = current;

		if (node == nl.getTail()) {
			current = null;
			return null;
		}
		current = node.getNext();

		return (N) node;
	}

}
