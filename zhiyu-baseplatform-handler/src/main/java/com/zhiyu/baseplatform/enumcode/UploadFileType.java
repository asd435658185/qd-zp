package com.zhiyu.baseplatform.enumcode;

/**
 * 上传文件类型
 * @author wdj
 *
 */
public enum UploadFileType {

	NOTIFICATION(0,"通知类图片"),

	STUDENT_AVATAR(1, "学生头像"),

	TEACHER_AVATAR(2, "老师头像"),

	CLASS_IMG(3,"班级图片"),

	GIFT_IMG(4,"礼品图片"),

	PROJECT_IMG(5,"四项评比图片"),

	ANDRIOD_APP(6,"安卓app"),

	MORAL_IMG(7,"德育风采图片"),

	MORAL_CLASS(8,"德育维度图片"),
	
	MORAL_TV(9,"德育电台图片或视频"),

	CLOUD_BASE_IMPORT_TEMPLATE_STUDENT(20,"云平台学生导入模板"),

	CLASS_ACTIVITY_SPACE(30,"班级活动空间"),

	LINKTOP_RECORD(40, "凌拓录音");
	/**
	 * 构造方法
	 *
	 * @param value
	 * @param name
	 */
	private UploadFileType(Integer value, String name) {
		this.value = value;
		this.name = name;
	}

	private Integer value;//枚举的值

	private String name;

	// 获取枚举类
	public static UploadFileType getType(Integer value) {
		for (UploadFileType method : UploadFileType.values()) {
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
