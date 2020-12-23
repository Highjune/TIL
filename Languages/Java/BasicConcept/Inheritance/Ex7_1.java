class Tv {
	boolean power;
	int channel;
	
	void power()		{power = !power;}
	void channelUp()	{++channel;}
	void channelDown()	{--channel;}
}

class SmartTv extends Tv { //SmartTv는 Tv에 캡션(자막)을 보여주는 기능
	boolean caption;	//캡션상태(on/off)
	
	void displayCaption(String text) {
		if(caption) {	//캡션 상태가 on(true)일 때만 text를 보여 준다
			System.out.println(text);
		}
	}
}

class Ex7_1 {
	public static void main(String[] args) {
		SmartTv stv = new SmartTv();
		stv.channel = 80;	//조상 클래스로부터 상속받은 멤버
		stv.channelUp();	//조상 클래스로부터 상속받은 멤버
		System.out.println(stv.channel);
		stv.displayCaption("Hello, World");
		stv.caption = true; //캡션(자막) 기능을 켠다
		stv.displayCaption("Hello, World");
	}
}


