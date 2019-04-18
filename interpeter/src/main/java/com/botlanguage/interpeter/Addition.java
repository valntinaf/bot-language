package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class Addition implements ASTNode {
	private ASTNode operand1;
	private ASTNode operand2;
	
	public Addition(ASTNode operand1, ASTNode operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		if(operand1.execute(symbolTable, bot) instanceof Double && operand2.execute(symbolTable, bot) instanceof Double)
			return (double)operand1.execute(symbolTable, bot) + (double)operand2.execute(symbolTable, bot);
		
		else if(operand1.execute(symbolTable, bot) instanceof Integer && operand2.execute(symbolTable, bot) instanceof Double)
			return Double.valueOf((int) operand1.execute(symbolTable, bot)) + (double)operand2.execute(symbolTable, bot);
		
		else if(operand1.execute(symbolTable, bot) instanceof Double && operand2.execute(symbolTable, bot) instanceof Integer)
			return (double)operand1.execute(symbolTable, bot) + Double.valueOf((int) operand2.execute(symbolTable, bot));
		
		else if (operand1.execute(symbolTable, bot) instanceof Integer && operand2.execute(symbolTable, bot) instanceof Integer)
			return (int)operand1.execute(symbolTable, bot) + (int)operand2.execute(symbolTable, bot);
		
		else
			return operand1.execute(symbolTable, bot).toString() + operand2.execute(symbolTable, bot).toString();
	}

}
