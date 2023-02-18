package de.theredend2000.calculator.listeners;

import de.theredend2000.calculator.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener {

    private Main plugin;
    private String ls;

    public MenuListener(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onClickNewMapInventory(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals("Calculator")) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getItemMeta().hasLocalizedName()) {
                    switch (event.getCurrentItem().getItemMeta().getLocalizedName()) {
                        case "-":
                            plugin.getMenuManager().rechnung = plugin.getMenuManager().rechnung+"-";
                            plugin.getMenuManager().createCalculatorInventory(player);
                            break;
                        case "+":
                            plugin.getMenuManager().rechnung = plugin.getMenuManager().rechnung+"+";
                            plugin.getMenuManager().createCalculatorInventory(player);
                            break;
                        case "*":
                            plugin.getMenuManager().rechnung = plugin.getMenuManager().rechnung+"*";
                            plugin.getMenuManager().createCalculatorInventory(player);
                            break;
                        case "/":
                            plugin.getMenuManager().rechnung = plugin.getMenuManager().rechnung+"/";
                            plugin.getMenuManager().createCalculatorInventory(player);
                            break;
                        case "=":

                                String rechnung = plugin.getMenuManager().rechnung;
                                for(int i = 0; i < rechnung.length(); i++){
                                    if (Character.isDigit(rechnung.charAt(i))){
                                        ls = ls+String.valueOf(rechnung.charAt(i));

                                    }
                                }
                            player.sendMessage(ls);
                            plugin.getMenuManager().createCalculatorInventory(player);
                            break;
                    }
                    for(int i = 0; i < 10; i++){
                        if(event.getCurrentItem().getItemMeta().getLocalizedName().equals("number"+(i+1))){
                            plugin.getMenuManager().rechnung = plugin.getMenuManager().rechnung+event.getCurrentItem().getItemMeta().getDisplayName();
                            plugin.getMenuManager().createCalculatorInventory(player);
                        }
                    }
                }
            }
        }
    }

}
