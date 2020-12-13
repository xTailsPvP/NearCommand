package de.tails.nearcommand.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Near_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player))
			return true;
		Player player = (Player) sender;
		if(!(player.hasPermission("near.use"))) {
			player.sendMessage("§cDazu hast du keine Rechte!");
			return true;
		}
		if(args.length == 0) {
			player.sendMessage("§bIn der Nähe befindende Entities:");
			for(Entity entity : player.getNearbyEntities(40, 40, 40)) {
				if(entity instanceof Player) { // Mit dieser Abfrage begrenzt ihr die In der Näher
												// befinden Entties auf Spieler
					player.sendMessage("§9" + entity.getName() + " §3" + Integer
							.valueOf((int) player.getLocation().distance(entity.getLocation())));
				}
			}
		} else {
			player.sendMessage("§cBitte verwende /near");
		}
		return false;
	}
}