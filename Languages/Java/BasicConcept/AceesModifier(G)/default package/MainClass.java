/*
 * class : public, (default), abstract, final
 * method : public, (default), protected, private, static, final, abstract,
 * variable : public, (default), protected, private, static, final 
 */

import kr.co.sist.libs.Student;

public class MainClass extends Student{
	public static void main(String[] args) {
//		Student s = new Student();
		MainClass mc = new MainClass(); //나 자식을 만들면, 내것은 물론 아버지것도 쓸 수 있는 것임
	}
}
