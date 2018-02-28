package menethil.house.bot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.EmbedType;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.user.UserTypingEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.sound.midi.Synthesizer;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * All the events that we want to handle  are in this class.
 */
public class AlmightyEventListener extends ListenerAdapter
{
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        JDA jda = event.getJDA();
        MessageChannel channel = event.getChannel();
        if(event.getAuthor().isBot()){return;}

        if(event.getAuthor().getName().contains("Speyside"))
        {
            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle("Image");
            builder.setImage("attachment://flower.png");
            builder.build();
            MessageBuilder mssg = new MessageBuilder();
            try
            {
                InputStream file = new URL("https://goo.gl/images/Q3o2rc").openStream();
                mssg.setEmbed(builder.build());
                channel.sendFile(file, "flower.png", mssg.build()).queue();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
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
