package yang.al.ch02;

/**
 * Created by root on 15-6-17.
 */
public class MergeX {
    private static final int CUTOFF = 7;
    private MergeX() {}

    private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi ; k++) {
            if (i > mid)
                dst[k] = src[j++];
            else if (j > hi)
                dst[k] = src[i++];
            else if (less(src[j], src[i]))
                dst[k] = src[j++];
            else
                dst[k] = src[i++];
        }
    }

    private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid+1, hi);

        if (!less(src[mid+1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo + 1);
            return;
        }
        merge(src, dst, lo, mid, hi);
    }

    private static boolean less(Comparable a, Comparable b) {
        return (a.compareTo(b) < 0);
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length-1);
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }


}
