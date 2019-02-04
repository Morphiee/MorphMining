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
import net.md_5.bungee.api.ChatColor;

public class PouchRecipe implements Listener {
	
	private Main plugin;
	  
	public PouchRecipe(Main plugin) {
		this.plugin = plugin;
	}

	public void openGUIPR(Player player) {
		Inventory PR = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.GUIColor() + "Pouch Recipe"));
		
		ItemStack item = new ItemStack(Material.FLOWER_POT, 1);
		ItemMeta im = item.getItemMeta();
		ArrayList<String> itemlore = new ArrayList();
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + TextColor() + "Automatically stores your artifacts!"));
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Right-Click to use."));
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"));
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', ItemColor() + "Miner's Pouch"));
		im.setLore(itemlore);
		item.setItemMeta(im);
		PR.setItem(20, item);
		
		ItemStack Leather = new ItemStack(Material.LEATHER);
		ItemMeta LeatherMeta = Leather.getItemMeta();
		LeatherMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', MainColor() + "Leather"));
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
		EyeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', MainColor() + "Eye of Ender"));
		Eye.setItemMeta(EyeMeta);
		PR.setItem(15, Eye);
		
		ItemStack Ender = new ItemStack(Material.ENDER_CHEST);
		ItemMeta EnderMeta = Ender.getItemMeta();
		EnderMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', MainColor() + "Ender Chest"));
		Ender.setItemMeta(EnderMeta);
		PR.setItem(24, Ender);
		
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Back&8:"));
	    Back.setItemMeta(BackMeta);
	    PR.setItem(48, Back);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.GRAY + "The above is the recipe for");
		Infolore.add(ChatColor.GRAY + "the Pouch. (Item on the left.)");
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Information" + "&8:"));
		Info.setItemMeta(InfoMeta);
		PR.setItem(50, Info);
		
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("MainGlassColor"));
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
