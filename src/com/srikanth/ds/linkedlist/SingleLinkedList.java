package com.srikanth.ds.linkedlist;

public class SingleLinkedList {

	public SLLNode fillWithData(SLLNode linkedList, String data) {
		SLLNode tempList = null;
		if (linkedList == null) {
			linkedList = new SLLNode(data);
			return linkedList;
		} else {
			tempList = linkedList;
			if (linkedList.getNext() == null) {
				linkedList.setNext(new SLLNode(data));
			} else {
				while (linkedList.getNext() != null) {
					linkedList = linkedList.getNext();
				}
				linkedList.setNext(new SLLNode(data));
			}
			return tempList;
		}

	}
	
	public int countNodes(SLLNode linkedList){
		SLLNode tempList = linkedList;
		int count = 0;
		while (tempList != null){
			tempList = tempList.getNext();
			count++;
		}
		return count;
		
	}
	
	public void printAllNodes(SLLNode linkedList){
		SLLNode sllNode = linkedList;
		System.out.println("printing all nodes data");		
		while(sllNode != null){
			System.out.println(sllNode.getData()+"->");
			sllNode = sllNode.getNext();
		}
		System.out.println("null");
	}

}
