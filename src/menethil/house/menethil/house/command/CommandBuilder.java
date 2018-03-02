package menethil.house.menethil.house.command;

import menethil.house.util.MenethilParser;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

import java.util.List;

public class CommandBuilder
{
    public static MenethilCommand build(MenethilParser.CommandType single, JDA jda, String command)
    {
        switch (single)
        {
            case TOFROM:
                return buildToFrom(jda,command);
            case SINGLE:
                return buildSingle(jda,command);
            case UNKNOWN:
                break;
        }
        return null;
    }
    private static MenethilCommand buildSingle(JDA jda, String command)
    {
        String[] splitCommand  = command.split("\\s+");
        switch (splitCommand[1])
        {
            case "timer":
                List<TextChannel> channel = jda.getTextChannelsByName("General", true);
                System.out.println("This is a timer");
                channel.get(0).sendMessage("Timer started").queue();

        }
        return null;
    }

    private static MenethilCommand buildToFrom(JDA jda, String command)
    {
        return null;
    }


}
