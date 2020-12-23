package kr.co.sist.libs;

/*Enum의 문법
 * 1. 상수가 항상 제일 윗줄(앞)에
 * 2. 각 상수의 값은 생성자를 통해서
 * 3. 생성자의 Access Modifier 사용 불가
*/


public enum Coin {
//   private int cent;  오면 안됨. 상수가 제일 윗줄에 와야 되므로
   PENNY(1), NICKEL(5), DIME(10), QUARTER(25);  //만
   //이렇게 값을 주는 것 : 생성자라고 생각하자~
   private int cent;
   /*Public*/ Coin(int cent) {  //생성자에 public(access modifier)붙이면 안 된다.
      this.cent = cent;
   }
   
   public int getValue() {return this.cent;} //   
}



