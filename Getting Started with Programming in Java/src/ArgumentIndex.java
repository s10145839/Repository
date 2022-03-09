public class ArgumentIndex {
    public static void main(String[] args) {
        int a = 100, b = 200, c = 300;
        String s1 = String.format("%d %d %d", a, b, c);
        String s2 = String.format("%3$d %1$d %2$d", a, b, c);
        String s3 = String.format("%2$d %<d %1$d", a, b, c);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
