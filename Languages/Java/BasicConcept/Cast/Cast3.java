/*
 * ��ü�� ����ȯ
 * 1. �ڽ� --> �θ� : �ڵ�/���� ����ȯ ��� ����, �׻� ����
 * 2. �θ� --> �ڽ� : ��������ȯ �����ϸ�, �׻� ���������� �ʴ´�. 
 * 
 */


public class Cast3 {
       public static void main(String[] args) {
              Test t = new Test();
              Demo d = new Demo();
//           d = t; //�θ�� �ڽ����� ����ȯ�� �� �ȴ�
              if(t instanceof Demo) {
                     d = (Demo)t;
              }else {
                     System.out.println("����ȯ �Ұ�");
              }
              //�׻� �����ϴ� ���� �ƴϱ� ������ instanceof �����ڰ� false�� �����ϸ� ����ȯ x,
              //�� �θ� �ڽ����� ����ȯ�� �Ǵ� ����  instanceof�����ڷ� �����Ѵ�.
       }
}
class Test{}
class Demo extends Test{}