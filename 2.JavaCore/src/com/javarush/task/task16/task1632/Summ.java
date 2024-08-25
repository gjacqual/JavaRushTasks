package com.javarush.task.task16.task1632;

import java.util.Scanner;

public class Summ extends Thread{
	public void run() {
		Scanner scanner = new Scanner(System.in);
		int summ = 0;
		while (scanner.hasNext()) {
			String numString = scanner.next();
			if (numString.equals("N")){
				break;
			}
			summ = summ + Integer.parseInt(numString);
		}
		System.out.println(summ);
	}
}
