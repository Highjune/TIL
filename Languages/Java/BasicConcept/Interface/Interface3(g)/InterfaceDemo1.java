//7. interface�� ���߻���� �����ϸ�, �� interface�� comma�� �����Ѵ�.
//8. interface�� ���������� �ش� interface�� �޼ҵ忡�� ������ �� �ִ�.
//9. interface�� ����� static�̱� ������ interface�̸����� �����ؼ� �̸� �浹�� �߻����� �ʴ´�.(�̸����� �����ϸ� ���� �ƹ����� MONEY���� ��Ӵ��� MONEY���� ������ �Ǳ� ������)
//10. interface������ �迭�� ���� �� �ִµ�, �̴� interface���� �ڽİ�ü�� �����ϱ� ���� �迭�̴�.

//���߻���� ������, ���� �ؿ��� ���� ��� (�ҹ�, �Ҹ�, ��, ��) ���� method�� �� ������ ����� �ȴ�.

public class InterfaceDemo1 implements Father, Mother{
//	public void father() {}
//	public void mother() {}
//	public void grandFather() {}
//	public void grandMother() {}	  �̷��� 4���� �� ����������� ���� �� ���.
//�ؿ������� �ٽ� �ϳ��ϳ��� �� �ٿ��� ������ ������
	public void father() {System.out.println("called by father()");}
	public void mother() {System.out.println("called by mother()");}
	public void grandFather() {System.out.println("called by grandFather()");}
	public void grandMother() {System.out.println("called by grandMother()");}
	public static void main(String[] args) {
	
		GrandFather grandFather = new InterfaceDemo1();
		grandFather.grandFather();   //grandFather. �μ��� grandFather()���� ������ �� �ִ�. �ֳ��ϸ� interfaceDemo1������ �ڽ�(grandFather)�� ������ �߱� ������
		GrandMother grandMother = new InterfaceDemo1();
		grandMother.grandMother(); //grandMother. �μ��� grandMother()���� ������ �� �ִ�. �ֳ��ϸ� interfaceDemo1������ �ڽ�(grandMother)�� ������ �߱� ������
		Father father = new InterfaceDemo1();
		father.father(); father.grandFather(); father.grandMother(); //�ƺ��� �ڽŰ͵�(�ڽ��� ������ �������ϱ�), �Ҿƹ���, �ҸӴϵ� ���ٰ����ϴ�(�ֳ��ϸ� ����̴ϱ�)
		Mother mother = new InterfaceDemo1();
		mother.mother(); //������ �ڽŰ�(��� �ڽ��� �ڽ��� �������������ϱ�) �ۿ� �ȵ�. �Ҿƹ��� �ҸӴϰ��� ���� ���Ѵ�. �ֳ��ϸ� ����� �ƴϱ� ������.

		System.out.println("�ƹ����� �� = " + Father.MONEY); //money�� static�̹Ƿ� �� �ּҷ� ������ �ʿ����. �̸�(Father)�� ����
		System.out.println("��Ӵ��� �� = " + Mother.MONEY); //money�� static�̹Ƿ� �� �ּҷ� ������ �ʿ����. �̸�(Mother)�� ����
		
		Mother[] array = new Mother[3]; //Mother�� new �� ���µ�?? ������ Mother�� ���� ���� �ƴ϶� mother�� �ڽĵ��� ���� �迭! �� ���� ���̹Ƿ� ���� �� �ִ�.
		array[0] = new InterfaceDemo1(); //���⿡�� �ƺ�, �Ҿƹ���, �ҸӴ� �� �ִ´�. mother�� �ڳ��� interfacedemo�� ���� �� �ִ�.
		array[0].mother();  
	}
	
	}






		


