//week�� �θ���, InterfaceDemo����

//interface 2���� ���
//1. interface���� ������ ���� �� ����. public static final�� ������ ����� �����ϰ� �ݵ�� �ʱ�ȭ�ؾ� �Ѵ�.
//2. interface���� public abstract�� ������ �߻�޼ҵ常 �����ϴ�. (100���� 100�� �� �߻�޼ҵ�). �޼ҵ��� �ٵ�X
//ex) api���� java.lang - Runnable ���� �޼ҵ� 1�� �ִµ� void run()�� �ִµ� �� �տ� �� public abstract�� �����Ǿ� �ִ�.
//�տ� public�� �����Ǿ� ������ �ڽ��� ���� ���� public���� ������ �ȴ�.
//���߿� JDBC(�ڹٿ� DB��ġ�°�) �� �ٵ�, JDBC�� ��κ��� interface��.


public interface Weekable { //interface�� ���� ����.
//	private int age; //�ּ��� ����
//	private final int AGE = 1; //final�� ���� �� ���� ����. �빮�ڷ� ��ߵ�, �ݵ�� �ʱⰪ�� ��� �Ѵ�.
	
//	public static final int AGE = 1; //�̷��� �Ǿ�� �Ǵµ� ������ public static final�̹Ƿ� �տ� �����Ѵ�.�׷��� �Ʒ�ó��.
//	int AGE = 1; 
	
	int SUN = 0, MON=1, TUE=2, WED=3, THU=4, FRI=5, SAT=6;  //�տ� public static final�� �����Ǿ� �ִ�.
	
//	void display();//�޼ҵ忡�� �ٵ� ����� �Ѵ�.
//	protected display(); // protected�� �ȵȴ�.
//	public abstract void display(); //�տ� public abstract �� �����ȴ�. ��� ���� �� public �� abstract�̹Ƿ� ����.
	void set(int date); //
	int get(); //
	//���⼭ set �� get�� ���븸 �������ְ� �� �ڽ��� week���� ����� �������ش�. 
	
	
}








