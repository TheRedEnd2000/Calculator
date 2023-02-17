package de.theredend2000.calculator.menus;

import de.theredend2000.calculator.Main;
import de.theredend2000.calculator.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MenuManager {

    private Main plugin;
    public String rechnung = "§7";

    public MenuManager(Main plugin){
        this.plugin = plugin;
    }

    public void createCalculatorInventory(Player player){
        Inventory inventory = Bukkit.createInventory(player,54,"Calculator");
        int[] redglass = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53};
        for(int i = 0; i < redglass.length; i++){
            inventory.setItem(redglass[i], new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).setDisplayname("§c").build());
        }
        int[] numbers = new int[]{27,28,29,36,37,38,45,46,47};
        for(int i = 0; i < numbers.length; i++){
            inventory.setItem(numbers[i], new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§6"+(i+1)).setLocalizedName("number"+(i+1)).build());
        }
        inventory.setItem(48, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§60").setLocalizedName("number0").build());
        inventory.setItem(12, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname(rechnung).build());
        inventory.setItem(13, new ItemBuilder(Material.ARROW).setDisplayname("§4§l=").build());
        inventory.setItem(14, new ItemBuilder(Material.LIME_STAINED_GLASS_PANE).setDisplayname("§7Shown when Click '='").build());
        inventory.setItem(25, new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setDisplayname("§cDEL").setLocalizedName("del").build());
        inventory.setItem(26, new ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE).setDisplayname("§cAC").setLocalizedName("ac").build());
        inventory.setItem(34, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§6*").setLocalizedName("*").build());
        inventory.setItem(35, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§6/").setLocalizedName("/").build());
        inventory.setItem(43, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§6+").setLocalizedName("+").build());
        inventory.setItem(44, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§6-").setLocalizedName("-").build());
        inventory.setItem(53, new ItemBuilder(Material.ORANGE_STAINED_GLASS_PANE).setDisplayname("§6Calculate").setLocalizedName("=").build());
        player.openInventory(inventory);
    }

}
