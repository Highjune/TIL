package kr.co.sist.libs.utils;

import java.util.Properties;

public class DepartmentUtil {
	public static String getDepartment(char code) {
		Properties deptInfo = new Properties();
		deptInfo.setProperty("A", "康诀何");
		deptInfo.setProperty("B", "诀公何");
		deptInfo.setProperty("C", "全焊何");
		deptInfo.setProperty("D", "牢荤何");
		deptInfo.setProperty("E", "版府何");
		deptInfo.setProperty("F", "魄盟何");
		deptInfo.setProperty("G", "醚公何");
		String key = String.valueOf(code);
		return deptInfo.getProperty(key);    //'A' --> "A" --> "康诀何"
	}
}
