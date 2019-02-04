package me.morphie.MorphMining.Mining;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import net.md_5.bungee.api.ChatColor;

public class SpawnerMining implements Listener {
	
	private Main plugin;
	  
	public SpawnerMining(Main plugin) {
		this.plugin = plugin;
	}
	
    private void dropSpawner(World world, Location loc, ItemStack item) {
	    world.dropItem(loc, item);
    }

//    Config Option:
//    # SilkSpawners disable them or change the percentage at which they drop. (Requires silk touch!)
//    SilkSpawners:
//      Enabled: false
//      Percentage: 100
// 
//    @EventHandler
//    public void onSpawnerClick(PlayerInteractEvent event) {
//        final Player player = event.getPlayer();
//        if (event.getAction() == null) {
//          return;
//        }
//        if (event.getItem() == null) {
//          return;
//        }
//        if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.SPAWNER)) && (event.getItem().hasItemMeta())) {
//        	ItemStack item = event.getItem();
//        	if(item.hasItemMeta()) {
//                ItemMeta itemMeta = item.getItemMeta();
//                if (itemMeta.getLore().contains(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "State &8» " + TextColor() + "&cDamaged"))) {
//                	event.setCancelled(true);
//                } else if (itemMeta.getLore().contains(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "State &8» " + TextColor() + "&aRepaired"))) {
//                	event.setCancelled(true);
//                }	
//            }
//        }
//    }
//	
//	@EventHandler
//	public void onSpawnerMine(BlockBreakEvent event) {
//		if (plugin.getConfig().getBoolean("SilkSpawners.Enabled") == true) {
//			Player p = event.getPlayer();
//			Block b = event.getBlock();
//			ItemStack i = p.getInventory().getItemInMainHand();
//			if (p.hasPermission("MorphMining.SilkSpawners")) {
//			    Random random = new Random();
//			    int chance = random.nextInt(100) + 1;
//			    int spawnerChance = plugin.getConfig().getInt("SilkSpawners.Percentage");
//			    if (chance <= spawnerChance) {
//					if (event.getBlock().getType() == Material.SPAWNER) {
//				        CreatureSpawner type = (CreatureSpawner) b.getState();
//				        EntityType mobtype = type.getSpawnedType();
//				        World world = b.getWorld();
//				        Location loc = b.getLocation();
//						if (i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLDEN_PICKAXE || i.getType() == Material.IRON_PICKAXE) {
//							if (i.containsEnchantment(Enchantment.SILK_TOUCH)) {
//								ItemStack spawner = new ItemStack(Material.SPAWNER);
//								ItemMeta spawnerMeta = spawner.getItemMeta();
//								ArrayList<String> spawnerLore = new ArrayList();
//								spawnerLore.add("");
//								spawnerLore.add(ChatColor.translateAlternateColorCodes('&', TextColor() + "Right-Click this spawner to open its menu."));
//								spawnerLore.add("");
//								spawnerLore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "State &8» " + TextColor() + "&cDamaged"));
//								spawnerLore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "Reinforced &8» " + TextColor() + "&cFalse"));
//								spawnerLore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "Type &8» &e" + mobtype.toString()));
//								spawnerLore.add("");
//								spawnerLore.add(ChatColor.translateAlternateColorCodes('&', MainColor() + "MorphMining"));
//								spawnerMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ItemColor() + "Mob Spawner"));
//								spawnerMeta.setLore(spawnerLore);
//								spawner.setItemMeta(spawnerMeta);
//								dropSpawner(world, loc, spawner);
//								p.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " You feel a touch of magic when you mine this!"));
//							}
//						}
//					}		
//			    }
//			}
//		}
//	}
//	
//    public String Prefix() {
//    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.Prefix");
//    }
//    
//    public String GUIColor() {
//    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.GUIColor");
//    }
//    
//    public String ItemColor() {
//    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.ItemColor");
//    }
//    
//    public String MainColor() {
//    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.MainColor");
//    }
//    
//    public String TextColor() {
//    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.TextColor");
//    }
//    
//    public String HighlightColor() {
//    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.HighlightColor");
//    }
//    
//    public String ErrorPrefix() {
//    	return this.plugin.messagescfg.messagesCFG.getString("Messages.ErrorMessages.Prefix");
//    }
}
