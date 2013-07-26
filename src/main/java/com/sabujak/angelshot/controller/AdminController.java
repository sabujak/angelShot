package com.sabujak.angelshot.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sabujak.angelshot.model.CallVO;
import com.sabujak.angelshot.model.FromApplication;
import com.sabujak.angelshot.service.AdminService;
import com.sabujak.util.StringUtil;


@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired 
	private AdminService adminService;
	
	
	@RequestMapping(value = "/admindex.do")
	public String admIndex(HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		
		
		return "admin/login";
	}
	
	
	@RequestMapping(value = "/admlogin.do", method = RequestMethod.POST)
	public String admlogin(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="admin_id",required=true,defaultValue="") String admId,
			@RequestParam(value="admin_pass",required=true,defaultValue="") String admPass) throws Exception {
		
	
		admId = StringUtil.urlToString(admId);
		admPass =  StringUtil.urlToString(admPass);
		
		if(admId.equals("tmap") && admPass.equals("driver")){
			CallVO userVo = new CallVO();			
			userVo.setHp_no("admin");			
			HttpSession session = request.getSession();			
			session.setAttribute("userSes", userVo);
			
		}else{
			return "admin/login";
		}
		
		
		return "redirect:/admin/admin.do";
	}
	
	@RequestMapping(value = "/admlogout.do", method = RequestMethod.GET)
	public String admlogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();		
		CallVO userVo = (CallVO) request.getSession().getAttribute("userSes");
		
		session.removeValue("userSes");
		
		return "admin/login";
	}
	
	@RequestMapping(value = "/admin.do", method = RequestMethod.GET)
	public String adminMain(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="page",required=true,defaultValue="1") int page,
			@RequestParam(value="keyfield",required=true,defaultValue="") String keyfield,
			@RequestParam(value="keyword",required=true,defaultValue="") String keyword ) throws Exception {
		
		keyfield = StringUtil.urlToString(keyfield);
		keyword =  StringUtil.urlToString(keyword);		
		
		
		/*
		HttpSession session = request.getSession();	
		
		if(request.getSession().getAttribute("userSes")==null){
			return "admin/index";
		}
		CallVO userVo = (CallVO) request.getSession().getAttribute("userSes");
		
				
		if(userVo.getHp_no()==null){
			return "admin/index";
		}else if(!userVo.getHp_no().equals("admin")){
			return "admin/index";
		}
		*/
		
		int perpage = 10;
		int listpage = 5;
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("perpage", perpage);
		map.put("currentPage", page);
		
		if(keyfield.equals("hp_no")){
			map.put("hp_no", keyword);
			map.put("call_hpno","");
		}else if(keyfield.equals("call_hpno")){
			map.put("hp_no", "");
			map.put("call_hpno", keyword);
		}else{
			map.put("hp_no", "");
			map.put("call_hpno","");
		}
		
		List<CallVO> list = adminService.getUserList(map);
		List<HashMap> hashMapList = adminService.getUserListHashMap(map);
		
		CallVO callVo = (CallVO)list.get(0);
		
		request.setAttribute("list", list);
		
		request.setAttribute("totalCnt", callVo.getTotal_cnt());
		request.setAttribute("startNum", callVo.getStart_num());
		request.setAttribute("endNum", callVo.getEnd_num());
		
		request.setAttribute("currentPage", page);
		request.setAttribute("perpage", perpage);
		request.setAttribute("listpage", listpage);		
		request.setAttribute("hashMapList", hashMapList);
		
		return "admin/adm";
	}
	
}
