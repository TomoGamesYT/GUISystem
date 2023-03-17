package com.botrpg.tomogamesyt.guilib.menu.items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuItem {
    public static ItemStack nullItem(){
        return toItemStack(new NullSlot());
    }
    public static ItemStack previousButton(){
        return toItemStack(new ReturnToPrevious());
    }
    public static ItemStack closeButton(){
        return toItemStack(new CloseSlot());
    }

    public static ItemStack helmButton(){
        return toItemStack(new HelmButton());
    }
    public static ItemStack chstpltButton(){
        return toItemStack(new ChestplateButton());
    }
    public static ItemStack leggButton(){
        return toItemStack(new LeggingsButton());
    }
    public static ItemStack bootsButton(){
        return toItemStack(new BootsButton());
    }
    public static ItemStack armorButton() {
        return toItemStack(new ArmorMenuButton());
    }

    private static ItemStack toItemStack(iMenuItem menuItem){
        ItemStack itemStack = new ItemStack(menuItem.getMaterial());
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(menuItem.getDisplayName());
        if(menuItem.getLore() != null) {
            if (!menuItem.getLore().isEmpty()) {
                meta.setLore(menuItem.getLore());
            }
        }
        meta.setCustomModelData(menuItem.getCustomModelData());
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
