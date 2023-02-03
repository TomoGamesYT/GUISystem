package com.github.tomogamesyt.guisystem.guisystem;

import com.github.tomogamesyt.guisystem.guisystem.menu.GUIs.GenInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAnimationEvent;

public class open implements Listener {
    GenInventory genInventory = new GenInventory();

    @EventHandler
    public void onClick(PlayerAnimationEvent event){
        Player player = event.getPlayer();
        if(!player.isSneaking())return;
        player.sendMessage("air click");
        genInventory.open(player, GenInventory.armor());
    }

    /*
    * CustomInventoryのいんすたんすを生成
    *
    * openメソッドでArmorMenuを呼び出す
    * ArmorMenuでInventoryを作成
    * InventoryをCustomInventoryのinitInventoryに渡す。
    * 帰ってきた返り値のInventoryにArmorMenuでItemを配置
    *
    * */
}
