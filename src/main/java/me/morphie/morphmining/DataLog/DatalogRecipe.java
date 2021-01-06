package me.morphie.morphmining.DataLog;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.morphmining.menus.MainMenu;
import net.md_5.bungee.api.ChatColor;
import me.morphie.morphmining.MorphMining;

public class DatalogRecipe implements Listener {

	private MorphMining plugin;
	  
	public DatalogRecipe(MorphMining plugin) {
		this.plugin = plugin;
	}

	public void openGUIDR(Player player) {
		Inventory DR = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "DataLog Recipe"));
		
		ItemStack DataLog = new ItemStack(Material.BOOK, 1);
		ItemMeta DataMeta = DataLog.getItemMeta();
		ArrayList<String> Datalore = new ArrayList();
		Datalore.add(" ");
		Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "The infinite wisdom of MorphMining"));
		Datalore.add(" ");
		Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Version" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + this.plugin.getVersion()));
		Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Author" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + "Morphie"));
		Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Right-Click to use."));
		Datalore.add(" ");
		Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
		DataMeta.setLore(Datalore);
		DataMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining DataLog"));
		DataLog.setItemMeta(DataMeta);
		DR.setItem(20, DataLog);
		
		ItemStack Leather = new ItemStack(Material.LEATHER);
		ItemMeta LeatherMeta = Leather.getItemMeta();
		LeatherMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Leather"));
		Leather.setItemMeta(LeatherMeta);
		DR.setItem(14, Leather);
		DR.setItem(15, Leather);
		DR.setItem(16, Leather);
		DR.setItem(23, Leather);
		DR.setItem(25, Leather);
		DR.setItem(32, Leather);
		DR.setItem(33, Leather);
		DR.setItem(34, Leather);
		
		ItemStack Book = new ItemStack(Material.BOOK);
		ItemMeta BookMeta = Leather.getItemMeta();
		BookMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Book"));
		Book.setItemMeta(BookMeta);
		DR.setItem(24, Book);
		
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to go back!"));
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Back" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    Back.setItemMeta(BackMeta);
	    DR.setItem(48, Back);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "The above is the recipe for"));
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "the Datalog. (Item on the left.)"));
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		Info.setItemMeta(InfoMeta);
		DR.setItem(50, Info);
		
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("Settings.MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    DR.setItem(10, bGlass);
	    DR.setItem(11, bGlass);
	    DR.setItem(12, bGlass);
	    DR.setItem(19, bGlass);
	    DR.setItem(21, bGlass);
	    DR.setItem(28, bGlass);
	    DR.setItem(29, bGlass);
	    DR.setItem(30, bGlass);
	    
	    int glass = 0;
	    while (glass < 54) {
	    	if ((glass != 10) && (glass != 11) && (glass != 12) && (glass != 14)  && (glass != 15) && (glass != 16) && (glass != 19) && (glass != 20) && (glass != 21) && (glass != 23) && (glass != 24) && (glass != 25) && (glass != 28) && (glass != 29) && (glass != 30) && (glass != 32) && (glass != 33) && (glass != 34) && (glass != 48) && (glass != 50)) {
	            ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	            ItemMeta GlassMeta = Glass.getItemMeta();
	            GlassMeta.setDisplayName(" ");
	            Glass.setItemMeta(GlassMeta);
	            DR.setItem(glass, Glass);
	    	}
	    	glass ++;
	    }
	    
	    player.openInventory(DR);
	}
}
