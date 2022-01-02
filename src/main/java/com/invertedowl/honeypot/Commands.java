package com.invertedowl.honeypot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class Commands implements CommandExecutor {
    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("customSupporterItem")){
            if (sender instanceof Player){
                Player player = ((Player) sender);
                if (player.hasPermission("supportercommands.customitem")) {
                    ItemMeta meta = player.getItemInUse().getItemMeta();
                    assert meta != null;
                    meta.setCustomModelData(Honeypot.instance.getConfig().getInt("supporterItem"));
                    player.sendMessage(Objects.requireNonNull(Honeypot.instance.getConfig().getString("supporterItemMessage")));
                }
            } else {
                sender.sendMessage("Yo console cant do this command");
            }
            return true;
        }
        return false;
    }
}
