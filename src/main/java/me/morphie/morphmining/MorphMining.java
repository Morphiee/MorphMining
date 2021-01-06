package me.morphie.morphmining;

import jdk.nashorn.internal.objects.annotations.Getter;
import me.morphie.morphmining.menus.ArchivistMenu;
import me.morphie.morphmining.DataLog.LogBook;
import me.morphie.morphmining.DataLog.LogEvents;
import me.morphie.morphmining.DataLog.LogMenu;
import me.morphie.morphmining.Files.Messages;
import me.morphie.morphmining.Files.MetricsLite;
import me.morphie.morphmining.Items.CrafterItems;
import me.morphie.morphmining.Items.Pouch;
import me.morphie.morphmining.Items.PouchEvents;
import me.morphie.morphmining.Items.TrashCanEvent;
import me.morphie.morphmining.events.InventoryCloseEvent;
import me.morphie.morphmining.menus.MarketMenu;
import me.morphie.morphmining.Mining.NetherMining;
import me.morphie.morphmining.Mining.OverworldMining;
import me.morphie.morphmining.Mining.SpawnerMining;
import me.morphie.morphmining.events.InventoryClickEvent;
import me.morphie.morphmining.events.PlayerFileEvent;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class MorphMining extends JavaPlugin implements Listener {

	public static Logger log = Logger.getLogger("Minecraft");
	public static Economy econ = null;
	public Messages messagescfg;
	public String version = "1.7.0";

	private PlayerFileEvent pe;
	private InventoryClickEvent ie;
	private InventoryCloseEvent ce;
	
	private LogBook logbook;
	private LogEvents logevents;
	private LogMenu logmenu;
	private MarketMenu marketMenu;
	private OverworldMining mining;
	private NetherMining nethermining;
	private Pouch pouch;
	private PouchEvents pouchevents;
	private SpawnerMining spawnermining;
	private MineStats stats;
	private TrashCanEvent trashcan;

	public void onEnable() {
		this.pe = new PlayerFileEvent(this);
		this.ie = new InventoryClickEvent(this);
		this.ce = new InventoryCloseEvent(this);
		getServer().getPluginManager().registerEvents(this.pe, this);
		getServer().getPluginManager().registerEvents(this.ie, this);
		getServer().getPluginManager().registerEvents(this.ce, this);

		this.logbook = new LogBook(this);
		this.logevents = new LogEvents(this);
		this.logmenu = new LogMenu(this);
		this.marketMenu = new MarketMenu(this);
		this.mining = new OverworldMining(this);
		this.nethermining = new NetherMining(this);
		this.pouch = new Pouch(this);
		this.pouchevents = new PouchEvents(this);
		this.spawnermining = new SpawnerMining(this);
		this.stats = new MineStats(this);
		this.trashcan = new TrashCanEvent(this);
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new ArchivistMenu(), this);
		getServer().getPluginManager().registerEvents(this.logbook, this);
		getServer().getPluginManager().registerEvents(this.logevents, this);
		getServer().getPluginManager().registerEvents(this.logmenu, this);
		getServer().getPluginManager().registerEvents(this.marketMenu, this);
		getServer().getPluginManager().registerEvents(this.mining, this);
		getServer().getPluginManager().registerEvents(this.nethermining, this);
		getServer().getPluginManager().registerEvents(this.pouch, this);
		getServer().getPluginManager().registerEvents(this.pouchevents, this);
		getServer().getPluginManager().registerEvents(this.spawnermining, this);
		getServer().getPluginManager().registerEvents(this.stats, this);
		getServer().getPluginManager().registerEvents(this.trashcan, this);
		
		getCommand("mine").setExecutor(new Commands(this));
		
	    if (!setupEconomy()) {
	      getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", new Object[] { getDescription().getName() }));
	      getServer().getPluginManager().disablePlugin(this);
	      return;
	    }
	    
        new MetricsLite(this);
	    
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[----------[&3MorphMining&8]----------]"));
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bVersion&8: &a" + this.getVersion()));
		createConfig();
		loadConfigManager();
		recipeBackup();
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bRecipes&8: &aLoaded"));
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bPlugin Status&8: &aEnabled"));
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[----------[&3MorphMining&8]----------]"));
	}
	
	public void onDisable(){
		getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[----------[&3MorphMining&8]----------]"));
		getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bVersion&8: &a" + this.getVersion()));
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bRecipes&8: &cUnloaded"));
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bPlugin Status&8: &cDisabled"));
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[----------[&3MorphMining&8]----------]"));
	}
	
	private void createConfig() {
		try {
			if (!getDataFolder().exists()) {
				getDataFolder().mkdirs();
			}
			File file = new File(getDataFolder(), "config.yml");
			if (!file.exists()) {
				getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bConfig&8: &aGenerating config."));
				getConfig().options().copyDefaults(true);
				saveDefaultConfig();
			} else {
				getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bConfig&8: &aLoading config."));
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
    
    public void loadConfigManager() {
      this.messagescfg = new Messages();
      this.messagescfg.setup();
    }
	
	public int getArtifacts(String paramString) {
		int i = 0;
	    while (this.getConfig().getString("Artifacts." + paramString + "." + i + ".Name") != null) {
	    	i++;
	    }
	    i--;
	    
	    return i;
	}
	
	public void recipeBackup() {
        Iterator<Recipe> it = getServer().recipeIterator();

        try {
	        while (it.hasNext()) {
	            Recipe recipe = it.next();
	            if (recipe.getResult().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.getMessage("Menus.ItemColor") + "TrashCan"))) {
	            	it.remove();
	            } else if (recipe.getResult().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.getMessage("Menus.ItemColor") + "Miner's Pouch"))) {
	            	it.remove();
	            } else if (recipe.getResult().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.getMessage("Menus.ItemColor") + "MorphMining DataLog"))) {
	            	it.remove();
	            }
	        }	
        } catch (NullPointerException e1) {
        }

        this.loadRecipes();
	}
	
	public void loadRecipes() {
		if (this.getConfig().getBoolean("Recipes.Trashcan.Enabled") == true) {
			try {
				new CrafterItems(this).createRecipeTrashcan();
			} catch (IllegalStateException ie) {
			}
		}
		if (this.getConfig().getBoolean("Recipes.Pouch.Enabled") == true) {
			try {
				new CrafterItems(this).createRecipePouch();
			} catch (IllegalStateException ie) {
			}
		}
		if (this.getConfig().getBoolean("Recipes.Datalog.Enabled") == true) {
			try {
				new CrafterItems(this).createRecipeDatalog();
			} catch (IllegalStateException ie) {
			}
		}
	}
	
    public ItemStack createInventoryItem(String paramString1, int paramInt, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean, int durability) {
    	ItemStack localItemStack = new ItemStack(Material.matchMaterial(paramString1), paramInt);
    	localItemStack.setDurability((short) durability);
    	ItemMeta localItemMeta = localItemStack.getItemMeta();
    	if (paramBoolean) {
    		localItemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
    		localItemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    	}
    	localItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', paramString2));
    	localItemMeta.setLore(paramArrayList);
    	localItemStack.setItemMeta(localItemMeta);
    	return localItemStack;
    }
    
    public ItemStack createInventoryGlassItem(String paramString1, int glassInt, int paramInt, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean) {
    	ItemStack localItemStack = new ItemStack(Material.matchMaterial(paramString1), paramInt, (short) glassInt);
    	ItemMeta localItemMeta = localItemStack.getItemMeta();
    	if (paramBoolean) {
    		localItemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
    		localItemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    	}
    	localItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', paramString2));
    	localItemMeta.setLore(paramArrayList);
    	localItemStack.setItemMeta(localItemMeta);
    	return localItemStack;
    }

	public String getMessage(String string) {
		return this.messagescfg.messagesCFG.getString(string);
	}
	
	public List<String> getMessageList(String string) {
		return this.messagescfg.messagesCFG.getStringList(string);
	}

	@Getter
	public String getVersion() {
		return version;
	}
}
