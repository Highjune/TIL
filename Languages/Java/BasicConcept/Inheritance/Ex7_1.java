class Tv {
	boolean power;
	int channel;
	
	void power()		{power = !power;}
	void channelUp()	{++channel;}
	void channelDown()	{--channel;}
}

class SmartTv extends Tv { //SmartTv�� Tv�� ĸ��(�ڸ�)�� �����ִ� ���
	boolean caption;	//ĸ�ǻ���(on/off)
	
	void displayCaption(String text) {
		if(caption) {	//ĸ�� ���°� on(true)�� ���� text�� ���� �ش�
			System.out.println(text);
		}
	}
}

class Ex7_1 {
	public static void main(String[] args) {
		SmartTv stv = new SmartTv();
		stv.channel = 80;	//���� Ŭ�����κ��� ��ӹ��� ���
		stv.channelUp();	//���� Ŭ�����κ��� ��ӹ��� ���
		System.out.println(stv.channel);
		stv.displayCaption("Hello, World");
		stv.caption = true; //ĸ��(�ڸ�) ����� �Ҵ�
		stv.displayCaption("Hello, World");
	}
}


