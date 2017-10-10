package com.ducetech.framework.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常的工具类
 * 参考了guava的Throwables
 *
 * @ClassName: ExceptionUtils
 * @Date 17-10-9 下午1:27
 */
public class ExceptionUtils {

	/**
	 * 将CheckedException转换为UncheckedException
	 *
	 * @param e
	 * @return java.lang.RuntimeException
	 * @throws
	 * @Title: unchecked
	 * @Date: 17-10-9 下午1:28
	 */
	public static RuntimeException unchecked(Throwable e) {
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}


	/**
	 * 将ErrorStack转化为String
	 *
	 * @param ex
	 * @return java.lang.String
	 * @throws
	 * @Title: getStackTraceAsString
	 * @Date: 17-10-9 下午1:29
	 */
	public static String getStackTraceAsString(Throwable ex) {
		StringWriter stringWriter = new StringWriter();
		ex.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	/**
	 * 获取组合本异常信息与底层异常信息的异常描述, 适用于本异常为统一包装异常类,底层异常才是根本原因的情况
	 *
	 * @param ex
	 * @return java.lang.String
	 * @throws
	 * @Title: getErrorMessageWithNestedException
	 * @author: hongyangliao
	 * @Date: 17-10-9 下午1:29
	 */
	public static String getErrorMessageWithNestedException(Throwable ex) {
		Throwable nestedException = ex.getCause();
		return new StringBuilder().append(ex.getMessage()).append(" nested exception is ")
				.append(nestedException.getClass().getName()).append(":").append(nestedException.getMessage())
				.toString();
	}

	/**
	 * 获取异常的Root Cause
	 *
	 * @param ex
	 * @return java.lang.Throwable
	 * @throws
	 * @Title: getRootCause
	 * @Date: 17-10-9 下午1:30
	 */
	public static Throwable getRootCause(Throwable ex) {
		Throwable cause;
		while ((cause = ex.getCause()) != null) {
			ex = cause;
		}
		return ex;
	}

	/**
	 * 判断异常是否由某些底层的异常引起
	 *
	 * @param ex
	 * @param causeExceptionClasses
	 * @return boolean
	 * @throws
	 * @Title: isCausedBy
	 * @Date: 17-10-9 下午1:30
	 */
	public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
		Throwable cause = ex;
		while (cause != null) {
			for (Class<? extends Exception> causeClass : causeExceptionClasses) {
				if (causeClass.isInstance(cause)) {
					return true;
				}
			}
			cause = cause.getCause();
		}
		return false;
	}
}
