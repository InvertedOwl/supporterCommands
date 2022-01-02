package com.invertedowl.honeypot;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Honeypot extends JavaPlugin {


    public static Honeypot instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.getCommand("customSupporterItem").setExecutor(new Commands());
        getDataFolder().mkdir();
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
