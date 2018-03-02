package menethil.house.util;

import menethil.house.menethil.house.command.CommandBuilder;
import menethil.house.menethil.house.command.MenethilCommand;
import menethil.house.expressions.*;
import net.dv8tion.jda.core.JDA;

import java.util.*;

public class MenethilParser
{
    private static boolean loaded = false;

    public static enum CommandType { SINGLE, TOFROM, UNKNOWN}

    /*
     * Terminals
     */
    private static TerminalExpression singleCommandStarter = null;
    private static TerminalExpression fromCommand = null;
    private static TerminalExpression toCommand = null;
    private static TerminalExpression timerCommand = null;
    private static TerminalExpression loveCommand = null;

    /*
     * Complex Expressions
     */
    // Unions
    private static UnionExpression allSingleCommands = null;
    private static UnionExpression allTextChannels = null;
    private static UnionExpression allVoiceChannels  = null;

    // Intersections
    private static IntersectionExpression singleCommands = null;

    // Ordered
    private static OrderedExpression singleCommandOrdered = null;
    private static OrderedExpression toFromVoice = null;

    public static MenethilCommand parseCommand(JDA jda, String command)
    {
        MenethilCommand menethilCommand = null;
        if(!loaded) LoadExpressions(jda);

        System.out.println(command);
        // Determine Command type
        switch (getCommandType(command))
        {
            case SINGLE:
                System.out.println("Hello: " + command);
                menethilCommand = CommandBuilder.build(CommandType.SINGLE, jda, command);
                break;
            case TOFROM:
                menethilCommand = CommandBuilder.build(CommandType.TOFROM, jda, command);
                break;
            case UNKNOWN:
                menethilCommand = CommandBuilder.build(CommandType.UNKNOWN, jda, command);
                break;
        }

        return menethilCommand;
    }
    /*
        Do something with the expressions to determine the command type.
     */
    private static CommandType getCommandType(String command)
    {
        if (singleCommandOrdered.interpret(command))
        {
            return CommandType.SINGLE;
        }

        return null;
    }

    private static void LoadExpressions(JDA jda)
    {

        // Loading the expressions in some order may be a terrible design decision
        // Some expressions technically could depend on other expressions that haven't
        // been loaded yet;
        loadTerminals();
        loadUnions(jda);
        loadOrdered();

        loaded = true;
    }

    private static void loadOrdered()
    {
        toFromVoice = new OrderedExpression(
                Arrays.asList(
                        fromCommand,
                        allVoiceChannels,
                        toCommand,
                        allVoiceChannels), "");

        singleCommandOrdered = new OrderedExpression(
                Arrays.asList(singleCommandStarter, allSingleCommands), "");
    }

    private static void loadUnions(JDA jda)
    {
        List<Expression> voiceChannels = new ArrayList<>();
        jda.getVoiceChannels().stream().forEach( e -> voiceChannels.add(new TerminalExpression(e.getName())));
        UnionExpression allVoiceChannels = new UnionExpression(voiceChannels);

        List<Expression> textChannels = new ArrayList<>();
        jda.getVoiceChannels().stream().forEach( e -> textChannels.add(new TerminalExpression(e.getName())));
        allTextChannels = new UnionExpression(textChannels);

        allSingleCommands = new UnionExpression(Arrays.asList(timerCommand,loveCommand));

    }

    private static void loadTerminals()
    {
        singleCommandStarter = new TerminalExpression("|");
        fromCommand = new TerminalExpression("<");
        toCommand = new TerminalExpression(">");
        timerCommand = new TerminalExpression("timer");
        loveCommand = new TerminalExpression("love");
    }
}
