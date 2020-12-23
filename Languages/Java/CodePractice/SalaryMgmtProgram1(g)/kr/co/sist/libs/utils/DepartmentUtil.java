package kr.co.sist.libs.utils;

import java.util.Properties;

public class DepartmentUtil {
	public static String getDepartment(char code) {
		Properties deptInfo = new Properties();
		deptInfo.setProperty("A", "������");
		deptInfo.setProperty("B", "������");
		deptInfo.setProperty("C", "ȫ����");
		deptInfo.setProperty("D", "�λ��");
		deptInfo.setProperty("E", "�渮��");
		deptInfo.setProperty("F", "���˺�");
		deptInfo.setProperty("G", "�ѹ���");
		String key = String.valueOf(code);
		return deptInfo.getProperty(key);    //'A' --> "A" --> "������"
	}
}
