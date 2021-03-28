# FrogJmp
> [문제링크](https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/start/)


# 내 풀이. 44%, TIMEOUT ERROR
```
class Solution {
    public int solution(int X, int Y, int D) {
        int number = 0;

        while (X < Y) {
            X += D;
            number++;
        }
        
        return number;
    }
}
```

# 타인 풀이
```
class Solution {
    public int solution(int X, int Y, int D) {
        
        if( (Y-X)%D == 0)
            return (Y-X)/D;
        else
            return (int)Math.floor((Y-X)/D)+1;  
    }
}
```
