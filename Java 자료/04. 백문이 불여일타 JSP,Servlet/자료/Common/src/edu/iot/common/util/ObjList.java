package edu.iot.common.util;

public interface ObjList<E> {
	void add(E obj);
	void add(int index, E obj);
	E get(int index);
	void set(int index, E obj);
	E remove(int index);
	int size();
	void print();
}
