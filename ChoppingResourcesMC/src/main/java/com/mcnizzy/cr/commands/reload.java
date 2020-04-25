package com.mcnizzy.cr.commands;

import com.mcnizzy.cr.plugin.ChoppingResources;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reload implements CommandExecutor {

    ChoppingResources plugin;

    public reload(ChoppingResources plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("crreload")){

            try {
                plugin.reloadConfig();
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"El plugin se ha recargado correctamente.");

                return true;
            }catch (Exception e){
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"Ocurrió un error.");
                return true;
            }
        }

        return true;
    }
}
