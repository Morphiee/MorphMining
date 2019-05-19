package me.morphie.MorphMining.Archivist;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;


public class Archivist implements Listener {
	
	private Main plugin = Main.getPlugin(Main.class);
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Archivist")) {
		      Player player = (Player)event.getWhoClicked();
		      event.setCancelled(true);
		      if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
		    	  return;
		      }
		      switch (event.getCurrentItem().getType()) {
		      case END_CRYSTAL:
		    	  event.setCancelled(true);
		    	  break;
		      case STRUCTURE_VOID:
		    	  event.setCancelled(true);
		    	  break;
		      case ENDER_EYE:
		    	  event.setCancelled(true);
		    	  break;
		      case REDSTONE_BLOCK:
		    	  event.setCancelled(true);
		    	  break;
		      case DIAMOND_BLOCK:
		    	  event.setCancelled(true);
		    	  break;
		      case BONE:
		    	  event.setCancelled(true);
		    	  break;
		      case ANVIL:
		    	  event.setCancelled(true);
		    	  break;
		      case DIAMOND_ORE:
		    	  player.closeInventory();
		    	  new OreGrinderMenu(this.plugin).openGUIOG(player);
		    	  break;
		      case BOOK:
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
	
	public void openGUIArch(Player player) {
		Inventory Arch = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "Archivist"));
		
		ItemStack Coming = new ItemStack(Material.STRUCTURE_VOID);
		ItemMeta ComingMeta = Coming.getItemMeta();
		ComingMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Coming Soon!"));
		Coming.setItemMeta(ComingMeta);

		ItemStack Buy = new ItemStack(Material.ENDER_EYE);
		ItemMeta BuyMeta = Buy.getItemMeta();
		BuyMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Analyzers"));
		Buy.setItemMeta(BuyMeta);
		
		ItemStack Sell = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta SellMeta = Sell.getItemMeta();
		SellMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Planned Updates"));
		Sell.setItemMeta(SellMeta);
		
		ItemStack Ore = new ItemStack(Material.DIAMOND_ORE);
		ItemMeta OreMeta = Ore.getItemMeta();
		ArrayList<String> Orelore = new ArrayList();
		Orelore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Grind your ores for a"));
		Orelore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "chance to get gems!"));
		OreMeta.setLore(Orelore);
		OreMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Ore Grinder"));
		Ore.setItemMeta(OreMeta);
	    
	    ItemStack Art = new ItemStack(Material.END_CRYSTAL);
	    ItemMeta ArtMeta = Art.getItemMeta();
	    ArrayList<String> Artlore = new ArrayList();
	    Artlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "&oComing soon!"));
	    ArtMeta.setLore(Artlore);
	    ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Relic Analyzer"));
	    Art.setItemMeta(ArtMeta);
	    
	    ItemStack Fos = new ItemStack(Material.BONE);
	    ItemMeta FosMeta = Fos.getItemMeta();
	    ArrayList<String> Foslore = new ArrayList();
	    Foslore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "&oComing soon!"));
	    FosMeta.setLore(Foslore);
	    FosMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Fossil Analyzer"));
	    Fos.setItemMeta(FosMeta);
	    
	    ItemStack Forge = new ItemStack(Material.ANVIL);
	    ItemMeta ForgeMeta = Forge.getItemMeta();
	    ArrayList<String> Forgelore = new ArrayList();
	    Forgelore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "&oComing soon!"));
	    ForgeMeta.setLore(Forgelore);
	    ForgeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Miner's Forge"));
	    Forge.setItemMeta(ForgeMeta);
	    
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
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Back" + this.plugin.getMessage("Menus.SpacerColor") + "&8:"));
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
	            Arch.setItem(glass, Glass);
	    	}
	    	glass ++;
	    }
	    
	    Arch.setItem(9, bGlass);
	    Arch.setItem(10, Buy);
	    Arch.setItem(11, bGlass);
	    Arch.setItem(12, Ore);
	    Arch.setItem(13, Coming);
	    Arch.setItem(14, Coming);
	    Arch.setItem(15, Coming);
	    Arch.setItem(16, Coming);
	    Arch.setItem(17, bGlass);
	    Arch.setItem(18, bGlass);
	    Arch.setItem(20, bGlass);
	    Arch.setItem(26, bGlass);
	    Arch.setItem(27, bGlass);
	    Arch.setItem(28, Sell);
	    Arch.setItem(29, bGlass);
	    Arch.setItem(30, Art);
	    Arch.setItem(31, Fos);
	    Arch.setItem(32, Forge);
	    Arch.setItem(33, Coming);
	    Arch.setItem(34, Coming);
	    Arch.setItem(35, bGlass);
	    Arch.setItem(48, Back);
	    Arch.setItem(50, Info);
	    player.openInventory(Arch);
	}
}
