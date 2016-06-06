/**
 * A collection that contains no duplicate elements of numbers 1, 2, 3 and so on.
 * More formally, sets contain no pair of elements e1 and e2 such that e1 == e2.
 * As implied by its name, this class models the mathematical set abstraction.
 *
 * @author Jane Doe 1234567 Group 42h
 * @author John Doe 1234567 Group 42h
 */
class IntSet {
    private int[] set;

    /**
     * create a set of numbers
     *
     * @param a elements
     */
    IntSet(int... a) {
        set = makeSet(a);
    }

    /**
     * helper function for set creation
     *
     * @param a a properly set
     * @return returns a real set
     */
    protected int[] makeSet(int[] a) {
        int[] setWithoutDoubles = new int[a.length];
        int counter = 0;
        next:
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) {
                continue;
            }
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    continue next;
                }
            }
            setWithoutDoubles[counter] = a[i];
            counter++;
        }

        int[] set = new int[counter];
        System.arraycopy(setWithoutDoubles, 0, set, 0, set.length);
        return set;
    }

    /**
     * adds all elems from the given set to the set
     *
     * @param a source set
     */
    public void addAll(IntSet a) {
        int[] union = new int[set.length + a.set.length];
        System.arraycopy(set, 0, union, 0, set.length);
        System.arraycopy(a.set, 0, union, set.length, a.set.length);
        set = makeSet(union);
    }

    /**
     * remove all elements from the set witch are not in the given set
     *
     * @param a source set
     */
    public void retainAll(IntSet a) {
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
        set = makeSet(intersection);
    }

    /**
     * remove all elements from the set witch are in the given set
     *
     * @param a source set
     */
    public void removeAll(IntSet a) {
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
        set = makeSet(setMinus);
    }

    /**
     * sum of the set
     *
     * @return the sum of the set
     */
    public int sum() {
        int sum = 0;
        for (int aSet : set) {
            sum += aSet;
        }
        return sum;
    }

    /**
     * avg of the set
     *
     * @return the avg of the set
     */
    public int avg() {
        if (set.length == 0) {
            return 0;
        }
        return sum() / set.length;
    }

    /**
     * min element of the set
     *
     * @return the min element of the set
     */
    public int min() {
        if (set.length == 0) {
            return 0;
        }
        int min = set[0];
        for (int aSet : set) {
            if (aSet < min) {
                min = aSet;
            }
        }
        return min;
    }

    /**
     * max element of the set
     *
     * @return the max element of the set
     */
    public int max() {
        if (set.length == 0) {
            return 0;
        }
        int max = set[0];
        for (int aSet : set) {
            if (max < aSet) {
                max = aSet;
            }
        }
        return max;
    }

    /**
     * prints all elements from the set
     */
    public void print() {
        for (int aSet : set) {
            System.out.print(aSet + " ");
        }
        System.out.println();
    }

    /**
     * Get set
     *
     * @return int array set
     */
    public int[] getSet() {
        return set;
    }

    /**
     * toString method.
     *
     * @return set object as string
     */
    public String toString() {
        StringBuilder x = new StringBuilder();
        x = x.append("{ ");
        for (int i : set) {
            x = x.append(i + " ");
        }
        x = x.append('}');
        return x.toString();
    }

    /**
     * Method checks if given number is in set
     *
     * @param i number to check
     * @return true if number is in set, else false
     */
    public boolean isIn(int i) {
        for (int j : set) {
            if (i == j) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if given set is a subset
     *
     * @param s set to check
     * @return true if subset, else false
     */
    public boolean isSubSet(IntSet s) {
        int[] tmp = s.getSet();
        for (int i : tmp) {
            if (!isIn(i)) {
                return false;
            }
        }
        return true;
    }


    public boolean equals(Object o) {
        return false;
    }

    /**
     * main method
     *
     * @param args unused
     */
    public static void main(String[] args) {
        IntSet set1 = new IntSet(1, 2, 2, 4, -1, -42, 0, 3, 54, 234, 5654, 12, 3, 6, 3);
        set1.print();
        IntSet set2 = new IntSet(2, 2, 4, 5, 7, 1, 3);
        set2.print();
        IntSet set3 = new IntSet(2, 4, 4, 7, 9);
        SortedIntSet set4 = new SortedIntSet(1, 2, 3, 4, 5);
        SortedIntSet set5 = new SortedIntSet(1, 8, 7, 2, 0, 4, 4, 5);
        set3.print();
        set1.addAll(set2);
        set1.print();
        set1.removeAll(set2);
        set1.print();
        set1.addAll(set2);
        set1.print();
        set1.retainAll(set2);
        set1.print();

        System.out.println("set1.min() = " + set1.min());
        System.out.println("set1.max() = " + set1.max());
        System.out.println("set1.avg() = " + set1.avg());
        System.out.println("set1.sum() = " + set1.sum());
        System.out.println(set1.toString());
        System.out.println(set2.isSubSet(set3));
        System.out.println(set5);
    }
}
