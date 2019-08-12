package com.util.immutablequeue.impl;

import com.util.immutablequeue.api.Queue;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Purpose -> For testing ImmutableQueue class
 * @author Indrajith G R Aug 8, 2019 11:25:40 AM
 */
public class ImmutableQueueTest extends TestCase{
	private Queue<Integer> immutableQueue = new ImmutableQueue<>();
	/**
     * @return the suite with current test class
     */
    public static TestSuite suite() {
    	return new TestSuite(ImmutableQueueTest.class);
    }
    
	/**
	 * Checking immutability by verifying the reference after method calls
	 */
	public void test_Immutability() {
		Queue<Integer> immutableQueueAfterEnQueue = immutableQueue.enQueue(1);
		/** verifying enqueue method */
		assertFalse(immutableQueueAfterEnQueue == immutableQueue);
		/** verifying dequeue method */
		Queue<Integer> immutableQueueAfterdeQueue = immutableQueueAfterEnQueue.deQueue();
		assertFalse(immutableQueueAfterEnQueue == immutableQueueAfterdeQueue);
	}

	/**
	 * For testing enqueue empty and head check
	 */
	public void test_Enqueue() {
		/** adding items into queue*/
		immutableQueue = immutableQueue.enQueue(1).enQueue(2);
		/** checking not empty condition*/
		assertFalse(immutableQueue.isEmpty());
		/** confirming position of entry */
		assertTrue(immutableQueue.head().equals(1));
	}
	
	/**
	 * For testing queue empty and non empty conditions
	 */
	public void test_isEmpty() {
		/** empty condition */
		assertTrue(immutableQueue.isEmpty());
		immutableQueue = immutableQueue.enQueue(1);
		/** non empty condition */
		assertFalse(immutableQueue.isEmpty());
	}
	
	/**
	 * For testing head method with empty and multiple entry conditions
	 */
	public void test_head() {
		/** null when queue is empty */
		assertNull(immutableQueue.head());
		immutableQueue = immutableQueue.enQueue(2).enQueue(1);
		assertTrue(immutableQueue.head().equals(2));
	}
	
	/**
	 * For testing deQueue method with multiple entry conditions
	 */
	public void test_deQueue() {
		immutableQueue = immutableQueue.enQueue(5).enQueue(10).enQueue(20);
		assertFalse(immutableQueue.isEmpty());
		immutableQueue = immutableQueue.deQueue();
		assertFalse(immutableQueue.isEmpty());
		assertTrue(immutableQueue.head().equals(10));
		immutableQueue = immutableQueue.deQueue();
		assertFalse(immutableQueue.isEmpty());
		immutableQueue = immutableQueue.deQueue();
		assertTrue(immutableQueue.isEmpty());
	}
}
