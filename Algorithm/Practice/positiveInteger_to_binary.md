# 10진수 -> 2진수

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
