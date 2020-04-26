package com.mcnizzy.cr.events;

import com.mcnizzy.cr.plugin.ChoppingResources;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class BlockBreak implements Listener {


    @EventHandler
    public void Break(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Block bedrock;
        Location locationBlock = block.getLocation();
        Material material = block.getType();
        if(material.equals(Material.OAK_LOG)){
            player.sendMessage("You have broke "+material);
            player.giveExpLevels(5);
            

        }
        player.sendMessage(ChatColor.GREEN+"Working!");

    }
}
