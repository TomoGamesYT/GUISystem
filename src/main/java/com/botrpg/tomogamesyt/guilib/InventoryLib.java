package com.botrpg.tomogamesyt.guilib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class InventoryLib {
    private final Plugin plugin;

    public void runSync(Runnable runnable){
        Bukkit.getScheduler().runTask(plugin, runnable);
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public InventoryLib(Plugin plugin) {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(new EventListener(this), plugin);
    }
}

