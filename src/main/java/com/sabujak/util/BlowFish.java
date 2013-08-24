package com.sabujak.util;

import java.net.URLDecoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.sabujak.angelshot.conf.Define;

public class BlowFish {

	private static String enkey = Define.colmaEncryptkey;
	private static String dekey = Define.colmaDecryptkey;
	
	
	//private static Base64 base64 = new Base64(true);

	// encrypt using blowfish algorithm
	public static String encrypt(String Data) throws Exception {

		SecretKeySpec key = new SecretKeySpec(enkey.getBytes(),"Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] encreyptedText = cipher.doFinal(Data.getBytes());
		BASE64Encoder base64 = new BASE64Encoder();
		String encText = base64.encode(encreyptedText);
		//String encText = base64.encodeToString(encreyptedText);
		//String urlEncText = URLEncoder.encode(encText,"UTF-8");
		
		return encText;
	}

	// decrypt using blow fish algorithm
	public static String decrypt(String encrypted) throws Exception {
		BASE64Decoder base64 = new BASE64Decoder();
		
	//	byte[] encryptedData = base64.decodeBase64(encrypted);
		byte[] encryptedData = base64.decodeBuffer(encrypted);
		SecretKeySpec key = new SecretKeySpec(dekey.getBytes(),	"Blowfish");
		Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key);
				
		byte[] decrypted = cipher.doFinal(encryptedData);
		return new String((decrypted),"UTF-8");

	}

//	public static void main(String[] args) throws Exception {
//		String data = "fVkLJNKh78s2jW3Imxv7ZKEJtL0OXQ2UETl0X8r+YfXfHQkKIvXEHeFExXHz5e6272kO97UJptEj wzXkAx8IO9jGzklkwqH0U+IhmkQCbfKiTROQdNsMLhTs6MbqM0Q2/xlGf57drX4MyUYKc+RTcGYV C6eY2IPq";
//		//String encoded = encrypt(data);
//		//System.out.println(encoded);
//		data = URLDecoder.decode(data);
//		String decoded = decrypt(data);
//		System.out.println(decoded);
//	}

}
