package me.morphie.MorphMining.Files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import me.morphie.MorphMining.Main;

public class Messages implements Listener {

	  private Main plugin = (Main)Main.getPlugin(Main.class);
	  public FileConfiguration messagesCFG;
	  public File messagesFile;
	  
	  public void setup() {
	    if (!this.plugin.getDataFolder().exists()) {
	      this.plugin.getDataFolder().mkdir();
	    }
	    this.messagesFile = new File(this.plugin.getDataFolder(), "messages.yml");
	    if (!this.messagesFile.exists()) {
	      try {
	        this.messagesFile.createNewFile();
	        
	        this.messagesCFG = YamlConfiguration.loadConfiguration(this.messagesFile);
	        
	        this.messagesCFG.addDefault("Messages.Misc.Prefix", "&9&lMorphMining &8&l➙");
	        this.messagesCFG.addDefault("Messages.Misc.MainColor", "&9");
	        this.messagesCFG.addDefault("Messages.Misc.TextColor", "&7");
	        this.messagesCFG.addDefault("Messages.Misc.HighlightColor", "&b");
	        this.messagesCFG.addDefault("Messages.Misc.GUIColor", "&9&l");
	        this.messagesCFG.addDefault("Messages.Misc.ItemColor", "&9&l");
	        this.messagesCFG.addDefault("Messages.ErrorMessages.Prefix", "&8[&9&l!&8]");
	        
	        this.messagesCFG.options().copyDefaults(true);
	        saveMessages();
	      }
	      catch (IOException e) {
	        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not create the messages.yml file");
	      }
	    }
	    this.messagesCFG = YamlConfiguration.loadConfiguration(this.messagesFile);
	  }
	  
	  public void saveMessages() {
	    try {
	      this.messagesCFG.save(this.messagesFile);
	    }
	    catch (IOException e) {
	      Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save the messages.yml file");
	    }
	  }
	  
	  public void reloadMessages() {
	    this.messagesCFG = YamlConfiguration.loadConfiguration(this.messagesFile);
	  }
}
