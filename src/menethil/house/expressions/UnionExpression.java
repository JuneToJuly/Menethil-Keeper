package menethil.house.expressions;

import java.util.List;

public class UnionExpression extends MultiExpression
{
    public UnionExpression(List<Expression> multiExpression)
    {
        super(multiExpression);
    }

    /**
     *  Our Message must be contained in at least one Expression.
     * @param context the message to be checked
     * @return true if contained in one at least expression <br>
     *        false otherwise
     */
    @Override
    public boolean interpret(String context)
    {
        for (Expression expression:
             expressionList)
        {
            if(expression.interpret(context)) return true;
        }
        return false;
    }
}
