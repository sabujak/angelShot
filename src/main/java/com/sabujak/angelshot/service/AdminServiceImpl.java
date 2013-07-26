package com.sabujak.angelshot.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabujak.angelshot.dao.AdminDao;
import com.sabujak.angelshot.model.CallVO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired 
	private AdminDao adminDao;
	
	@Override
	public List<CallVO> getUserList(HashMap<String, Object> map) throws Exception {
		List<CallVO> list = adminDao.getUserList(map);
		//DR_User dr_user = tDriver01Dao.isFirst(mac);
		return list;
			
	}
	
	@Override
	public List<HashMap> getUserListHashMap(HashMap<String, Object> map)  throws Exception {
		List<HashMap> list = adminDao.getUserListHashMap(map);
		//DR_User dr_user = tDriver01Dao.isFirst(mac);
		return list;
			
	}

}
