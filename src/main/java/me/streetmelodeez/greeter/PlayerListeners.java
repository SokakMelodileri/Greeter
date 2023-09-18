package me.streetmelodeez.greeter;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListeners implements Listener {
    Greeter plugin;

    public PlayerListeners (Greeter plugin){
        this.plugin = plugin;
        }

    @EventHandler
    public void wm (PlayerJoinEvent event) {
        String pw = PlaceholderAPI.setPlaceholders(event.getPlayer(), plugin.config.getString("welcomeMessage"));
        event.setJoinMessage(plugin.tag + pw);
    }

    @EventHandler
    public void gbm (PlayerQuitEvent event) {
        String pg = PlaceholderAPI.setPlaceholders(event.getPlayer(), plugin.config.getString("byeMessage"));
        event.setQuitMessage(plugin.tag + pg);
    }

    @EventHandler
    public void selam (AsyncPlayerChatEvent event){
        String selam = event.getMessage();
        String pw2 = PlaceholderAPI.setPlaceholders(event.getPlayer(), plugin.config.getString("selamAlmaMesaj"));
        if (selam.startsWith("selam") || selam.startsWith("Selam") || selam.startsWith("SELAM")){
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                event.getPlayer().sendMessage(plugin.tag + pw2);
            }, 1L);

        }else if (selam.equals("sa") || selam.equals("SA") || selam.equals("Sa")){
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
            event.getPlayer().sendMessage(plugin.tag + pw2);
        }, 1L);
        }
    }

}
