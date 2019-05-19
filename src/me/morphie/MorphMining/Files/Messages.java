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
	        
	        this.messagesCFG.addDefault("ArtifactActionMessage", "&b+1 &9ARTIFACT");
	        this.messagesCFG.addDefault("ArtifactSellMessage", "&7You got $&bMONEY &7from &bARTIFACT &7artifacts!");
	        this.messagesCFG.addDefault("Commands.Header", "&8&m]--------+&r&8[ &9&lMorphMining &8]&8&m+--------[");
	        this.messagesCFG.addDefault("Commands.Footer", "&8&m]-------------+&r &8[&9&l!&8] &8&m+-------------[");
	        this.messagesCFG.addDefault("Commands.Menu", "&b/mine menu &8- &7Opens the miner station menu.");
	        this.messagesCFG.addDefault("Commands.Datalog", "&b/mine datalog &8- &7Opens the datalog menu.");
	        this.messagesCFG.addDefault("Commands.Gems", "&b/mine gems  &8- &7To view how many gems you have.");
	        this.messagesCFG.addDefault("Commands.OreGrinder", "&b/mine og &8- &7Opens the ore grinder menu.");
	        this.messagesCFG.addDefault("Commands.Recipe", "&b/mine recipe <name> &8- &7To view the recipe of a custom item.");
	        this.messagesCFG.addDefault("Commands.Shop", "&b/mine shop &8- &7Opens the shop menu.");
	        this.messagesCFG.addDefault("Commands.Stats", "&b/mine stats <player> &8- &7Opens the mining stats menu.");
	        this.messagesCFG.addDefault("Commands.Withdraw", "&b/mine withdraw <tier> <amount> &8- &7To withdraw artifacts from you pouch.");
	        this.messagesCFG.addDefault("Commands.Reload", "&9[Admin] &b/mine reload &8- &7Reloads the plugins files. (Perms Required)");
	        this.messagesCFG.addDefault("DatalogOnJoinMessage", "&7You recieved a datalog! Right-Click to use.");
	        this.messagesCFG.addDefault("ErrorPrefix", "&8[&9&l!&8] ");
	        this.messagesCFG.addDefault("GemMessage", "&7You currently have &bGEMS &7gems!");
	        this.messagesCFG.addDefault("InvalidArgsMessage", "&7Invalid arguments! /mine to view all commands.");
	        this.messagesCFG.addDefault("InvalidFunds", "&7You do not have valid funds for this!");
	        this.messagesCFG.addDefault("InvalidGems", "&7You do not have enough gems for this!");
	        this.messagesCFG.addDefault("InvalidRecipe", "&7Invalid recipe name! &8[&7DL&8, &7P&8, &7TC&8]");
	        this.messagesCFG.addDefault("Menus.TitleColor", "&9&l");
	        this.messagesCFG.addDefault("Menus.ItemColor", "&9&l");
	        this.messagesCFG.addDefault("Menus.LoreColor", "&7");
	        this.messagesCFG.addDefault("Menus.HighlightColor", "&b");
	        this.messagesCFG.addDefault("Menus.SpacerColor", "&8");
	        this.messagesCFG.addDefault("NoPermsMessage", "&7You don't have permission to do this!");
	        this.messagesCFG.addDefault("OreGrinder.GemMessage", "&7You got &bGEMS &7gems from &bORES &7ores!");
	        this.messagesCFG.addDefault("OreGrinder.NoGemMessage", "&7You were unlucky and got &b0 &7gems from &bORES &7ores!");
	        this.messagesCFG.addDefault("Prefix", "&9&lMorphMining &8&l➙ ");
	        this.messagesCFG.addDefault("ReloadMessage", "&7Plugin files successfully reloaded!");
	        this.messagesCFG.addDefault("Pouch.WithdrawMessage", "&7you withdrew &bARTIFACTS &7artifacts!");
	        this.messagesCFG.addDefault("Pouch.UpgradeMessage", "&7Upgrade successfully purchased!");
	        this.messagesCFG.addDefault("Pouch.NoArtifacts", "&7You don't have enough artifacts in your pouch");
	        this.messagesCFG.addDefault("Pouch.NegativeArtifacts", "&7You cannot withdraw a negative number!");
	        this.messagesCFG.addDefault("Pouch.CorrectUsage", "&bCorrect Usage&8: &7/mine withdraw <tier> <amount>");
	        this.messagesCFG.addDefault("Pouch.ActionMessage", "&b(Pouch) +1 &9ARTIFACT");
	        this.messagesCFG.addDefault("Pouch.ActionFullMessage", "&b(Pouch Full) +1 &9ARTIFACT");
	        this.messagesCFG.addDefault("Stats.NoStatsMessage", "&7This player doesn't have any stats!");
	        this.messagesCFG.addDefault("SpigotLink", "&7https://www.spigotmc.org/resources/morphmining.53827/");
	        this.messagesCFG.addDefault("Trashcan.UpgradeMessage", "&7Upgrade successfully purchased! &8(&bGEMS Gems&8, &b$MONEY&8)");
	        
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
