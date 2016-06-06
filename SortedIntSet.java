/**
 * A sorted collection
 *
 * @author Jan Philip Kozina 4052980 group 11a
 * @author Sina Meier 4738550 group 11a
 */
class SortedIntSet extends IntSet {
    private int[] set;

    /**
     * Creates a sorted set of numbers
     *
     * @param a elements
     */
    SortedIntSet(int... a) {
        set = makeSet(a);
        if (!isSorted(set)) {
            set = bubbleSort(makeSet(a));
        }
    }

    /**
     * Checks if set is sorted
     *
     * @param set int array to check
     * @return true if sorted, else false
     */
    private boolean isSorted(int[] set) {
        int j = 0;
        boolean b = false;
        for (int i = 1; i < set.length; i++) {
            if (set[i] > set[j]) {
                b = true;
                j++;
            } else {
                return false;
            }
        }
        return b;
    }

    /**
     * sorts a set of numbers ascending with bubblesort-algorithm
     *
     * @param a int array
     * @return ascending sorted int array
     */
    private int[] bubbleSort(int[] a) {
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }

        }

        return a;
    }

    @Override
    public String toString() {
        StringBuilder x = new StringBuilder();
        x = x.append("{ ");
        for (int i : set) {
            x = x.append(i);
            x = x.append(" ");
        }
        x = x.append('}');
        return x.toString();
    }
}
