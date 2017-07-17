package com.srikanth.ds.linkedlist;

public class SLLNode {
	
	private String data;
	private SLLNode next;
	
	public SLLNode(String data) {
		super();
		this.data = data;
		this.next = null;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public SLLNode getNext() {
		return next;
	}
	public void setNext(SLLNode next) {
		this.next = next;
	}
	
}
