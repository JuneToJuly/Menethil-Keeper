package menethil.house.expressions;

public class TerminalExpression implements Expression
{
    private String message;

    /**
     *  Create an Expression to be check against
     * @param context
     */
    public TerminalExpression(String context)
    {
        message = context;
    }

    /**
     * Determine if the message received interprets to true or false
     * @param context the message
     * @return true if string was
     */
    @Override
    public boolean interpret(String context)
    {
        return context.contains(message);
    }
}
