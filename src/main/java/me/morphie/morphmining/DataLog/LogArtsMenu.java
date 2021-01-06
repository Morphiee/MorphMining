package me.morphie.morphmining.DataLog;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import me.morphie.morphmining.MorphMining;

public class LogArtsMenu implements Listener {
	
	private MorphMining plugin;
	  
	public LogArtsMenu(MorphMining plugin) {
		this.plugin = plugin;
	}
	
	public void openArtTierMenu(Player player, String tier) {
	    Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + tier + " Artifacts"));
	    
	    int Count = 0;
	    while (this.plugin.getConfig().getString("Artifacts." + tier + "." + Count) != null) {
	      Count++;
	    }
	    Count--;
	    
	    while (Count > -1) {
	    	Material material = Material.matchMaterial(this.plugin.getConfig().getString("Settings.ArtifactItem"));
	    	ItemStack item = new ItemStack(material);
	    	ItemMeta itemmeta = item.getItemMeta();
	    	itemmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts." + tier + "." + Count + ".Name")));
	    	ArrayList<String> itemLore = new ArrayList();
	    	
	    	if (tier.equals("Common")) {
			    itemLore.add(" ");
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts." + tier + "." + Count + ".Description")));
			    itemLore.add(" ");
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Tier " + this.plugin.getMessage("Menus.SpacerColor") + "� " + this.plugin.getMessage("Menus.LoreColor") + tier));
	    		itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Ores " + this.plugin.getMessage("Menus.SpacerColor") + "� " + this.plugin.getMessage("Menus.LoreColor") + "Coal"));
	    		itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
		    	itemmeta.setLore(itemLore);
		    	item.setItemMeta(itemmeta);
		    	itemLore.clear();
		    	inv.setItem(Count, item);
	    	} else if (tier.equals("Rare")) {
			    itemLore.add(" ");
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts." + tier + "." + Count + ".Description")));
			    itemLore.add(" ");
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Tier " + this.plugin.getMessage("Menus.SpacerColor") + "� " + this.plugin.getMessage("Menus.LoreColor") + tier));
	    		itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Ores " + this.plugin.getMessage("Menus.SpacerColor") + "� " + this.plugin.getMessage("Menus.LoreColor") + "Redstone"));
	    		itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
		    	itemmeta.setLore(itemLore);
		    	item.setItemMeta(itemmeta);
		    	itemLore.clear();
		    	inv.setItem(Count, item);
	    	} else if (tier.equals("Legendary")) {
			    itemLore.add(" ");
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts." + tier + "." + Count + ".Description")));
			    itemLore.add(" ");
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Tier " + this.plugin.getMessage("Menus.SpacerColor") + "� " + this.plugin.getMessage("Menus.LoreColor") + tier));
	    		itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Ores " + this.plugin.getMessage("Menus.SpacerColor") + "� " + this.plugin.getMessage("Menus.LoreColor") + "Lapis"));
	    		itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
		    	itemmeta.setLore(itemLore);
		    	item.setItemMeta(itemmeta);
		    	itemLore.clear();
		    	inv.setItem(Count, item);
	    	} else if (tier.equals("Mythic")) {
			    itemLore.add(" ");
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts." + tier + "." + Count + ".Description")));
			    itemLore.add(" ");
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			    itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Tier " + this.plugin.getMessage("Menus.SpacerColor") + "� " + this.plugin.getMessage("Menus.LoreColor") + tier));
	    		itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Ores " + this.plugin.getMessage("Menus.SpacerColor") + "� " + this.plugin.getMessage("Menus.LoreColor") + "Diamond, Emerald"));
	    		itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
		    	itemmeta.setLore(itemLore);
		    	item.setItemMeta(itemmeta);
		    	itemLore.clear();
		    	inv.setItem(Count, item);
	    	} else if (tier.equals("HellStone")) {
		    	Material material2 = Material.matchMaterial(this.plugin.getConfig().getString("Settings.HellstoneItem"));
		    	ItemStack item2 = new ItemStack(material2);
		    	ItemMeta item2meta = item2.getItemMeta();
		    	item2meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts." + tier + "." + Count + ".Name")));
		    	ArrayList<String> item2Lore = new ArrayList();
			    item2Lore.add(" ");
			    item2Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts." + tier + "." + Count + ".Description")));
			    item2Lore.add(" ");
			    item2Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			    item2Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Tier " + this.plugin.getMessage("Menus.SpacerColor") + "� " + this.plugin.getMessage("Menus.LoreColor") + tier));
	    		item2Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Ores " + this.plugin.getMessage("Menus.SpacerColor") + "� " + this.plugin.getMessage("Menus.LoreColor") + "Nether Quartz"));
	    		item2Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
			    item2Lore.add(" ");
	    		item2Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Only obtainable in the nether!"));
		    	item2meta.setLore(item2Lore);
		    	item2.setItemMeta(item2meta);
		    	item2Lore.clear();
		    	inv.setItem(Count, item2);
	    	}
	    	
	    	Count--;
	    }
	    
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("Settings.MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    inv.setItem(45, bGlass);
	    inv.setItem(53, bGlass);
	    
	    ItemStack bbbGlass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	    ItemMeta bbbGlassMeta = bbbGlass.getItemMeta();
	    ArrayList<String> bbbGlasslore = new ArrayList();
	    bbbGlasslore.add(" ");
	    bbbGlassMeta.setDisplayName(" ");
	    bbbGlass.setItemMeta(bbbGlassMeta);
	    inv.setItem(46, bbbGlass);
	    inv.setItem(47, bbbGlass);
	    inv.setItem(49, bbbGlass);
	    inv.setItem(51, bbbGlass);
	    inv.setItem(52, bbbGlass);
	    
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to go back!"));
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Back" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    Back.setItemMeta(BackMeta);
	    inv.setItem(48, Back);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "All artifacts of the"));
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + tier + "artifact tier!"));
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		Info.setItemMeta(InfoMeta);
		inv.setItem(50, Info);
	    
	    player.openInventory(inv);
	}
}