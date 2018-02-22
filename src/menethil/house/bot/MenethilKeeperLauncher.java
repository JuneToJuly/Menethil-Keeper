package menethil.house.bot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;

import javax.security.auth.login.LoginException;

public class MenethilKeeperLauncher
{
    private static JDA jda;
    private static String TOKEN;

    public static void main(String args[])
    {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setToken(TOKEN);

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
