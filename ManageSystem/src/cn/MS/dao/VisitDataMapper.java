package cn.MS.dao;

import java.util.List;

import cn.MS.bean.VisitData;

public interface VisitDataMapper {
	int addVisitData(VisitData visitData);  //���һ������
	List<VisitData> getVisitDataByVisitPerson(String visitPerson);
	List<VisitData> getVisitDataByVisitDate(String date);
	List<VisitData> getAllVisitData();
}
