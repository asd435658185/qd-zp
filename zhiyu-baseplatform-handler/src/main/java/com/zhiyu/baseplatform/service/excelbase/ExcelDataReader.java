package com.zhiyu.baseplatform.service.excelbase;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Excel数据读取服务
 * 
 * @author wangdj
 *
 */
public class ExcelDataReader {

	/** 列名 */
	private String[] columnNames;
	/** 列类型 */
	private Integer[] columnTypes;
	/** 代码KV */
	private HashMap<String, Object> codeType;
	/** 写入到的Object类型,该方法必须继承ExcelObj才可以使用 */
	private AbsExcelObj excelDto;

	public AbsExcelObj getExcelDto() {
		return excelDto;
	}

	public void setExcelDto(AbsExcelObj excelDto) {
		this.excelDto = excelDto;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public Integer[] getColumnTypes() {
		return columnTypes;
	}

	public void setColumnTypes(Integer[] columnTypes) {
		this.columnTypes = columnTypes;
	}

	public HashMap<String, Object> getCodeType() {
		return codeType;
	}

	public void setCodeType(HashMap<String, Object> codeType) {
		this.codeType = codeType;
	}

	/**
	 * 获取excel到一个List<List<HashMap<String,Object>>> 从外到内依次为：sheet页,行,单元格
	 * 
	 * @param file
	 *            要读取的文件
	 * @param snum
	 *            读取那个sheet页,从0算起
	 * @param rnum
	 *            从那行开始读取,从0算起
	 * @return 返回一个List<List<HashMap<String,Object>>>对象
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public List<List<HashMap<String, Object>>> getExcel(File file, int snum, int rnum) throws Exception {
		List<List<HashMap<String, Object>>> list = new ArrayList<List<HashMap<String, Object>>>();
		Object localObject = null;
		// 传入路径
		FileInputStream is = new FileInputStream(file);
		HSSFWorkbook wbs = new HSSFWorkbook(is);
		HSSFSheet childSheet = wbs.getSheetAt(snum);
		for (int j = rnum; j <= childSheet.getLastRowNum(); j++) {
			// 读取行元素
			List<HashMap<String, Object>> listrow = new ArrayList<HashMap<String, Object>>();
			HSSFRow row = childSheet.getRow(j);
			if (null != row) {
				HashMap<String, Object> cellv = null;
				for (int k = 0; k < row.getLastCellNum(); k++) {
					// 读取单元格
					HSSFCell cell = row.getCell((short) k);
					cellv = new HashMap<String, Object>();
					if (cell == null) {
						cellv.put(columnNames[k], null);
						listrow.add(cellv);
						continue;
					} else {
						// 判断获取类型
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							localObject = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {// 时间类型数据
								localObject = cell.getDateCellValue();
								break;
							}
							localObject = cell.getNumericCellValue();
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							localObject = new Boolean(cell.getBooleanCellValue());
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							localObject = "";
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							int a = (cell.getCellFormula().indexOf("+") + 1) + (cell.getCellFormula().indexOf('/') + 1)
									+ (cell.getCellFormula().indexOf('*') + 1)
									+ (cell.getCellFormula().indexOf('-') + 1);
							if (a <= 0) {
								localObject = cell.getCellFormula();
							} else if (a > 0) {
								localObject = cell.getNumericCellValue();
							}
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							localObject = new Byte(cell.getErrorCellValue());
							break;
						default:
							System.out.println("未知类型");
							break;
						}
						try {
							// 限制类型的时候,做下面的类型强制转换
							if (columnTypes != null) {
								localObject = getRightTypeValue(localObject, k);
							}
						} catch (Exception e) {
							cellv.put("ErrMsg", e.getMessage());
							listrow.add(cellv);
							continue;
						}
						cellv.put(columnNames[k], localObject);
					}
					listrow.add(cellv);
				}
				list.add(listrow);
			}
		}
		return list;
	}

	/**
	 * 读取到excel到List<Object>
	 * 
	 * @param file
	 *            要读取的文件
	 * @param snum
	 *            读取那个sheet页,从0算起
	 * @param runm
	 *            从那行开始读取,从0算起
	 * @return 返回一个List<Object>对象
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List<Object> getExcelObj(File file, int snum, int runm) throws Exception {
		List<Object> list = new ArrayList<Object>();
		Class c = excelDto.getClass();
		AbsExcelObj dto = null;
		List<List<HashMap<String, Object>>> exceldata = getExcel(file, snum, runm);
		if (exceldata != null) {
			for (List<HashMap<String, Object>> lista : exceldata) {
				dto = (AbsExcelObj) c.newInstance();
				dto.putValue("ErrMsg", "");
				for (int i = 0; i < lista.size(); i++) {
					HashMap<String, Object> hm = lista.get(i);
					if (hm.get(columnNames[i]) != null) {
						dto.putValue(columnNames[i], hm.get(columnNames[i]));
					} else {
						dto.putValue("ErrMsg", dto.outValue("ErrMsg") + "第" + (i + 1) + "列存在为空的值;");
						continue;
					}
				}
				list.add(dto);
			}
		}
		return list;
	}

	/**
	 * 这里获取的值是输入正确,但是单元格属性设置错误导致类型错误,需要矫正的值
	 * 
	 * @param localObject
	 * @param k
	 * @return 经过类型矫正的值
	 * @throws Exception
	 */
	private Object getRightTypeValue(Object localObject, int k) throws Exception {
		switch (columnTypes[k]) {
		case ExcelColumnType.NO:// 不做任何转换
			break;
		case ExcelColumnType.cCode:
			// 需要根据KV转换规则进行转换
			Object obj = codeType.get(localObject.toString());
			if (obj == null) {
				throw new Exception("找不到对应的代码值,请确认代码值列是否为文本类型!");
			} else {
				localObject = obj;
			}
			break;
		case ExcelColumnType.cDATE:
			if (!(localObject instanceof Date)) {
				if (localObject instanceof String) {
					// 按照格式yyyy-MM-dd转换
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					localObject = sdf.parse(localObject.toString());
				} else if (localObject instanceof Double) {
					int day = ((Double) localObject).intValue();
					Calendar c = Calendar.getInstance();
					c.set(1900, 0, 1);
					c.add(Calendar.DAY_OF_YEAR, day);
					localObject = c.getTime();
				} else {
					throw new Exception("日期格式错误");
				}
			}
			break;
		case ExcelColumnType.cDOUBLE:
			if (!(localObject instanceof Double)) {
				if (localObject instanceof String) {
					localObject = Double.parseDouble(localObject.toString());
				}
			}
			break;
		case ExcelColumnType.cFlOAT:
			if (localObject instanceof Double) {
				localObject = ((Double) localObject).floatValue();
			}
			break;
		case ExcelColumnType.cINT:
			if (localObject instanceof Double) {
				localObject = ((Double) localObject).intValue();
			}
			break;
		case ExcelColumnType.cLONG:
			if (localObject instanceof Double) {
				localObject = ((Double) localObject).longValue();
			}
			break;
		case ExcelColumnType.cSTRING:
			if (localObject instanceof Double) {
				localObject = ((Double) localObject).longValue();
			}
			localObject = localObject.toString();
			break;
		}
		return localObject;
	}
}
