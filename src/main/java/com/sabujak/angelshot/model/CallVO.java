package com.sabujak.angelshot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CallVO {
	private String user_key; //	회원고유번호
	private String call_no; //	주문번호
	
	private String start_sido;
	private String start_gu;
	private String start_mn;
	private String start_poi_name;
	private String start_lat;
	private String start_long;
	
	private String end_sido;
	private String end_gu;
	private String end_mn;
	private String end_poi_name;
	private String end_lat;
	private String end_long;
	
	private String via_yn;
	private String call_price;
	private String receipt_no;
	private String status;
	private String call_hpno;
	private String wrt_dttm;
	private String upd_dttm;
	private String cancel_dttm;
	private String dev_code;
	private String memo;
	
	
	
	
	private String mac_address; //	단말기 별 고유 mac address
	private String hp_no; //	회원 휴대전화번호
	private String agree_dttm; //	동의일시
	private String agree_code; // 동의코드
	
	
	
	private int total_cnt;
	private int start_num;
	private int end_num;
	private int rnum;
	
	@SuppressWarnings("rawtypes")
	private List<HashMap> hashMapList;
	
	@SuppressWarnings("rawtypes")
	public List<HashMap> getHashMapList(){
		if(hashMapList == null){
			hashMapList = new ArrayList<HashMap>();
		}
		return hashMapList;
	}
	
	@SuppressWarnings("rawtypes")
	public void setHashMapList(List<HashMap> hashMapList){
		this.hashMapList = hashMapList;
	}
	
	
	
	
	public int getTotal_cnt() {
		return total_cnt;
	}

	public void setTotal_cnt(int total_cnt) {
		this.total_cnt = total_cnt;
	}

	public int getStart_num() {
		return start_num;
	}

	public void setStart_num(int start_num) {
		this.start_num = start_num;
	}

	public int getEnd_num() {
		return end_num;
	}

	public void setEnd_num(int end_num) {
		this.end_num = end_num;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getUser_key() {
		return user_key;
	}
	
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	public String getCall_no() {
		return call_no;
	}
	public void setCall_no(String call_no) {
		this.call_no = call_no;
	}
	public String getStart_sido() {
		return start_sido;
	}
	public void setStart_sido(String start_sido) {
		this.start_sido = start_sido;
	}
	public String getStart_gu() {
		return start_gu;
	}
	public void setStart_gu(String start_gu) {
		this.start_gu = start_gu;
	}
	public String getStart_mn() {
		return start_mn;
	}
	public void setStart_mn(String start_mn) {
		this.start_mn = start_mn;
	}
	public String getStart_poi_name() {
		return start_poi_name;
	}
	public void setStart_poi_name(String start_poi_name) {
		this.start_poi_name = start_poi_name;
	}
	public String getStart_lat() {
		return start_lat;
	}
	public void setStart_lat(String start_lat) {
		this.start_lat = start_lat;
	}
	public String getStart_long() {
		return start_long;
	}
	public void setStart_long(String start_long) {
		this.start_long = start_long;
	}
	public String getEnd_sido() {
		return end_sido;
	}
	public void setEnd_sido(String end_sido) {
		this.end_sido = end_sido;
	}
	public String getEnd_gu() {
		return end_gu;
	}
	public void setEnd_gu(String end_gu) {
		this.end_gu = end_gu;
	}
	public String getEnd_mn() {
		return end_mn;
	}
	public void setEnd_mn(String end_mn) {
		this.end_mn = end_mn;
	}
	public String getEnd_poi_name() {
		return end_poi_name;
	}
	public void setEnd_poi_name(String end_poi_name) {
		this.end_poi_name = end_poi_name;
	}
	public String getEnd_lat() {
		return end_lat;
	}
	public void setEnd_lat(String end_lat) {
		this.end_lat = end_lat;
	}
	public String getEnd_long() {
		return end_long;
	}
	public void setEnd_long(String end_long) {
		this.end_long = end_long;
	}
	public String getVia_yn() {
		return via_yn;
	}
	public void setVia_yn(String via_yn) {
		this.via_yn = via_yn;
	}
	public String getCall_price() {
		return call_price;
	}
	public void setCall_price(String call_price) {
		this.call_price = call_price;
	}
	public String getReceipt_no() {
		return receipt_no;
	}
	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCall_hpno() {
		return call_hpno;
	}
	public String getCall_hpno1(){
		if(call_hpno!=null){
			return call_hpno.substring(0,3);
		}else{
			return call_hpno;
		}
	}
	
	public String getCall_hpno2(){
		if(call_hpno!=null){
			return call_hpno.substring(3,7);
		}else{
			return call_hpno;
		}
	}
	
	public String getCall_hpno3(){
		if(call_hpno!=null){
			return call_hpno.substring(7);
		}else{
			return call_hpno;
		}
	}
	public void setCall_hpno(String call_hpno) {
		this.call_hpno = call_hpno;
	}
	public String getWrt_dttm() {
		return wrt_dttm;
	}
	public void setWrt_dttm(String wrt_dttm) {
		this.wrt_dttm = wrt_dttm;
	}
	public String getUpd_dttm() {
		return upd_dttm;
	}
	public void setUpd_dttm(String upd_dttm) {
		this.upd_dttm = upd_dttm;
	}
	public String getCancel_dttm() {
		return cancel_dttm;
	}
	public void setCancel_dttm(String cancel_dttm) {
		this.cancel_dttm = cancel_dttm;
	}
	public String getDev_code() {
		return dev_code;
	}
	public void setDev_code(String dev_code) {
		this.dev_code = dev_code;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getMac_address() {
		return mac_address;
	}

	public void setMac_address(String mac_address) {
		this.mac_address = mac_address;
	}

	public String getHp_no() {
		return hp_no;
	}
	
	public String getHp_no1(){
		if(hp_no!=null){
			return hp_no.substring(0,3);
		}else{
			return hp_no;
		}
	}
	
	public String getHp_no2(){
		if(hp_no!=null){
			return hp_no.substring(3,7);
		}else{
			return hp_no;
		}
	}
	
	public String getHp_no3(){
		if(hp_no!=null){
			return hp_no.substring(7);
		}else{
			return hp_no;
		}
	}
	
	
	public void setHp_no(String hp_no) {
		this.hp_no = hp_no;
	}

	public String getAgree_dttm() {
		return agree_dttm;
	}

	public void setAgree_dttm(String agree_dttm) {
		this.agree_dttm = agree_dttm;
	}

	public String getAgree_code() {
		return agree_code;
	}

	public void setAgree_code(String agree_code) {
		this.agree_code = agree_code;
	}
}
