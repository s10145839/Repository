public class DoWhileLoop {
    public static void main(String[] args) {
        int i = 5;
        do {
            System.out.print(i);
            System.out.print(" * 2 = ");
            i *= 2;
            System.out.println(i);
        } while (i < 25);
    }
}
