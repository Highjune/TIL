# BinaryGap
>> 자연수를 이진수로 변환했을 때 가장 긴 1사이의 거리(BinaryGap)


## 내가 푼 것(삽질)

### 10진수 -> 2진수 변환방법
```
public class Solution { 
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solu(100));
	}

	public String solu(int N) { // N = 48
		int k = -1; // 몫 
		String answer = "";
//		while(N/2 > 2) {
		while(N > 2) {
			k = N%2; // 0 
			String kStr = Integer.toString(k);
			answer += kStr;
			N = N/2; // 24
		}		
		//마지막 몫 붙이기
		answer += Integer.toString(N);
//		//거꾸로 출력
		String reverseAnswer = "";
		for(int i = answer.length()-1; i>=0 ; i--) {
			reverseAnswer += answer.charAt(i); 
		}
		return reverseAnswer;
	}
	
}
```

### BinaryGap
```
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solu(1231245));
	}

	public int solu(int N) { // N = 145
		int k = -1; // 몫
		String reverseAnswer = "";
		while(N > 1) {
			k = N%2;  
			String kStr = Integer.toString(k);
			reverseAnswer += kStr;
			N = N/2; 
		}		
		//마지막 몫 붙이기 
		reverseAnswer += Integer.toString(N); 
		
//		//거꾸로 출력
		String answer = "";
		for(int i = reverseAnswer.length()-1; i>=0 ; i--) {
			answer += reverseAnswer.charAt(i); 
		}

		int[] arr = new int[reverseAnswer.length()];
		for(int i = 0 ; i<arr.length ; i++) {
			arr[i] = answer.charAt(i) - '0'; // [1, 0, 0, 1, 0, 0, 0, 1] 
		}
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i = 0 ; i < arr.length ; i++) { // [1, 0, 0, 1, 0, 0, 0, 1]
			if(arr[i] == 1) {
				arrList.add(i); // 0, 3, 7
			}
		}
		
		ArrayList<Integer> maxList = new ArrayList<Integer>();
		for(int i = 0 ; i < arrList.size()-1; i++) { // 0, 3, 7 
			int diff  = arrList.get(i+1) - arrList.get(i);
//			System.out.println(diff);
			maxList.add(diff);
		}
		
		int final_answer = Collections.max(maxList) - 1;
		
//		return answer; // 10010001
		return final_answer;
	}

}

```

## 첫 알고리즘 풀이 후기
알고리즘 이론 인강, 책만 한 번 들었을 뿐 경험이 너무 없어서 일단 꾸역구역 고민하고 풀었다는 것에 의의를 두자.
매일 고민하기.
삽질코드라도 풀어내니 너무나 재밌다(2021.02.17)

