package me.streetmelodeez.greeter;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.profile.PlayerProfile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public final class Greeter extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
    getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void jasd (PlayerJoinEvent event){
        String at = PlaceholderAPI.setPlaceholders(event.getPlayer(), "%vault_eco_balance%");
            System.out.println("Bakiyeniz" + Integer.parseInt(at) * 2);

        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta meta = item.getItemMeta();
        SkullMeta smeta = (SkullMeta) meta;
        final URL url;
        try {
            url = new URL("https://textures.minecraft.net/texture/" + event.getPlayer().getName());
        } catch (final MalformedURLException e) {
            // The URL should never be malformed
            throw new RuntimeException(e);
        }

        final PlayerProfile profile = getServer().createPlayerProfile(UUID.randomUUID());
        profile.getTextures().setSkin(url);
        smeta.setOwnerProfile(profile);
        item.setItemMeta(smeta);
        event.getPlayer().getInventory().addItem(item);
    }
}

