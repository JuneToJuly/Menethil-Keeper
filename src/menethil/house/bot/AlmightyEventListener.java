package menethil.house.bot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.user.UserTypingEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * All the events that we want to handle  are in this class.
 */
public class AlmightyEventListener extends ListenerAdapter
{
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        // Do something
        // We can create another class called for example: MessagePolice, deletes bad messages
        // Pass in the message to the police
        // MessagePolice police = new MessagePolice(event); // event.getMessage()
        // We can now ask the police to do stuff for us now
        // if(police.isBadMessage()) // IF (true)
        // {
        //      police.detainThatMessage(); // delete it
        // }
        // We gave our police object the MessageReceivedEvent so it has
        // access to the JDA Object! Which means it can call the API

        // Just a nice way of structuring the code instead of dumping all
        // in this one method.
        // We could literally dump everything police does into this but then
        // we wouldn't know what the heck was going on. Abstract out the details, cha feel.
    }

    @Override
    public void onUserTyping(UserTypingEvent event)
    {
        // Why you typing bro, do something here
        // Can find all kinds of methods to Override by looking in Listener Adapter
    }
}
