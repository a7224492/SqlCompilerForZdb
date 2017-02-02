package com.kodgames.sqlcompiler.lex;

public class Token
{
	private StringBuilder token;
	private TokenType type;
	private int value;
	
	public Token()
	{
		this.token = new StringBuilder();
		this.type = TokenType.UNKOWN;
		this.value = -1;
	}
	
	public void setToken(StringBuilder token)
	{
		this.token = token;
	}
	public StringBuilder getToken()
	{
		return this.token;
	}
	public void setType(TokenType type)
	{
		this.type = type;
	}
	public TokenType getType()
	{
		return this.type;
	}
	public void setValue(int value)
	{
		this.value = value;
	}
	public int getValue()
	{
		return this.value;
	}
}