package me.streetmelodeez.greeter;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Greeter extends JavaPlugin implements Listener {
    FileConfiguration config = this.getConfig();
    String tag = (config.getString("pluginTag") + "§r ");
    @Override
    public void onEnable() {
        configYenile();
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Greeter is enabled]");
        getServer().getPluginManager().registerEvents(new PlayerListeners(this), this);
        getCommand("greeter").setExecutor(new Commands(this));
        getCommand("greeter").setTabCompleter(new TabComplete(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Greeter is disabled]");
    }

    public void configYenile(){
        reloadConfig();
        saveDefaultConfig();
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
    }
}

