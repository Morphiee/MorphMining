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
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import me.morphie.MorphMining.Archivist.OreGrinderMenu;
import me.morphie.MorphMining.DataLog.LogBook;
import me.morphie.MorphMining.DataLog.LogMenu;
import me.morphie.MorphMining.Files.playerFileMethods;
import me.morphie.MorphMining.Items.Artifacts;
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
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "]--------+" + ChatColor.RESET + ChatColor.DARK_GRAY + "[ " + MainColor() + "Morph Mining" + ChatColor.DARK_GRAY + " ]" + ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "+--------["));
				sender.sendMessage("");
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "/mine menu" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the miners station."));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "/mine datalog" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the miners datalog."));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "/mine gems" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To view how many gems you have."));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "/mine og" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the ore grinder menu."));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "/mine shop" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the mining shop."));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "/mine stats <player>" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open your stats menu."));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "/mine withdraw <tier> <amount>" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To withdraw artifacts from your pouch."));
				if (sender.hasPermission("morphmining.admin") || sender.hasPermission("morphmining.reload")) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "/mine reload" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To reload the plugins config files! (Perms Required)"));
				}
				sender.sendMessage("");
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "]-------------+" + ChatColor.RESET + ChatColor.DARK_GRAY + "[" + MainColor() + "!" + ChatColor.DARK_GRAY + "]" + ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "+-------------["));
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
			else if (args[0].equalsIgnoreCase("gems")) {
				Player player = (Player)sender;
				UUID uuid = player.getUniqueId();
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " You currently have " + HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Stats.Gems") + TextColor() + " gems!"));
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
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " You have withdrawn " + HighlightColor() + "" + parseInt + TextColor() + " artifacts."));
									new playerFileMethods(this.plugin).setData(player, uuid, "Pouch.Common", -parseInt);
									return true;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " You don't have enough artifacts in your pouch!"));
									return true;
								}
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " You can only withdraw a positive number."));
								return true;
							}
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Correct Usage: " + TextColor() + "/mine withdraw <tier> <amount>"));
							return true;
						}
					} else if (args[1].equalsIgnoreCase("rare")) {
						if (!(args[2] == null)) {
							int parseInt = Integer.parseInt(args[2]);
							if (parseInt > 0) {
								if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare") >= parseInt) {					
									new Artifacts(this.plugin).getArts("RareArt", parseInt, player);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " You have withdrawn " + HighlightColor() + "" + parseInt + TextColor() + " artifacts."));
									new playerFileMethods(this.plugin).setData(player, uuid, "Pouch.Rare", -parseInt);
									return true;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " You don't have enough artifacts in your pouch!"));
									return true;
								}
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " You can only withdraw a positive number."));
								return true;
							}
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Correct Usage: " + TextColor() + "/mine withdraw <tier> <amount>"));
							return true;
						}
					} else if (args[1].equalsIgnoreCase("legendary")) {
						if (args[2] != null) {
							int parseInt = Integer.parseInt(args[2]);
							if (parseInt > 0) {
								if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary") >= parseInt) {					
									new Artifacts(this.plugin).getArts("LegendaryArt", parseInt, player);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " You have withdrawn " + HighlightColor() + "" + parseInt + TextColor() + " artifacts."));
									new playerFileMethods(this.plugin).setData(player, uuid, "Pouch.Legendary", -parseInt);
									return true;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " You don't have enough artifacts in your pouch!"));
									return true;
								}
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " You can only withdraw a positive number."));
								return true;
							}
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Correct Usage: " + TextColor() + "/mine withdraw <tier> <amount>"));
							return true;
						}
					} else if (args[1].equalsIgnoreCase("mythic")) {
						if (args[2] != null) {
							int parseInt = Integer.parseInt(args[2]);
							if (parseInt > 0) {
								if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic") >= parseInt && parseInt > 0) {					
									new Artifacts(this.plugin).getArts("MythicArt", parseInt, player);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " You have withdrawn " + HighlightColor() + "" + parseInt + TextColor() + " artifacts."));
									new playerFileMethods(this.plugin).setData(player, uuid, "Pouch.Mythic", -parseInt);
									return true;
								} else {
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " You don't have enough artifacts in your pouch!"));
									return true;
								}
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " You can only withdraw a positive number."));
								return true;
							}
						} else {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Correct Usage: " + TextColor() + "/mine withdraw <tier> <amount>"));
							return true;
						}
					} else {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Correct Usage: " + TextColor() + "/mine withdraw <tier> <amount>"));
						return true;
					}
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Correct Usage: " + TextColor() + "/mine withdraw <tier> <amount>"));
					return true;
				}
			}
			else if (args[0].equalsIgnoreCase("stats")) {
				if ((sender instanceof Player)) {
					Player player = (Player)sender;
					if (args.length == 2) {
						if (Bukkit.getServer().getPlayer(args[1]) != null) {
							UUID uuid = Bukkit.getServer().getPlayer(args[1]).getUniqueId();
							if (getFileExists(uuid)) {
								new MineStats(this.plugin).openGUIStats(player, uuid, args[1]);
								return true;
							} else {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " This player doesn't have any mining stats!"));
								return true;
							}
						} else {
							UUID uuid = Bukkit.getServer().getOfflinePlayer(args[1]).getUniqueId();
							if (getFileExists(uuid)) {
								new MineStats(this.plugin).openGUIStats(player, uuid, args[1]);
								return true;
							} else {
								sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " This player doesn't have any mining stats!"));
								return true;
							}
						}
					} else {
						new MineStats(this.plugin).openGUIStats(player, player.getUniqueId(), player.getName().toString());
						return true;
					}
				}
			}
			else if (args[0].equalsIgnoreCase("reload")) {
				if (sender.hasPermission("morphmining.admin") || sender.hasPermission("morphmining.reload")) {
					Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("MorphMining");
		            if (plugin != null) {
		            	this.plugin.reloadConfig();
		            	plugin.getServer().getPluginManager().disablePlugin(plugin);
		            	plugin.getServer().getPluginManager().enablePlugin(plugin);
		            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + ChatColor.GRAY + " Plugin has been successfully reloaded!"));
		            	return true;
		            }
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " You don't have permission to do this!"));
					return true;
		        }
		   } else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Invaild argument! Use /mine to view all commands."));
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
	
    public String Prefix() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.Prefix");
    }
    
    public String GUIColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.GUIColor");
    }
    
    public String ItemColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.ItemColor");
    }
    
    public String MainColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.MainColor");
    }
    
    public String TextColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.TextColor");
    }
    
    public String HighlightColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.HighlightColor");
    }
    
    public String ErrorPrefix() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.ErrorMessages.Prefix");
    }
}
