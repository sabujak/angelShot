package com.sabujak.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sabujak.angelshot.conf.Define;

public class HttpUtil {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	private static HttpURLConnection conn;

	public static HttpURLConnection sendGetRequest(String _url) throws IOException {
		URL url = new URL(_url);
		conn = (HttpURLConnection) url.openConnection();
		conn.setUseCaches(false);
		
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		return conn;
	}
	
	
	public static String sendPostRequest(String _parameter, HttpURLConnection _conn) throws UnsupportedEncodingException, IOException {
		
		DataOutputStream write = new DataOutputStream(_conn.getOutputStream());
		write.write(_parameter.getBytes(Define.encoding));
		write.flush();
		write.close();
		
		int responseCode = _conn.getResponseCode();
		BufferedReader br = new BufferedReader(new InputStreamReader(_conn.getInputStream()));
		String outLine;
		StringBuffer response = new StringBuffer();
		while((outLine = br.readLine())!=null) {
			response.append(outLine);
		}
		br.close();
		String out = response.toString();
		logger.info("code:"+responseCode+", " + out );
		
		return out;
	}
	

	
	
	public static void sendPostRequest() {
		
		String url = Define.nddsUrl_dev;
		
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Language", "utf-8");
			con.setRequestProperty("content-Type", "application/json; charset=utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("AP_CODE", "ESC_AP_TMAPDRWJ");

			String parameters = "{\"header\":{\"reqTime\":\"20130610000000\",\"userId\":\"ESC\",\"svcRequester\":\"tmap\"},\"searchTypCd\":\"A\",\"reqCnt\":1,\"reqSeq\":1,\"areaName\":\"강남구\",\"noorX\":\"0\",\"noorY\":\"0\",\"name\":\"하이닉스\",\"radius\":\"0\"}";
			
			con.setDoOutput(true);
			
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			
			wr.write(parameters.getBytes("utf-8"));
			wr.flush();
			wr.close();
			
			int resonseCode = con.getResponseCode();
			System.out.println("responseCode:" + resonseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = in.readLine()) !=null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println("code:"+response.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void setHeader(Map<String, String> _map) {
		if (_map.size()>0) {
			Iterator<String> it = _map.keySet().iterator();
			while(it.hasNext()) {
				String key = (String) it.next();
				String val = _map.get(key);
				System.out.println("kv:"+key+":"+val);
//				conn.setRequestProperty(key, val);
			}
					
		}
	}
	
	public static HttpURLConnection sendPostRequest(String _url, Map<String, String> params) throws IOException {
		URL url = new URL(_url);
		conn = (HttpURLConnection) url.openConnection();
		conn.setUseCaches(false);
		
		conn.setDoInput(true);
		
		StringBuffer requestParams = new StringBuffer();
		
		if (params != null && params.size() > 0) {
			
			conn.setDoOutput(true);
			
			Iterator<String> paramIterator = params.keySet().iterator()	;
			while(paramIterator.hasNext()) {
				String key = paramIterator.next();
				String val = params.get(key);
				requestParams.append(URLEncoder.encode(key, Define.encoding));
				requestParams.append("=").append(URLEncoder.encode(val, Define.encoding));
//				requestParams.append("&");
			}
			
			OutputStreamWriter writer = new OutputStreamWriter( conn.getOutputStream() );
			System.out.println("r:"+requestParams.toString());
			writer.write(requestParams.toString());
			writer.flush();
		}
		return conn;
	}
	
	public static String readLineResponse() throws IOException {
		
		InputStream inputstream = null;
		if (conn != null) {
			inputstream = conn.getInputStream();
		} else {
			throw new IOException("connection is not established.");
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
		String response = reader.readLine();
		reader.close();
		return response;
	}
	
	public static String[] readLinesResponse() throws IOException {
		InputStream inputstream = null;
		
		if (conn != null) {
			inputstream = conn.getInputStream();
		}else {
			throw new IOException("connection is not established.");
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
		List<String> response = new ArrayList<String>();
		
		String line = "";
		while((line = reader.readLine()) != null) {
			response.add(line);
		}
		reader.close();
		
		return (String[]) response.toArray(new String[0]);
	}
	
	public static void disconnect() {
		if (conn != null) {
			conn.disconnect();
		}
	}
}
