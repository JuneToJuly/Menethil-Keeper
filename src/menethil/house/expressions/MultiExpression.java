package menethil.house.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class MultiExpression implements Expression
{
    protected List<Expression> expressionList;

    public MultiExpression(Expression... expressionsToUnion)
    {
        expressionList = new ArrayList<>(Arrays.asList(expressionsToUnion));
    }

}
