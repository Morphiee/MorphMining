package me.morphie.MorphMining.DataLog;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import net.md_5.bungee.api.ChatColor;

public class DatalogRecipe implements Listener {

	private Main plugin;
	  
	public DatalogRecipe(Main plugin) {
		this.plugin = plugin;
	}

	public void openGUIDR(Player player) {
		Inventory DR = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.GUIColor() + "DataLog Recipe"));
		
		ItemStack DataLog = new ItemStack(Material.BOOK, 1);
		ItemMeta DataMeta = DataLog.getItemMeta();
		ArrayList<String> Datalore = new ArrayList();
		Datalore.add(" ");
		Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + TextColor() + "The infinite wisdom of MorphMining"));
		Datalore.add(" ");
		Datalore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
		Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "➛ " + this.TextColor() + "Version&8: " + TextColor() + new Station(plugin).Version));
		Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "➛ " + this.TextColor() + "Author&8:" + TextColor() + " Morphie"));
		Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "➛ " + this.TextColor() + "Right-Click to use."));
		Datalore.add(" ");
		Datalore.add(ChatColor.translateAlternateColorCodes('&', MainColor() + "MorphMining"));
		DataMeta.setLore(Datalore);
		DataMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ItemColor() + "MorphMining DataLog"));
		DataLog.setItemMeta(DataMeta);
		DR.setItem(20, DataLog);
		
		ItemStack Leather = new ItemStack(Material.LEATHER);
		ItemMeta LeatherMeta = Leather.getItemMeta();
		LeatherMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', MainColor() + "Leather"));
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
		BookMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', MainColor() + "Book"));
		Book.setItemMeta(BookMeta);
		DR.setItem(24, Book);
		
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Back&8:"));
	    Back.setItemMeta(BackMeta);
	    DR.setItem(48, Back);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.GRAY + "The above is the recipe for");
		Infolore.add(ChatColor.GRAY + "the Datalog. (Item on the left.)");
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Information" + "&8:"));
		Info.setItemMeta(InfoMeta);
		DR.setItem(50, Info);
		
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("MainGlassColor"));
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
