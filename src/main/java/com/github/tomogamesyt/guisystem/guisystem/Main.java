package com.github.tomogamesyt.guisystem.guisystem;

import com.github.tomogamesyt.guisystem.guisystem.menu.gui.GenInventory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void runSync(Runnable runnable){
        Bukkit.getScheduler().runTask(this, runnable);
    }

    public GenInventory getGenInventory(){
        return GenInventory.getGenInventory();
    }

    @Override
    public void onEnable(){
        Bukkit.getServer().getPluginManager().registerEvents(new EventListener(), this);
    }
}
