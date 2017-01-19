package com.kodgames.sqlcompiler.lex;

/**
 * 
 * @author jiangzhen
 *
 */
public class Lexical {
	
	private static int BUFF_SIZE = 120;
	/**
	 * 
	 */
	private StringBuilder buffer;
	private int startIndex, searchIndex;
	
	public Lexical()
	{
		this.buffer = new StringBuilder(BUFF_SIZE*2);
		this.startIndex = 0;
		this.searchIndex = 0;
	}
	
	public Token token()
	{
		Token token = new Token();
		StringBuilder tokenBuilder = new StringBuilder();
		
		this.searchIndex = this.startIndex;
		do
		{
			char ch = this.buffer.charAt(this.searchIndex);
			if (isDelimiter(ch))
			{
				
				break;
			}
			tokenBuilder.append(ch);
			this.searchIndex = (this.searchIndex+1)%this.buffer.length();
			if (this.searchIndex == this.startIndex)
			{
				System.out.print("token is too long!!!!");
				break;
			}
		}
		while (true);
		
		return token;
	}

	private boolean isDelimiter(char ch)
	{
		
		return false;
	}
	
	
}
