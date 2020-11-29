package me.morphie.MorphMining.Market;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import me.morphie.MorphMining.Main;

public class ArtifactShop implements Listener {
	
	private Main plugin;
	  
	public ArtifactShop(Main plugin) {
		this.plugin = plugin;
	}
	
	public void openGUIShop(Player player) {
		Inventory Shop = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "Artifact Shop"));
		
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Drop loot in then close!"));
		InfoMeta.setLore(Infolore);
		
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		Info.setItemMeta(InfoMeta);
		Shop.setItem(50, Info);
		
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to go back!"));
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Back" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    Back.setItemMeta(BackMeta);
	    Shop.setItem(48, Back);
	    
	    ItemStack Prices = new ItemStack(Material.MAP);
	    ItemMeta PricesMeta = Prices.getItemMeta();
	    ArrayList<String> Priceslore = new ArrayList();
	    Priceslore.add(" ");
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Common" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + this.plugin.getConfig().getDouble("ArtifactPrice.Common")));
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Rare" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + this.plugin.getConfig().getDouble("ArtifactPrice.Rare")));
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Legendary" +  this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + this.plugin.getConfig().getDouble("ArtifactPrice.Legendary")));
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Mythic" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + this.plugin.getConfig().getDouble("ArtifactPrice.Mythic")));
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "HellStone" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") +this.plugin.getConfig().getDouble("ArtifactPrice.HellStone")));
	    PricesMeta.setLore(Priceslore);
	    PricesMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Prices" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    Prices.setItemMeta(PricesMeta);
	    Shop.setItem(4, Prices);
	    
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("Settings.MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    Shop.setItem(0, bGlass);
	    Shop.setItem(8, bGlass);
	    Shop.setItem(45, bGlass);
	    Shop.setItem(53, bGlass);
	    
	    int x = 0;
	    while (x < 54)
	    {
	      if ((x != 48) && (x != 50) && ((x < 10) || (x >= 17)) && ((x < 19) || (x >= 26)) && ((x < 28) || (x >= 35)) && ((x < 37) || (x >= 44)) && (x != 4) && (x != 0) && (x != 8) && (x != 45) && (x != 53))
	      {
	        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta glassMeta = glass.getItemMeta();
	        
	        glassMeta.setDisplayName(" ");
	        glass.setItemMeta(glassMeta);
	        Shop.setItem(x, glass);
	      }
	      x++;
	    }
	    
	    player.openInventory(Shop);
	}
}
