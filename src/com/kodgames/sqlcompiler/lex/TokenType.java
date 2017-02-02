package com.kodgames.sqlcompiler.lex;

public enum TokenType
{
	UNKOWN("UNKOWN", -1),
	IDENTIFIER("TOKEN_TYPE", 10001);
	private String name;
	private int value;
	private TokenType(String name, int value)
	{
		this.name = name;
		this.value = value;
	}
	public String toString()
	{
		return this.name+"="+this.value;
	}
}
