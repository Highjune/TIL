package test;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
	public static void main(String[] args) {
		String str = "안녕하세요";

		byte[] bytes1 = str.getBytes();
		System.out.println("bytes1.length: " + bytes1.length);
		String str1 = new String(bytes1);
		System.out.println("bytes1->String: " + str1);
		
		try {
			
		byte[] bytes2 = str.getBytes("EUC-KR");
		System.out.println("bytes1.length: " + bytes2.length);
		String str2 = new String(bytes2);
		System.out.println("bytes1->String: " + str2);
		
		
		byte[] bytes3 = str.getBytes("UTF-8");
		System.out.println("bytes1.length: " + bytes3.length);
		String str3 = new String(bytes3);
		System.out.println("bytes1->String: " + str3);
		
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/*
		 * bytes1.length: 15
			bytes1->String: 안녕하세요
			bytes1.length: 10
			bytes1->String: 안녕하세요
			bytes1.length: 15
			bytes1->String: 안녕하세요
		 */
	}
}
