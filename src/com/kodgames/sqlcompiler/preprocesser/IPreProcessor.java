package com.kodgames.sqlcompiler.preprocesser;

/**
 * 预处理器接口
 * @author jiangzhen
 *
 */
public interface IPreProcessor {
	
	/**
	 * 填满一个缓冲区，合并多余的界符
	 * @param buffer
	 */
	public void getOneLine(StringBuilder buffer);
}
