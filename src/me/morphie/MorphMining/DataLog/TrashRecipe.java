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

public class TrashRecipe implements Listener {
	
	private Main plugin;
	  
	public TrashRecipe(Main plugin) {
		this.plugin = plugin;
	}

	public void openGUITR(Player player) {
		Inventory TR = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "Trashcan Recipe"));
		
		ItemStack item = new ItemStack(Material.CAULDRON, 1);
		ItemMeta im = item.getItemMeta();
		ArrayList<String> itemlore = new ArrayList();
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Dump all unwanted things here!"));
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Level" + this.plugin.getMessage("Menus.SpacerColor") + ": [" + this.plugin.getMessage("Menus.HighlightColor") + "●" + this.plugin.getMessage("Menus.LoreColor") + "●●" + this.plugin.getMessage("Menus.SpacerColor") + "]"));
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Nullifier" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.HighlightColor") + "Disabled"));
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Right-Click to use."));
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "TrashCan"));
		im.setLore(itemlore);
		item.setItemMeta(im);
		TR.setItem(20, item);
		
		ItemStack Iron = new ItemStack(Material.IRON_INGOT);
		ItemMeta IronMeta = Iron.getItemMeta();
		IronMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Iron Ingot"));
		Iron.setItemMeta(IronMeta);
		TR.setItem(14, Iron);
		TR.setItem(16, Iron);
		TR.setItem(23, Iron);
		TR.setItem(25, Iron);
		TR.setItem(32, Iron);
		TR.setItem(33, Iron);
		TR.setItem(34, Iron);
		
		ItemStack Caul = new ItemStack(Material.CAULDRON);
		ItemMeta CaulMeta = Caul.getItemMeta();
		CaulMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Cauldron"));
		Caul.setItemMeta(CaulMeta);
		TR.setItem(15, Caul);
		
		ItemStack Lava = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta LavaMeta = Lava.getItemMeta();
		LavaMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Lava Bucket"));
		Lava.setItemMeta(LavaMeta);
		TR.setItem(24, Lava);
		
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to go back!"));
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Back&" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    Back.setItemMeta(BackMeta);
	    TR.setItem(48, Back);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "The above is the recipe for"));
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "the Trashcan. (Item on the left.)"));
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		Info.setItemMeta(InfoMeta);
		TR.setItem(50, Info);
		
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("Settings.MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    TR.setItem(10, bGlass);
	    TR.setItem(11, bGlass);
	    TR.setItem(12, bGlass);
	    TR.setItem(19, bGlass);
	    TR.setItem(21, bGlass);
	    TR.setItem(28, bGlass);
	    TR.setItem(29, bGlass);
	    TR.setItem(30, bGlass);
	    
	    int glass = 0;
	    while (glass < 54) {
	    	if ((glass != 10) && (glass != 11) && (glass != 12) && (glass != 14)  && (glass != 15) && (glass != 16) && (glass != 19) && (glass != 20) && (glass != 21) && (glass != 23) && (glass != 24) && (glass != 25) && (glass != 28) && (glass != 29) && (glass != 30) && (glass != 32) && (glass != 33) && (glass != 34) && (glass != 48) && (glass != 50)) {
	            ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	            ItemMeta GlassMeta = Glass.getItemMeta();
	            GlassMeta.setDisplayName(" ");
	            Glass.setItemMeta(GlassMeta);
	            TR.setItem(glass, Glass);
	    	}
	    	glass ++;
	    }
	    
	    player.openInventory(TR);
	}
}
