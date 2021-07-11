import java.util.*;

public class Main {
	public static void main(String[] args) {
		// 동전 개수 N과 각 N개의 동전의 금액이 주어졌을 때
		// 그 동전들의 합으로 이루어질 수 없는 숫자 중 최솟값
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int [n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Array.sort(arr);
		
		/*while(true) {
			// 로직 구현해야 함
			// 아이디어:
			// num을 1씩 늘려가며 반복문 수행
			num++
			
			// 만약 arr들의 합으로 num이 구해지면 continue;
			// 수들의 조합의 모든 경우의 수를 따져봐야 할듯
			// 방법을 모르겟다.
			// else, break
			
			
		}*/
		// 이하 정답코드
		int num = 1;
		for (int i = 0; i < n; i ++) {
			//만들 수 없는 금액을 찾았을 때 반복 종료
			if (num < arr[i]) break;
			num += arr[i];
		}
		
		System.out.println(num);
	}
}
