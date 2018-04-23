package me.morphie.MorphMining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class VersionChecker implements Listener {
	
	private Main plugin;
	  
	public VersionChecker(Main plugin) {
		this.plugin = plugin;
	}
	
	public String key = "key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=";
	public String Version = "1.2.5";
	
	@EventHandler
	public void versionchecker(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.isOp()) {
			try {
				HttpURLConnection connection = (HttpURLConnection)new URL("http://www.spigotmc.org/api/general.php").openConnection();
				connection.setDoOutput(true);
				connection.setRequestMethod("POST");
				connection.getOutputStream().write((this.key + 53827).getBytes("UTF-8"));
				String version = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
				if (!version.equals(this.Version)) {
					p.sendMessage("");
					p.sendMessage(ChatColor.RED + "You do not have the most updated version of MorphMining.");
					p.sendMessage("");
				}
			}
			catch (IOException event) {
				this.plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "ERROR: Could not make connection to SpigotMC.org");
				event.printStackTrace();
	    	}	
		}
	}
}
