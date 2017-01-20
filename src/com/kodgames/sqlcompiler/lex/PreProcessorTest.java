package com.kodgames.sqlcompiler.lex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PreProcessorTest {

	@Test
	public void testProcessor() {
		PreProcessor p = new PreProcessor();
		String ret = p.processor("select *   from   m\n\ty_t\table;");
		assertEquals(true,ret.equals("select * from my_table;"));
	}

}
