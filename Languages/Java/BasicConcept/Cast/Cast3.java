/*
 * 객체의 형변환
 * 1. 자식 --> 부모 : 자동/강제 형변환 모두 가능, 항상 성공
 * 2. 부모 --> 자식 : 강제형변환 가능하며, 항상 성공하지는 않는다. 
 * 
 */


public class Cast3 {
       public static void main(String[] args) {
              Test t = new Test();
              Demo d = new Demo();
//           d = t; //부모는 자식으로 형변환이 안 된다
              if(t instanceof Demo) {
                     d = (Demo)t;
              }else {
                     System.out.println("형변환 불가");
              }
              //항상 성공하는 것은 아니기 떄문에 instanceof 연산자가 false를 리턴하면 형변환 x,
              //즉 부모가 자식으로 형변환이 되는 것은  instanceof연산자로 진단한다.
       }
}
class Test{}
class Demo extends Test{}