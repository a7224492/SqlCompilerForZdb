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
	
	// TODO 还没有完整的测试
	public String processor(String line)
	{
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < line.length(); ++i)
		{
			char ch = line.charAt(i);
			if (isUselessChar(ch))
			{
				continue;
			}
			if (isSpaceChar(ch) && i != 0)
			{
				char pre = line.charAt(i-1);
				if (isSpaceChar(pre))
				{
					continue;
				}
			}
			strBuilder.append(ch);
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
