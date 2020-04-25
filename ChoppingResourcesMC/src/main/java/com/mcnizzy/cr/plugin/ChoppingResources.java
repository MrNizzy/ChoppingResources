package com.mcnizzy.cr.plugin;

import com.mcnizzy.cr.commands.General;
import com.mcnizzy.cr.commands.healthme;
import com.mcnizzy.cr.commands.help;
import com.mcnizzy.cr.commands.reload;
import com.mcnizzy.cr.events.BlockBreak;
import com.mcnizzy.cr.events.movement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

import java.io.*;

public final class ChoppingResources extends JavaPlugin {

    private FileConfiguration messages = null;
    private File messagesFile = null;
    String pathMessages;
    String pathConfig;
    PluginDescriptionFile PDFile = getDescription();
    public String Version = PDFile.getVersion();


    public void onEnable() {

        registerEvents();
        assignmentCommands();
        registerConfig();
        Bukkit.getConsoleSender().sendMessage("<======================[PLUGIN]=======================>");
        Bukkit.getConsoleSender().sendMessage(
                ChatColor.DARK_AQUA + "The " + PDFile.getName() + ChatColor.DARK_AQUA +
                        " plugin was created by MrNizzy");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"Version: "+PDFile.getVersion());
        Bukkit.getConsoleSender().sendMessage("<======================[ENABLED]======================>");
    }

    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(
                ChatColor.DARK_AQUA + "The plugin " + PDFile.getName() +
                        ChatColor.DARK_AQUA + " has been disabled.");

    }

    public void assignmentCommands(){
        //this.getCommand("cr").setExecutor(new General(this));
        //this.getCommand("crreload").setExecutor(new reload(this));
        this.getCommand("healthme").setExecutor(new healthme());
    }
    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        //pm.registerEvents(new movement(), this);
        pm.registerEvents(new BlockBreak(), this);
    }

    public void registerConfig(){
        File config = new File(this.getDataFolder(),"config.yml");
        pathConfig = config.getPath();
        if(!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }

}
