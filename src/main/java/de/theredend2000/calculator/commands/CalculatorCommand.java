package de.theredend2000.calculator.commands;

import de.theredend2000.calculator.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CalculatorCommand implements CommandExecutor {

    private Main plugin;

    public CalculatorCommand(Main plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(plugin.getConfig().getBoolean("Settings.NeedCalculatorMenuOpenPermission")){
                String permission = Objects.requireNonNull(plugin.getConfig().getString("Permissions.CalculatorMenuOpenPermission"));
                if(player.hasPermission(permission)){
                    plugin.getMenuManager().createCalculatorInventory(player);
                }else
                    player.sendMessage(plugin.getConfig().getString("Messages.NoPermissionMessage").replaceAll("&","§").replaceAll("%permission%", permission));
                return true;
            }
            plugin.getMenuManager().createCalculatorInventory(player);
        }
        return false;
    }
}
