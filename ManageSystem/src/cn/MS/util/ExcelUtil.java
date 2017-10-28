package cn.MS.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import cn.MS.bean.VisitData;

/**
 * 数据导入和导出的工具类ExcelUtil
 * 
 * @author asus
 *
 */

public class ExcelUtil {
	// 总行数
	private int totalRows = 0;
	// 总条数
	private int totalCells = 0;
	// 错误信息接收器
	private String errorMsg;

	// 构造方法
	public ExcelUtil() {
	}

	// 获取总行数
	public int getTotalRows() {
		return totalRows;
	}

	// 获取总列数
	public int getTotalCells() {
		return totalCells;
	}

	// 获取错误信息
	public String getErrorInfo() {
		return errorMsg;
	}

	/**
	 * 读EXCEL文件，获取信息集合
	 * 
	 * @param fielName
	 * @return
	 */
	public List<VisitData> getExcelInfo(MultipartFile mFile) {
		String fileName = mFile.getOriginalFilename();// 获取文件名
		List<VisitData> visitDataList = null;
		try {
			if (!validateExcel(fileName)) {// 验证文件名是否合格
				return null;
			}
			boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
			if (isExcel2007(fileName)) {
				isExcel2003 = false;
			}
			visitDataList = createExcel(mFile.getInputStream(), isExcel2003);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visitDataList;
	}

	/**
	 * 根据excel里面的内容读取客户信息
	 * 
	 * @param is
	 *            输入流
	 * @param isExcel2003
	 *            excel是2003还是2007版本
	 * @return
	 * @throws IOException
	 */
	public List<VisitData> createExcel(InputStream is, boolean isExcel2003) {
		List<VisitData> visitDataList = null;
		try {
			Workbook wb = null;
			if (isExcel2003) {// 当excel是2003时,创建excel2003
				wb = new HSSFWorkbook(is);
			} else {// 当excel是2007时,创建excel2007
				wb = new XSSFWorkbook(is);
			}
			visitDataList = readExcelValue(wb);// 读取Excel里面客户的信息
		} catch (IOException e) {
			e.printStackTrace();
		}
		return visitDataList;
	}

	/**
	 * 读取Excel里面客户的信息
	 * 
	 * @param wb
	 * @return
	 */
	private List<VisitData> readExcelValue(Workbook wb) {
		// 得到第一个shell
		Sheet sheet = (Sheet) wb.getSheetAt(0);
		// 得到Excel的行数
		this.totalRows = sheet.getPhysicalNumberOfRows();
		// 得到Excel的列数(前提是有行数)
		if (totalRows > 1 && sheet.getRow(0) != null) {
			this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		List<VisitData> visitDataList = new ArrayList<VisitData>();
		// 循环Excel行数
		for (int r = 1; r < totalRows; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			VisitData visitData = new VisitData();
			// 循环Excel的列
			for (int c = 0; c < this.totalCells; c++) {
				Cell cell = row.getCell(c);
				try{
					if (null != cell) {
						int cellType = cell.getCellType();
						// 姓名
						if (c == 0) {
							if (cellType == HSSFCell.CELL_TYPE_STRING) {
								visitData.setVisitPerson(cell.getStringCellValue().toString());
							}
						} else if (c == 1) { // 日期
							if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									// 如果是date类型则 ，获取该cell的date值
									Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
									visitData.setVisitDate(date);
								}
							}
						} else if (c == 2) { // 时间
							if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									// 如果是date类型则 ，获取该cell的date值
									Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
									visitData.setVisitTime(date);
								}
							}
						} else if (c == 3) { // 地点
							if (cellType == HSSFCell.CELL_TYPE_STRING) {
								visitData.setAddress(cell.getStringCellValue().toString());
							}
						} else if (c == 4) { // 部门
							if (cellType == HSSFCell.CELL_TYPE_STRING) {
								visitData.setDepartmentName(cell.getStringCellValue().toString());
							}
						} else if (c == 5) { // 职务
							if (cellType == HSSFCell.CELL_TYPE_STRING) {
								visitData.setRoleName(cell.getStringCellValue().toString());
							}
						} else if (c == 6) { // 纵享销客
							if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
								BigDecimal big=new BigDecimal(cell.getNumericCellValue());  
				                String value = big.toString();  
				                //解决1234.0  去掉后面的.0  
				                if(null!=value&&!"".equals(value.trim())){  
				                     String[] item = value.split("[.]");  
				                     if(1<item.length&&"0".equals(item[1])){  
				                         value=item[0];  
				                     }  
				                }  
								visitData.setCountPerson(value);
							}else{
								visitData.setCountPerson(cell.getStringCellValue().toString());
							}
						} else if (c == 7) { // 走访内容
							if (cellType == HSSFCell.CELL_TYPE_STRING) {
								visitData.setDetails(cell.getStringCellValue().toString());
							}
						}
					}
				}catch(Exception e){
					
				}
			}
			// 添加到list
			visitDataList.add(visitData);
		}
		return visitDataList;
	}

	/**
	 * 验证EXCEL文件
	 * 
	 * @param filePath
	 * @return
	 */
	public boolean validateExcel(String filePath) {
		if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
			errorMsg = "文件名不是excel格式";
			return false;
		}
		return true;
	}

	// @描述：是否是2003的excel，返回true是2003
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	// @描述：是否是2007的excel，返回true是2007
	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
}