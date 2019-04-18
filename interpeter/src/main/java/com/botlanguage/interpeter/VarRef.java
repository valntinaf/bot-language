package com.botlanguage.interpeter;

import java.util.Map;

import org.jpavlich.bot.Bot;

public class VarRef implements ASTNode {
	
private String name;
	
	public VarRef(String value) {
		super();
		this.name = value;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable, Bot bot) {
		return symbolTable.get(name);
	}

}
