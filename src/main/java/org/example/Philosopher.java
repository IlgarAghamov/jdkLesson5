package org.example;

public class Philosopher extends Thread {
    private int id;
    private Fork leftFork;
    private Fork rightFork;
    private int mealsEaten;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.mealsEaten = 0;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            eat();
            System.out.println("Philosopher " + id + " is thinking.");
        }
    }

    public void eat() {
        leftFork.pickUp();
        rightFork.pickUp();
        System.out.println("Philosopher " + id + " is eating.");
        leftFork.putDown();
        rightFork.putDown();
        mealsEaten++;
        System.out.println("Philosopher " + id + " has eaten " + mealsEaten + " time(s).");
    }
}
