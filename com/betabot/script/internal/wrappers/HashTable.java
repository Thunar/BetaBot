package com.betabot.script.internal.wrappers;

public class HashTable {

	private final com.betabot.client.HashTable nc;
	private com.betabot.client.Node current;
	private int c_index = 0;

	public HashTable(com.betabot.client.HashTable hashTable) {
		nc = hashTable;
	}

	public com.betabot.client.Node getFirst() {
		c_index = 0;
		return getNext();
	}

	public com.betabot.client.Node getNext() {
		if (c_index > 0 && nc.getBuckets()[c_index - 1] != current) {
			com.betabot.client.Node node = current;
			current = node.getPrevious();
			return node;
		}
		while (c_index < nc.getBuckets().length) {
			com.betabot.client.Node node = nc.getBuckets()[c_index++].getPrevious();
			if (nc.getBuckets()[c_index - 1] != node) {
				current = node.getPrevious();
				return node;
			}
		}
		return null;
	}
}
