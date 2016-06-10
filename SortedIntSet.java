/**
 * A collection like IntSet, but the collection is sorted ascending.
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
            set = bubbleSort(set);
        }
        super.setSet(set);
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

    /**
     * adds all elements from the given set to the set
     *
     * @param a source set
     */
    public void addAll(SortedIntSet a) {
        int[] union = new int[set.length + a.set.length];
        System.arraycopy(set, 0, union, 0, set.length);
        System.arraycopy(a.set, 0, union, set.length, a.set.length);
        set = bubbleSort(makeSet(union));
    }

    /**
     * adds all elements from the given set to the set
     *
     * @param a source set
     */
    @Override
    public void addAll(IntSet a) {
        super.addAll(a);
        set = bubbleSort(super.getSet());
    }

    /**
     * remove all elements from the set witch are not in the given set
     *
     * @param a source set
     */
    public void retainAll(SortedIntSet a) {
        int[] intersection = new int[set.length];
        int counter = 0;
        for (int aSet : set) {
            for (int j = 0; j < a.set.length; j++) {
                if (aSet == a.set[j]) {
                    intersection[counter] = aSet;
                    counter++;
                }
            }
        }
        set = bubbleSort(makeSet(intersection));
        super.setSet(set);
    }

    /**
     * remove all elements from the set witch are not in the given set
     *
     * @param a source set
     */
    @Override
    public void retainAll(IntSet a) {
        super.retainAll(a);
        set = bubbleSort(super.getSet());
    }

    /**
     * remove all elements from the set witch are in the given set
     *
     * @param a source set
     */
    public void removeAll(SortedIntSet a) {
        int[] setMinus = new int[set.length];
        int counter = 0;
        next:
        for (int aSet : set) {
            for (int j = 0; j < a.set.length; j++) {
                if (aSet == a.set[j]) {
                    continue next;
                }
            }
            setMinus[counter] = aSet;
            counter++;
        }
        set = bubbleSort(makeSet(setMinus));
        super.setSet(set);
    }

    /**
     * toString method
     * @return set in object as string
     */
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
