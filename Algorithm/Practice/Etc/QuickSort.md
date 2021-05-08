# 내 풀이

- 자바로 배우는 쉬운 자료구조
- 추후에 다시 볼 것 (아래 코드 에러남)
```

public class Sort {
    int i = 0;
    public int partition(int[] a, int begin, int end) {
        int pivot, temp, L, R, t;

        L = begin;
        R = end;
        pivot = (begin + end) / 2;
        System.out.printf("\n [퀵정렬 %d 단계 : pivot = %d ]\n", ++i, a[pivot]);
        while (L < R) {
            while ((a[L] <= a[pivot]) && (L<=R)) L++;
            while ((a[R] > a[pivot]) && (L<=R)) R--;
            if (L < R) {
                temp = a[L];
                a[L] = a[R];
                a[R] = temp;

                if (L == pivot) { // L과 R원소를 교환하여, 결과적으로 피봇 원소의 위치가 변경된 경우
                    for (t = 0 ; t < a.length ; t++) {
                        System.out.printf("%3d ", a[t]);
                    }
                    System.out.println();
                    return R;
                }
            }
        }

        // (L > R)이 된 경우
        temp = a[pivot];
        a[pivot] = a[R];
        a[R] = temp;
        for (t = 0 ; t < a.length ; t++) {
            System.out.printf("%3d   ", a[t]);
        }
        System.out.println();
        return R;
    }

    public void quickSort(int a[], int begin, int end) {
        if (begin < end) {
            int p;
            p = partition(a, begin, end);
            quickSort(a, begin, p-1);
            quickSort(a, p+1, end);
        }
    }

    public static void main(String[] args) {
        int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
        Sort s = new Sort();
        System.out.printf("\n정렬할 원소 : ");
        for (int i = 0 ; i < a.length ; i++) {
            System.out.printf("%3d", a[i]);
        }
        System.out.println();
        s.quickSort(a, 0, 7);
    }

}
```


# 타인 풀이
- https://www.youtube.com/watch?v=7BDzle2n47c
- 다시 확인할 것
```

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Sort {
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end); // start~end 영역에서 partition을 나누고 오른쪽 영역의 첫번째 방 반환
        if (start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }
        if (part2 < end) {
            quickSort(arr, part2, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }

}

```


