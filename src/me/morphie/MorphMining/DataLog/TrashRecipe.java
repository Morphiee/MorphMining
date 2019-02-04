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
		Inventory TR = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.GUIColor() + "Trashcan Recipe"));
		
		ItemStack item = new ItemStack(Material.CAULDRON, 1);
		ItemMeta im = item.getItemMeta();
		ArrayList<String> itemlore = new ArrayList();
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + TextColor() + "Dump all unwanted things here!"));
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Level&8: [" + this.HighlightColor() + "●" + this.TextColor() + "●●&8]"));
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Nullifier&8: " + this.HighlightColor() + "Disabled"));
		itemlore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "➛ " + this.TextColor() + "Right-Click to use."));
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"));
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "TrashCan"));
		im.setLore(itemlore);
		item.setItemMeta(im);
		TR.setItem(20, item);
		
		ItemStack Iron = new ItemStack(Material.IRON_INGOT);
		ItemMeta IronMeta = Iron.getItemMeta();
		IronMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', MainColor() + "Iron Ingot"));
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
		CaulMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', MainColor() + "Cauldron"));
		Caul.setItemMeta(CaulMeta);
		TR.setItem(15, Caul);
		
		ItemStack Lava = new ItemStack(Material.LAVA_BUCKET);
		ItemMeta LavaMeta = Lava.getItemMeta();
		LavaMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', MainColor() + "Lava Bucket"));
		Lava.setItemMeta(LavaMeta);
		TR.setItem(24, Lava);
		
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Back&8:"));
	    Back.setItemMeta(BackMeta);
	    TR.setItem(48, Back);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.GRAY + "The above is the recipe for");
		Infolore.add(ChatColor.GRAY + "the Trashcan. (Item on the left.)");
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Information" + "&8:"));
		Info.setItemMeta(InfoMeta);
		TR.setItem(50, Info);
		
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("MainGlassColor"));
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
