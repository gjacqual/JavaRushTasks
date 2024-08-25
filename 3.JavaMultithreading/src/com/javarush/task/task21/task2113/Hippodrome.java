package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

	static Hippodrome game;

	private List<Horse> horses;


	public static void main(String[] args) throws InterruptedException {
		List<Horse> horses = new ArrayList<>();
		horses.add(new Horse("First", 3, 0));
		horses.add(new Horse("Second", 3, 0));
		horses.add(new Horse("Third", 3, 0));
		game = new Hippodrome(horses);
		game.run();
		game.printWinner();
	}

	public Hippodrome(List<Horse> horses) {
		this.horses = horses;
	}

	public List<Horse> getHorses() {
		return horses;
	}

	void run() throws InterruptedException {
		for (int i = 1; i <= 100; i++) {
			move();
			print();
			Thread.sleep(200);
		}
	}

	void move() {
		for (Horse horse : horses) {
			horse.move();
		}
	}

	void print() {
		for (Horse horse : horses) {
			horse.print();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}
	public Horse getWinner() {
		double maxDistance = 0.0;
		Horse winner = null;
		for (Horse horse : horses) {
			if (horse.getDistance() > maxDistance) {
				maxDistance = horse.getDistance();
			}
		}
		for (Horse horse : horses) {
			if (horse.getDistance() == maxDistance) {
				return horse;
			}
		}
		return null;
	}

	public void printWinner() {
		System.out.println("Winner is " + getWinner().getName() + "!");
	}
}
