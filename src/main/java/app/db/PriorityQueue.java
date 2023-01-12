package app.db;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T> {

    // An array of key value pairs
    private List<KeyValuePair<T, Integer>> elements;

    public PriorityQueue() {
        elements = new ArrayList<>();
    }

    // Inserts a new element into the priority queue
    public void push(T element, int priority) {
        elements.add(new KeyValuePair<>(element, priority));
        // Sort the elements based on priority
        elements.sort(Comparator.comparing(KeyValuePair::getValue));
    }

    // Returns the highest priority element
    public T peek() {
        if (elements.size() > 0) {
            return elements.get(0).getKey();
        }
        return null;
    }

    // Removes the highest priority element
    public void pop() {
        if (elements.size() > 0) {
            elements.remove(0);
        }
    }

    // Returns the size of the queue
    public int size() {
        return elements.size();
    }

    // Inner class for key value pairs
    private class KeyValuePair<T, Integer> {
        private T key;
        private Integer value;

        public KeyValuePair(T key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }
}