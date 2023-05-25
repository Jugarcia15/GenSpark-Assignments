package org.example;

import java.util.Scanner;

public class Main {
        public static void arrayPairs(int N,int[] A)
        {
            int target = 20;
            int start =0;
            int end = 0;
            int maxProduct = Integer.MIN_VALUE;
            for( int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    if( A[i] + A[j] == target && A[i] * A[j] > maxProduct && A[i] > end){
                        maxProduct = A[i]*A[j];
                        start = A[i];
                        end = A[j];
                        if ( end > start){
                            int temp = 0;
                            temp = start;
                            start = end;
                            end = temp;
                        }
                    }
                }
            }
            System.out.println(start + " " + end);
            return;
        }

    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        //INPUT [uncomment & modify if required]
        int N = sc.nextInt ();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
        {
            A[i] = sc.nextInt ();
        }
        arrayPairs(N,A);
    }
}