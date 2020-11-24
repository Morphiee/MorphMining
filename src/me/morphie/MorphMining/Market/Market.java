package me.morphie.MorphMining.Market;

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

import me.morphie.MorphMining.Station;
import net.md_5.bungee.api.ChatColor;
import me.morphie.MorphMining.Main;

public class Market implements Listener {
	
	private Main plugin;
	  
	public Market(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Miner's Market")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case STRUCTURE_VOID:
				event.setCancelled(true);
				break;
			case BOOK:
				event.setCancelled(true);
				break;
			case EMERALD_BLOCK: 
				event.setCancelled(true);
				break;
			case LAPIS_BLOCK:
				event.setCancelled(true);
				break;
			case PRISMARINE_CRYSTALS:
				event.setCancelled(true);
				break;
			case CHEST:
	    		player.closeInventory();
	    		new ArtifactShop(this.plugin).openGUIShop(player);
	    		break;
			case REDSTONE:
	    		player.closeInventory();
	    		new Station(this.plugin).openGUIMining(player);
	    		break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
				
			}
		}
	}
	
	public void openGUIMarket(Player player) {
		Inventory Menu = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "Miner's Market"));
		
		ItemStack Coming = new ItemStack(Material.STRUCTURE_VOID);
		ItemMeta ComingMeta = Coming.getItemMeta();
		ComingMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "&oComing Soon!"));
		Coming.setItemMeta(ComingMeta);

		ItemStack Buy = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta BuyMeta = Buy.getItemMeta();
		BuyMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Buy"));
		Buy.setItemMeta(BuyMeta);
		
		ItemStack Sell = new ItemStack(Material.LAPIS_BLOCK);
		ItemMeta SellMeta = Sell.getItemMeta();
		SellMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Sell"));
		Sell.setItemMeta(SellMeta);
	    
	    ItemStack Gems = new ItemStack(Material.PRISMARINE_CRYSTALS);
	    ItemMeta GemsMeta = Gems.getItemMeta();
	    ArrayList<String> Gemslore = new ArrayList();
	    Gemslore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Spend your gems for mining goods!"));
	    Gemslore.add(" ");
	    Gemslore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "&oComing soon!"));
	    GemsMeta.setLore(Gemslore);
	    GemsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Gem Shop"));
	    Gems.setItemMeta(GemsMeta);
	    
	    ItemStack Art = new ItemStack(Material.CHEST);
	    ItemMeta ArtMeta = Art.getItemMeta();
	    ArrayList<String> Artlore = new ArrayList();
	    Artlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Sell your artifacts here!"));
	    ArtMeta.setLore(Artlore);
	    ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Artifact Shop"));
	    Art.setItemMeta(ArtMeta);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click on a shop to view more!"));
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		Info.setItemMeta(InfoMeta);
		
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to go back!"));
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Back" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    Back.setItemMeta(BackMeta);
	    
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("Settings.MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    
	    int glass = 0;
	    while (glass < 54) {
	    	if ((glass != 9) && (glass != 10) && (glass != 11) && (glass != 12) && (glass != 13) && (glass != 14)  && (glass != 15) && (glass != 16) && (glass != 17) && (glass != 18) && (glass != 20) && (glass != 26) && (glass != 27) && (glass != 28) && (glass != 29) && (glass != 30) && (glass != 31) && (glass != 32) && (glass != 33) && (glass != 34) && (glass != 35) && (glass != 48) && (glass != 50)) {
	            ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	            ItemMeta GlassMeta = Glass.getItemMeta();
	            GlassMeta.setDisplayName(" ");
	            Glass.setItemMeta(GlassMeta);
	            Menu.setItem(glass, Glass);
	    	}
	    	glass ++;
	    }
	    
	    Menu.setItem(9, bGlass);
	    Menu.setItem(10, Buy);
	    Menu.setItem(11, bGlass);
	    Menu.setItem(12, Gems);
	    Menu.setItem(13, Coming);
	    Menu.setItem(14, Coming);
	    Menu.setItem(15, Coming);
	    Menu.setItem(16, Coming);
	    Menu.setItem(17, bGlass);
	    Menu.setItem(18, bGlass);
	    Menu.setItem(20, bGlass);
	    Menu.setItem(26, bGlass);
	    Menu.setItem(27, bGlass);
	    Menu.setItem(28, Sell);
	    Menu.setItem(29, bGlass);
	    Menu.setItem(30, Art);
	    Menu.setItem(31, Coming);
	    Menu.setItem(32, Coming);
	    Menu.setItem(33, Coming);
	    Menu.setItem(34, Coming);
	    Menu.setItem(35, bGlass);
	    Menu.setItem(48, Back);
	    Menu.setItem(50, Info);
	    
	    player.openInventory(Menu);
	}
}
