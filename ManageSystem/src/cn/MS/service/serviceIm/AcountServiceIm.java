package cn.MS.service.serviceIm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.MS.bean.User;
import cn.MS.dao.UserMapper;
import cn.MS.service.AcountService;

@Transactional
@Service("AcountService")
public class AcountServiceIm implements AcountService {
	@Autowired
	UserMapper um;

	@Override
	public User getUser(User user) {

		return um.getUserByLoginname(user.getLoginName());
	}

}
