package com.example.model;

import java.util.Random;

public class Game {
    private Player player;
    private boolean gameStarted;

    public Game() {
        this.player = new Player();  // Создаем игрока
        this.gameStarted = false;    // Игра не началась
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void startGame() {
        this.gameStarted = true;
        this.player = new Player();  // Сброс данных игрока при начале игры
    }

    public void attack() {
        if (player.isGameOver()) {
            return; // Игра закончена, не наносим урон
        }
        // Логика атаки, наносящая урон
        Random rand = new Random();
        int damage = rand.nextInt(20) + 10;  // Урон от 10 до 30
        player.decreaseHealth(damage);
    }

    public void levelUp() {
        if (player.isGameOver()) {
            return; // Если игра завершена, нельзя повысить уровень
        }
        player.levelUp();  // Игрок повышает уровень
    }

    public void restartGame() {
        player.restart();  // Рестарт игры
        gameStarted = false;  // Игра не начата
    }

    // Проверка состояния игры
    public boolean isGameOver() {
        return player.isGameOver();
    }

    public String getGameOverMessage() {
        if (isGameOver()) {
            return "Game Over! You lost.";
        }
        return "";
    }
}
