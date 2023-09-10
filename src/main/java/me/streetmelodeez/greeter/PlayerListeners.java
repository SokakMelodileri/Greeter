package me.streetmelodeez.greeter;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListeners implements Listener {
    Greeter plugin;
    String tag = ChatColor.RED + "[Greeter] ";
    public PlayerListeners (Greeter plugin){this.plugin = plugin;}
    @EventHandler
    public void wm (PlayerJoinEvent event) {
        String pw = PlaceholderAPI.setPlaceholders(event.getPlayer(), "%luckperms_prefix%");
        String pw2 = PlaceholderAPI.setPlaceholders(event.getPlayer(), "%player_name%");
        event.getPlayer().getServer().broadcastMessage(tag + ChatColor.GOLD + pw + " " + ChatColor.WHITE + pw2 + ChatColor.AQUA +" Sunucuya giriş yaptı!");
    }

    @EventHandler
    public void gbm (PlayerQuitEvent event) {
        String pw = PlaceholderAPI.setPlaceholders(event.getPlayer(), "%luckperms_prefix%");
        String pw2 = PlaceholderAPI.setPlaceholders(event.getPlayer(), "%player_name%");
        event.getPlayer().getServer().broadcastMessage(tag + ChatColor.GOLD + pw + " " + ChatColor.WHITE + pw2 + ChatColor.DARK_PURPLE +" Sunucudan ayrıldı!");
    }

    @EventHandler
    public void selam (AsyncPlayerChatEvent event){
        String selam = event.getMessage();
        String pw2 = PlaceholderAPI.setPlaceholders(event.getPlayer(), "%player_name%");
        if (selam.startsWith("selam") || selam.startsWith("Selam") || selam.startsWith("SELAM")){
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                event.getPlayer().sendMessage(tag + ChatColor.LIGHT_PURPLE +"Aleykümselam hoş geldin " + pw2);
            }, 1L);

        }else if (selam.equals("sa") || selam.equals("SA") || selam.equals("Sa")){
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
            event.getPlayer().sendMessage(tag + ChatColor.LIGHT_PURPLE +"Aleykümselam " + pw2);
        }, 1L);
        }

    }
}
