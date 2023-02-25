package com.github.tomogamesyt.guisystem.guisystem.menu.items;

import org.bukkit.Material;

import java.util.List;

public interface iMenuItem {
    String getDisplayName();
    Material getMaterial();
    List<String> getLore();
    int getCustomModelData();
}
