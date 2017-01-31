package com.kodgames.sqlcompiler.lex;

public enum TokenType
{
	DELIMITER_TOKEN("DELIMITER_TOKEN", 10004),
	FINISH_TOKEN("FINISH_TOKEN", 10003),
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
	public int getValue()
	{
		return value;
	}
	public String getName()
	{
		return name;
	}
	public String toString()
	{
		return this.name+"="+this.value;
	}
}
