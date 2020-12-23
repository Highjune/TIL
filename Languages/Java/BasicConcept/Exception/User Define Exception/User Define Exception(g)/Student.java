/*����� ���� exception
 * ����� checked Exception, ����� Unchecked Exception.
 * 
 */


public class Student {
	private int kor, eng;

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) throws KoreanException{
		if(kor >= 0 && kor <=100) this.kor = kor;
		else throw new KoreanException(//()�� �޼��� 
				"���� ������ 0~100���Դϴ�. \nȮ�� �� �ٽ� �Է��ϼ���.");    //�� �޼ҵ带 ������ �ݵ�� try catch �� ��� �ϹǷ� �ۿ��ٰ� �ݵ�� �����ؾߵ�.
	}

	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) throws ClassNotFoundException{
		if(eng >= 0 && eng <= 100) this.eng = eng;
		else throw new EnglishException(
				"���������� 0~100�������Դϴ�. \nȮ�� �� �ٽ� �Է��� �ּ���.");
		}

	
	
}
