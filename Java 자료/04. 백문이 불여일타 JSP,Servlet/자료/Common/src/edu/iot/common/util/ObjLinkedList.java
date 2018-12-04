package edu.iot.common.util;

public class ObjLinkedList implements ObjList {

	private class Node {
		Object 	obj;	// 노드가 저장하는 데이터 객체
		Node	prev;	// 이전 Node 참조
		Node 	next;	// 다음 Node 참조
		
		Node(Object obj){
			this.obj = obj;
		}
	}
	
	Node head;	// 첫번째 Node를 참조하기 위한 더미 객체 
	Node tail;	// 마지막 Node 참조용
	int size;	// 저장하고 있는 노드의 개수 
	
	public ObjLinkedList() {
		head = new Node(null);
		head.prev = head;
		head.next = head;
		tail = head;	// 리스트가 비어있음을 의미
		size=0;
	}
	
	@Override
	public void add(Object obj) {
		// Node node = new Node(obj);
		
		add(size, obj);
//		tail.next = node;
//		node.prev = tail;
//		size++;
//		
//		// 마지막 노드 참조 변경
//		tail = node;
//		tail.next = head;
//		head.prev = tail;
	}

	@Override
	public void add(int index, Object obj) {
		Node node = new Node(obj);

		// index 위치의 Node 찾기
		Node cur = select(index);

		node.prev = cur.prev;
		cur.prev.next = node;
		
		node.next = cur;
		cur.prev = node;
		size++;
	}

	private Node select(int index) {
		Node cur = head.next;
		for(int i=0; i<index; i++) {
			cur = cur.next;
		}
		return cur;
	}
	
	@Override
	public Object get(int index) {
		Node cur = select(index);
		return cur.obj;
	}

	@Override
	public void set(int index, Object obj) {
		Node cur = select(index);
		cur.obj = obj;
	}

	@Override
	public Object remove(int index) {
		Node cur = select(index);

		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		
		size--;
		return cur.obj;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void print() {
		Node cur = head.next;
		
		while(cur!=head) {
			Object obj = cur.obj;
			System.out.print(obj + " ");
			cur = cur.next;
		}
		System.out.println();
		
		
	}

}
