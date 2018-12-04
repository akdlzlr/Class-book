package edu.iot.common.util;

public class ObjArrayList<E> implements ObjList<E> {
	final static int INIT_SIZE=10;
	private E[] data;
	private int size;
	
	public ObjArrayList() {
		data = (E[])(new Object[INIT_SIZE]);
	}
	
	public ObjArrayList(int size) {
		data = (E[])(new Object[size]);
	}
	
	@Override
	public void add(E obj) {
		data[size] = obj;
		size++;		
	}

	@Override
	public void add(int index, E obj) {
		// 범위에 따라 오른쪽으로 시프트		
		
		data[index] = obj;
		size++;
	}

	@Override
	public E get(int index) {
		return data[index];
	}

	@Override
	public void set(int index, E obj) {
		data[index] = obj;
	}

	@Override
	public E remove(int index) {
		E obj = data[index];
		// 범위에 따라 왼쪽으로 시프트
		
		
		size--;		
		return obj;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}
