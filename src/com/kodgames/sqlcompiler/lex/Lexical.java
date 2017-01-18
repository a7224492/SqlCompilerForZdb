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
	private Token token;
	
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
		resetSearchIndex();
		resetToken();
		do
		{
			char ch = currChar();
			if (isDelimiter(ch))
			{
				finishOneToken();
				return token;
			}
			else if (isLetter(ch))
			{
				identifierLoop();
				parseTokenType();
				return token;
			}
			tokenAppend(ch);
			advance();
			if (isTokenTooLong())
			{
				errorHandler(ErrorType.TOKEN_TOO_LONG);
				break;
			}
		}
		while (true);
		
		return token;
	}
	
	private void resetSearchIndex()
	{
		this.searchIndex = this.startIndex;
	}
	private void resetToken()
	{
		this.token = new Token();
	}
	private void tokenAppend(char ch)
	{
		this.token.getToken().append(ch);
	}
	
	private void advance()
	{
		this.searchIndex = (this.searchIndex+1)%this.buffer.length();
	}
	
	private char currChar()
	{
		return this.token.getToken().charAt(this.searchIndex);
	}
	private void parseTokenType()
	{
		
	}

	private void identifierLoop() 
	{
		advance();
		while (true)
		{
			if (isTokenTooLong())
			{
				errorHandler(ErrorType.TOKEN_TOO_LONG);
			}
			char ch = currChar();
			if (isDelimiter(ch))
			{
				finishOneToken();
				break;
			}
			tokenAppend(ch);
			advance();
		}
	}
	private boolean isTokenTooLong()
	{
		if ((this.searchIndex+1)%BUFF_SIZE == this.startIndex)
		{
			return true;
		}
		return false;
	}
	
	private void finishOneToken()
	{
		this.startIndex = this.searchIndex;
	}

	private boolean isLetter(char ch) 
	{
		if (ch >= 'a' && ch <= 'z')
		{
			return true;
		}
		if (ch >= 'A' && ch <= 'Z')
		{
			return true;
		}
		if (ch == '_')
		{
			return true;
		}
		return false;
	}
	
	private boolean isDigit(char ch)
	{
		if (ch >= '0' && ch <= '9')
		{
			return true;
		}
		return false;
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
