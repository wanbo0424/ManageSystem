package cn.MS.service.serviceIm;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.MS.bean.Department;
import cn.MS.dao.DepartmentMapper;
import cn.MS.service.DepartmentService;

@Transactional
@Service("DepartmentService")
public class DepartmentServiceIm implements DepartmentService {
	@Autowired
	private DepartmentMapper dm;

	public int addDepartment(Department de) {
		return dm.addDepartment(de);
	}

	@Override
	public int delete(int id) {

		return dm.deleteDepartment(id);
	}

	@Override
	public String selectAll() {
		List<Department> list = dm.selectAll();
		JSONArray array = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		int i=0;
		if (list != null) {
			for (Department d : list) {
				i++;
				JSONObject ob = new JSONObject();
				ob.put("id", d.getId());
				ob.put("departmentName", d.getDepartmentName());
				ob.put("phone", d.getPhone());
				ob.put("state", d.getState());
				array.put(ob);
			}
		}
		jsonObject.put("total", i);
		jsonObject.put("rows", array);

		return jsonObject.toString();
	}

	@Override
	public int updateDepartment(Department de) {
		return dm.updateDepartment(de);
	}

	/* 
	 * @see cn.MS.service.DepartmentService#getAllIdandName()
	 */
	@Override
	public String getAllIdandName() {
		List<Department> list = dm.selectAll();
		JSONArray array = new JSONArray();

		if (list != null) {
			for (Department d : list) {
				JSONObject ob = new JSONObject();
				ob.put("id", d.getId());
				ob.put("departmentName", d.getDepartmentName());
				array.put(ob);
			}
		}
	
		return array.toString();
	}
}
