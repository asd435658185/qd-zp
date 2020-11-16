package com.zhiyu.baseplatform.service.excelbase;

import java.io.File;
import java.util.List;

/**
 * 
 * @author wdj
 *
 */
public class ExcelImportService {

	/**
	 * 读取excel表格数据
	 * @param file
	 * @param fieldProperties   表格标题对应到代码中对象属性的名称
	 * @param types             相应格中到数据类型
	 * @return
	 * @throws Exception
	 */
	public List<Object> readImportExcelContent(AbsExcelObj excelObj, File file,String[] fieldProperties,Integer[] types ) throws Exception{
		ExcelDataReader excel = new ExcelDataReader();
		// 存入文件列名,必填项
		excel.setColumnNames(fieldProperties);
		excel.setColumnTypes(types);
		// //文件列名对应类型,可选,不写可能会出现异常
		excel.setExcelDto(excelObj);

		// 使用第二种方法直接获取List<Object>
		List<Object> list = excel.getExcelObj(file, 0, 1);
		
		return list;
	}
}
