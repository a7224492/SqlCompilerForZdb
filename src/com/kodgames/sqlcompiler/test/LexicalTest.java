package com.kodgames.sqlcompiler.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kodgames.sqlcompiler.lex.Lexical;
import com.kodgames.sqlcompiler.lex.Token;
import com.kodgames.sqlcompiler.lex.TokenType;

public class LexicalTest
{

	@Test
	public void testToken()
	{
		String sqls[]={
			"select * from student",
			"select",
			"*",
			"from",
			"student"
		};
		Lexical lex = new Lexical();
		
		lex.processLine(sqls[0]);
		for (int i = 1; i < sqls.length; ++i)
		{
			Token token = lex.token();
			boolean b = "select".equals(token.getToken().toString());
			if (b)
			{
				System.out.println("true");
			}
			else
			{
				System.out.println("false");
			}
			boolean c = (TokenType.KEY_WORD.getValue()==token.getType().getValue());
			if (c == true)
			{
				System.out.println("true");
			}
			else
			{
				System.out.println("false");
			}
			assertEquals("select", token.getToken().toString());
			assertEquals(TokenType.KEY_WORD.getValue(), token.getType().getValue());
		}
	}

}
