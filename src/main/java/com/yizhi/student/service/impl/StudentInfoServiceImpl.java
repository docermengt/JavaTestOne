package com.yizhi.student.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yizhi.student.dao.StudentInfoDao;
import com.yizhi.student.domain.StudentInfoDO;
import com.yizhi.student.service.StudentInfoService;



@Service
public class StudentInfoServiceImpl implements StudentInfoService {



	@Autowired
	private StudentInfoDao studentInfoDao;
	
	@Override
	public StudentInfoDO get(Integer id){
		System.out.println("======service层中传递过来的id参数是：" + id + "======");
		return studentInfoDao.get(id);
	}


	@Override
	public List<StudentInfoDO> list(Map<String, Object> map){
		Integer currPage = new Integer(map.get("currPage").toString());
		Integer pageSize = new Integer(map.get("pageSize").toString());
		Integer start = (currPage-1)*pageSize;
		Map map1 = new HashMap();
		map1.put("start", start);
		map1.put("pageSize", pageSize);
		return studentInfoDao.list(map1);
	}

	//"===================================================================================="


	@Override
	public int count(Map<String, Object> map){
		return studentInfoDao.count(map);
	}
	
	@Override
	public int save(StudentInfoDO studentInfo){
		return studentInfoDao.save(studentInfo);
	}
	
	@Override
	public int update(StudentInfoDO studentInfo){
		return studentInfoDao.update(studentInfo);
	}
	
	@Override
	public int remove(Integer id){
		return studentInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return studentInfoDao.batchRemove(ids);
	}
	
}
