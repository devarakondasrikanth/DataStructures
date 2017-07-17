package com.srikanth.ds.linkedlist;

import java.util.UUID;

public class SLLNodeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLLNode sllNode = null;
		SingleLinkedList sll = new SingleLinkedList();
		for(int i=1;i<=5000;i++){
			sllNode = sll.fillWithData(sllNode,UUID.randomUUID().toString());
		}
		
		sll.printAllNodes(sllNode);
		
		System.out.println("No of nodes in the linked list are "+sll.countNodes(sllNode));
	}

}
