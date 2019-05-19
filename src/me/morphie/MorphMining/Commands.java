package me.morphie.MorphMining;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.morphie.MorphMining.Archivist.OreGrinderMenu;
import me.morphie.MorphMining.DataLog.LogMenu;
import me.morphie.MorphMining.Files.playerFileMethods;
import me.morphie.MorphMining.Items.Artifacts;
import me.morphie.MorphMining.Items.Pouch;
import me.morphie.MorphMining.Market.ArtifactShop;
import me.morphie.MorphMining.Market.Market;
import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {
	
	private Main plugin;
	  
	public Commands(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("mine")) {
			if (args.length == 0) {
				sender.sendMessage("");
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.Header")));
				sender.sendMessage("");
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.Menu")));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.Datalog")));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.Gems")));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.OreGrinder")));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.Shop")));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.Stats")));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.Recipe")));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.Withdraw")));
				sender.sendMessage("");
				if (sender.hasPermission("morphmining.admin") || sender.hasPermission("morphmining.reload")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.Reload")));
				}
				sender.sendMessage("");
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Commands.Footer")));
				sender.sendMessage("");
				return true;
			
			}
			if (args[0].equalsIgnoreCase("menu")) {
				Player player = (Player)sender;
				new Station(this.plugin).openGUIMining(player);
				return true;
			}
			else if (args[0].equalsIgnoreCase("datalog")) {
				Player player = (Player)sender;
				new LogMenu(this.plugin).openGUIMineLog(player);
				return true;
			}
			else if (args[0].equalsIgnoreCase("market")) {
				Player player = (Player)sender;
				new Market(this.plugin).openGUIMarket(player);
				return true;
			}
			else if (args[0].equalsIgnoreCase("og")) {
				Player player = (Player)sender;
				new OreGrinderMenu(this.plugin).openGUIOG(player);
				return true;
			}
			else if (args[0].equalsIgnoreCase("shop")) {
				Player player = (Player)sender;
				new ArtifactShop(this.plugin).openGUIShop(player);
				return true;
			}
			else if (args[0].equalsIgnoreCase("pouch")) {
				Player player = (Player)sender;
				new Pouch(this.plugin).openGUIPouch(player);
				return true;
			}
			else if (args[0].equalsIgnoreCase("gems")) {
				Player player = (Player)sender;
				UUID uuid = player.getUniqueId();
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("GemMessage").replace("GEMS", "" + new playerFileMethods(this.plugin).getStat(uuid, "Stats.Gems"))));
				return true;
			}
			else if (args[0].equalsIgnoreCase("withdraw")) {
				Player player = (Player)sender;
				UUID uuid = player.getUniqueId();
				if (args.length == 3) {
					if (args[1].equalsIgnoreCase("common")) {
						if (args[2] != null) {
							int parseInt = Integer.parseInt(args[2]);
							if (parseInt > 0) {
								if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Common") >= parseInt && parseInt > 0) {					
									new Artifacts(this.plugin).getArts("CommonArt", parseInt, player);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Pouch.WithdrawMessage").replace("ARTIFACTS", "" + parseInt)));
									new playerFileMethods(this.plugin).setData(player, uuid, "Pouch.Common", -parseInt);
									return true;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.NoArtifacts")));
									return true;
								}
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.NegativeArtifacts")));
								return true;
							}
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.CorrectUsage")));
							return true;
						}
					} else if (args[1].equalsIgnoreCase("rare")) {
						if (!(args[2] == null)) {
							int parseInt = Integer.parseInt(args[2]);
							if (parseInt > 0) {
								if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare") >= parseInt) {					
									new Artifacts(this.plugin).getArts("RareArt", parseInt, player);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Pouch.WithdrawMessage").replace("ARTIFACTS", "" + parseInt)));
									new playerFileMethods(this.plugin).setData(player, uuid, "Pouch.Rare", -parseInt);
									return true;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.NoArtifacts")));
									return true;
								}
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.NegativeArtifacts")));
								return true;
							}
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.CorrectUsage")));
							return true;
						}
					} else if (args[1].equalsIgnoreCase("legendary")) {
						if (args[2] != null) {
							int parseInt = Integer.parseInt(args[2]);
							if (parseInt > 0) {
								if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary") >= parseInt) {					
									new Artifacts(this.plugin).getArts("LegendaryArt", parseInt, player);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Pouch.WithdrawMessage").replace("ARTIFACTS", "" + parseInt)));
									new playerFileMethods(this.plugin).setData(player, uuid, "Pouch.Legendary", -parseInt);
									return true;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.NoArtifacts")));
									return true;
								}
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.NegativeArtifacts")));
								return true;
							}
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.CorrectUsage")));
							return true;
						}
					} else if (args[1].equalsIgnoreCase("mythic")) {
						if (args[2] != null) {
							int parseInt = Integer.parseInt(args[2]);
							if (parseInt > 0) {
								if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic") >= parseInt && parseInt > 0) {					
									new Artifacts(this.plugin).getArts("MythicArt", parseInt, player);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Pouch.WithdrawMessage").replace("ARTIFACTS", "" + parseInt)));
									new playerFileMethods(this.plugin).setData(player, uuid, "Pouch.Mythic", -parseInt);
									return true;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.NoArtifacts")));
									return true;
								}
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.NegativeArtifacts")));
								return true;
							}
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.CorrectUsage")));
							return true;
						}
					} else {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.CorrectUsage")));
						return true;
					}
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.CorrectUsage")));
					return true;
				}
			} else if (args[0].equalsIgnoreCase("stats")) {
				if ((sender instanceof Player)) {
					Player player = (Player)sender;
					if (args.length == 2) {
						if (Bukkit.getServer().getPlayer(args[1]) != null) {
							UUID uuid = Bukkit.getServer().getPlayer(args[1]).getUniqueId();
							if (getFileExists(uuid)) {
								new MineStats(this.plugin).openGUIStats(player, uuid, args[1]);
								return true;
							} else {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Stats.NoStatsMessage")));
								return true;
							}
						} else {
							UUID uuid = Bukkit.getServer().getOfflinePlayer(args[1]).getUniqueId();
							if (getFileExists(uuid)) {
								new MineStats(this.plugin).openGUIStats(player, uuid, args[1]);
								return true;
							} else {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Stats.NoStatsMessage")));
								return true;
							}
						}
					} else {
						new MineStats(this.plugin).openGUIStats(player, player.getUniqueId(), player.getName().toString());
						return true;
					}
				}
			} else if (args[0].equalsIgnoreCase("reload")) {
				if (sender.hasPermission("morphmining.admin") || sender.hasPermission("morphmining.reload")) {
					Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("MorphMining");
		            if (this.plugin != null) {
		            	this.plugin.reloadConfig();
		            	this.plugin.getServer().getPluginManager().disablePlugin(plugin);
		            	this.plugin.getServer().getPluginManager().enablePlugin(plugin);
		            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("ReloadMessage")));
		            	return true;
		            }
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("NoPermsMessage")));
					return true;
		        }
			} else if (args[0].equalsIgnoreCase("recipe")) {
				if (args.length > 1) {
					if (args[1].equalsIgnoreCase("DL")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Crafting Grid" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  |" + this.plugin.getMessage("Menus.HighlightColor") + this.plugin.getConfig().getString("Recipes.Datalog.Line1") + "&f|" + this.plugin.getMessage("Menus.SpacerColor") + " - " + this.plugin.getMessage("Menus.LoreColor") + "Line 1"));    
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  |" + this.plugin.getMessage("Menus.HighlightColor") + this.plugin.getConfig().getString("Recipes.Datalog.Line2") + "&f|" + this.plugin.getMessage("Menus.SpacerColor") + " - " + this.plugin.getMessage("Menus.LoreColor") + "Line 2")); 
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  |" + this.plugin.getMessage("Menus.HighlightColor") + this.plugin.getConfig().getString("Recipes.Datalog.Line3") + "&f|" + this.plugin.getMessage("Menus.SpacerColor") + " - " + this.plugin.getMessage("Menus.LoreColor") + "Line 3")); 
						sender.sendMessage(" ");
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Ingredients" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + "(Key | Item)"));
					    int Count = 0;
					    while (plugin.getConfig().getString("Recipes.Datalog.Ingredients." + Count) != null) {
					    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.SpacerColor") + "  [" + this.plugin.getMessage("Menus.HighlightColor") + plugin.getConfig().getString("Recipes.Datalog.Ingredients." + Count + ".Key") + this.plugin.getMessage("Menus.SpacerColor") + "] " + this.plugin.getMessage("Menus.LoreColor") + plugin.getConfig().getString("Recipes.Datalog.Ingredients." + Count + ".Material")));
					    	Count++;
					    }
						return true;
					} else if (args[1].equalsIgnoreCase("P")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Crafting Grid" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  |" + this.plugin.getMessage("Menus.HighlightColor") + this.plugin.getConfig().getString("Recipes.Pouch.Line1") + "&f|" + this.plugin.getMessage("Menus.SpacerColor") + " - " + this.plugin.getMessage("Menus.LoreColor") + "Line 1"));    
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  |" + this.plugin.getMessage("Menus.HighlightColor") + this.plugin.getConfig().getString("Recipes.Pouch.Line2") + "&f|" + this.plugin.getMessage("Menus.SpacerColor") + " - " + this.plugin.getMessage("Menus.LoreColor") + "Line 2")); 
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  |" + this.plugin.getMessage("Menus.HighlightColor") + this.plugin.getConfig().getString("Recipes.Pouch.Line3") + "&f|" + this.plugin.getMessage("Menus.SpacerColor") + " - " + this.plugin.getMessage("Menus.LoreColor") + "Line 3")); 
						sender.sendMessage(" ");
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Ingredients" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + "(Key | Item)"));
					    int Count = 0;
					    while (plugin.getConfig().getString("Recipes.Pouch.Ingredients." + Count) != null) {
					    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.SpacerColor") + "  [" + this.plugin.getMessage("Menus.HighlightColor") + plugin.getConfig().getString("Recipes.Pouch.Ingredients." + Count + ".Key") + this.plugin.getMessage("Menus.SpacerColor") + "] " + this.plugin.getMessage("Menus.LoreColor") + plugin.getConfig().getString("Recipes.Pouch.Ingredients." + Count + ".Material")));
					    	Count++;
					    }
						return true;
					} else if (args[1].equalsIgnoreCase("TC")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Crafting Grid" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  |" + this.plugin.getMessage("Menus.HighlightColor") + this.plugin.getConfig().getString("Recipes.Trashcan.Line1") + "&f|" + this.plugin.getMessage("Menus.SpacerColor") + " - " + this.plugin.getMessage("Menus.LoreColor") + "Line 1"));    
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  |" + this.plugin.getMessage("Menus.HighlightColor") + this.plugin.getConfig().getString("Recipes.Trashcan.Line2") + "&f|" + this.plugin.getMessage("Menus.SpacerColor") + " - " + this.plugin.getMessage("Menus.LoreColor") + "Line 2")); 
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "  |" + this.plugin.getMessage("Menus.HighlightColor") + this.plugin.getConfig().getString("Recipes.Trashcan.Line3") + "&f|" + this.plugin.getMessage("Menus.SpacerColor") + " - " + this.plugin.getMessage("Menus.LoreColor") + "Line 3")); 
						sender.sendMessage(" ");
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Ingredients" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + "(Key | Item)"));
					    int Count = 0;
					    while (plugin.getConfig().getString("Recipes.Trashcan.Ingredients." + Count) != null) {
					    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.SpacerColor") + "  [" + this.plugin.getMessage("Menus.HighlightColor") + plugin.getConfig().getString("Recipes.Trashcan.Ingredients." + Count + ".Key") + this.plugin.getMessage("Menus.SpacerColor") + "] " + this.plugin.getMessage("Menus.LoreColor") + plugin.getConfig().getString("Recipes.Trashcan.Ingredients." + Count + ".Material")));
					    	Count++;
					    }
						return true;
					} else {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidRecipe")));
						return true;
					}
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidRecipe")));
					return true;
		        }
		   } else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidArgsMessage")));
				return true;
		   }
		}
		return false;
	}
	
	public boolean getFileExists(UUID uuid) {
		File playerFile = new File(this.plugin.getDataFolder() + File.separator + "PlayerData", uuid + ".yml");
	    FileConfiguration playerCFG = YamlConfiguration.loadConfiguration(playerFile);
	    if (!playerFile.exists()) {
	    	return false;
	    }
	    return true;
	  }
}
