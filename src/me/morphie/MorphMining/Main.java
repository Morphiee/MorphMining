package me.morphie.MorphMining;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.morphie.MorphMining.Archivist.Archivist;
import me.morphie.MorphMining.Archivist.OreGrinderEvents;
import me.morphie.MorphMining.DataLog.LogBook;
import me.morphie.MorphMining.DataLog.LogEvents;
import me.morphie.MorphMining.DataLog.LogMenu;
import me.morphie.MorphMining.Files.Messages;
import me.morphie.MorphMining.Files.MetricsLite;
import me.morphie.MorphMining.Items.CrafterItems;
import me.morphie.MorphMining.Items.Pouch;
import me.morphie.MorphMining.Items.PouchEvents;
import me.morphie.MorphMining.Items.TrashCanEvent;
import me.morphie.MorphMining.Market.Market;
import me.morphie.MorphMining.Market.ArtifactShopEvents;
import me.morphie.MorphMining.Mining.NetherMining;
import me.morphie.MorphMining.Mining.OverworldMining;
import me.morphie.MorphMining.Mining.SpawnerMining;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin implements Listener {

	public static Logger log = Logger.getLogger("Minecraft");
	public static Economy econ = null;
	public Messages messagescfg;
	
	private LogBook logbook;
	private LogEvents logevents;
	private LogMenu logmenu;
	private Market market;
	private OverworldMining mining;
	private NetherMining nethermining;
	private OreGrinderEvents oregrinder;
	private Pouch pouch;
	private PouchEvents pouchevents;
	private ArtifactShopEvents shopevents;
	private SpawnerMining spawnermining;
	private Station station;
	private MineStats stats;
	private TrashCanEvent trashcan;

	public void onEnable() {
		this.logbook = new LogBook(this);
		this.logevents = new LogEvents(this);
		this.logmenu = new LogMenu(this);
		this.market = new Market(this);
		this.mining = new OverworldMining(this);
		this.nethermining = new NetherMining(this);
		this.oregrinder = new OreGrinderEvents(this);
		this.pouch = new Pouch(this);
		this.pouchevents = new PouchEvents(this);
		this.shopevents = new ArtifactShopEvents(this);
		this.spawnermining = new SpawnerMining(this);
		this.station = new Station(this);
		this.stats = new MineStats(this);
		this.trashcan = new TrashCanEvent(this);
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new Archivist(), this);
		getServer().getPluginManager().registerEvents(this.logbook, this);
		getServer().getPluginManager().registerEvents(this.logevents, this);
		getServer().getPluginManager().registerEvents(this.logmenu, this);
		getServer().getPluginManager().registerEvents(this.market, this);
		getServer().getPluginManager().registerEvents(this.mining, this);
		getServer().getPluginManager().registerEvents(this.nethermining, this);
		getServer().getPluginManager().registerEvents(this.oregrinder, this);
		getServer().getPluginManager().registerEvents(this.pouch, this);
		getServer().getPluginManager().registerEvents(this.pouchevents, this);
		getServer().getPluginManager().registerEvents(this.shopevents, this);
		getServer().getPluginManager().registerEvents(this.spawnermining, this);
		getServer().getPluginManager().registerEvents(this.station, this);
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
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bVersion&8: &a" + new Station(this).Version));
		createConfig();
		loadConfigManager();
		recipeBackup();
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bRecipes&8: &aLoaded"));
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bPlugin Status&8: &aEnabled"));
	    getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[----------[&3MorphMining&8]----------]"));
	}
	
	public void onDisable(){
		getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[----------[&3MorphMining&8]----------]"));
		getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&bVersion&8: &a" + new Station(this).Version));
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
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		UUID uuid = player.getUniqueId();
		
		new BukkitRunnable() {
			public void run() {
				File file = Main.this.getData(uuid);
		        FileConfiguration pd = YamlConfiguration.loadConfiguration(file);
		        if (!pd.contains("Stats.Gems")) {
		        	pd.set("Stats.Gems", Integer.valueOf(0));
		        	pd.set("Stats.ArtifactsMinedAll", Integer.valueOf(0));
		        	pd.set("Stats.ArtifactsMinedCommon", Integer.valueOf(0));
		        	pd.set("Stats.ArtifactsMinedRare", Integer.valueOf(0));
		        	pd.set("Stats.ArtifactsMinedLegendary", Integer.valueOf(0));
		        	pd.set("Stats.ArtifactsMinedMythic", Integer.valueOf(0));
		        	pd.set("Stats.ArtifactsMinedHellstone", Integer.valueOf(0));
		        	pd.set("Stats.StoneMined", Integer.valueOf(0));
		        	pd.set("Stats.CoalOreMined", Integer.valueOf(0));
		        	pd.set("Stats.RedstoneOreMined", Integer.valueOf(0));
		        	pd.set("Stats.IronOreMined", Integer.valueOf(0));
		        	pd.set("Stats.GoldOreMined", Integer.valueOf(0));
		        	pd.set("Stats.LapisOreMined", Integer.valueOf(0));
		        	pd.set("Stats.DiamondOreMined", Integer.valueOf(0));
		        	pd.set("Stats.EmeraldOreMined", Integer.valueOf(0));
		        	pd.set("Stats.QuartzOreMined", Integer.valueOf(0));
		        	pd.set("Stats.MoneyEarned", Integer.valueOf(0));
		        	pd.set("Pouch.Enabled", Boolean.valueOf(false));
		        	pd.set("Pouch.CommonUpgrade", Boolean.valueOf(false));
		        	pd.set("Pouch.RareUpgrade", Boolean.valueOf(false));
		        	pd.set("Pouch.LegendaryUpgrade", Boolean.valueOf(false));
		        	pd.set("Pouch.MythicUpgrade", Boolean.valueOf(false));
		        	pd.set("Pouch.Common", Integer.valueOf(0));
		        	pd.set("Pouch.Rare", Integer.valueOf(0));
		        	pd.set("Pouch.Legendary", Integer.valueOf(0));
		        	pd.set("Pouch.Mythic", Integer.valueOf(0));
		            try {
		              pd.save(file);
		            }
		            catch (IOException e) {
		              Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not save " + uuid + "'s player file!");
		              e.printStackTrace();
		            }
		        }
			}
		}.runTaskLater(this, 60L);		
	}
	
	public File getData(UUID uuid) {
		File data = new File(getDataFolder() + File.separator + "PlayerData", uuid + ".yml");
	    FileConfiguration dataFile = YamlConfiguration.loadConfiguration(data);
	    if (!data.exists()) {
	    	try {
	    		dataFile.save(data);
	    	}	
	    	catch (IOException e1) {
	    		e1.printStackTrace();
	    	}
	    }
		return data;  
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
	
}
