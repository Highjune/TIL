
public class Method2 {
	public static void main(String[] args) {
		int kor = 90, eng = 100, mat = 79;
		Method2 md = new Method2(); //static�� �����Ƿ� �̷��� �����ؼ� �ּҷ� �ҷ��´�.
		md.calc(kor, eng, mat);
}
	void calc(int kor1, int eng1, int mat1) {  //���⼭ kor, eng, mat�̶� �ᵵ �ȴ�. ���������� ������ �޶� ���� �Ȱ��� �ᵵ ��
		int total = kor1 + eng1 + mat1;
		double avg = total/3. ; 
		char grade = mygrade(avg); // ���⿡���� calc�� mygrade�� �ȹ�� �ξ� �����ϹǷ� �ּ� �ʿ���� �ٷ� �ҷ��� �� �ִ�??
		System.out.println("total = " + total + ", avg = " + avg + ", grade = " + grade);
	}
	
	char mygrade(double avg) {//double���� avg�� ���� �Ǵ��� ABCD grade�� �Ѿ���Ƿ� char����
		char grade = '\0'; //���������� �׻� �ʱ�ȭ�ؾ� �ȴ�.  Q) null�� �ϸ� �ȵ�. char�̹Ƿ� null ���� �ƴ϶� null �ּҸ� ��ߵ�
		grade = (avg >= 90) ? 'A' :
						(avg >= 80) ? 'B' :
							(avg >= 70) ? 'C' :
								(avg >= 60) ? 'D' : 'F';
		return grade; //���ư���. ����? �ڱ⸦ ȣ���� ������ ����.
		
		}
}
///cf) null���� null�ּҿ� null�� 2���� �ִ�. char�� ���� ���� ���� �� �����Ƿ�~ . 
//*****�ſ� �߿�
//���� ������ MethodDemo2 md = new MethodDemo2(); ���ο� ���� ������� ������. md�� ���ο� �� �ּ���
//MethodDemo2 md�� �����ϰ� �Ǹ� �� �ȿ��� �� calc�� mygrade�� �����ȴ�. ���ε� �ᱹ �Լ��̹Ƿ� static�� �پ� �����ϱ�
//�ܺο� �մٰ� ����. �׷��� �ܺο��� calc�� mygrade�� �θ��� ���ؼ��� ���� ����ߵǱ� ������ new�� �Ἥ md.~ ���� �θ�
//�׷��� calc�� mygrade�� �ᱹ ���� ����(��) �ȿ� �ִ� ��������̱� ������ �������� �ʿ䰡 ����. �׷��� �׳� �ٷ� 
//char grade = mygrade(avg); �׷��� ���⼭�� �ٷ� mygrade�� �ҷ����� ��.
//���� calc���� static�� ���� ���¶�� calc�� �� ��(�ܺ�, ������)�� �ֱ� ������ �� �����Ŀ� mygrade�� �ҷ����� �ȴ�.




