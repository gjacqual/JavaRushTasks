package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		if (args.length == 4 && args[0].equals("-c")) {
			String productName = args[1];
			if (productName.length() > 30) {
				productName = productName.substring(0, 30);
			}
			String price = args[2];
			String quantity = args[3];
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String filename = bufferedReader.readLine();
			int id = 0;
			try (FileReader fileReader = new FileReader(filename);
				 BufferedReader br = new BufferedReader(fileReader)) {
				while(br.ready()) {
					String  data = br.readLine();
					String tempId = data.substring(0, 8).trim();
					if (Integer.parseInt(tempId) > id) {
						id = Integer.parseInt(tempId);
					}
				}
				id++;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			try (FileWriter fileWriter = new FileWriter(filename, true);
				 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
				bufferedWriter.append("\n");
				bufferedWriter.append(Integer.toString(id));
				bufferedWriter.append(spaceFormatter(Integer.toString(id).length(), 7));
				bufferedWriter.append(productName);
				bufferedWriter.append(spaceFormatter(productName.length(), 29));
				bufferedWriter.append(price);
				bufferedWriter.append(spaceFormatter(price.length(), 7));
				bufferedWriter.append(quantity);
				bufferedWriter.append(spaceFormatter(quantity.length(), 3));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}


	private static String spaceFormatter(int stringLength, int maxLength) {
		StringBuilder spaces = new StringBuilder();
		for (int i = stringLength; i <= maxLength; i++) {
			spaces.append(" ");
		}
		return spaces.toString();
	}
}
