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
	
	public String token()
	{
		StringBuilder token = new StringBuilder();
		
		return token.toString();
	}
}
