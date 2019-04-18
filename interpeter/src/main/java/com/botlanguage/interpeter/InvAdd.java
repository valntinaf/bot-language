package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class InvAdd implements ASTNode {
	private ASTNode operand1;
	
	public InvAdd(ASTNode operand1) {
		super();
		this.operand1 = operand1;
	}
	
	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		if(operand1.execute(symbolTable, bot) instanceof Double)
			return -(double)operand1.execute(symbolTable, bot);
		else
			return -(int)operand1.execute(symbolTable, bot);
	}

}
