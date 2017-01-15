package com.kodgames.sqlcompiler.preprocesser;

import java.io.IOException;

/**
 * 
 * @author jiangzhen
 *
 */
public interface IPreProcessor {
	
	/**
	 * 
	 * @param buffer
	 * @throws IOException 
	 */
	public void putIntoBuffer(StringBuilder buffer) throws IOException;
}
