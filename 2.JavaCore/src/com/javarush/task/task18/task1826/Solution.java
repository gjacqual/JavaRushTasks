package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

		String key = args[0];
		try (FileInputStream fileInputStream = new FileInputStream(args[1]);
			 FileOutputStream fileOutputStream = new FileOutputStream(args[2])) {
			int i;
			while ((i = fileInputStream.read()) != -1) {
				if ("-e".equals(key))
					fileOutputStream.write(i + 3);
                else if ("-d".equals(key))
                    fileOutputStream.write(i - 3);
                else
                    fileOutputStream.write(i);
				System.out.print((char) i);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
