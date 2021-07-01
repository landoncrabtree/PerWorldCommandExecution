package pw.landon.pwce.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import pw.landon.pwce.PWCEPlugin;

public class PWCECommand implements CommandExecutor {
    private final PWCEPlugin main;
    public PWCECommand(PWCEPlugin main) { this.main = main; }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender console = main.getServer().getConsoleSender();
            int argLength = args.length;
            switch (argLength) {
                case 0, 1 -> {
                    console.sendMessage("[PWCE] /pwce <world> <command>");
                    return false;
                }
                default -> {
                    String world = args[0];
                    if (Bukkit.getWorld(world) != null) {
                        StringBuilder commandString = new StringBuilder("");
                        for (int i = 1; i < argLength; i++) {
                            commandString.append(args[i]).append(" ");
                        }
                        System.out.println("[PWCE] Executing command " + commandString + "in world " + world);
                        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "PWCE");
                        npc.spawn(new Location(Bukkit.getWorld(world), 0, 0, 0));
                        npc.setProtected(true);
                        npc.setUseMinecraftAI(false);
                        npc.setFlyable(true);
                        Entity entity = npc.getEntity();
                        Player player = (Player) entity;
                        player.setOp(true);
                        player.performCommand(commandString.toString());
                        npc.destroy();
                        return true;

                    } else {
                        console.sendMessage("[PWCE] That world is not loaded.");
                        return false;
                    }

                }
            }

        }
        return true;
    }

}
