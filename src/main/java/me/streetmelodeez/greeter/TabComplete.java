package me.streetmelodeez.greeter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {
    Greeter pl;
    public TabComplete(Greeter plugin){
        this.pl = plugin;
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        if(sender instanceof Player){
            if(args.length > 0){
                completions.add("reload");
            }
        }
        return completions;
    }
}
