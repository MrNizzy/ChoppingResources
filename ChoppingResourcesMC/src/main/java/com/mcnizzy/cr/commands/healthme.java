package com.mcnizzy.cr.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healthme implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("healthme")){
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(args.length<1){
                    player.sendMessage(ChatColor.RED+ "Please include how much you want to be healed by");
                    return true;
                }else if(args.length == 1){
                    try {
                        double phealth = player.getHealth();
                        double addhealth = Double.parseDouble(args[0]);
                        double finalhealth = 0;
                        if(phealth<20){
                            if(addhealth<20){
                                finalhealth = addhealth + phealth;
                                if(finalhealth<20){
                                    player.setHealth(finalhealth);
                                }else{
                                    player.setHealth(20);
                                }
                                player.sendMessage(ChatColor.GRAY+ "You have healed for "+ ChatColor.GREEN+
                                        addhealth+ " health");
                            }else{
                                player.setHealth(20);
                                player.sendMessage(ChatColor.GRAY+ "You have healed for "+ ChatColor.GREEN+
                                        " 20 health");
                            }
                            return true;
                        }else{
                            player.sendMessage(ChatColor.YELLOW+"If you take damage... I could heal you");
                            return true;
                        }
                    }catch (NumberFormatException e){
                        player.sendMessage(ChatColor.RED+ "Please input a real number!");
                        return true;
                    }
                }

            }else{
                sender.sendMessage(ChatColor.RED+"Only players can execute this command.");
            }
        }
        return true;
    }
}
