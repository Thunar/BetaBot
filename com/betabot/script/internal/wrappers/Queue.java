package com.betabot.script.internal.wrappers;

import com.betabot.client.NodeSubQueue;

@SuppressWarnings("unchecked")
public class Queue<N extends com.betabot.client.NodeSub> {

	private final NodeSubQueue nl;
	private com.betabot.client.NodeSub current;

	public Queue(NodeSubQueue nl) {
		this.nl = nl;
	}

	public int size() {
		int size = 0;
		com.betabot.client.NodeSub node = nl.getTail().getPrevSub();

		while (node != nl.getTail()) {
			node = node.getPrevSub();
			size++;
		}

		return size;
	}

	public N getHead() {
		com.betabot.client.NodeSub node = nl.getTail().getNextSub();

		if (node == nl.getTail()) {
			current = null;
			return null;
		}
		current = node.getNextSub();

		return (N) node;
	}

	public N getNext() {
		com.betabot.client.NodeSub node = current;

		if (node == nl.getTail()) {
			current = null;
			return null;
		}
		current = node.getNextSub();

		return (N) node;
	}

}
