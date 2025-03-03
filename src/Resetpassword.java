import java.util.Random;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class Resetpassword {
    private static final LocalDateTime LastDateTime = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd-hh");
    private final StringBuilder sb = new StringBuilder();
    private final Random rd = new Random();
    private final User.Admin admin = new User.Admin();
    private final User.Staff staff = new User.Staff();

    public static void resetpassword(){
        if (ChronoUnit.HOURS.between(LastDateTime, LocalDateTime.now()) == 24 ){
            System.out.println("");
        }
    }
}
