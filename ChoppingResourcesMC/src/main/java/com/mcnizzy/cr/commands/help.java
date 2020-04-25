package com.mcnizzy.cr.commands;

import com.mcnizzy.cr.plugin.ChoppingResources;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class help implements CommandExecutor {

    private ChoppingResources plugin;

    public help(ChoppingResources plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        FileConfiguration Config = this.plugin.getConfig();
        if(!(sender instanceof Player)){
            if(args[0].equalsIgnoreCase("reload"));
        }

        return false;
    }
}