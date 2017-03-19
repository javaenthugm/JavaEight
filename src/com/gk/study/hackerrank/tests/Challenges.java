package com.gk.study.hackerrank.tests;

import java.util.Scanner;

/**
 * @author javaenthu
 *
 */
public class Challenges {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        String numArray = in.nextLine();
        int sum = 0;
        System.out.println(numArray);
        String[] array = numArray.split(" ");
        System.out.println(array);
        /*for(int i=0;i<array.length;i++){
            sum+=Integer.valueOf(array[i]);
        }*/
        System.out.println(sum);
    }
	
}
