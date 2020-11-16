package com.zhiyu.baseplatform.enumcode;

/**
 * 识别码生成方式
 * @author wdj
 *
 */
public enum IdentifyCodeGenerateType {

	DEFAULT(0,"学籍号"),
	
	UUID(1, "辅助id为uuid方式");

	/**
	 * 构造方法
	 *
	 * @param value
	 * @param name
	 */
	private IdentifyCodeGenerateType(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	private Integer value;//枚举的值

	private String name;

	// 获取枚举类
	public static IdentifyCodeGenerateType getType(Integer value) {
		for (IdentifyCodeGenerateType method : IdentifyCodeGenerateType.values()) {
			if (method.getValue() == value) {
				return method;
			}
		}
		return null;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value 要设置的value
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 要设置的name
	 */
	public void setName(String name) {
		this.name = name;
	}//显示值

}
