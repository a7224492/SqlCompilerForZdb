package com.kodgames.sqlcompiler.lex;

public class Token
{
	private StringBuilder token;
	private TokenType type;
	
	public Token()
	{
		this.token = new StringBuilder();
		this.type = TokenType.UNKOWN;
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
	
	@Override
	public String toString()
	{
		return new StringBuilder().append("[")
			.append("token=")
			.append(token)
			.append(",type=")
			.append(type.getName())
			.append(",value=")
			.append(type.getValue())
			.toString();
	}
}