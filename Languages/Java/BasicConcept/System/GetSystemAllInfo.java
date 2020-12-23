package practice;

import java.util.Enumeration;
import java.util.Properties;

public class GetSystemAllInfo {
	public static void main(String[] args) {
		
		  Properties pro = System.getProperties ( ); //시스템 정보를 몽땅 갖고 온다.
		  Enumeration e = pro.propertyNames();
		  while(e.hasMoreElements()) {
		   String obj = (String)e.nextElement();
		   System.out.println(obj + ":"+ System.getProperty(obj ));
		  }

	}
}
