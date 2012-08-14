package com.rsfriend.script.internal.wrappers;

public class HashTable {

	private final com.rsfriend.client.HashTable nc;
	private com.rsfriend.client.Node current;
	private int c_index = 0;

	public HashTable(com.rsfriend.client.HashTable hashTable) {
		nc = hashTable;
	}

	public com.rsfriend.client.Node getFirst() {
		c_index = 0;
		return getNext();
	}

	public com.rsfriend.client.Node getNext() {
		if (c_index > 0 && nc.getBuckets()[c_index - 1] != current) {
			com.rsfriend.client.Node node = current;
			current = node.getPrevious();
			return node;
		}
		while (c_index < nc.getBuckets().length) {
			com.rsfriend.client.Node node = nc.getBuckets()[c_index++].getPrevious();
			if (nc.getBuckets()[c_index - 1] != node) {
				current = node.getPrevious();
				return node;
			}
		}
		return null;
	}
}
