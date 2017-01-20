package com.kodgames.sqlcompiler.lex;

/**
 * 
 * @author jiangzhen
 *
 */
class PreProcessor{
		
	private char[] spaceChars={
			' ',
	};
	private char[] uselessChars={
			'\n','\r','\t'
	};
	public PreProcessor() {
		
	}
	
	public String processor(String line)
	{
		StringBuilder strBuilder = new StringBuilder(line);
		for (int i = 0; i < strBuilder.length(); ++i)
		{
			char ch = strBuilder.charAt(i);
			while (isUselessChar(ch))
			{
				strBuilder.deleteCharAt(i);
				ch = strBuilder.charAt(i);
			}
			if (isSpaceChar(ch) && i != (strBuilder.length()-1))
			{
				++i;
				char next = strBuilder.charAt(i);
				while (i < strBuilder.length() && isSpaceChar(next))
				{
					strBuilder.deleteCharAt(i);
					next = strBuilder.charAt(i);
				}
			}
		}
		return strBuilder.toString();
	}
	
	private boolean isUselessChar(char ch)
	{
		for (int i = 0; i < uselessChars.length; ++i)
		{
			if (ch == uselessChars[i])
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean isSpaceChar(char ch)
	{
		for (int i = 0; i < spaceChars.length; ++i)
		{
			if (ch == spaceChars[i])
			{
				return true;
			}
		}
		return false;
	}
}
