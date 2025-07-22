package com.nation.dungeon.util;

import com.nation.dungeon.Enemy;
import com.nation.dungeon.Player;
import com.nation.dungeon.merchant.ItemCombiner;

public class GameManager {

    private static final GameManager instance = new GameManager();

    private final DatabaseManager databaseManager = new DatabaseManager();
    private final AudioManager audioManager = new AudioManager();
    private final ItemCombiner itemCombiner = new ItemCombiner();

    private Player player;
    private Enemy enemy;

    private boolean isFullScreen = false;

    public static GameManager get() {
        return instance;
    }

    public DatabaseManager databaseManager() {
        return this.databaseManager;
    }

    public AudioManager audioManager() {
        return this.audioManager;
    }

    public ItemCombiner itemCombiner() {
        return this.itemCombiner;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void setFullScreen(boolean fullScreen) {
        this.isFullScreen = true;
    }

    public boolean isFullScreen() {
        return this.isFullScreen;
    }
}
