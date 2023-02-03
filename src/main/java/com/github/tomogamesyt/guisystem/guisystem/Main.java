package com.github.tomogamesyt.guisystem.guisystem;

import com.github.tomogamesyt.guisystem.guisystem.menu.GUIs.GenInventory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    public void runSync(Runnable runnable){
        Bukkit.getScheduler().runTask(this, runnable);
    }

    @Override
    public void onEnable(){
        Bukkit.getServer().getPluginManager().registerEvents(new EventListener(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new open(), this);
    }

    public GenInventory genInventory(){
        return new GenInventory();
    }
}
