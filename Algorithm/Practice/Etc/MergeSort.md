# 내 풀이

- 자바로 배우는 쉬운 자료구조
- 추후에 다시 볼 것

```
public class MergeSort {
	private int sorted[] = new int[30];

	public void merge(int a[], int m, int middle, int n) {
		int size = a.length;
		int i, j, k, t;
		i = m;
		j = middle + 1;
		k = m;

		while (i <= middle && j <= n) {
			if (a[i] <= a[j]) {
				sorted[k] = a[i++];
			} else {
				sorted[k] = a[j++];
			}
			k++;
		}

		if (i > middle) {
			for (t = j ; t <= n ; t++, k++) {
				sorted[k] = a[t];
			}
		} else {
			for (t=i ; t <= middle; t++, k++) {
				sorted[k] = a[t];
			}
		}

		for (t = m ; t <= n ; t++) {
			a[t] = sorted[t];
		}
		System.out.printf("\n 병합 정렬 >> ");

		for (t = 0 ; t < size ; t++) {
			System.out.printf("%3d ", a[t]);
		}
	}

	public void mergeSort(int a[], int m , int n) {
		int middle;
		if (m < n) {
			middle = (m + n) / 2;
			mergeSort(a, m, middle);
			mergeSort(a, middle + 1, n);
			merge(a, m, middle, n);
		}
	}

	public static void main(String[] args) {
//		int[] a = new int[] {69, 10, 30, 2, 16, 8, 31, 22};
		int[] a = new int[] {4, 2, 6, 3, 7, 8, 5, 1};
		int size = a.length;
		MergeSort s = new MergeSort();
		System.out.println("\n정렬할 원소 : ");
		for (int i = 0 ; i < a.length ; i++) {
			System.out.printf(" %d", a[i]);
		}
		System.out.println();
		s.mergeSort(a, 0, size-1);
	}

}

```

# 타인 풀이

- https://www.youtube.com/watch?v=QAyl79dCO_k

```

public class test {

	private static void mergeSort(int[] arr) {
		int[] tmp = new int[arr.length]; // 임시 저장소
		mergeSort(arr, tmp, 0, arr.length - 1); // 재귀호출 시작
	}

	private static void mergeSort(int[] arr, int[] tmp, int start, int end) { // 정렬할 배열, 임시저장 공간, 시작 인덱스, 끝 인덱스
		if (start < end) { // 이 조건에만 재귀호출
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid); // 왼쪽 - (시작) ~ (중간)
			mergeSort(arr, tmp, start, mid); // 오른쪽 - (중간 + 1) ~ (끝)
			// 재귀함수 끝. 가운데(mid)를 기준으로 왼쪽과 오른쪽이 각각 정렬되어 있는 상태.
			merge(arr, tmp, start, mid, end); // 두 개로 나뉘어져 있는 방을 병합
		}
	}

	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		//임시 저장소(temp)에 정렬된 배열을 필요한만큼 복사
		for (int i = start ; i <= end ; i++) {
			tmp[i] = arr[i];
		}
		// 배열 2개가 중간지점을 기준으로 하나로 붙어있으니까 첫번째 배열의 첫번째 방(part1)과, 두번째 배열의 첫번째 방(part2)로 저장
		int part1 = start;
		int part2 = mid + 1;
		// 양쪽 배열방에서 작은 값을 하나씩 복사할 때마다 결과배열방에 어디에 저장해야 되는지도 알아야 하니까 복사 후에 하나씩 늘려줘서 다음에 저장할 곳을 기억
		int index = start;

		while (part1 <= mid && part2 <= end) { // 첫번째 배열과 두번째 배열 중 하나가 끝날 때까지 돔.
			if (tmp[part1] <= tmp[part2]) { // 두 개의 배열의 첫 번째 방의 값을 비교
				// 앞의 배열의 첫번째 방이 작을 경우
				arr[index] = tmp[part1]; // 앞의 것을 복사하고
				part1++; // 앞쪽 포인터 1칸 뒤로 옮기고

			} else { // 뒤의 배열의 첫번재 방이 더 작을 경우
				arr[index] = tmp[part2]; // 뒤의 것을 복사하고
				part2++; // 뒤쪽 포인터 1칸 뒤로 옮기고
			}
			// 어느쪽의 배열을 옮겼든 간에 index + 1
			index++;
		}
		// 위의 while문에서 만약 뒤쪽 배열은 비었고 앞쪽 배열은 남아있을 경우를 대비
		// 앞의 포인터가 배열의 끝에서 남은만큼 돌면서 최종적으로 저장할 배열에 남은 값들을 복사
		// 그러면 반대의 경우는(앞쪽 배열은 비었고 뒤쪽 배열에 데이터가 남았을 경우)? 뒤쪽 배열은 이미 최종배열의 뒤쪽에 자리하고 있으므로 뒤쪽에 남은 데이터는 그대로 놔둬도 됨.
		for (int i = 0 ; i <= mid - part1 ; i++) {
			arr[index + i] = tmp[part1 + i];
		}
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
		mergeSort(arr);
		printArray(arr);
	}
}
```
