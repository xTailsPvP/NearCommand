package de.tails.nearcommand.main;

import org.bukkit.plugin.java.JavaPlugin;

public class NearCommand extends JavaPlugin {

	private static NearCommand plugin;

	@Override
	public void onEnable() {
		plugin = this;
		getCommand("near").setExecutor(new Near_CMD());
	}

	@Override
	public void onDisable() {
		plugin = null;
	}

	public static NearCommand getPlugin() {
		return plugin;
	}
}