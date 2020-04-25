package com.mcnizzy.cr.commands;

import com.mcnizzy.cr.plugin.ChoppingResources;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class General implements CommandExecutor {

    private ChoppingResources plugin;

    public General(ChoppingResources pl){
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration Config = this.plugin.getConfig();
        if(!(sender instanceof Player)){
            if(args[0].equalsIgnoreCase("reload")){
                plugin.reloadConfig();
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN +"El plugin "+plugin.getName()+
                        " se ha recargado correctamente");
            }else{
                Bukkit.getConsoleSender().sendMessage("No se puede usar ese comando desde la consola.");
            }
            return false;
        }

        return true;
    }
}
