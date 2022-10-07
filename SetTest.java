//  Name:   Pham, Vinh 
//  Project:  #2 
//  Due:        7 October 2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Implementation of Set ADT using LinkedList.
//    With union, equals, and subset methods introduced.

public class SetTest {
    public static void main(String[] args) {
        
        SetInterface<Integer> A = new LinkedSet<>();
        SetInterface<Integer> B = new LinkedSet<>();
        SetInterface<Integer> C = new LinkedSet<>();
        

        System.out.println("Checking if set A: {1,2,3} is equal to set B: {2,1,3}");
        addSet(A, new int[] {1,2,3});
        addSet(B, new int[] {2,1,3});
        System.out.println(A.equals(B));
        System.out.println();
        System.out.println("Removing an item from set A");
        A.remove(1);
        System.out.println("Checking if set A is not equal to set B");
        System.out.println(!A.equals(B));
        System.out.println();

        System.out.println("Checking if set A: {1} is a subset of set B: {1,2}");
        addSet(A, new int[] {1});
        addSet(B, new int[] {1,2});
        System.out.println(A.subset(B));
        A.clear();
        B.clear();
        System.out.println();

        System.out.println("Testing union() with set A: {1,2,3} and set B: {2,3,4,5} should return set C: {1,2,3,4,5}");
        addSet(A, new int[] {1,2,3});
        addSet(B, new int[] {2,3,4,5});
        System.out.println(A.union(B));
        A.clear();
        B.clear();
        System.out.println();

        System.out.println("Testing union() with 3 sets.");
        addSet(A, new int[] {1, 2, 3});
        addSet(B, new int[] {2, 3, 4, 5});
        addSet(C, new int[] {6,7,8,3,5,2,9});
        SetInterface<Integer> D = A.union(B).union(C);
        System.out.println(D);
        A.clear();
        B.clear();
        System.out.println();
        
        System.out.println("Testing equals() with 2 empty sets");
        addSet(A, new int[] {});
        addSet(B, new int[] {});
        System.out.println(A.equals(B));
        A.clear();
        B.clear();
        System.out.println();
    }

    private static void addSet(SetInterface<Integer> set, int[] num) {
        for (int index : num)
            set.add(index);
    }


}
