package de.theredend2000.calculator.menus;

import de.theredend2000.calculator.Main;
import de.theredend2000.calculator.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MenuManager {

    private Main plugin;

    public MenuManager(Main plugin){
        this.plugin = plugin;
    }

    public void createCalculatorInventory(Player player){
        Inventory inventory = Bukkit.createInventory(player,54,"Calculator");
        int[] redglass = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,15,16,17,18,19,20,21,22,23,24};
        for(int i = 0; i < redglass.length; i++){
            inventory.setItem(redglass[i], new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setDisplayname("§c").build());
        }
        int[] numbers = new int[]{27,28,29,36,37,38,45,46,47};
        for(int i = 0; i < numbers.length; i++){
            inventory.setItem(numbers[i], new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§7Number §6"+(i+1)).build());
        }
        inventory.setItem(48, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§7Number §60").build());
        player.openInventory(inventory);
    }

}
