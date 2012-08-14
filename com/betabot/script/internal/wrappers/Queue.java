package com.rsfriend.script.internal.wrappers;

import com.rsfriend.client.NodeSubQueue;

@SuppressWarnings("unchecked")
public class Queue<N extends com.rsfriend.client.NodeSub> {

	private final NodeSubQueue nl;
	private com.rsfriend.client.NodeSub current;

	public Queue(NodeSubQueue nl) {
		this.nl = nl;
	}

	public int size() {
		int size = 0;
		com.rsfriend.client.NodeSub node = nl.getTail().getPrevSub();

		while (node != nl.getTail()) {
			node = node.getPrevSub();
			size++;
		}

		return size;
	}

	public N getHead() {
		com.rsfriend.client.NodeSub node = nl.getTail().getNextSub();

		if (node == nl.getTail()) {
			current = null;
			return null;
		}
		current = node.getNextSub();

		return (N) node;
	}

	public N getNext() {
		com.rsfriend.client.NodeSub node = current;

		if (node == nl.getTail()) {
			current = null;
			return null;
		}
		current = node.getNextSub();

		return (N) node;
	}

}
