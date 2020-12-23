https://youtu.be/IzcwaCSHmcE (중간부터)
(짤린것이어서) https://youtu.be/SqIr-X6zNWU 
https://youtu.be/e7BHJmrqAt8 

직렬화(+역직렬화) 프로그램 (나중에 주소록관리프로그램1도 이 원리로 만듬, 참고하기)
ex) 쇼핑몰할 때 쓰면 됨. (아직 DB를 안 배워서 여기서는 비록 파일에서 갖고 오긴 하겠지만 ~)
즉, 장바구니 쓸 때.

ex)
모나미 볼펜 300 모나미 서울시 강남구 역삼동
키보드 	15000	세진키보드 부산시 해운대구 해운대동

==>만약 파일을 열었는데 제품의 목록이 이렇게 되어 있으면 파일을 열 때마다 일일이 다 만들어줘야(라인마다 다 읽어서~) 되고 읽어올 때도 저 양식으로 인출해야되서 불편함.
제품을 직렬화해서 파일로 하면 그대로 역직렬화 하면 된다.
물론 나중에 DB로 하면 더 편하긴 함. 


프로그램 설명)
(처음)
읽어올(vector들어있는) 파일이 없다면 새로 만들고, 있다면 (이전에 실행해서 사용했던 것들 있으면) 사용했었던 것 불러와서 저장 후 다시 덮어쓰기 저장.
ex) 이전에 3명까지 저장해놨었다면 4명부터 input하는 것임.

Init
그래서 Init에서 파일 없으면 만들고 있으면 불러와서 안에 있는 vector를 역직렬화해서 꺼내서 작업 시작
그리고 이 작업한 것을 input 으로 추가해서 덮어서 저장.
C:/temp에서 sungjuklist.ser 지우고 시작
(처음에 이 파일이 없어서 만들면 vector는 null, 있는데 vector를 저장한 적이 없어서 null)

Student - 직렬화 가능한 클래스로 생성
Main - 경로를 init에 넣고, init()으로 vector를 리턴한 후에 그것을 input, calc, sort, output에 넣음. output에는 경로도 같이.
Init - 생성자에 읽어들일 파일의 위치에 대한 세팅, init()메서드는 해당 위치에 대한 객체 읽어들이고, vector<Student>를 리턴(만약 기존 객체가 있다면 객체 그대로, 없다면 새로운 vector)
Input - do-while로 입력값 받고 싶은 만큼(y라면) 받기.
Calc - vector의 것 하나하나 다 계산해서 총점, 평균, 등급까지.
Sort - Collections.sort로
Output - 생성자에 vector와 path를 넣어서 ObjectOutputStream할 곳 세팅. output() 에서는 writeObject, 경로는 = "C:/temp/sungjuklist.ser"

