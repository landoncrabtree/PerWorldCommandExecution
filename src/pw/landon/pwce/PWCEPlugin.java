package pw.landon.pwce;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pw.landon.pwce.commands.PWCECommand;

import java.util.Objects;

public class PWCEPlugin extends JavaPlugin {

    private static PWCEPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("[PWCE] Enabled. Made by @Religion.");
        Objects.requireNonNull(this.getCommand("pwce")).setExecutor(new PWCECommand(this));
    }

    public static PWCEPlugin getInstance() {
        return instance;
    }
}
