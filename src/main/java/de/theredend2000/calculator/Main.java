package de.theredend2000.calculator;

import de.theredend2000.calculator.commands.CalculatorCommand;
import de.theredend2000.calculator.listeners.MenuListener;
import de.theredend2000.calculator.menus.MenuManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private MenuManager menuManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        //Managers
        menuManager = new MenuManager(this);
        //Commmands
        getCommand("calculator").setExecutor(new CalculatorCommand(this));
        //Listener
        Bukkit.getPluginManager().registerEvents(new MenuListener(this),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public MenuManager getMenuManager() {
        return menuManager;
    }
}
