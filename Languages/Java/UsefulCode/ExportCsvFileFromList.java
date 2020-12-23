package practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExportCsvFileFromList {
	public static void main(String[] args) throws Exception {
		List<Map<String, Object>> exportList = new ArrayList<Map<String, Object>>(3);
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "June1");
		map1.put("age",  15);
		map1.put("gender", "men");
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "June2");
		map2.put("age",  16);
		map2.put("gender", "women");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "June3");
		map3.put("age",  17);
		map3.put("gender", "women");
		
		exportList.add(map1);
		exportList.add(map2);
		exportList.add(map3);		
		
		System.out.println(exportList);
		
    	boolean result = true;
    	//저장 위치
    	String savePath = "C:\\Users\\Ventureport\\Desktop\\csvfolder\\";
    	//출력할 파일 이름
    	String fileName = "exportedFile";
    	
    	BufferedWriter fw;
    	
    	try {
	    	File dir = new File(savePath);
	    	if(!dir.isDirectory()) { // 또는 !dir.exists() 로 확인
	    		dir.mkdirs();
	    	}
	    	
	    	fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName + ".csv"), "UTF-8"));
	    	// 3개의 리스트(map1, map2, map3). 총 3바퀴
	    	for(Map<String, Object> exportMap : exportList) { 
	    		String line = "";
	    		// map1개당 3개의 K, V 쌍
	    		for(String key : exportMap.keySet()) {  
	    			String data="";
	    			if(exportMap.get(key)!=null) { //  
	    				data=exportMap.get(key).toString();
//	    				System.out.println(data);
	    			}
	    			// 혹시 데이터 중에 ,가 있다면 _ 로 대체
	    			data.replace(",", "_"); 
	    			if(data.length()==0 || data.toUpperCase().equals("NULL")) {
	    				line += ",";
	    			} else {
	    				line += data + ",";
	    			}
	    		}
	    		// 마지막 쉼표 제외.
	    		line = line.substring(0, line.length()-1); 
	    		fw.write(line);
//	    		fw.write(System.getProperty("line.seprator"));  // fw.write("\r\n"); 말고 OS에 상관없이. 그런데 에러남?
	    		fw.write("\r\n"); //윈도우의 엔터
	    	}	    	
	    		fw.flush();
	    		fw.close();
	    		
	    	} catch (Exception e) {
	    		e.printStackTrace();
    		
    		}
    		
    	}
    	    	
	   	
		
	}

