package me.morphie.MorphMining;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import java.io.File;
import java.util.logging.Logger;

import me.morphie.MorphMining.Archivist.Archivist;
import me.morphie.MorphMining.Crates.CrateEvents;
import me.morphie.MorphMining.Crates.CrateRewards;
import me.morphie.MorphMining.Crates.CratesMenu;
import me.morphie.MorphMining.MineLog.LogEvents;
import me.morphie.MorphMining.MineLog.LogMenu;
import me.morphie.MorphMining.Mining.NetherMining;
import me.morphie.MorphMining.Mining.OverworldMining;
import me.morphie.MorphMining.Shop.Shop;
import me.morphie.MorphMining.Shop.ShopEvents;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin implements Listener {

	public static Logger log = Logger.getLogger("Minecraft");
	public static Economy econ = null;
	public static Permission perms = null;
	public static GriefPrevention griefpreventionPlugin = null;
	public static WorldGuardPlugin worldguardPlugin = null;
	private Archivist arch;
	private CratesMenu crates;
	private CrateEvents crateevents;
	private CrateRewards craterewards;
	private Dev dev;
	private LogEvents logevents;
	private LogMenu logmenu;
	private OverworldMining mining;
	private NetherMining nethermining;
	private Shop shop;
	private ShopEvents shopevents;
	private Station station;
	private VersionChecker vc;

	public void onEnable() {
		setupPluginDependencies();
		this.arch = new Archivist(this);
		this.crates = new CratesMenu(this);
		this.crateevents = new CrateEvents(this);
		this.craterewards = new CrateRewards(this);
		this.dev = new Dev(this);
		this.logevents = new LogEvents(this);
		this.logmenu = new LogMenu(this);
		this.mining = new OverworldMining(this);
		this.nethermining = new NetherMining(this);
		this.shop = new Shop(this);
		this.shopevents = new ShopEvents(this);
		this.station = new Station(this);
		this.vc = new VersionChecker(this);
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "MorphMining" + ChatColor.DARK_GRAY + " >> " + ChatColor.GREEN + "Plugin Enabled");
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(this.arch, this);
		getServer().getPluginManager().registerEvents(this.crates, this);
		getServer().getPluginManager().registerEvents(this.craterewards, this);
		getServer().getPluginManager().registerEvents(this.crateevents, this);
		getServer().getPluginManager().registerEvents(this.logevents, this);
		getServer().getPluginManager().registerEvents(this.logmenu, this);
		getServer().getPluginManager().registerEvents(this.dev, this);
		getServer().getPluginManager().registerEvents(this.mining, this);
		getServer().getPluginManager().registerEvents(this.nethermining, this);
		getServer().getPluginManager().registerEvents(this.shopevents, this);
		getServer().getPluginManager().registerEvents(this.station, this);
		getServer().getPluginManager().registerEvents(this.vc, this);
		
		createConfig();
		
	    if (!setupEconomy())
	    {
	      getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", new Object[] { getDescription().getName() }));
	      getServer().getPluginManager().disablePlugin(this);
	      return;
	    }
	    setupPermissions();
	}
	
	public void onDisable(){
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "MorphMining" + ChatColor.DARK_GRAY + " >> " + ChatColor.RED + "Plugin Disabled");
	}
	
	private void createConfig() {
		try {
			if (!getDataFolder().exists()) {
				getDataFolder().mkdirs();
			}
			File file = new File(getDataFolder(), "config.yml");
			if (!file.exists()) {
				getLogger().info("Config.yml not found, creating!");
				getConfig().options().copyDefaults(true);
				saveDefaultConfig();
		  }
			else {
				getLogger().info("Config.yml found, loading!");
			}
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
	    }
	    RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
	    if (rsp == null) {
	      return false;
	    }
	    econ = (Economy)rsp.getProvider();
	    return econ != null;
	  }
	
    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
    
    private void setupPluginDependencies() {
        try {
            setupWorldGuard();
        } catch (Exception e) {
            log.warning("[MorphMining] Failed to load WorldGuard");
            e.printStackTrace();
        }
        try {
            setupGriefPrevention();
        } catch (Exception e) {
            log.warning("[MorphMining] Failed to load GriefPrevention");
            e.printStackTrace();
        }
    }
    
    private void setupGriefPrevention() {
        Plugin gp = this.getServer().getPluginManager().getPlugin("GriefPrevention");
        if (gp == null) {
            log.info("[MorphMining] Couldn't hook into GriefPrevention, not depending!");
        } else {
            Main.griefpreventionPlugin = (GriefPrevention)gp;
            log.info("[MorphMining] Hooked into GriefPrevention!");         
        }
    }
    
    private void setupWorldGuard() {
        Plugin wg = this.getServer().getPluginManager().getPlugin("WorldGuard");
        if (wg == null) {
            log.info("[MorphMining] Couldn't hook into WorldGuard, not depending!");
        } else {
            Main.worldguardPlugin = (WorldGuardPlugin)wg;
            log.info("[MorphMining] Hooked into WorldGuard!");         
        }
    }
    
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("mine")) {
			if (args.length == 0) {
				sender.sendMessage("");
				sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "]--------+" + ChatColor.RESET + ChatColor.DARK_GRAY + "[ " + ChatColor.DARK_RED + ChatColor.ITALIC + "Morph Mining" + ChatColor.DARK_GRAY + " ]" + ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "+--------[");
				sender.sendMessage("");
				sender.sendMessage(ChatColor.RED + "/mine" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open this menu.");
				sender.sendMessage(ChatColor.RED + "/mine menu" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the miners station.");
				sender.sendMessage(ChatColor.RED + "/mine shop" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the mining shop.");
				sender.sendMessage(ChatColor.RED + "/mine log" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the miners log.");
				if (perms.has(sender, "morphmining.admin")) {
					sender.sendMessage(ChatColor.RED + "/mine dev" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the admin menu! (Perms Required)");
					sender.sendMessage(ChatColor.RED + "/mine reload" + ChatColor.DARK_GRAY + " - " + ChatColor.GRAY + "To open the admin menu! (Perms Required)");
				}
				sender.sendMessage("");
				sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "]-------------+" + ChatColor.RESET + ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "!" + ChatColor.DARK_GRAY + "]" + ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "+-------------[");
				sender.sendMessage("");
				return true;
			
			}
			if (args[0].equalsIgnoreCase("menu")) {
				Player player = (Player)sender;
				this.station.openGUIMining(player);
				return true;
			}
			else if (args[0].equalsIgnoreCase("log")) {
				Player player = (Player)sender;
				this.logmenu.openGUIMineLog(player);
				return true;
			}
			else if (args[0].equalsIgnoreCase("shop")) {
				Player player = (Player)sender;
				this.shop.openGUIShop(player);
				return true;
			}
			else if (args[0].equalsIgnoreCase("crates")) {
				Player player = (Player)sender;
				this.crates.openGUICrate(player);
				return true;
			}
			else if (args[0].equalsIgnoreCase("dev")) {
				Player player = (Player)sender;
				if (perms.has(player, "morphmining.dev") || (perms.has(player, "morphmining.admin"))) {
					this.dev.openGUIDev(player);
					return true;
				}
				else {
					player.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.RED + ChatColor.BOLD + "!" + ChatColor.DARK_GRAY + ChatColor.BOLD + "]" + ChatColor.RED + ChatColor.ITALIC + " You don't have permission to access this!");
					return true;
				}
			}
			else if (args[0].equalsIgnoreCase("reload")) {
				if (perms.has(sender, "morphmining.reload") || (perms.has(sender, "morphmining.admin"))){
		          Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("MorphMining");
		          if (plugin != null)
		          {
		            reloadConfig();
		            sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "MorphMining has been successfully reloaded!");
		            return true;
		          }
		        }
		        else
		        {
		          sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.RED + ChatColor.BOLD + "!" + ChatColor.DARK_GRAY + ChatColor.BOLD + "]" + ChatColor.RED + ChatColor.ITALIC + " You don't have permission to do this!");
		          return true;
		        }
		      }
			else {
				sender.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.RED + ChatColor.BOLD + "!" + ChatColor.DARK_GRAY + ChatColor.BOLD + "]" + ChatColor.RED + " Invaild argument! Use /mine to view all commands.");
				return true;
			}
		}
		return false;
	}
}
