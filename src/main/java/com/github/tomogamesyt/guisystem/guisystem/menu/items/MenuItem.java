package com.github.tomogamesyt.guisystem.guisystem.menu.items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuItem {
    public static iMenuItem nullItem(){return new NullSlot();}
    public static iMenuItem previousButton(){return new ReturnToPrevious();}

    public static iMenuItem helmButton(){return new HelmButton();}
    public static iMenuItem chstpltButton(){return new ChestplateButton();}
    public static iMenuItem leggButton(){return new LeggingsButton();}
    public static iMenuItem bootsButton(){return new BootsButton();}

    public static ItemStack toItemStack(iMenuItem menuItem){
        ItemStack itemStack = new ItemStack(menuItem.getMaterial());
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(menuItem.getDisplayName());
        if(!menuItem.getLore().isEmpty() || menuItem.getLore() != null){
            meta.setLore(menuItem.getLore());
        }
        meta.setCustomModelData(menuItem.getCustomModelData());
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
