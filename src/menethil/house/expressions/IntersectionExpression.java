package menethil.house.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class IntersectionExpression extends MultiExpression
{
    public IntersectionExpression(Expression... expressionsToUnion)
    {
        super(expressionsToUnion);
    }

    /**
     * Our message must be contained in every set of Expressions
     * @param context message to be checked
     * @return true if message is in all expressions
     *         false other wise
     */
    @Override
    public boolean interpret(String context)
    {
        for (Expression expression:
                expressionList)
        {
            // If our message does interpret to true for all messages
            // Example:
            // Message is: Big Dog
            // Expression is: Big Animal, which contains too expressions:
            // Expression 1: "Big", Expression 2: "Dog Cat Elephant Squid Snake"
            // It would Trigger true in the first one and True in the second one
            // Therefore we could then say, if our message is contained in the set of expressions
            // Big & Animal -> do something that only a message of big animal would want done.
            if(!expression.interpret(context)) return false;
        }
        return true;
    }
}
