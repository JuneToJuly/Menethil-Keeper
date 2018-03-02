package menethil.house.bot;

import menethil.house.menethil.house.command.MenethilCommand;
import menethil.house.util.MenethilParser;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.user.UserTypingEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * All the events that we want to handle are in this class.
 */
public class AlmightyEventListener extends ListenerAdapter
{
    List<MenethilCommand> cachedCommands = new ArrayList<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if(event.getAuthor().isBot()){return;}
        cachedCommands.add(MenethilParser.parseCommand(event.getJDA(), event.getMessage().getContentRaw()));
        cachedCommands.get(cachedCommands.size()-1).invoke();
    }


    @Override
    public void onUserTyping(UserTypingEvent event)
    {
        JDA jda = event.getJDA();
        System.out.println("User is typign");
        MessageChannel channel = event.getChannel();
        //channel.sendMessage("Spit it out " + event.getMember().getEffectiveName()).queue();
    }

}
