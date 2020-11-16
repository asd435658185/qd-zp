package com.zhiyu.baseplatform.enumcode;

/**
 * 奖励方式
 * @author wdj
 *
 */
public enum MenuType {

	PARENT(0,"父级菜单"),
	
	LEAF(1, "叶子菜单");

	/**
	 * 构造方法
	 *
	 * @param value
	 * @param name
	 */
	private MenuType(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	private Integer value;//枚举的值

	private String name;

	// 获取枚举类
	public static MenuType getType(Integer value) {
		for (MenuType method : MenuType.values()) {
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
