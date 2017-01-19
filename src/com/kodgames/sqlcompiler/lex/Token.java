package com.kodgames.sqlcompiler.lex;

public class Token
{
	private StringBuilder token;
	private int type;
	private int value;
	
	public Token()
	{
		this.token = new StringBuilder();
		this.type = -1;
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
	public void setType(int type)
	{
		this.type = type;
	}
	public int getType()
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