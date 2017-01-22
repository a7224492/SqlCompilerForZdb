package com.kodgames.sqlcompiler.lex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PreProcessorTest {

	@Test
	public void testProcessor() {
		PreProcessor p = new PreProcessor();
		String[] sqls = {
//				"sled   qe   n\t\n\rss   \n\n",
//				"sled qe nss ",
				"\new\t\r  eq    r\r\rqen",
				"ew eq rqen",
				"\n\newqe   eqwe ",
				"ewqe eqwe "
		};
		for (int i = 0; i < sqls.length; i+=2)
		{
			String ret = p.processor(sqls[i]);
			assertEquals(true, ret.equals(sqls[i+1]));
		}
	}

}
