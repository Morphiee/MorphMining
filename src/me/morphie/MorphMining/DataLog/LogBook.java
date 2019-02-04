package me.morphie.MorphMining.DataLog;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import me.morphie.MorphMining.Market.ArtifactShop;

public class LogBook implements Listener {

	private Main plugin;
	  
	public LogBook(Main plugin) {
		this.plugin = plugin;
	}
	
	public ItemStack giveDataLog() {
		ItemStack DataLog = new ItemStack(Material.BOOK);
		ItemMeta DataMeta = DataLog.getItemMeta();
		ArrayList<String> Datalore = new ArrayList();
		Datalore.add(" ");
		Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "➛ &7&oThe infinite wisdom of MorphMining"));
		Datalore.add(" ");
		Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "Version &8» &7" + new Station(plugin).Version));
		Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "Author &8» &7Morphie"));
		Datalore.add(" ");
		Datalore.add(ChatColor.translateAlternateColorCodes('&', MainColor() + "Right-Click to open the datalog!"));
		DataMeta.setLore(Datalore);
		DataMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ItemColor() + "MorphMining DataLog"));
		DataLog.setItemMeta(DataMeta);
		return DataLog;
	}
	
    @EventHandler
    public void onArtClick(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getAction() == null) {
          return;
        }
        if (event.getItem() == null) {
          return;
        }
        if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.BOOK))) {
            ItemStack item2 = event.getItem();
            if (item2.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', ItemColor() + "MorphMining DataLog"))) {
            	new LogMenu(this.plugin).openGUIMineLog(player);
            }
        }
    }
	
	@EventHandler
	public void onFirstJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPlayedBefore()) {
			if (plugin.getConfig().getBoolean("GiveBookOnFirstJoin") == true) {
				Inventory inv = player.getInventory();
				inv.addItem(giveDataLog());
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " You recieved a datalog! Right-Click to use."));		
			}
		}
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
