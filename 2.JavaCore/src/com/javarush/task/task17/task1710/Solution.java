package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.javarush.task.task17.task1710.Sex.MALE;

/* 
CRUD
*/

public class Solution {
	public static List<Person> allPeople = new ArrayList<Person>();

	static {
		allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			if (args[0].equals("-c")) {
				String[] dateFrom = args[3].split("/");
				if (args[2].equals("м")) {
					allPeople.add(Person.createMale(args[1], new Date(Integer.parseInt(dateFrom[2]) - 1900, Integer.parseInt(dateFrom[1]) - 1, Integer.parseInt(dateFrom[0]))));
				} else if (args[2].equals("ж")) {
					allPeople.add(Person.createFemale(args[1], new Date(Integer.parseInt(dateFrom[2]) - 1900, Integer.parseInt(dateFrom[1]) - 1, Integer.parseInt(dateFrom[0]))));
				}
				System.out.println(allPeople.size() -1 );
			} else if (args[0].equals("-r")) {
				Person person = allPeople.get((Integer.parseInt(args[1])));
				System.out.println(person.getName() + " " + (person.getSex() == MALE ? "м": "ж" ) +
						" " + new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH).format(person.getBirthDate()));
			} else if (args[0].equals("-u")) {
				String[] dateFrom = args[4].split("/");
				Person person = allPeople.get((Integer.parseInt(args[1])));
				person.setName(args[2]);
				person.setSex(args[3].equals("ж")? Sex.FEMALE : Sex.MALE);
				person.setBirthDate(new Date(Integer.parseInt(dateFrom[2]) - 1900, Integer.parseInt(dateFrom[1]) - 1, Integer.parseInt(dateFrom[0])));
			} else if (args[0].equals("-d")) {
				Person person = allPeople.get((Integer.parseInt(args[1])));
				person.setName(null);
				person.setSex(null);
				person.setBirthDate(null);
			}
		}
	}
}
