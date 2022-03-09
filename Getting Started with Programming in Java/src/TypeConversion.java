public class TypeConversion {

    public static void main(String[] args) {
        float floatValue = 1.0f;
        double doubleValue = 4.0d;
        byte byteValue = 7;
        short shortValue = 7;
        long longValue = 5;

        short result1 = (short) longValue;
        short result2 = (short)(byteValue - longValue);
        float result3 = longValue - floatValue;

        System.out.println("Success");
    }
}
