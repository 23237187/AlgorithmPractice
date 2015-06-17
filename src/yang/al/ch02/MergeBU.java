package yang.al.ch02;

/**
 * Created by root on 15-6-17.
 */
public class MergeBU {
    private MergeBU() {}

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi ; k++) {
            if (k > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[j++];
        }
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int n = 1; n < N; n++) {
            for (int i = 0; i < N-n; i+= n+n) {
                int lo = i;
                int mid = i + n - 1;
                int hi = Math.min(i+n+n-1, N-1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
}
