package com.bwf.util;

public class Test {

	public static void main(String[] args) {
		long res = 2054353l;
		while(res > 0) {
			System.out.println(res & 7);
			res >>>= 3;
		}
	}

}
