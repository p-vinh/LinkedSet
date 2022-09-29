public class SetTest {
    public static void main(String[] args) {
        
        SetInterface<Integer> A = new LinkedSet<>();
        SetInterface<Integer> B = new LinkedSet<>();
        SetInterface<Integer> C = new LinkedSet<>();
        SetInterface<Integer> D = new LinkedSet<>();

        int[] setA = {1, 3, 5, 7};
        int[] setB = {3, 4, 5};
        int[] setC = {3, 6, 7, 10};

        addSet(A, setA);
        addSet(B, setB);
        addSet(C, setC);

        System.out.println(A.toString());

    }

    private static void addSet(SetInterface<Integer> set, int[] num) {
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
    }
}
