//�츮�� 1�� ������Ʈ�� ��� (���� DB�� ���� ������ �� ���� ���̴ϱ� �迭��)
//dept, emp Ŭ������ �Բ�~ 

//Name : SMITH
//
//��� : 
//�̸� :
//���� :
//�Ҽ� �μ� �̸� :
//�Ҽ� �μ� ��ġ :

import java.util.Scanner;

//�𵨸� �����ϴ� ����
//DB���� select * from dept; �غ���
//��� ���ڵ尡 ������ �ϴµ� �츮�� ������ �� ���κ��� �Ǳ⶧���� �� ���� ==> �迭��!
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
//			System.out.println(deptArray[i].toString()); //���� �� Ȯ��
		
//	Calendar cal = Calendar.getInstance();
	//1. Calendar�� �߻�Ŭ�����̱� ������ new ������, Calendar�� �ڽ��� ������ �ʰ� ���� �ٸ� ������� �����!
	//2. getInstance()�� static�̱� ������ �ּ� ���� ���� ���� (API���� �� �� ����)
	//Calender�ּҴ� �� �ʿ�? set��  ���� ����!
		
//		Emp smith = new Emp(7369, "SMITH", "CLERK", 7902, "80/12/17", 800, 0, 20);  //�̷��� 14�� �� �ִ� �ͺ��� �迭�� ����!

//������ DB�� ������ ������ ó���ؾ� �Ǵµ�, �츮�� ���� �� ��m���ϱ� �ϴ� �迭�� �ְ� �ϴ� ������ !! 
		
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
		
		//�Է�
		Scanner scan = new Scanner(System.in);
		System.out.print("Name : ");
		String name = scan.next();
		
		//�˻�
		Emp result = null; //���������� �׻� �ʱ�ȭ
		for(int i =0 ; i <empArray.length ; i++) {
			//���� i��° ����� �̸��� �Է��� ����� �̸��� ���ٸ�
			if(empArray[i].getEname().equals(name)) {
				result = empArray[i];//ã�� ����� i��° ����̴�.
	}
}
//		System.out.println(result); //result.toString()
		int deptno = result.getDeptno(); //������ ã�� ���.�� �μ���ȣ
		Dept result1 = null;
		for(int i = 0 ; i<deptArray.length - 1 ; i++) {  //-1�� ������ �츮�� ���� 5�� ������µ� 4�������� ä�m���Ƿ� //
			if(deptArray[i].getDeptno() == deptno) 
				result1 = deptArray[i];
		}
		
		//������
		System.out.print("��� : ");				System.out.println(result.getEmpno());
		System.out.print("�̸� : ");				System.out.println(result.getEname());
		System.out.print("���� : ");				System.out.println(result.getJob());
		System.out.print("�Ҽ� �μ� �̸� : ");	System.out.println(result1.getdName());
		System.out.print("�Ҽ� �μ� ��ġ : ");	System.out.println(result1.getLoc());


	}	
}




