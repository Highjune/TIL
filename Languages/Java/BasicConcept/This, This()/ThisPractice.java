public class ThisPractice{
	//iv�տ��� this.�� ����
	
	long a, b; // this.a, this.b ==> iv�� ��¥�̸�
	
	ThisPractice(int a, int b) { //������
		//���⼭�� �����Ұ�(���� �̸��̱⶧����)
		//this�� �ٿ��� iv�� lv�� ����
		this.a = a; //this.a�� iv, a�� lv
		this.b = b;			
	}
	
	long add() {
		return a + b; // ������ return this.a + this.b�ε� ���⼭�� ������ ������ long a, b;�� �������� iv�ΰ��� �˱� ������.
	}
	
	//static�� ��ü���� ���� ����ϴ� ���̹Ƿ� iv���Ұ�
	static long add(long a, long b) { //Ŭ���� �޼���(static �޼���). �Ű����� long a, long b �� �� lv
		return a+b; //�� �� lv��. �׷��� this.�� �� ���δ�.
	}
}