public class FormatFlag {
    public static void main(String[] args) {
        int value = 10;
        String s1 = String.format("%d", value);
        String s2 = String.format("%x", value);
        String s3 = String.format("%#x", value);
        System.out.println("Base10: " + s1);
        System.out.println("Hexcode: " + s2);
        System.out.println("Hexcode: " + s3);
    }
}
