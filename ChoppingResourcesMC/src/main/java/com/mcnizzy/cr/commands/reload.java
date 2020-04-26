package com.mcnizzy.cr.commands;

import com.mcnizzy.cr.plugin.ChoppingResources;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class reload implements CommandExecutor {

    ChoppingResources plugin;

    public reload(ChoppingResources plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        FileConfiguration Messages = plugin.getMessages();
        if(command.getName().equalsIgnoreCase("crreload")){

            try {
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GREEN+
                        Messages.getString("Messages.t-reload-console"));

                return true;
            }catch (Exception e){
                sender.sendMessage(ChatColor.RED+Messages.getString("Messages.t-error"));
                return true;
            }
        }

        return true;
    }
}
