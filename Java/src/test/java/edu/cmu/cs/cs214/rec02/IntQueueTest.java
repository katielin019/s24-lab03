package edu.cmu.cs.cs214.rec02;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;


/**
 * TODO: 
 * 1. The {@link LinkedIntQueue} has no bugs. We've provided you with some example test cases.
 * Write your own unit tests to test against IntQueue interface with specification testing method 
 * using mQueue = new LinkedIntQueue();
 * 
 * 2. 
 * Comment `mQueue = new LinkedIntQueue();` and uncomment `mQueue = new ArrayIntQueue();`
 * Use your test cases from part 1 to test ArrayIntQueue and find bugs in the {@link ArrayIntQueue} class
 * Write more unit tests to test the implementation of ArrayIntQueue, with structural testing method
 * Aim to achieve 100% line coverage for ArrayIntQueue
 *
 * @author Alex Lockwood, George Guo, Terry Li
 */
public class IntQueueTest {

    private IntQueue mQueue;
    private List<Integer> testList;

    /**
     * Called before each test.
     */
    @Before
    public void setUp() {
        // comment/uncomment these lines to test each class
        // mQueue = new LinkedIntQueue();
        mQueue = new ArrayIntQueue();

        testList = new ArrayList<>(List.of(1, 2, 3));
    }

    @Test
    public void testIsEmpty() {
        // This is an example unit test
        assertTrue(mQueue.isEmpty());
    }

    @Test
    public void testNotEmpty() {
        mQueue.enqueue(testList.get(0));
        assertNotNull(mQueue.peek());
    }

    @Test
    public void testPeekEmptyQueue() {
        assertNull(mQueue.peek());
    }

    @Test
    public void testPeekNoEmptyQueue() {
        mQueue.enqueue(testList.get(0));
        assertEquals(mQueue.peek(), testList.get(0));
    }

    @Test
    public void testEnqueue() {
        // This is an example unit test
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i));
            assertEquals(testList.get(0), mQueue.peek());
            assertEquals(i + 1, mQueue.size());
        }
    }

    @Test
    public void testDequeue() {
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i));
        }
        for (int j = 0; j < testList.size(); j++) {
            assertEquals(mQueue.dequeue(), testList.get(j));
        }
        assertNull(mQueue.dequeue());
    }

    @Test
    public void testContent() throws IOException {
        // This is an example unit test
        InputStream in = new FileInputStream("src/test/resources/data.txt");
        try (Scanner scanner = new Scanner(in)) {
            scanner.useDelimiter("\\s*fish\\s*");

            List<Integer> correctResult = new ArrayList<>();
            while (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                correctResult.add(input);
                System.out.println("enqueue: " + input);
                mQueue.enqueue(input);
            }

            for (Integer result : correctResult) {
                assertEquals(mQueue.dequeue(), result);
            }
        }
    }

    // Structural test for ArrayIntQueue
    @Test
    public void testIsEmptyStructural() {
        assertTrue(mQueue.isEmpty());
        mQueue.enqueue(testList.get(0));
        assertFalse(mQueue.isEmpty());
    }

    // Structural test for ArrayIntQueue
    @Test
    public void testClearStructural() {
        for (int i = 0; i < testList.size(); i++) {
            mQueue.enqueue(testList.get(i));
        }
        assertFalse(mQueue.isEmpty());
        mQueue.clear();
        assertEquals(mQueue.size(), 0);
    }

    // Structural test for ArrayIntQueue
    @Test
    public void testEnsureCapacityStructural() {
        for (int i = 1; i < 10; i++) {
            mQueue.enqueue(i);
        }
        assertEquals(mQueue.size(), 9);
        mQueue.dequeue();
        mQueue.enqueue(10);
        for (int j = 11; j < 15; j++) {
            mQueue.enqueue(j);
            assertEquals(mQueue.size(), j - 1);
        }
        assertEquals(mQueue.peek(), testList.get(1));
    }
}
