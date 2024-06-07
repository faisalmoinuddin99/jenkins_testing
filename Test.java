import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        System.out.println("Hello Jenkins from Java");

        int[] a = {1, 2, 4, 5, 6, 6};

        int sum_greater_than_three = Arrays.stream(a).filter(x -> x > 3)
                .map(x -> x + 10)
                .skip(1).sum();
        System.out.println("sum_greater_than_three :" + sum_greater_than_three);

        System.out.println("We have selected Poll SCM");
        System.out.println("Repo Polling V2");
    }
}
