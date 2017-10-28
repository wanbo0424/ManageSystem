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
 * ���ݵ���͵����Ĺ�����ExcelUtil
 * 
 * @author asus
 *
 */

public class ExcelUtil {
	// ������
	private int totalRows = 0;
	// ������
	private int totalCells = 0;
	// ������Ϣ������
	private String errorMsg;

	// ���췽��
	public ExcelUtil() {
	}

	// ��ȡ������
	public int getTotalRows() {
		return totalRows;
	}

	// ��ȡ������
	public int getTotalCells() {
		return totalCells;
	}

	// ��ȡ������Ϣ
	public String getErrorInfo() {
		return errorMsg;
	}

	/**
	 * ��EXCEL�ļ�����ȡ��Ϣ����
	 * 
	 * @param fielName
	 * @return
	 */
	public List<VisitData> getExcelInfo(MultipartFile mFile) {
		String fileName = mFile.getOriginalFilename();// ��ȡ�ļ���
		List<VisitData> visitDataList = null;
		try {
			if (!validateExcel(fileName)) {// ��֤�ļ����Ƿ�ϸ�
				return null;
			}
			boolean isExcel2003 = true;// �����ļ����ж��ļ���2003�汾����2007�汾
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
	 * ����excel��������ݶ�ȡ�ͻ���Ϣ
	 * 
	 * @param is
	 *            ������
	 * @param isExcel2003
	 *            excel��2003����2007�汾
	 * @return
	 * @throws IOException
	 */
	public List<VisitData> createExcel(InputStream is, boolean isExcel2003) {
		List<VisitData> visitDataList = null;
		try {
			Workbook wb = null;
			if (isExcel2003) {// ��excel��2003ʱ,����excel2003
				wb = new HSSFWorkbook(is);
			} else {// ��excel��2007ʱ,����excel2007
				wb = new XSSFWorkbook(is);
			}
			visitDataList = readExcelValue(wb);// ��ȡExcel����ͻ�����Ϣ
		} catch (IOException e) {
			e.printStackTrace();
		}
		return visitDataList;
	}

	/**
	 * ��ȡExcel����ͻ�����Ϣ
	 * 
	 * @param wb
	 * @return
	 */
	private List<VisitData> readExcelValue(Workbook wb) {
		// �õ���һ��shell
		Sheet sheet = (Sheet) wb.getSheetAt(0);
		// �õ�Excel������
		this.totalRows = sheet.getPhysicalNumberOfRows();
		// �õ�Excel������(ǰ����������)
		if (totalRows > 1 && sheet.getRow(0) != null) {
			this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		List<VisitData> visitDataList = new ArrayList<VisitData>();
		// ѭ��Excel����
		for (int r = 1; r < totalRows; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			VisitData visitData = new VisitData();
			// ѭ��Excel����
			for (int c = 0; c < this.totalCells; c++) {
				Cell cell = row.getCell(c);
				try{
					if (null != cell) {
						int cellType = cell.getCellType();
						// ����
						if (c == 0) {
							if (cellType == HSSFCell.CELL_TYPE_STRING) {
								visitData.setVisitPerson(cell.getStringCellValue().toString());
							}
						} else if (c == 1) { // ����
							if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									// �����date������ ����ȡ��cell��dateֵ
									Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
									visitData.setVisitDate(date);
								}
							}
						} else if (c == 2) { // ʱ��
							if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
								if (HSSFDateUtil.isCellDateFormatted(cell)) {
									// �����date������ ����ȡ��cell��dateֵ
									Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
									visitData.setVisitTime(date);
								}
							}
						} else if (c == 3) { // �ص�
							if (cellType == HSSFCell.CELL_TYPE_STRING) {
								visitData.setAddress(cell.getStringCellValue().toString());
							}
						} else if (c == 4) { // ����
							if (cellType == HSSFCell.CELL_TYPE_STRING) {
								visitData.setDepartmentName(cell.getStringCellValue().toString());
							}
						} else if (c == 5) { // ְ��
							if (cellType == HSSFCell.CELL_TYPE_STRING) {
								visitData.setRoleName(cell.getStringCellValue().toString());
							}
						} else if (c == 6) { // ��������
							if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
								BigDecimal big=new BigDecimal(cell.getNumericCellValue());  
				                String value = big.toString();  
				                //���1234.0  ȥ�������.0  
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
						} else if (c == 7) { // �߷�����
							if (cellType == HSSFCell.CELL_TYPE_STRING) {
								visitData.setDetails(cell.getStringCellValue().toString());
							}
						}
					}
				}catch(Exception e){
					
				}
			}
			// ��ӵ�list
			visitDataList.add(visitData);
		}
		return visitDataList;
	}

	/**
	 * ��֤EXCEL�ļ�
	 * 
	 * @param filePath
	 * @return
	 */
	public boolean validateExcel(String filePath) {
		if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
			errorMsg = "�ļ�������excel��ʽ";
			return false;
		}
		return true;
	}

	// @�������Ƿ���2003��excel������true��2003
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	// @�������Ƿ���2007��excel������true��2007
	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
}