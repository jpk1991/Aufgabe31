/**
 * Test class for IntSet and SortedIntSet
 *
 * @author Jan Philip Kozina 4052980 group 11a
 * @author Sina Meier 4738550 group 11a
 */
public class Test {
    /**
     * Main method
     * @param args unused
     */
    public static void main(String[] args) {
        //IntSet tests
        System.out.println("-----------------IntSet tests-----------------");
        IntSet set1 = new IntSet(1, 2, 2, 4, -1, -42, 0, 3, 54, 234, 5654, 12, 3, 6, 3);
        set1.print();
        IntSet set2 = new IntSet(2, 2, 4, 5, 7, 1, 3);
        set2.print();
        IntSet set3 = new IntSet(2, 4, 4, 7, 9, 10);
        set3.print();
        IntSet set4 = new IntSet(2, 7, 4, 9);
        set4.print();
        IntSet set5 = new IntSet(1, 2, 2, 4, -1, -42, 0, 3, 54, 234, 5654, 12, 3, 6, 3, 5, 7);
        System.out.print(set1 + " union " + set2 + " = ");
        set1.addAll(set2);
        set1.print();
        System.out.print(set1 + " minus " + set2 + " = ");
        set1.removeAll(set2);
        set1.print();
        System.out.print(set1 + " intersect " + set2 + " = ");
        set1.retainAll(set2);
        set1.print();

        System.out.println("current set5: " + set5);
        System.out.println("set5.min() = " + set5.min());
        System.out.println("set5.max() = " + set5.max());
        System.out.println("set5.avg() = " + set5.avg());
        System.out.println("set5.sum() = " + set5.sum());
        System.out.println("set5 toString = " + set5.toString());
        System.out.println("set3 is subset of set4 (false) = " + set4.isSubSet(set3));
        System.out.println("set4 is subset of set3 (true) = " + set3.isSubSet(set4));

        //SortedIntSet tests
        System.out.println("-----------------SortedIntSet tests-----------------");
        SortedIntSet set6 = new SortedIntSet(1, 2, 2, 4, -1, -42, 0, 3, 54, 234, 5654, 12, 3, 6, 3);
        set6.print();
        SortedIntSet set7 = new SortedIntSet(2, 2, 4, 5, 7, 1, 3);
        set7.print();
        SortedIntSet set8 = new SortedIntSet(2, 4, 4, 7, 9, 10);
        set8.print();
        SortedIntSet set9 = new SortedIntSet(2, 7, 4, 9);
        set9.print();

        System.out.println(set6 + " union " + set7);
        set6.addAll(set7);
        set6.print();
        System.out.println(set6 + " minus " + set7);
        set6.removeAll(set7);
        System.out.println(set6);
        set6.print();
        System.out.println(set6 + " union " + set7);
        set6.addAll(set7);
        set6.print();
        System.out.println(set6 + " intersect " + set7);
        set6.retainAll(set7);
        System.out.println(set6);
        System.out.print("current set6: ");
        set6.print();

        System.out.println("set6.min() = " + set6.min());
        System.out.println("set6.max() = " + set6.max());
        System.out.println("set6.avg() = " + set6.avg());
        System.out.println("set6.sum() = " + set6.sum());
        System.out.println("set6 toString = " + set6.toString());
        set7.print();
        System.out.println(set7);
        System.out.println("set8 is subset of set9 (false) = " + set9.isSubSet(set8));
        System.out.println("set9 is subset of set8 (true) = " + set8.isSubSet(set9));

        //mixed tests
        System.out.println("-----------------Mixed tests-----------------");
        System.out.println("current set5 = " + set5);
        System.out.println("current set7 = " + set7);
        System.out.println("set5 is subset of set7 (false) = " + set7.isSubSet(set5));
        System.out.println("set7 is subset of set5 (true) = " + set5.isSubSet(set7));
        System.out.println("current set2 = " + set2);
        System.out.println("current set7 = " + set7);
        System.out.println("set2 equals set7 (true) = " + set2.equals(set7));
        System.out.println("set7 equals set2 (true) = " + set7.equals(set2));
        System.out.println("set5 equals set2 (false) = " + set5.equals(set2));
        System.out.println("set2 equals set5 (false) = " + set2.equals(set5));
        System.out.println(set6 + " union " + set7);
        set5.addAll(set7);
        set5.print();
        System.out.println(set5 + " minus " + set7);
        set5.removeAll(set7);
        System.out.println(set5);
        set5.print();
        System.out.println(set5 + " union " + set7);
        set5.addAll(set7);
        set5.print();
        System.out.println(set5 + " intersect " + set7);
        set5.retainAll(set7);
        System.out.println(set5);
        System.out.print("current set5: ");
        set5.print();

    }
}
