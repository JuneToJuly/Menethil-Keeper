package menethil.house.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HiddenData
{
    public static String getToken()
    {
        String token = "";
        try
        {
            token = new BufferedReader(new FileReader("config.conf")).readLine().trim();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return token;
    }
}
