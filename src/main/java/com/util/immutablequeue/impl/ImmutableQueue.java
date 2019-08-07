package com.util.immutablequeue.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.exceptions.CouldNotProcessOperationException;
import com.util.immutablequeue.api.Queue;

/**
 * Purpose -> Immutable queue based on api
 * @author Indrajith G R Aug 7, 2019 12:18:47 PM
 * @version 1.0.0.0
 * @param <T>
 */
public final class ImmutableQueue<T> implements Queue<T>, Serializable {
	private static final long serialVersionUID = -7242746504922349747L;
	private final ArrayList<T> queue;

	private ImmutableQueue(ArrayList<T> list) {
		super();
		this.queue = list;
	}

	public ImmutableQueue() {
		super();
		this.queue = null;
	}

	@Override
	public Queue<T> enQueue(T t) {
		ArrayList<T> list = new ArrayList<>();
		if(this.queue != null)
			list.addAll(this.queue);
		/** since the provided api does not throws any Exception I'm forced to log the message and returns an empty queue */
		if(t == null) {
			System.out.println("Could not process operation");
		}else
			list.add(t);
		return new ImmutableQueue<T>(list);
	}

	/**
	 * Removes the element at the beginning of the immutable queue and returns the new queue
	 */
	@Override
	public Queue<T> deQueue() {
		if (isEmpty()) {
			/** since the provided api does not throws any Exception I'm forced to log the message and returns an empty queue */
			System.out.println("Could not process request ");
		}
		return (isEmpty() || queue.size() < 2) ? new ImmutableQueue<T>()
				: new ImmutableQueue<T>(new ArrayList<T>(queue.subList(1, queue.size() - 1)));
	}

	/**
	 * Since this is an immutable class, the queue always contains a list that
	 * contains a list of objects, which maintains an order of entry so object at index 0 will always be the head element
	 * If the queue is empty then returns null
	 */
	@Override
	public T head() {
		return isEmpty() ? null : queue.get(0);
	}

	/**
	 * returns true if the queue is empty else returns false
	 */
	@Override
	public boolean isEmpty() {
		return this.queue == null || this.queue.size() == 0 ? true : false;
	}

	/**
	 * To return the size of objects in the queue
	 * @return int
	 */
	public int getSize() {
		return isEmpty() ? 0 : this.queue.size();
	}

	/**
	 * Removes the head element if the queue is not empty
	 * if the queue contains only one element the returns an empty queue
	 * if the queue is already empty then throws exception
	 * @return Queue<T>
	 * @throws CouldNotProcessOperationException
	 */
	public Queue<T> remove() throws CouldNotProcessOperationException{
		if(isEmpty()) {
			throw new CouldNotProcessOperationException(new NoSuchElementException());
		}
		return queue.size() < 2 ? new ImmutableQueue<T>() : new ImmutableQueue<T>(new ArrayList<T>(queue.subList(1, queue.size() - 1)));
	}
}
