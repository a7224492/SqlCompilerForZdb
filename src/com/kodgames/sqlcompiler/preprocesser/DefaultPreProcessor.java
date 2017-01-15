package com.kodgames.sqlcompiler.preprocesser;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author jiangzhen
 *
 */
class DefaultPreProcessor{
	
	private RandomAccessFile randomFile = null;
	
	public DefaultPreProcessor(RandomAccessFile randomFile) {
		this.randomFile = randomFile;
	}
	
	public void putIntoBuffer(StringBuilder buffer, int bufferSize) throws IOException {
		for (int i = 0; i < bufferSize; ++i)
		{
			char ch = this.randomFile.readChar();
			if (ch == ' ' && i != 0)
			{
				if (buffer.charAt(i-1) == ' ')
				{
					continue;
				}
			}
			buffer.append(ch);
		}
		
		
	}

}
