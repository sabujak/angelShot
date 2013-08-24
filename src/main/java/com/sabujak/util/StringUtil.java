package com.sabujak.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class StringUtil {
    public static String urlToString (String obj) throws UnsupportedEncodingException{
//    	System.out.println("UTF-8" + new String( URLDecoder.decode(obj, "").getBytes("UTF-8"),"EUC-KR" ));
//    	System.out.println("EUC-KR" + new String( URLDecoder.decode(obj, "").getBytes("EUC-KR"),"UTF-8" ));
//    	System.out.println("UTF-8" + new String( URLDecoder.decode(obj, "").getBytes("UTF-8"),"UTF-8" ));
//    	System.out.println("EUC-KR" + new String( URLDecoder.decode(obj, "").getBytes("EUC-KR"),"EUC-KR" ));
    	//isCharset(obj);
    	return charEncodeString( URLDecoder.decode(trimToString(obj, "")));
    }
     
    
    public static String charEncodeString (String obj) throws UnsupportedEncodingException{
    	return obj;//new String( obj.getBytes("UTF-8"),"UTF-8" );
    }
    public static String isServr(String sido, String gu) {
    	String serverType = "";
    	
    	if (sido.equals("") || gu.equals("")){
    		serverType = "A";
    		return serverType;
      	}
    
    	
    	
    	String service_sido[] = {"서울","인천","경기","광주","경북","대구","대전","전남","전북","제주","충남","충북"};
    	
    	
    	String service_gu[] = {"구미시","강진군","곡성군","나주시","담양군","목포시","무안군","영암군","장성군","진도군","함평군","해남군","화순군","군산시","익산시","전주시","계룡시","공주시","금산군","논산시","서천군","연기군","아산시","천안시","청주시","옥천군","청원군","청주시"};
    	
    	String subSido = sido.substring(0, 2);
    	String subGu = gu.substring(0,2);
    			
    	for (String tmpSido : service_sido) {
			if (subSido.equals(tmpSido)){
				if ( service_sido[0].equals(subSido) || 
						service_sido[1].equals(subSido) || 
						service_sido[2].equals(subSido)){
					serverType = "A";
				}else{
					for (String tmpGu : service_gu) {
						if (tmpGu.equals(subGu)){
							serverType = "B";
						}else{
							serverType = "";
						}
						
					}
				}
				
			}
		}
    	return serverType;
    	     
    	  
    	
    }
    
    public static String isCharset(String keyword) throws UnsupportedEncodingException{
    	if ( keyword != null ) {
    	     String charset[] = {"UTF-8", "euc-kr", "ksc5601", "iso-8859-1", "8859_1", "ascii", "latin1", "UTF-8"};
    	     
    	     for(int k=0; k<charset.length ; k++){
    	             for(int l=0 ; l<charset.length ; l++){
    	                     if(k==l){
    	                             continue;
    	                     }else{
    	                             System.out.println(charset[k]+" : "+charset[l]+" :"+new String(keyword.getBytes(charset[k]),charset[l]));
    	                     }
    	             }
    	     }
    	   }
    	return "";
    }
	public static String trimToString(Object obj) {
            return trimToString(obj, "");
    }
	     
 
    public static String trimToString(Object obj, String init) {
        if (obj == null) {
            return init;
        }
        String temp = init;
        if (obj instanceof String) {
            temp = StringUtil.trimToEmpty((String) obj);
        } else if (obj instanceof Integer) {
            temp = String.valueOf(((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            temp = String.valueOf(((Float) obj).floatValue());
        } else {
            temp = obj.toString().trim();
        }
        return temp;
    }
    public static String trimToEmpty(String str)
    {
      return str == null ? "" : str.trim();
    }
    
    public static String isStep(String status){
    	String returnStr = "";
    	if(status.equals("접수")||status.equals("대기")||status.equals("강제")||status.equals("문의")||status.equals("예약")){
    		returnStr = "1";
    	}else if(status.equals("배차")){
    		returnStr = "2";
    	}else{
    		returnStr = "3";
    	}
    	return returnStr;
    }
}
