package com.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();  // Создаем нового игрока перед каждым тестом
    }

    @Test
    void testInitialState() {
        assertEquals(100, player.getHealth(), "Player should start with 100 health");
        assertEquals(1, player.getLevel(), "Player should start at level 1");
        assertFalse(player.isGameOver(), "Player should not be in game over state initially");
    }

    @Test
    void testAttack() {
        int initialHealth = player.getHealth();
        player.attack();  // Игрок атакует, теряя здоровье
        assertTrue(initialHealth > player.getHealth(), "Health should decrease after attack");
    }

    @Test
    void testGameOver() {
        player.decreaseHealth(110);  // Снижаем здоровье ниже 0
        assertTrue(player.isGameOver(), "Game should be over when health reaches 0 or below");
        assertEquals(0, player.getHealth(), "Player's health should be 0 after game over");
    }

    @Test
    void testLevelUp() {
        int initialLevel = player.getLevel();
        player.levelUp();  // Игрок повышает уровень
        assertEquals(initialLevel + 1, player.getLevel(), "Player's level should increase after level up");
    }

    @Test
    void testRestart() {
        player.decreaseHealth(50);  // Игрок теряет часть здоровья
        int healthAfterDamage = player.getHealth();
        player.levelUp();  // Игрок повышает уровень
        int levelAfterLevelUp = player.getLevel();

        player.restart();  // Рестарт игры

        assertEquals(100, player.getHealth(), "Player's health should be reset to 100 after restart");
        assertEquals(1, player.getLevel(), "Player's level should be reset to 1 after restart");
        assertFalse(player.isGameOver(), "Player should not be in game over state after restart");
        assertNotEquals(healthAfterDamage, player.getHealth(), "Player's health should change after restart");
        assertNotEquals(levelAfterLevelUp, player.getLevel(), "Player's level should change after restart");
    }
}
