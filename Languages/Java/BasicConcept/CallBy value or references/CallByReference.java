
public class CallByReference {
public static void main(String[] args) {
	Test t = new Test(); 
	t.original = 500;
	System.out.println("Before call t.original = " + t.original);
	
	CallByReference cbr = new CallByReference();
//	cbr.change(t.original); //callbyvalue��. �������� ���� �Ѿ���� !8���� ���� �� �ϳ��� ������ callbyvalue**********
	
	cbr.change(t); //callbyreference(�ּҸ� �ѱ�� �Ǹ�). cf) String�� �ּҰ� �Ѿ�� ������ �ٲ��� �ʱ� ������ callbyvalue
	System.out.println("After call t.original = " + t.original);
//�̷��� �ּҸ� �����ϸ� ���� �ٲ��. �� ������ �Ȱ��� �ٶ󺸴ϱ�.
	
}

void change(Test num) {  //Test num = t; // num�� �ּ�
	num.original *= 100;  //num�� �ּҷ� ���� original�̶�� �濡��.
	System.out.println("in change() num.original = " + num.original );

}
}
class Test{
	int original ; //�������(Ŭ���� �ȿ� ������ static  X), ��������� �ݵ�� �ּҰ� �ʿ�
}