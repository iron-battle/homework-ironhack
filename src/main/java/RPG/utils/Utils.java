package RPG.utils;

import java.util.UUID;

public class Utils {

    public static String generateUUID()    {
        String result = UUID.randomUUID().toString();

        result = result.replaceAll("-", "");
        result = result.substring(0, 32);

        return result;
    }

}
