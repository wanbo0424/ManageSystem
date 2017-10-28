package cn.MS.service;


import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import cn.MS.bean.VisitData;

public interface VisitDataService {
	/**
	 * ��ȡexcel�е�����,����list
	 */
	String readExcelFile(MultipartFile file);
	String addVisitData(VisitData visitData);
	String getByUsername(String username);
	String getByDate(Date date);
	String getAll();
}
