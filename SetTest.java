public class SetTest {
    public static void main(String[] args) {
        
        SetInterface<Integer> A = new LinkedSet<>();
        SetInterface<Integer> B = new LinkedSet<>();
        SetInterface<Integer> C = new LinkedSet<>();
        SetInterface<Integer> D = new LinkedSet<>();

        int[] setA = {1, 3, 5, 7};
        int[] setB = {1, 3, 5, 7, 8, 32, 23};
        int[] setC = {1};

        addSet(A, setA);
        addSet(B, setB);
        addSet(C, setC);

        System.out.println(A.toString());
        System.out.println(B.toString());
        System.out.println(C.toString());
        System.out.println(D.toString());

        System.out.println(A.union(B));
        

    }

    private static void addSet(SetInterface<Integer> set, int[] num) {
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
    }
}
