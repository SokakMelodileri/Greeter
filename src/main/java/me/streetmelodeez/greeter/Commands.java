package me.streetmelodeez.greeter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    Greeter pl;

    public Commands(Greeter plugin){
        this.pl = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(command.getName().equalsIgnoreCase("greeter")){
                if (args.length > 0){
                    switch (args[0]) {
                        case "reload":
                            pl.configYenile();
                            sender.sendMessage("§aKonfigürasyon dosyası başarıyla yenilendi.");
                            break;
                    }
                }else{
                    sender.sendMessage("§4Bilinmeyen Komut! Kullanılabilir komutları görmek için §a/greeter help");
                }
            }
        }
        return false;
    }
}
