package helpers;

import java.util.UUID;

public class StringHelper {

    public static String generateRandomEmail() {
        return UUID.randomUUID().toString().substring(0, 9) + "@mailnesia01.com";
    }
}
