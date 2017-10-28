package cn.MS.service;

import java.util.List;

import cn.MS.bean.CompareResults;
import cn.MS.bean.FailPerson;

public interface FailPersonService {
	String getAll();  //��ѯ���в��ϸ���Ա
	int add(FailPerson fp);
	int delete(int id);
	int update(FailPerson fp);
	/**
	 * ���ݱȽϽ�������ϸ����Ա�Զ���ӵ����ϸ����
	 */
	int autoAddFailPerson();
	/**
	 * ���������Ƚ�
	 * @return ���رȽϽ��list���ϣ����屣����CompareResults����
	 */
	List<CompareResults> compare();
	String getCompareResults();
}
