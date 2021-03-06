package DP;
import java.util.Scanner;

// 문제: https://www.acmicpc.net/problem/11054
// 해결중
// 풀이: https://ldgeao99.tistory.com/354

public class boj_11054 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        int arr[] = new int [n];
        int dp_inc[] = new int [n];
        int dp_dec[] = new int [n];
        int dp[] = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = scanner.nextInt();
        }
        // 각 위치로까지 증가 부분수열의 합 구하기
        dp_inc[0] = 1;
        for (int i = 1; i < n; i++) {
            dp_inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp_inc[i] <= dp_inc[j]) {
                    dp_inc[i] = dp_inc[j] +1;
                }
            }
        }
        /////////// "앞에서부터" 단순 감소가 아니라 뒤에서 부터 증가로 생각해야함!!
        // 바이토닉 수열의 원리 생각하면 이유 쉽게 알 수 있음
        for (int i = n-1; i >= 0 ; i--) {
            dp_dec[i] = 1;
            for (int j = n-1; j > i; j--) {
                if(arr[i] > arr[j] && dp_dec[i] <= dp_dec[j]) {
                    dp_dec[i] = dp_dec[j] +1;
                }
            }
        }
        // 두 부분수열 길이의 합 중 가장 긴것을 답으로 출력하기
        int dp_max = 0;
        for (int i = 0; i < n;i ++) {
            dp[i] = dp_inc[i] + dp_dec[i];
            dp_max = Math.max(dp[i], dp_max);
        }
        int result = dp_max -1;
        System.out.println(result);

    }
}
