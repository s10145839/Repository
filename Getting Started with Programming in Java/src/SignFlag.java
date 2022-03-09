public class SignFlag {
    public static void main(String[] args) {
        int positive = 123;
        int negative = -456;
        String s1 = String.format("%d", positive);
        String s2 = String.format("%d", negative);
        String s3 = String.format("% d", positive);
        String s4 = String.format("% d", negative);
        String s5 = String.format("%+d", positive);
        String s6 = String.format("%+d", negative);
        String s7 = String.format("%(d", positive);
        String s8 = String.format("%(d", negative);
        String s9 = String.format("% (d", positive);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
        System.out.println(s8);
        System.out.println(s9);
    }
}
