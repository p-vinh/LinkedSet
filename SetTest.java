public class SetTest {
    public static void main(String[] args) {
        
        SetInterface<Integer> A = new LinkedSet<>();
        SetInterface<Integer> B = new LinkedSet<>();
        SetInterface<Integer> C = new LinkedSet<>();
        SetInterface<Integer> D = new LinkedSet<>();

        addSet(A, new int[] {1, 2, 3});
        addSet(B, new int[] {2, 1, 3});
        System.out.println(A.equals(B));
        A.clear();
        B.clear();

        addSet(A, new int[] {1});
        addSet(B, new int[] {1, 2});
        System.out.println(A.subset(B));
        A.clear();
        B.clear();

        addSet(A, new int[] {1, 2, 3});
        addSet(B, new int[] {2, 3, 4, 5});
        System.out.println(A.union(B));
        A.clear();
        B.clear();

        addSet(A, new int[] {1});
        addSet(B, new int[] {2, 3});
        System.out.println(A.equals(B));
        A.clear();
        B.clear();
        
        

        // System.out.println(D.subset(A));
        // System.out.println(D.subset(B));
        // System.out.println(D.subset(C));
        // System.out.println(D.subset(D));


        // System.out.println(A.equals(B));


    }

    private static void addSet(SetInterface<Integer> set, int[] num) {
        for (int index : num)
            set.add(index);
    }
}
