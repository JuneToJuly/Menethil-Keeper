package menethil.house.bot;

import menethil.house.util.HiddenData;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;

import javax.security.auth.login.LoginException;
import java.io.*;

public class MenethilKeeperLauncher
{
    private static JDA jda;
    private static String TOKEN;

    public static void main(String args[])
    {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setToken(HiddenData.getToken());
        builder.addEventListener(new AlmightyEventListener());

        try
        {
            jda = builder.buildBlocking();
        } catch (LoginException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
