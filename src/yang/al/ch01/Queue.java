package yang.al.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by root on 15-6-17.
 */
public class Queue<Item> implements Iterable<Item> {
    private int N;
    private Node<Item> first;
    private Node<Item> last;
    private class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item: this) {
            s.append(item + " ");
        }
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first){
            current = first;
        }


        @Override
        public boolean hasNext() {
            return current!= null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String item = in.next();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) System.out.print(q.dequeue() + " ");
        }
        System.out.println("(" + q.size() + " left on queue)");
    }
}
