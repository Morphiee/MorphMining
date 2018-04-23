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

import me.morphie.MorphMining.Archivist.Archivist;
import me.morphie.MorphMining.MineLog.LogMenu;
import me.morphie.MorphMining.Shop.Shop;
import net.md_5.bungee.api.ChatColor;

public class Station implements Listener {

	private Main plugin;
	  
	public Station(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Mining Station")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case HOPPER:
				player.closeInventory();
				new Archivist(this.plugin).openGUIArch(player);
				break;
			case BEACON: 
				player.closeInventory();
				new Shop(this.plugin).openGUIShop(player);
				break;
			case BOOK_AND_QUILL:
				player.closeInventory();
				new LogMenu(this.plugin).openGUIMineLog(player);
				break;
			case PAPER:
				event.setCancelled(true);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
				
			}
		}
	}
	 
	public void openGUIMining(Player player) {
		Inventory Menu = Bukkit.createInventory(null, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining Station");

		ItemStack credits = new ItemStack(Material.PAPER);
		ItemMeta creditsMeta = credits.getItemMeta();
		ArrayList<String> creditslore = new ArrayList();
		creditslore.add(ChatColor.DARK_RED + "Version" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + new VersionChecker(this.plugin).Version);
		creditslore.add("");
	    creditslore.add(ChatColor.RED + "Code Contributors" + ChatColor.DARK_GRAY + ":");
	    creditslore.add(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + " Morphie");
	    creditslore.add(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + " Atasu");
		creditslore.add("");
	    creditslore.add(ChatColor.RED + "Bug Testers" + ChatColor.DARK_GRAY + ":");
	    creditslore.add(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + " NotoriousRogue");
	    creditslore.add(ChatColor.DARK_GRAY + "-" + ChatColor.GRAY + " xoStace");
	    creditsMeta.setLore(creditslore);
	    
	    creditsMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Credits");
	    credits.setItemMeta(creditsMeta);
	    
	    ItemStack arch = new ItemStack(Material.HOPPER);
	    ItemMeta archMeta = arch.getItemMeta();
	    ArrayList<String> archlore = new ArrayList();
	    archlore.add("");
	    archlore.add(ChatColor.GRAY + "Mining Master!");
	    archlore.add("");
	    archlore.add(ChatColor.GRAY + "The archivist analyzes");
	    archlore.add(ChatColor.GRAY + "crates and relics!");
	    archMeta.setLore(archlore);
	    
	    archMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "The Archivist");
	    arch.setItemMeta(archMeta);
	    
	    ItemStack shop = new ItemStack(Material.BEACON);
	    ItemMeta shopMeta = shop.getItemMeta();
	    ArrayList<String> shoplore = new ArrayList();
	    shoplore.add("");
	    shoplore.add(ChatColor.GRAY + "Buy and sell all");
	    shoplore.add(ChatColor.GRAY + "your mining goods!");
	    shopMeta.setLore(shoplore);
	    
	    shopMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Miner's Shop");
	    shop.setItemMeta(shopMeta);
	    
	    ItemStack log = new ItemStack(Material.BOOK_AND_QUILL);
	    ItemMeta logMeta = log.getItemMeta();
	    ArrayList<String> loglore = new ArrayList();
	    loglore.add("");
	    loglore.add(ChatColor.GRAY + "What's an artifact?");
	    loglore.add("");
	    loglore.add(ChatColor.GRAY + "Information about artifacts,");
	    loglore.add(ChatColor.GRAY + "relics, and more!");
	    logMeta.setLore(loglore);
	    
	    logMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Miner's Log");
	    log.setItemMeta(logMeta);
	    
	    ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
	    ItemMeta redGlassMeta = redGlass.getItemMeta();
	    ArrayList<String> redGlasslore = new ArrayList();
	    redGlasslore.add(" ");
	    
	    redGlassMeta.setDisplayName(" ");
	    redGlass.setItemMeta(redGlassMeta);
	    
	    int glass = 0;
	    while (glass < 54) {
	    	if ((glass != 3) && (glass != 4) && (glass != 5) && (glass != 12) && (glass != 14) && (glass != 18)  && (glass != 19) && (glass != 20) && (glass != 21) && (glass != 22) && (glass != 23) && (glass != 24) && (glass != 25) && (glass != 26) && (glass != 13) && (glass != 27) && (glass != 28) && (glass != 29) && (glass != 33) && (glass != 34) && (glass != 35) && (glass != 36) && (glass != 37) && (glass != 38) && (glass != 40) && (glass != 42) && (glass != 43) && (glass != 44)) {
	            ItemStack Glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	            ItemMeta GlassMeta = Glass.getItemMeta();
	            GlassMeta.setDisplayName(" ");
	            Glass.setItemMeta(GlassMeta);
	            Menu.setItem(glass, Glass);
	    	}
	    	glass ++;
	    }
	    
	    Menu.setItem(3, redGlass);
	    Menu.setItem(4, redGlass);
	    Menu.setItem(5, redGlass);
	    Menu.setItem(12, redGlass);
	    Menu.setItem(14, redGlass);
	    Menu.setItem(18, redGlass);
	    Menu.setItem(19, redGlass);
	    Menu.setItem(20, redGlass);
	    Menu.setItem(21, redGlass);
	    Menu.setItem(22, redGlass);
	    Menu.setItem(23, redGlass);
	    Menu.setItem(24, redGlass);
	    Menu.setItem(25, redGlass);
	    Menu.setItem(26, redGlass);
	    Menu.setItem(27, redGlass);
	    Menu.setItem(29, redGlass);
	    Menu.setItem(33, redGlass);
	    Menu.setItem(35, redGlass);
	    Menu.setItem(36, redGlass);
	    Menu.setItem(37, redGlass);
	    Menu.setItem(38, redGlass);
	    Menu.setItem(42, redGlass);
	    Menu.setItem(43, redGlass);
	    Menu.setItem(44, redGlass);
	    
	    Menu.setItem(13, arch);
	    Menu.setItem(28, shop);
	    Menu.setItem(34, log);
	    Menu.setItem(40, credits);
	    
	    player.openInventory(Menu);
	}
}
