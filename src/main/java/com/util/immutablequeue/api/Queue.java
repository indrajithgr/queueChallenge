package com.util.immutablequeue.api;

public interface Queue<T> {
	public Queue<T> enQueue(T t);
	public Queue<T> deQueue(T t);
	public T head();
	public boolean isEmpty();
}
