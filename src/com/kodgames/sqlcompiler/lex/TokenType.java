package com.kodgames.sqlcompiler.lex;

public enum TokenType
{
	KEY_WORD("KEY_WORD", 10002),
	IDENTIFIER("IDENTIFIER", 10001),
	UNKOWN("UNKOWN", -1);
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
