package yang.al.ch01;

import java.util.Iterator;
import java.util.Scanner;


/**
 * Created by root on 15-6-17.
 */
public class Bag<Item> implements Iterable<Item> {
    private int N;
    private Node first;

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public int size() {
        return N;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
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
        Bag<String> bag = new Bag<String>();
        Scanner in = new Scanner(System.in);
        while (!in.hasNext()) {
            String item = in.next();
            bag.add(item);
        }
        System.out.println("size of bag = " + bag.size());
        for (String s: bag) {
            System.out.println(s);
        }
    }


}


