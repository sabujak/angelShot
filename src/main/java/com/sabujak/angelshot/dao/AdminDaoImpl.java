package com.sabujak.angelshot.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sabujak.angelshot.model.CallVO;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired 
	SqlSession sqlSessionTemplat;
	

	
	@Override
	public List<CallVO> getUserList(HashMap<String, Object> map)  throws Exception{
		
		//HashMap<String,Object> param = new HashMap<String, Object>();
		//param.put("hp_no",callVo.getHp_no());
		//param.put("call_hpno", callVo.getCall_hpno());
		
		List<CallVO> list = sqlSessionTemplat.selectList("admin.getUserList",map);
		return list;
	}

	
	
	@SuppressWarnings({"rawtypes","unchecked"})
	public List<HashMap> getUserListHashMap(HashMap<String, Object> map)  throws Exception{
		
		//HashMap<String,Object> param = new HashMap<String, Object>();
		//map.put("hp_no",callVo.getHp_no());
		//map.put("call_hpno", callVo.getCall_hpno());
		
		List<HashMap> list = sqlSessionTemplat.selectList("admin.getUserListHashMap",map);
		return list;
	}
}
