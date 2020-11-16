package com.zhiyu.baseplatform.service.excelbase;

import java.lang.reflect.Method;

/**
 * Excel读取需要继承的基类，主要封装反射读取和设置属性值
 * 
 * @author wangdj
 *
 */
public class AbsExcelObj {

	private String errMsg;

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * 通过属性名设置属性值
	 * 
	 * @param name
	 * @param value
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void putValue(String name, Object value) {
		Class c = this.getClass();
		Class v = value.getClass();
		String firstChar = String.valueOf(name.charAt(0));
		String upperNameFirstChar = firstChar.toUpperCase() + name.substring(1);
		try {
			Method m = c.getMethod("set" + upperNameFirstChar, new Class[] { v });
			m.invoke(this, new Object[] { value });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回属性名对应的值
	 * 
	 * @param name
	 * @return 属性名对应的值
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object outValue(String name) {
		Class c = this.getClass();
		Object o = null;
		String firstChar = String.valueOf(name.charAt(0));
		String upperNameFirstChar = firstChar.toUpperCase() + name.substring(1);
		try {
			Method m = c.getMethod("get" + upperNameFirstChar, new Class[] {});
			o = m.invoke(this, new Object[] {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
}
