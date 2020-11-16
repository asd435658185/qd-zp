package com.zhiyu.baseplatform.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.google.common.collect.Maps;

/** 卡洛思短信平台 */
public class CarlosUtil {

	/** 请求地址 */
	public final static String API_SERVER = "http://47.98.235.166:9918/sms.aspx";
	/** 请求参数 */
	public final static Map<String, String> API_BASE_PARAMS = Maps.newConcurrentMap();
	static {
		// 企业ID
		API_BASE_PARAMS.put("userid", "81");
		// 用户帐号
		API_BASE_PARAMS.put("account", "ZYJY");
		// 帐号密码
		API_BASE_PARAMS.put("password", "12345678");
	}

	/** 返回结果 */
	public static class SendResult {
		public final static String SUCCESS = "success";
		public final static String FAILD = "faild";
	}

	/** 短信验证内容 */
	public static class VerifyMsgFormat {
		/** 注册验证内容 */
		public final static String REGISTER = "【知育教育】知育安全中心：%s是您本次身份校验码，15分钟内有效。";
		/** 密码重置验证内容 */
		public final static String PASSWORD_RESET = "【知育教育】您的帐号%s正在重设密码，请输入验证码:%s，若不是您本人发出，请忽略。";
		/** 手表关注验证内容 */
		public final static String FOLLOW_DEVICE = "【知育教育】验证码：%s。手机号为%s的用户请求绑定手表，若同意，请将该验证码告之，15分钟内有效。";
	}

	/** 发送短信 */
	public static CarlosReciveMsg send(Map<String, String> params) {

		Map<String, String> sendParams = Maps.newHashMap(params);
		sendParams.putAll(API_BASE_PARAMS);

		String xmlStr = HttpClientUtil.doHttpPost(API_SERVER, sendParams);

		try {
            // 将xml格式的数据转换成Map对象
            Map<String, Object> map = xmlStrToMap(xmlStr);
            //将map对象的数据转换成Bean对象
            return mapToBean(map, CarlosReciveMsg.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

    /**
     * 将xml格式的字符串转换成Map对象
     *
     * @param xmlStr xml格式的字符串
     * @return Map对象
     * @throws Exception 异常
     */
    @SuppressWarnings("rawtypes")
	public static Map<String, Object> xmlStrToMap(String xmlStr) throws Exception {
        if(StringUtils.isEmpty(xmlStr)) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        //将xml格式的字符串转换成Document对象
        Document doc = DocumentHelper.parseText(xmlStr);
        //获取根节点
        Element root = doc.getRootElement();
        //获取根节点下的所有元素
        List children = root.elements();
        //循环所有子元素
        if(children != null && children.size() > 0) {
            for(int i = 0; i < children.size(); i++) {
                Element child = (Element)children.get(i);
                map.put(child.getName(), child.getTextTrim());
            }
        }
        return map;
    }

    /**
     * 将Map对象通过反射机制转换成Bean对象
     *
     * @param map 存放数据的map对象
     * @param clazz 待转换的class
     * @return 转换后的Bean对象
     * @throws Exception 异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T mapToBean(Map<String, Object> map, Class<T> clazz) throws Exception {
        T obj = clazz.newInstance();
        if(map != null && map.size() > 0) {
            for(Map.Entry<String, Object> entry : map.entrySet()) {
                String propertyName = entry.getKey();
                Object value = entry.getValue();
                String setMethodName = "set"
                        + propertyName.substring(0, 1).toUpperCase()
                        + propertyName.substring(1);
                Field field = getClassField(clazz, propertyName);
				Class<T> fieldTypeClass = (Class<T>) field.getType();
                value = convertValType(value, fieldTypeClass);
                clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
            }
        }
        return obj;
    }

    /**
     * 将Object类型的值，转换成bean对象属性里对应的类型值
     *
     * @param value Object对象值
     * @param fieldTypeClass 属性的类型
     * @return 转换后的值
     */
    @SuppressWarnings("rawtypes")
	private static Object convertValType(Object value, Class fieldTypeClass) {
        Object retVal = null;
        if(Long.class.getName().equals(fieldTypeClass.getName())
                || long.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Long.parseLong(value.toString());
        } else if(Integer.class.getName().equals(fieldTypeClass.getName())
                || int.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Integer.parseInt(value.toString());
        } else if(Float.class.getName().equals(fieldTypeClass.getName())
                || float.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Float.parseFloat(value.toString());
        } else if(Double.class.getName().equals(fieldTypeClass.getName())
                || double.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Double.parseDouble(value.toString());
        } else {
            retVal = value;
        }
        return retVal;
    }

    /**
     * 获取指定字段名称查找在class中的对应的Field对象(包括查找父类)
     *
     * @param clazz 指定的class
     * @param fieldName 字段名称
     * @return Field对象
     */
    @SuppressWarnings("unchecked")
    private static <T> Field getClassField(Class<T> clazz, String fieldName) {
        if( Object.class.getName().equals(clazz.getName())) {
            return null;
        }
        Field []declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

		Class<T> superClass = (Class<T>) clazz.getSuperclass();
        if(superClass != null) {// 简单的递归一下
            return getClassField(superClass, fieldName);
        }
        return null;
    }
}
