package com.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();  // Создаем новый объект игры перед каждым тестом
    }

    @Test
    void testStartGame() {
        game.startGame();
        assertTrue(game.isGameStarted(), "Game should be started");
        assertEquals(100, game.getPlayer().getHealth(), "Player should start with 100 health");
        assertEquals(1, game.getPlayer().getLevel(), "Player should start at level 1");
    }

    @Test
    void testAttack() {
        game.startGame();
        int initialHealth = game.getPlayer().getHealth();
        game.attack();  // Игрок атакует
        assertTrue(initialHealth > game.getPlayer().getHealth(), "Health should decrease after attack");
    }

    @Test
    void testLevelUp() {
        game.startGame();
        int initialLevel = game.getPlayer().getLevel();
        game.levelUp();  // Игрок повышает уровень
        assertEquals(initialLevel + 1, game.getPlayer().getLevel(), "Level should increase after level up");
    }

    @Test
    void testGameOver() {
        game.startGame();
        // Симулируем серию атак, чтобы здоровье игрока стало 0
        game.getPlayer().decreaseHealth(110);
        assertTrue(game.isGameOver(), "Game should be over when health reaches 0");
        assertEquals("Game Over! You lost.", game.getGameOverMessage(), "Message should indicate game over");
    }

    @Test
    void testRestartGame() {
        game.startGame();
        game.attack();  // Атакуем, уменьшаем здоровье
        int healthAfterAttack = game.getPlayer().getHealth();
        game.restartGame();  // Рестарт игры

        assertEquals(100, game.getPlayer().getHealth(), "Player's health should be reset to 100 after restart");
        assertEquals(1, game.getPlayer().getLevel(), "Player's level should be reset to 1 after restart");
        assertFalse(game.isGameOver(), "Game should not be over after restart");
        assertNotEquals(healthAfterAttack, game.getPlayer().getHealth(), "Player's health should change after restart");
    }
}
