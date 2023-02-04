package com.github.tomogamesyt.guisystem.guisystem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void runSync(Runnable runnable){
        Bukkit.getScheduler().runTask(this, runnable);
    }

    @Override
    public void onEnable(){
        Bukkit.getServer().getPluginManager().registerEvents(new EventListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new open(), this);
    }
}
