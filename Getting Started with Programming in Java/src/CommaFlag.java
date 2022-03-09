public class CommaFlag {
    public static void main(String[] args) {
        int number = 1234567;
        double decimal = 1234567.0d;
        String s1 = String.format("%d", number);
        String s2 = String.format("%,d", number);
        String s3 = String.format("%,.2f", decimal);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
