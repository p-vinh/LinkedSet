public class SetTest {
    public static void main(String[] args) {
        
        SetInterface<Integer> A = new LinkedSet<>();
        SetInterface<Integer> B = new LinkedSet<>();
        SetInterface<Integer> C = new LinkedSet<>();
        SetInterface<Integer> D = new LinkedSet<>();

        int[] setA = {1};
        int[] setB = {2, 3};
        int[] setC = {1};

        addSet(A, setA);
        addSet(B, setB);
        addSet(C, setC);

        // System.out.println(A.toString());
        // System.out.println(B.toString());
        // System.out.println(C.toString());
        // System.out.println(D.toString());

        // System.out.println(A.union(B));
        
        // Fix union
        D = B.union(C);
        System.out.println(D);

        // System.out.println(D.subset(A));
        // System.out.println(D.subset(B));
        // System.out.println(D.subset(C));
        // System.out.println(D.subset(D));

        // set B changes with union so it will return true
        System.out.println(A.subset(B));

        // System.out.println(A.equals(B));


    }

    private static void addSet(SetInterface<Integer> set, int[] num) {
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
    }
}
