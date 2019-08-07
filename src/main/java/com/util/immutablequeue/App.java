package com.util.immutablequeue;

import com.util.immutablequeue.api.Queue;
import com.util.immutablequeue.impl.ImmutableQueue;

/**
 * Immutable Queue
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Immutable Queue!" );
        Queue<Integer> queue = new ImmutableQueue();
        queue = queue.enQueue(1);
        
    }
}
