package com.sabujak.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationHelper {
	
	public static String htmlSpecialchars(String _in) {
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<_in.length(); i++) {
		  char c = _in.charAt(i);

		  switch (c) {
		    case '<' : 
		      sb.append("&lt;");
		      break;
		    case '>' : 
		      sb.append("&gt;");
		      break;

		    case '&' :
		      sb.append("&amp;");
		      break;
		    case '"' :
		      sb.append("&quot;");
		      break;
		    case '\'' :

		      sb.append("&apos;");
		      break;
		    default:
		      sb.append(c);
		    }
		}
		  
		return sb.toString();
	}
	/**
	 * 
	 * [�좎룞�쇿뜝�섎툦�� �좎룞�쇿뜝�깆룞�쇿뜝�숈삕�좎뙓�몄삕 �좎룞�숈튂�좎룞�쇿뜝�섍낀���좎룞�쇿뜝�됰릺�듭삕�좎룞�쇿뜝�숈삕�좎룞��True �좎룞�쇿뜝�숈삕�좎룞��False
	 * 
	 */
	public static boolean isInclude(String baseStr, String searchStr) {
		
		for(int i = 0; i < baseStr.length(); i++){
			
			if(baseStr.length() - i >= searchStr.length()){
				String base = baseStr.substring(i, i + searchStr.length());
				
				if(base.equals(searchStr)){
					return true;
				}
			}
		}
		return false;		
	}
	
	/**
	 * 
	 * [�좎룞�쇿뜝�섎툦�� �좎룞�쇿뜝�밸콈�쇿뜝�숈삕 �좎룞�쇿뜝�숈삕�좎뙏�쎌삕 �좎룞�쇿뜝�숈삕�좎룞�쇿뜝�숈삕 泥댄겕 (aaaa, 1111) �좎룞�쇿뜝�숈삕�좎떦紐뚯삕 true
	 * 
	 */
	public static boolean isSame(String str) {
		
		int s = 0;
		int chk = 0;
				
		for(int i = 0; i < str.length(); i++){			
			if(s == str.codePointAt(i)){
				chk += 1;
			}
			else{
				chk = 0;
			}
			
			if(chk >= 3) return true;
			else s = str.codePointAt(i);
		}
		return false;
	}
	
	/**
	 * 
	 * [�좎룞�쇿뜝�섎툦�� �좎룞�쇿뜝�덈벝���좎룞�쇿뜝�섍낀���좎룞�쇿뜝�숈삕�좎룞�쇿뜝�숈삕 泥댄겕 (123, abc) �좎룞�쇿뜝�덈릺紐뚯삕 true
	 * 
	 */
	public static boolean isSequence(String str) {
					
		for(int i = 0; i < str.length(); i++){			
			if(str.length() - i >= 3){
				int a = str.codePointAt(i) - str.codePointAt(i + 1);
				int b = str.codePointAt(i + 1) - str.codePointAt(i + 2);
				int result = Math.abs(a) + Math.abs(b);
				if(result == 2) return true;
			}
		}	
		return false;
	}
		
	/**
	 * 
	 * [�좎룞�쇿뜝�섎툦�� �좎룞�쇿뜝�숈삕 �좎룞�쇿뜝�숈삕 泥댄겕
	 * 
	 */
	public static boolean isLength(String str, int min, int max) {
		
		if(str.length() < min) return false;
		if(str.length() > max) return false;
				
		return true;
	}
	
	/**
	 * 
	 * [�좎룞�쇿뜝�섎툦�� �좎룞�쇿뜝�덈벝���ㅵ뜝�숈삕�좎룞���좎룞�쇿뜝�섏슱��泥댄겕
	 * 
	 */
	public static boolean isKeybordSequence(String passwd) {

		String t = "qwertyuiop";
		String c = "asdfghjkl";
		String b = "zxcvbnm";

		String str = "";

		for (int i = 0; i < t.length() - 3; i++) {
			str = "" + t.charAt(i) + t.charAt(i + 1) + t.charAt(i + 2) + t.charAt(i + 3);
			if (passwd.indexOf(str) != -1) return true;
		}
		
		for (int i = 0; i < c.length() - 3; i++) {
			str = "" + c.charAt(i) + c.charAt(i + 1) + c.charAt(i + 2) + c.charAt(i + 3);
			if (passwd.indexOf(str) != -1) return true;
		}
		
		for (int i = 0; i < b.length() - 3; i++) {
			str = "" + b.charAt(i) + b.charAt(i + 1) + b.charAt(i + 2) + b.charAt(i + 3);
			if (passwd.indexOf(str) != -1) return true;
		}
		
		return false;
	}
	
	
	
	/**
	 * 
	 * [�좎룞�쇿뜝�섎툦�� XSS �좎룞�쇿뜝�숈삕 true = �좎룞�쇿뜝�숈삕 , false = �좎룞�쇿뜝�숈삕
	 * 
	 */
	public static boolean isScriptAttack(String str) { 
		
		boolean att = false;
		
		if(str != null){
			if(ValidationHelper.isInclude(str, "<")) att =true;
			if(ValidationHelper.isInclude(str, ">")) att =true;
			if(ValidationHelper.isInclude(str, "\"")) att =true;
			if(ValidationHelper.isInclude(str, "'")) att =true;
			if(ValidationHelper.isInclude(str, "&")) att =true;
		}
		
		return att;
	}
			
	//[�좎룞�쇿뜝�섎툦�� �좎룞�쇿뜝�섍낀���좎룞�쇿뜝�숈삕 �좎떎�먯삕�좎룞��泥댄겕
	public static boolean isNumber(String str) {
		String chk = "0123456789";
		
		for(int i = 0; i < chk.length(); i++){
			for(int j = 0; j < str.length(); j++){
				if(chk.charAt(i) == str.charAt(j)){
					return true;
				}
			}	
		}
		
		return false;
	}
	
	//[�좎룞�쇿뜝�섎툦�� �좎룞�쇿뜝�섍� �좎룞�쇿뜝�숈삕 �좎떎�먯삕�좎룞��泥댄겕
	public static boolean isEng(String str) {
		String chk = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for(int i = 0; i < chk.length(); i++){
			for(int j = 0; j < str.length(); j++){
				if(chk.charAt(i) == str.charAt(j)){
					return true;
				}
			}	
		}
		
		return false;
	}
	
	//[�좎룞�쇿뜝�섎툦�� �밧뜝�숈삕�좎뙓怨ㅼ삕 �좎룞�쇿뜝�숈삕 �좎떎�먯삕�좎룞��泥댄겕
	public static boolean isSpecial(String str) {
		String chk = "~`!@#$%^&*()-_+={}[];:'\"?/<>,.|\\";

		for(int i = 0; i < chk.length(); i++){
			for(int j = 0; j < str.length(); j++){
				if(chk.charAt(i) == str.charAt(j)){
					return true;
				}
			}	
		}
		
		return false;
	}
	
	//[�좎룞�쇿뜝�섎툦�� �좎룞�쇿뜝占썲뜝�숈삕�좎룞���좎룞�쇿뜝�숈삕 �밧뜝�숈삕�좎뙓怨ㅼ삕 �좎룞�쇿뜝�숈삕 �좎떎�먯삕�좎룞��泥댄겕 - !@$%^&* �좎룞���좎룞�쇿뜝占� 
	public static boolean isNotSpecial(String str) {
		String chk = "~`#()-_+={}[];:'\"?/<>,.|\\";
				
		for(int i = 0; i < chk.length(); i++){
			for(int j = 0; j < str.length(); j++){
				if(chk.charAt(i) == str.charAt(j)){
					return true;
				}
			}	
		}
		
		return false;
	}
	
	//[�좎룞�쇿뜝�섎툦�� �좎룞�숈껜�좎룞���좎룞�쇿뜝�숈삕�좎룞�쇿뜝�숈삕 泥댄겕
	public static boolean isNumbers(String str) {
		if(!isEng(str) && !isSpecials(str)) return true;
		return false;
	}
	
	//[�좎룞�쇿뜝�섎툦�� �좎룞�숈껜�좎룞���좎룞�쇿뜝�숈삕�좎룞�쇿뜝�숈삕 泥댄겕
	public static boolean isEngs(String str) {
		if(!isNumber(str) && !isSpecials(str)) return true;
		return false;
	}
	
	//[�좎룞�쇿뜝�섎툦�� �좎룞�숈껜�좎룞���밧뜝�숈삕�좎룞�쇿뜝�숈삕�좎룞��泥댄겕
	public static boolean isSpecials(String str) {
		if(!isEng(str) && !isNumber(str)) return true;
		return false;
	}

	//[�좎룞�쇿뜝�섎툦�� �좎룞�쇿뜝�깅벝���좎룞�숅뜮占쎌삕�좑옙泥댄겕
	public static boolean isIdstr(String str){
		String chk = "abcdefghijklmnopqrstuvwxyz0123456789-_";

		for(int i = 0; i < chk.length(); i++){
			for(int j = 0; j < str.length(); j++){
				if(chk.charAt(i) == str.charAt(j)){
					return true;
				}
			}	
		}
		
		return false;
	}
	public static boolean isValidMac(String mac){
		Pattern p = Pattern.compile("^([0-9a-fA-F][0-9a-fA-F]:){5}([0-9a-fA-F][0-9a-fA-F])$");
	    Matcher m = p.matcher(mac);
	    return m.find();
		
	}
	private static boolean isIPAddress(String str) {  
		  Pattern ipPattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");  
		  return ipPattern.matcher(str).matches();  
	}  
	 
	private static boolean isMacAddressb(String _mac) {  
		  Pattern ipPattern = Pattern.compile("^([0-9a-fA-F][0-9a-fA-F]-){5}([0-9a-fA-F][0-9a-fA-F])$");  
		  return ipPattern.matcher(_mac).matches();  
	}
	
	private static boolean isMacAddressc(String _mac) {  
		  Pattern ipPattern = Pattern.compile("^([0-9a-fA-F][0-9a-fA-F]:){5}([0-9a-fA-F][0-9a-fA-F])$");  
		  return ipPattern.matcher(_mac).matches();  
	}
	
	private static boolean isWrapMacAddress(String _mac) {
		
		String[] tmp = _mac.split("-");
		String[] tmp1 = _mac.split(":");
		
		if (tmp !=null && tmp.length==6) {
			return (isMacAddressb(_mac)) ? true:false; 
		} else if (tmp1 !=null && tmp1.length==6) {
			return (isMacAddressc(_mac)) ? true:false;
		} else {
			return false;
		}
	}
}
