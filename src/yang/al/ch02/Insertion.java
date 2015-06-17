package yang.al.ch02;



/**
 * Created by root on 15-6-17.
 */
public class Insertion {
    private Insertion() {}
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = N-1; i > 0; i--) {
            if (less(a[i], a[i-1])) exch(a, i, i-1);
        }

        if (N <= 2) return;
        for (int i = 2; i < N; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j-1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}

