package com.sabujak.angelshot.service;

import java.util.HashMap;
import java.util.List;

import com.sabujak.angelshot.model.CallVO;

public interface AdminService {
	public List<CallVO> getUserList(HashMap<String, Object> map)  throws Exception;
	public List<HashMap> getUserListHashMap(HashMap<String, Object> map)  throws Exception;
}
