package me.morphie.MorphMining.Items;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import me.morphie.MorphMining.DataLog.LogArtsMenu;
import me.morphie.MorphMining.DataLog.LogMenu;

public class TrashCan implements Listener {
	
	private Main plugin;
	  
	public TrashCan(Main plugin) {
		this.plugin = plugin;
	}
	
    @EventHandler
    public void TrashCanUse(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getAction() == null) {
          return;
        }
        if (event.getItem() == null) {
          return;
        }
        if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.CAULDRON)) && (event.getItem().hasItemMeta())) {
            ItemStack item2 = event.getItem();
            if (ChatColor.stripColor(item2.getItemMeta().getDisplayName()).equals("TrashCan") && ChatColor.stripColor(item2.getItemMeta().getLore().get(8)).equals("MorphMining")) {
    	        event.setCancelled(true);
    	        Inventory inv = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "TrashCan"));
    	        
    	        ItemStack item = new ItemStack(Material.BOOK);
    	        ItemMeta itemMeta = item.getItemMeta();
    	        ArrayList<String> itemLore = new ArrayList();
    	        itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Drop items in then close!"));
    	        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") +":"));
    	        itemMeta.setLore(itemLore);
    	        item.setItemMeta(itemMeta);
    	        inv.setItem(30, item);
    	        
    	        ItemStack item3 = new ItemStack(Material.FURNACE);
    	        ItemMeta item3Meta = item3.getItemMeta();
    	        ArrayList<String> item3Lore = new ArrayList();
    	        item3Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Set an item to be"));
    	        item3Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "automatically trashed on pick up."));
    	        item3Lore.add(" ");
    	        item3Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "&oComing soon!"));
    	        item3Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Nullification" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
    	        item3Meta.setLore(item3Lore);
    	        item3.setItemMeta(item3Meta);
    	        inv.setItem(32, item3);
    	        
    		    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("Settings.MainGlassColor"));
    		    ItemMeta bGlassMeta = bGlass.getItemMeta();
    		    ArrayList<String> bGlasslore = new ArrayList();
    		    bGlasslore.add(" ");
    		    bGlassMeta.setDisplayName(" ");
    		    bGlass.setItemMeta(bGlassMeta);
    		    inv.setItem(27, bGlass);
    		    inv.setItem(31, bGlass);
    		    inv.setItem(35, bGlass);
    		    
    	        ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
    	        ItemMeta GlassMeta = Glass.getItemMeta();
    	        GlassMeta.setDisplayName(" ");
    	        Glass.setItemMeta(GlassMeta);
    	        inv.setItem(28, Glass);
    	        inv.setItem(29, Glass);
    	        inv.setItem(33, Glass);
    	        inv.setItem(34, Glass);
    		    
    	        player.openInventory(inv);
            }
        }
    }
    
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Trashcan")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case BOOK:
				if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					event.setCancelled(true);
					break;
				}
			case FURNACE:
				if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Nullification" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					event.setCancelled(true);
					break;
				}
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
	}
}
