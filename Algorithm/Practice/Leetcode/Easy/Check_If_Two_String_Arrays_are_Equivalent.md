# Check_If_Two_String_Arrays_are_Equivalent
- [문제](https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/)


# 내 풀이
- 이렇게 풀면 안될듯 
```
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String first = "";
        String second = "";

        for (int i = 0 ; i < word1.length ; i++) {
            first += word1[i];
        }

        for (int i = 0 ; i < word2.length ; i++) {
            second += word2[i];
        }
        
        if (first.equals(second)) {
            return true;
        } else {
            return false;
        }

    }
}
```

# 타인 풀이
- 꽤 시간들여 이해함
```
class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int idx1 = 0, idx2 = 0, arrIdx1 = 0, arrIdx2 = 0;
        while (arrIdx1 < word1.length && arrIdx2 < word2.length) {
            if (word1[arrIdx1].charAt(idx1) != word2[arrIdx2].charAt(idx2)) return false;
            if (idx1 == word1[arrIdx1].length() - 1) {
                idx1 = 0;
                arrIdx1++;
            } else idx1++;
            if (idx2 == word2[arrIdx2].length() - 1) {
                idx2 = 0;
                arrIdx2++;
            } else idx2++;
        }
        return arrIdx1 == word1.length && arrIdx2 == word2.length;
    }
}
```