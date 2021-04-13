StoneWall

> [문제링크](https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/)

## 내 풀이1, 14%
- sample값 기준으로 답이 잘 나와서 맞다고 생각함. 

```
import java.util.*;

class Solution {
    public int solution(int[] H) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int blockNum = 0;
    	int nowHeight = 0;
    	
    	for (int i = 0 ; i < H.length ; i++) {
    		if (nowHeight == H[i]) {
    			continue;
    			
    		} else if (nowHeight < H[i]) {
    			stack.push(H[i] - nowHeight);
    			nowHeight = H[i];
    			blockNum++;
    			
    		} else if (nowHeight > H[i]) {
    			do{
    				nowHeight -= stack.peek();
    				stack.pop();
    			} while (nowHeight > H[i]);
    			stack.push(H[i] - nowHeight);
    			blockNum++;
    		}
    		
    	}
    	
    	return blockNum;
    }	
}
```

## 내 풀이2, 50%
- 이전의 높이가 H[i] 높이보다 높아서 한 블럭씩 (추가하지 않고) 제거하는 과정에서 딱 H[i] 높이가 되었을 때 다음 반복문 H[i+1] 가야했어야 함. 그래서 아래를 추가했는데도 50%..
```
if (nowHeight == H[i]) {
    				continue;
    			}
```

```
import java.util.*;

class Solution {
     public int solution(int[] H) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int blockNum = 0;
    	int nowHeight = 0;
    	
    	for (int i = 0 ; i < H.length ; i++) {
    		if (nowHeight == H[i]) {
    			continue;
    			
    		} else if (nowHeight < H[i]) {
    			stack.push(H[i] - nowHeight);
    			nowHeight = H[i];
    			blockNum++;
    			
    		} else if (nowHeight > H[i]) {
    			do{
    				nowHeight -= stack.pop();
    			} while (nowHeight > H[i]);
    			
    			if (nowHeight == H[i]) {
    				continue;
    			}
    			
    			stack.push(H[i] - nowHeight);
    			blockNum++;
    		}
    		
    	}
    	
    	return blockNum;
    }		
}
```


## 타인 풀이, 100%
http://romanticcode.tistory.com/37
```
import java.util.Stack;

class Solution {
    public int solution(int[] H) {
        
        Stack<Integer> stack = new Stack();
        int blockCnt = 0;
        
        for(int i =0 ; i < H.length; i++){
           
            while(stack.size() > 0 && stack.peek() > H[i]){
                stack.pop();
            }
            
            if(stack.size() == 0 || stack.peek() < H[i]){
                stack.push(H[i]);
                blockCnt++;
            }
        }
        return blockCnt;
    }
}

```