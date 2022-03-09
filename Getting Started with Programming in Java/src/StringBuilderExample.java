public class StringBuilderExample {
    public static void main(String[] args) {
        String location = "Florida";
        int flightNumber = 175;
        String time = "9:00";
        StringBuilder sb = new StringBuilder();

        sb.append("I flew to ");
        sb.append(location);
        sb.append(" on Flight #");
        sb.append(flightNumber);

        int pos = sb.indexOf(" on");
        sb.insert(pos, " at ");
        sb.insert(pos+4, time);

        String message = sb.toString();
        System.out.println(message);
    }
}
