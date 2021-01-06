package me.morphie.morphmining.DataLog;

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

import me.morphie.morphmining.Items.CrafterItems;
import me.morphie.morphmining.MorphMining;

public class LogBook implements Listener {

	private MorphMining plugin;
	  
	public LogBook(MorphMining plugin) {
		this.plugin = plugin;
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
            if (ChatColor.stripColor(item2.getItemMeta().getDisplayName()).equals("MorphMining DataLog") && ChatColor.stripColor(item2.getItemMeta().getLore().get(8)).equals("MorphMining")) {
            	new LogMenu(this.plugin).openGUIMineLog(player);
            }
        }
    }
	
	@EventHandler
	public void onFirstJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (!player.hasPlayedBefore()) {
			if (plugin.getConfig().getBoolean("Settings.GiveBookOnFirstJoin") == true) {
				Inventory inv = player.getInventory();
				inv.addItem(new CrafterItems(this.plugin).recipeItems("datalog"));
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("DatalogOnJoinMessage")));		
			}
		}
	}
}
