package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/* 
CRUD 2
*/

public class Solution {
	public static volatile List<Person> allPeople = new ArrayList<Person>();

	static {
		allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
	}

	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

	public static void main(String[] args) throws ParseException {
		if (args.length > 0) {
			int count = args.length;
			switch (args[0]) {
				case ("-c"):
					for (int i = 1; i <= count - 3; i += 3) {
						synchronized (allPeople) {
							allPeople.add(args[i + 1].equals("м")
									? Person.createMale(args[i], simpleDateFormat2.parse(args[i + 2]))
									: Person.createFemale(args[i], simpleDateFormat2.parse(args[i + 2])));
							System.out.println(allPeople.size() - 1);
						}
					}
					break;
				case ("-i"):
					for (int i = 1; i < count; i++) {
						synchronized (allPeople) {
							Person person = allPeople.get((Integer.parseInt(args[i])));
							System.out.println(person.getName() + " " + (person.getSex().equals(Sex.MALE) ? "м" : "ж") +
									" " + simpleDateFormat.format(person.getBirthDate()));
						}
					}
					break;
				case ("-u"):
					for (int i = 1; i <= count - 4; i += 4) {
						synchronized (allPeople) {
							Person person = allPeople.get((Integer.parseInt(args[i])));
							person.setName(args[i + 1]);
							person.setSex(args[i + 2].equals("ж") ? Sex.FEMALE : Sex.MALE);
							person.setBirthDate(simpleDateFormat2.parse(args[i + 3]));
						}
					}
					break;
				case ("-d"):
					for (int i = 1; i <= count - 1; i++) {
						synchronized (allPeople) {
							Person person = allPeople.get((Integer.parseInt(args[i])));
							person.setName(null);
							person.setSex(null);
							person.setBirthDate(null);
						}
					}
					break;
				default:
					synchronized (allPeople) {
						System.out.println("Incorrect arguments");
					}
					break;
			}
		}
	}
}
