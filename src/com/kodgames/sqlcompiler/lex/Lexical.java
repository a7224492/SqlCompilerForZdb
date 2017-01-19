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
	
	private static final String delimiter = " ()=;";
	
	private enum ErrorType {
		TOKEN_TOO_LONG;
	};
	
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
				token.setToken(tokenBuilder);
				break;
			}
			else if (isLetter(ch))
			{
				keyLoop();
			}
			tokenBuilder.append(ch);
			this.searchIndex = (this.searchIndex+1)%this.buffer.length();
			if (this.searchIndex == this.startIndex)
			{
				errorHandler(ErrorType.TOKEN_TOO_LONG);
				break;
			}
		}
		while (true);
		
		return token;
	}

	private boolean isEndToken(char ch)
	{
		return ch == ';';
	}

	private boolean isDelimiter(char ch)
	{
		for (int i = 0; i < delimiter.length(); ++i)
		{
			if (ch == delimiter.charAt(i))
			{
				return true;
			}
		}
		return false;
	}
	
	private void errorHandler(ErrorType type)
	{
		System.out.println("token too long");
	}
}
