package com.javarush.task.task16.task1632;

public class Warning extends Thread implements Message{

	@Override
	public void showWarning() {
		this.interrupt();
	}

	public void run(){
		while (!currentThread().isInterrupted()){

		}

	}
}
