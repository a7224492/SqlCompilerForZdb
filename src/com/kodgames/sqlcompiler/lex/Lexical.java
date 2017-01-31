package com.kodgames.sqlcompiler.lex;

/**
 * 
 * @author jiangzhen
 *
 */
public class Lexical
{

	private static int BUFF_SIZE = 240;
	/**
	 * 
	 */
	private StringBuilder buffer;
	private int startIndex, searchIndex;
	private Token token;

	private static final String delimiter = " ()=;,";
	private static final String identifierLetter = "*_"; 
	
	private PreProcessor preProcessor = new PreProcessor();

	private enum ErrorType
	{
		TOKEN_TOO_LONG;
	};

	public Lexical()
	{
		this.buffer = new StringBuilder(BUFF_SIZE);
		this.startIndex = 0;
		this.searchIndex = 0;
		this.token = new Token();
	}
	
	public void processLine(String line)
	{
		String retLine = preProcessor.processor(line);
		resetToken();
		resetSearchIndex();
		buffer.replace(0, buffer.length(), retLine);
	}

	public Token token()
	{
		resetToken();
		while (true)
		{
			char ch = currChar();
			if (isDelimiter(ch))
			{
				tokenAppend(ch);
				if (ch == ';')
				{
					token.setType(TokenType.FINISH_TOKEN);
				}
				else
				{
					token.setType(TokenType.DELIMITER_TOKEN);
				}
				break;
			}
			else if (isLetter(ch))
			{
				identifierLoop();
				parseToken();
				break;
			}
			else if (isDigit(ch))
			{
				digitLoop();
				break;
			}
			else
			{
				System.out.println("unkown character");
				break;
			}
		}	
		finishOneToken();
		return token;
	}

	private void resetToken()
	{
		token.getToken().delete(0, token.getToken().length());
		token.setType(TokenType.UNKOWN);
	}
	private void resetSearchIndex()
	{
		this.searchIndex = this.startIndex = 0;
	}

	private void tokenAppend(char ch)
	{
		this.token.getToken().append(ch);
	}

	private void advance()
	{
		++this.searchIndex;
		if (this.searchIndex == this.buffer.length())
		{
			errorHandlerTokenTooLong();
		}
	}

	private char currChar()
	{
		return this.buffer.charAt(this.searchIndex);
	}

	private void parseToken()
	{
		if (this.token.getType() == TokenType.IDENTIFIER)
		{
			return ;
		}
		if (isKeyword())
		{
			token.setType(TokenType.KEY_WORD);
			return;
		}
	}

	private void digitLoop()
	{
		while (true)
		{
			char ch = currChar();
			if (!isDigit(ch))
			{
				errorHandlerIllegalIdentifier();
				return ;
			}
			else if (isDelimiter(ch))
			{
				finishOneToken();
				return ;
			}
			tokenAppend(ch);
			advance();
		}
	}
	private void identifierLoop()
	{
		while (true)
		{
			if (isTokenTooLong())
			{
				errorHandler(ErrorType.TOKEN_TOO_LONG);
			}
			char ch = currChar();
			if (isDelimiter(ch))
			{
				break;
			}
			else if (isDigit(ch) || isIdentifierLetter(ch))
			{
				token.setType(TokenType.IDENTIFIER);
			}
			tokenAppend(ch);
			advance();
		}
	}

	private boolean isTokenTooLong()
	{
		if ((this.searchIndex + 1) % BUFF_SIZE == this.startIndex)
		{
			return true;
		}
		return false;
	}

	private void finishOneToken()
	{
		this.startIndex = this.searchIndex;
	}
	private boolean isIdentifierLetter(char ch)
	{
		for (int i = 0; i < identifierLetter.length(); ++i)
		{
			if (ch == identifierLetter.charAt(i))
			{
				return true;
			}
		}
		return false;
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
	private void errorHandlerIllegalIdentifier()
	{
		resetToken();
		System.out.println("illegal identifier");
	}
	private void errorHandlerTokenTooLong()
	{
		resetToken();
		System.out.println("token too long");
	}
	private boolean isKeyword()
	{
		return SKeyword.getInstance().isKeyWord(this.token.getToken().toString());
	}
}
