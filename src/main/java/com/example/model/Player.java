package com.example.model;

import java.util.Random;

public class Player {
    private int health;
    private boolean gameOver;
    private int level;

    public Player() {
        this.health = 100;  // Начальное здоровье
        this.gameOver = false;
        this.level = 1;  // Начальный уровень игры
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    // Метод для атаки врага, нанесение урона игроку
    public void attack() {
        if (!gameOver) {
            int damage = new Random().nextInt(20) + 10;  // Наносим случайный урон от 10 до 30
            this.health -= damage;
            checkGameOver();
        }
    }

    // Метод для прохождения уровня
    public void levelUp() {
        if (!gameOver) {
            this.level++;
        }
    }

    // Проверка, не закончилась ли игра
    private void checkGameOver() {
        if (this.health <= 0) {
            this.health = 0;
            this.gameOver = true;
        }
    }

    // Рестарт игры
    public void restart() {
        this.health = 100;
        this.level = 1;
        this.gameOver = false;
    }
    public void decreaseHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            this.gameOver = true;
        }
    }
}
