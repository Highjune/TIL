import java.util.Vector;


public class Main {
	public static void main(String[] args) {
		//���α׷��� ���� �� vector�� ���� ����� ���� �ƴ϶� ������ vector�� ���Ͽ��� ��� ���� ��.
		
		
		String path = "C:/temp/sungjuklist.ser";
		Init init = new Init(path); //Init�� �ʱ�ȭ(���α׷��� �޸𸮿� �ö�� ��)
		Vector<Student> vector = init.init(); //init()�� ���� ������ vector�� ����(DB����)���� ����. 
		//ex) ���� ������ vector�� 3���� �ִ� ���¶�� input���ʹ� 4��° �л����� ��� �Ǵ� ����.
		//�׷��� �츮�� ������¿��� ����
		//vector�� null�� �ƴ�. init()�� ������ ���ο� vector�� ������ų�, ���Ͽ��� ������ȭ�ؼ� ���� vector�̵���.
		//���Ͼ��� -> �����ϱ� createnewFile�� ���� ������� -> ���ϸ�������鼭 ois�� null�̴ϱ� vector�� null -> vertor�� null�̴ϱ� �����ϸ鼭 new vector�� �Ѱ��� -> �������忡���� 
		
		Input input = new Input(vector); //null�� �ƴ� vector�̰ų� null�� �ƴѻ��¿��� ���ο� vector�� ������ְų���. �׷��� ����input.input()�� ȣ���ϴϱ� �� ���� ������ vector�� null�� �ƴϴ�. 
		input.input(); //�׷��� 
		
		Calc calc = new Calc(vector);  
		calc.calc();
		  
//		Sort sort = new Sort(vector);  
//		sort.sort();
//		
		Output output = new Output(vector, path);  //���⿡���� vector�� �̹� calc�� �� ������ ����//������ ��(path)�� ����.
		output.output();
	}
}

