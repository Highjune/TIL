package kr.co.sist.libs;  //Student는 이 패키지로 갈 것임.

public class Student {
//   public String name = "한지민"; //public이라서 다른 패키지에 있는 곳(ex. default패키지에 있는 MainClass)에서도 보임
   private String name = "한지민"; //default는 같은 폴더 아니기 때문에 X
   int kor = 90;
   protected int eng = 100;  //protected이므로, 밖에서 보이게 하려면 부모자식 관계 만들어 줘야 됨
   //protecetd 비유 : 다른 지방 사람이지만 우리집 가족이면 접근 가능!
   //우리집 가문 : private
   //국립중앙박물관 : public
   
   public int mat = 79;
  
}


//같은 패키지에서만 접근 가능하고, 다른 패키지에서는 접근 못하게 하려면 default로!
//ex) Main, Calc, intput 등~에서 Main만 보이게 하려면, Main은 public, 다른 것들은 default!
//권한은 제한적이어야 한다.


