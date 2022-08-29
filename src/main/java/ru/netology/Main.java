package ru.netology;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        new Thread(() -> {
            for (int i = 0; i < 60; i++) {
                try {
                    queue.put("Абонент " + i);
                    System.out.println("Абонент " + i + " ожидает ответа оператора");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    System.out.println("Оператор №1 принял звонок от " + queue.take());
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    System.out.println("Оператор №2 принял звонок от " + queue.take());
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    System.out.println("Оператор №3 принял звонок от " + queue.take());
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();
    }
}
