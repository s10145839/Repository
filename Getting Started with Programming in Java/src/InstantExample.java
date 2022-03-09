import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("Time: " + now);
    }
    static void checkRelationship(Instant time) {
        Instant now = Instant.now();
        if(time.compareTo(now) > 0) {
            System.out.println("Instant is the future");
        } else if(time.compareTo(now) < 0) {
            System.out.println("Instant is the past");
        } else {
            System.out.println("Instant is the present");
        }
    }
}
