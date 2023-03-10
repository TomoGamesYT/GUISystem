package com.botrpg.tomogamesyt.guilib.menu.items;

import org.bukkit.Material;

import java.util.List;

public class ReturnToPrevious implements iMenuItem{
    @Override
    public String getDisplayName() {
        return "前に戻る";
    }

    @Override
    public Material getMaterial() {
        return Material.BARRIER;
    }

    @Override
    public List<String> getLore() {
        return null;
    }

    @Override
    public int getCustomModelData() {
        return 0;
    }
}
