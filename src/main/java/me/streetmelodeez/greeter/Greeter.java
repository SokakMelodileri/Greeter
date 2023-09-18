package me.streetmelodeez.greeter;

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
        getServer().getConsoleSender().sendMessage(tag + "§ais enabled");
        new PlayerListeners(this);
        new Commands(this);
        new TabComplete(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(tag + "§4is disabled");
    }

    public void configYenile(){
        reloadConfig();
        saveDefaultConfig();
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
    }
}

