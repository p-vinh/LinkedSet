public class SetTest {
    public static void main(String[] args) {
        
        SetInterface<Integer> A = new LinkedSet<>();
        SetInterface<Integer> B = new LinkedSet<>();
        SetInterface<Integer> C = new LinkedSet<>();
        SetInterface<Integer> D = new LinkedSet<>();

        System.out.println("Checking if set A: {1,2,3} is equal to set B: {2,1,3}");
        addSet(A, new int[] {1,2,3});
        addSet(B, new int[] {2,1,3});
        System.out.println(A.equals(B));
        A.clear();
        B.clear();

        addSet(A, new int[] {1});
        addSet(B, new int[] {1,2});
        System.out.println(A.subset(B));
        A.clear();
        B.clear();

        addSet(A, new int[] {1,2,3});
        addSet(B, new int[] {2,3,4,5});
        System.out.println(A.union(B));
        A.clear();
        B.clear();

        addSet(A, new int[] {1});
        addSet(B, new int[] {2,3});
        System.out.println(A.equals(B));
        A.clear();
        B.clear();

        addSet(A, new int[] {});
        addSet(B, new int[] {});
        System.out.println(A.equals(B));
        A.clear();
        B.clear();

        addSet(A, new int[] {});
        addSet(B, new int[] {1,2,3,4});
        System.out.println(A.equals(B));
        A.clear();
        B.clear();

    }

    private static void addSet(SetInterface<Integer> set, int[] num) {
        for (int index : num)
            set.add(index);
    }
}
