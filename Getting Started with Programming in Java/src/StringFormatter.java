public class StringFormatter {
    public static void main(String[] args) {
        int david = 17, dawson = 15, dillion = 8, gordon = 6;
        String s1 = "My nephews are " + david + ", " + dawson + ", " + dillion + ", and " + gordon + " years old";
        String s2 = String.format("My nephews are %d, %d, %d, and %d years old", david, dawson, dillion, gordon);
        double average = ((david - dawson) + (dawson - dillion) + (dillion - gordon)) / 3.0d;
        String s3 = "The average age between each is " + average + " years";
        String s4 = String.format("The average age between each is %.1f years",average);

        System.out.println(s2);
        System.out.println(s4);
    }
}
