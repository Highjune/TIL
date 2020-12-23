package kr.co.sist.libs;

/*Enum�� ����
 * 1. ����� �׻� ���� ����(��)��
 * 2. �� ����� ���� �����ڸ� ���ؼ�
 * 3. �������� Access Modifier ��� �Ұ�
*/


public enum Coin {
//   private int cent;  ���� �ȵ�. ����� ���� ���ٿ� �;� �ǹǷ�
   PENNY(1), NICKEL(5), DIME(10), QUARTER(25);  //��
   //�̷��� ���� �ִ� �� : �����ڶ�� ��������~
   private int cent;
   /*Public*/ Coin(int cent) {  //�����ڿ� public(access modifier)���̸� �� �ȴ�.
      this.cent = cent;
   }
   
   public int getValue() {return this.cent;} //   
}



