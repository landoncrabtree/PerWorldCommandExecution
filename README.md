# PerWorldCommandExecution
A 1.17 Spigot plugin that allows you to execute Console commands in specific worlds.

PerWorldCommandExecution is a simple, yet effective tool when it comes to managing your server. Execute commands through console in specific worlds. Normal Vanilla/Spigot behavior executes console commands through the default server.properties world, unless the command supports specifying the world. With PWCE, you can specify the world regardless if the command supports it or not.

## Dependencies:
PWCE depends on Citizens to function. The way PWCE works is by spawning a player entity in the specified world, and making that player execute the command. Citizens allows me to spawn players without the need to get into NMS. It also makes the plugin for lenient for backwards and future compatibility across Minecraft versions.

## Commands:
The only command is /pwce <world> <command>. This command must be ran through Console. For example, /pwce skyblock killall mobs. 

#### PWCE has been tested on Spigot-1.17. It is possible that it supports 1.13, 1.14, 1.15, and 1.16, but it has not been tested. Feel free to try it out and let me know if it works. 

