package com.kodgames.sqlcompiler.lex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PreProcessorTest {

	@Test
	public void testProcessor() {
		PreProcessor p = new PreProcessor();
		String[] sqls = {
				"",
				"",
				"\t",
				"",
				"a",
				"a",
				"\t\n",
				"",
				"a\t",
				"a",
				" a",
				" a",
				"  ",
				" ",
				"\n\t\rasdweq   eqew",
				"asdweq eqew",
				"dwqd\n\t   eqewq",
				"dwqd eqewq",
				"asd eqe \n\t\t weqe     ",
				"asd eqe weqe ",
				"dq d\t\t\t  qwe  \t\r   ",
				"dq d qwe "
		};
		for (int i = 0; i < sqls.length; i+=2)
		{
			boolean retBool = false;
			String ret = p.processor(sqls[i]);
			if (ret.equals(sqls[i+1]))
			{
				retBool = true;
			}
			else
			{
				retBool = false;
			}
			assertEquals(true, retBool);
		}
	}

}
