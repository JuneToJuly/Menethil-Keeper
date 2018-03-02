package menethil.house.expressions;

import sun.awt.Symbol;

import java.util.List;

public class OrderedExpression extends MultiExpression
{
    String regex;
    public OrderedExpression(List<Expression> multiExpression, String regex)
    {
        super(multiExpression);
        this.regex = regex;
        if (regex.isEmpty()) {this.regex = "\\s+";}
    }

    @Override
    public boolean interpret(String context)
    {
        System.out.println(regex);
        String[] splitContext = context.split(regex);
        for(int i = 0; i < expressionList.size(); i++)
        {
            // The context does not fit
            if (!expressionList.get(i).interpret(splitContext[i]))
            {
                System.out.println("Failed: " + splitContext[i]);
                return false;
            }
        }
        return true;
    }
}
