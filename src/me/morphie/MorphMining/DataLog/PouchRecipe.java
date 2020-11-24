package me.morphie.MorphMining.DataLog;

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

public class PouchRecipe implements Listener {
	
	private Main plugin;
	  
	public PouchRecipe(Main plugin) {
		this.plugin = plugin;
	}

	public void openGUIPR(Player player) {
		Inventory PR = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "Pouch Recipe"));
		
		ItemStack item = new ItemStack(Material.FLOWER_POT, 1);
		ItemMeta im = item.getItemMeta();
		ArrayList<String> itemlore = new ArrayList();
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Automatically stores your artifacts!"));
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Right-Click to use."));
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Miner's Pouch"));
		im.setLore(itemlore);
		item.setItemMeta(im);
		PR.setItem(20, item);
		
		ItemStack Leather = new ItemStack(Material.LEATHER);
		ItemMeta LeatherMeta = Leather.getItemMeta();
		LeatherMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Leather"));
		Leather.setItemMeta(LeatherMeta);
		PR.setItem(14, Leather);
		PR.setItem(16, Leather);
		PR.setItem(23, Leather);
		PR.setItem(25, Leather);
		PR.setItem(32, Leather);
		PR.setItem(33, Leather);
		PR.setItem(34, Leather);
		
		ItemStack Eye = new ItemStack(Material.ENDER_EYE);
		ItemMeta EyeMeta = Eye.getItemMeta();
		EyeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Eye of Ender"));
		Eye.setItemMeta(EyeMeta);
		PR.setItem(15, Eye);
		
		ItemStack Ender = new ItemStack(Material.ENDER_CHEST);
		ItemMeta EnderMeta = Ender.getItemMeta();
		EnderMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Ender Chest"));
		Ender.setItemMeta(EnderMeta);
		PR.setItem(24, Ender);
		
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to go back!"));
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Back" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    Back.setItemMeta(BackMeta);
	    PR.setItem(48, Back);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "The above is the recipe for"));
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "the Pouch. (Item on the left.)"));
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		Info.setItemMeta(InfoMeta);
		PR.setItem(50, Info);
		
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("Settings.MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    PR.setItem(10, bGlass);
	    PR.setItem(11, bGlass);
	    PR.setItem(12, bGlass);
	    PR.setItem(19, bGlass);
	    PR.setItem(21, bGlass);
	    PR.setItem(28, bGlass);
	    PR.setItem(29, bGlass);
	    PR.setItem(30, bGlass);
	    
	    int glass = 0;
	    while (glass < 54) {
	    	if ((glass != 10) && (glass != 11) && (glass != 12) && (glass != 14)  && (glass != 15) && (glass != 16) && (glass != 19) && (glass != 20) && (glass != 21) && (glass != 23) && (glass != 24) && (glass != 25) && (glass != 28) && (glass != 29) && (glass != 30) && (glass != 32) && (glass != 33) && (glass != 34) && (glass != 48) && (glass != 50)) {
	            ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	            ItemMeta GlassMeta = Glass.getItemMeta();
	            GlassMeta.setDisplayName(" ");
	            Glass.setItemMeta(GlassMeta);
	            PR.setItem(glass, Glass);
	    	}
	    	glass ++;
	    }
	    
	    player.openInventory(PR);
	}
}
