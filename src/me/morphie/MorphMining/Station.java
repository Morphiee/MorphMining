package me.morphie.MorphMining;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.morphie.MorphMining.Archivist.Archivist;
import me.morphie.MorphMining.DataLog.LogMenu;
import me.morphie.MorphMining.Market.Market;
import net.md_5.bungee.api.ChatColor;

public class Station implements Listener {

	private Main plugin;
	  
	public Station(Main plugin) {
		this.plugin = plugin;
	}
	
	public String Version = "1.3.1";

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Mining Station")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case END_CRYSTAL:
				player.closeInventory();
				new Archivist(this.plugin).openGUIArch(player);
				break;
			case ENDER_CHEST: 
				player.closeInventory();
				new Market(this.plugin).openGUIMarket(player);
				break;
			case BOOK:
				player.closeInventory();
				new LogMenu(this.plugin).openGUIMineLog(player);
				break;
			case PAPER:
				event.setCancelled(true);
				player.sendMessage(ChatColor.GRAY + "https://www.spigotmc.org/resources/morphmining.53827/");
				break;
			case PLAYER_HEAD:
				player.closeInventory();
				new MineStats(this.plugin).openGUIStats(player, player.getUniqueId(), player.getName().toString());
				break;
			case SPAWNER:
				event.setCancelled(true);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
				
			}
		}
	}
	
	public void openGUIMining(Player player) {
		Inventory Menu = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.GUIColor() + "Mining Station"));

		ItemStack credits = new ItemStack(Material.PAPER);
		ItemMeta creditsMeta = credits.getItemMeta();
		ArrayList<String> creditslore = new ArrayList();
		creditslore.add(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Version" + "&8: " + "&7" + this.Version));
		creditslore.add("");
	    creditslore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Code Contributors" + "&8:"));
	    creditslore.add(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + " Morphie");
	    creditslore.add(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + " PyroTempus");
		creditslore.add("");
	    creditslore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Click for Spigot link!"));
	    creditsMeta.setLore(creditslore);
	    
	    creditsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Credits"));
	    credits.setItemMeta(creditsMeta);
		
	    ItemStack arch = new ItemStack(Material.END_CRYSTAL);
	    ItemMeta archMeta = arch.getItemMeta();
	    ArrayList<String> archlore = new ArrayList();
	    archlore.add(ChatColor.GRAY + "Mining Master!");
	    archlore.add("");
	    archlore.add(ChatColor.GRAY + "The archivist manages");
	    archlore.add(ChatColor.GRAY + "a miner's utilities.");
	    archMeta.setLore(archlore);
	    
	    archMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "The Archivist"));
	    arch.setItemMeta(archMeta);
	    
	    ItemStack shop = new ItemStack(Material.ENDER_CHEST);
	    ItemMeta shopMeta = shop.getItemMeta();
	    ArrayList<String> shoplore = new ArrayList();
	    shoplore.add(ChatColor.GRAY + "Buy and sell all");
	    shoplore.add(ChatColor.GRAY + "your mining goods!");
	    shopMeta.setLore(shoplore);
	    
	    shopMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Miner's Market"));
	    shop.setItemMeta(shopMeta);
	    
	    ItemStack log = new ItemStack(Material.BOOK);
	    ItemMeta logMeta = log.getItemMeta();
	    ArrayList<String> loglore = new ArrayList();
	    loglore.add(ChatColor.GRAY + "What's an artifact?");
	    loglore.add("");
	    loglore.add(ChatColor.GRAY + "Information about artifacts,");
	    loglore.add(ChatColor.GRAY + "recipes, and more!");
	    logMeta.setLore(loglore);
	    
	    logMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() +"Miner's Log"));
	    log.setItemMeta(logMeta);
	    
	    ItemStack spawner = new ItemStack(Material.SPAWNER);
	    ItemMeta spawnerMeta = spawner.getItemMeta();
	    ArrayList<String> spawnerlore = new ArrayList();
	    spawnerlore.add(ChatColor.GRAY + "A unique twist on spawners!");
	    spawnerlore.add(" ");
	    spawnerlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "&oComing soon!"));
	    spawnerMeta .setLore(spawnerlore);
	    
	    spawnerMeta .setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Spawners"));
	    spawner.setItemMeta(spawnerMeta );
	    
	    ItemStack craft = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
	    SkullMeta craftMeta = (SkullMeta) craft.getItemMeta();
	    craftMeta.setOwner(player.getName());
	    ArrayList<String> craftlore = new ArrayList();
	    craftlore.add(ChatColor.GRAY + "Your MorphMining stats!");
	    craftMeta .setLore(craftlore);
	    
	    craftMeta .setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Stats"));
	    craft.setItemMeta(craftMeta );
	    
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    
	    ItemStack bbbGlass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	    ItemMeta bbbGlassMeta = bbbGlass.getItemMeta();
	    ArrayList<String> bbbGlasslore = new ArrayList();
	    bbbGlasslore.add(" ");
	    bbbGlassMeta.setDisplayName(" ");
	    bbbGlass.setItemMeta(bbbGlassMeta);
	    
	    int glass = 0;
	    while (glass < 54) {
	    	if ((glass != 0) && (glass != 1) && (glass != 2) && (glass != 3) && (glass != 5) && (glass != 6) && (glass != 7) && (glass != 8) && (glass != 9) && (glass != 10) && (glass != 13) && (glass != 16) && (glass != 17) && (glass != 18) && (glass != 20) && (glass != 21) && (glass != 23) && (glass != 24) && (glass != 26) && (glass != 27) && (glass != 30) && (glass != 32) && (glass != 35) && (glass != 37) && (glass != 40) && (glass != 43) && (glass != 48) && (glass != 49) && (glass != 50)) {
	            ItemStack Glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1, (short)7);
	            ItemMeta GlassMeta = Glass.getItemMeta();
	            GlassMeta.setDisplayName(" ");
	            Glass.setItemMeta(GlassMeta);
	            Menu.setItem(glass, Glass);
	    	}
	    	glass ++;
	    }
	    
	    Menu.setItem(0, bbbGlass);
	    Menu.setItem(1, bGlass);
	    Menu.setItem(2, bGlass);
	    Menu.setItem(3, bGlass);
	    Menu.setItem(5, bGlass);
	    Menu.setItem(6, bGlass);
	    Menu.setItem(7, bGlass);
	    Menu.setItem(8, bbbGlass);
	    Menu.setItem(9, bGlass);
	    Menu.setItem(10, bbbGlass);
	    Menu.setItem(16, bbbGlass);
	    Menu.setItem(17, bGlass);
	    Menu.setItem(18, bGlass);
	    Menu.setItem(20, bbbGlass);
	    Menu.setItem(24, bbbGlass);
	    Menu.setItem(26, bGlass);
	    Menu.setItem(27, bGlass);
	    Menu.setItem(30, bbbGlass);
	    Menu.setItem(32, bbbGlass);
	    Menu.setItem(35, bGlass);
	    Menu.setItem(40, bbbGlass);
	    Menu.setItem(48, bbbGlass);
	    Menu.setItem(50, bbbGlass);

	    
	    Menu.setItem(13, arch);
	    Menu.setItem(21, shop);
	    Menu.setItem(23, craft);
	    Menu.setItem(37, spawner);
	    Menu.setItem(43, log);
	    Menu.setItem(49, credits);
	    
	    player.openInventory(Menu);
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
