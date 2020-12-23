//우리의 1차 프로젝트와 비슷 (아직 DB에 쿼리 날리는 것 배우기 전이니까 배열로)
//dept, emp 클래스와 함께~ 

//Name : SMITH
//
//사번 : 
//이름 :
//직무 :
//소속 부서 이름 :
//소속 부서 위치 :

import java.util.Scanner;

//모델링 연습하는 것임
//DB에서 select * from dept; 해보면
//몇개의 레코드가 나오긴 하는데 우리는 각각을 다 따로봐야 되기때문에 다 생성 ==> 배열로!
public class Main {
	public static void main(String[] args) {
		
		Dept[] deptArray = new Dept[5];
	
		Dept newYork = new Dept(10,	"ACCOUNTING", "NEW YORK");
		Dept dallas = new Dept(20,	"RESEARCH", "DALLAS");
		Dept chicago = new Dept(30, "SALES", "CHICAGO");
		Dept boston = new Dept(40, "OPERATIONS",	"BOSTON");	

		deptArray[0] = newYork; 
		deptArray[1] = dallas;
		deptArray[2] = chicago;
		deptArray[3] = boston;
		
//		for(int i = 0 ; i<deptArray.length-1 ; i++)
//			System.out.println(deptArray[i].toString()); //넣은 것 확인
		
//	Calendar cal = Calendar.getInstance();
	//1. Calendar는 추상클래스이기 때문에 new 사용금지, Calendar는 자식을 만들지 않고 보통 다른 방법으로 만든다!
	//2. getInstance()는 static이기 때문에 주소 없이 접근 가능 (API에서 볼 수 있음)
	//Calender주소는 왜 필요? set을  쓰기 위해!
		
//		Emp smith = new Emp(7369, "SMITH", "CLERK", 7902, "80/12/17", 800, 0, 20);  //이렇게 14명 다 넣는 것보다 배열로 하자!

//원래는 DB에 쿼리를 날려서 처리해야 되는데, 우리는 아직 안 배웟으니까 일단 배열에 넣고 하는 것으로 !! 
		
		Emp[] empArray = new Emp[14];
		
		empArray[0] = new Emp(7369, "SMITH", "CLERK", 7902, "80/12/17", 800, 0, 20);
		empArray[1] = new Emp(7499, "ALLEN", "SALESMAN", 7698, "81/02/20", 1600, 300, 30);
		empArray[2] = new Emp(7521, "WARD", "SALESMAN", 7698, "81/02/22", 1250, 500, 30);
		empArray[3] = new Emp(7566, "JONES", "MANAGER", 7839, "81/04/02", 2975, 0, 20);
		empArray[4] = new Emp(7654, "MARTIN", "SALESMAN", 7698, "81/09/28", 1250,1400, 30);
		empArray[5] = new Emp(7698, "BLAKE", "MANAGER", 7839, "81/05/01", 2850, 0, 30);
		empArray[6] = new Emp(7782, "CLERK", "MANAGER", 7839, "81/06/09", 2450, 0, 10);
		empArray[7] = new Emp(7788, "SCOTT", "ANALYST", 7566, "87/04/19", 3000, 0, 20);
		empArray[8] = new Emp(7839, "KING", "PRESIDENT", 0, "81/11/17", 5000, 0, 10);
		empArray[9] = new Emp(7844, "TURNER", "SALESMAN", 7698, "80/09/08", 1500, 0, 30);
		empArray[10] = new Emp(7876, "ADAMS", "CLERK", 7788, "87/05/23", 1100, 0, 20);
		empArray[11] = new Emp(7900, "JAMES", "CLERK", 7698, "81/12/03", 950, 0, 30);
		empArray[12] = new Emp(7902, "FORD", "ALALYST", 7566, "81/12/03", 3000, 0, 20);
		empArray[13] = new Emp(7934, "MILLER", "CLERK", 7782, "82/01/23", 1300, 0, 10);
		
		//입력
		Scanner scan = new Scanner(System.in);
		System.out.print("Name : ");
		String name = scan.next();
		
		//검색
		Emp result = null; //지역변수는 항상 초기화
		for(int i =0 ; i <empArray.length ; i++) {
			//만일 i번째 사원의 이름이 입력한 사원의 이름과 같다면
			if(empArray[i].getEname().equals(name)) {
				result = empArray[i];//찾은 사원이 i번째 사원이다.
	}
}
//		System.out.println(result); //result.toString()
		int deptno = result.getDeptno(); //위에서 찾은 사원.의 부서번호
		Dept result1 = null;
		for(int i = 0 ; i<deptArray.length - 1 ; i++) {  //-1인 이유는 우리가 방을 5개 만들었는데 4개까지만 채웟으므로 //
			if(deptArray[i].getDeptno() == deptno) 
				result1 = deptArray[i];
		}
		
		//결과출력
		System.out.print("사번 : ");				System.out.println(result.getEmpno());
		System.out.print("이름 : ");				System.out.println(result.getEname());
		System.out.print("직무 : ");				System.out.println(result.getJob());
		System.out.print("소속 부서 이름 : ");	System.out.println(result1.getdName());
		System.out.print("소속 부서 위치 : ");	System.out.println(result1.getLoc());


	}	
}




