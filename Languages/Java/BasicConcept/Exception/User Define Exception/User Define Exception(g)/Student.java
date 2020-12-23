/*사용자 정의 exception
 * 국어는 checked Exception, 영어는 Unchecked Exception.
 * 
 */


public class Student {
	private int kor, eng;

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) throws KoreanException{
		if(kor >= 0 && kor <=100) this.kor = kor;
		else throw new KoreanException(//()은 메세지 
				"국어 점수는 0~100점입니다. \n확인 후 다시 입력하세요.");    //이 메소드를 쓸려면 반드시 try catch 를 써야 하므로 밖에다가 반드시 선언해야됨.
	}

	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) throws ClassNotFoundException{
		if(eng >= 0 && eng <= 100) this.eng = eng;
		else throw new EnglishException(
				"영어점수는 0~100점까지입니다. \n확인 후 다시 입력해 주세요.");
		}

	
	
}
