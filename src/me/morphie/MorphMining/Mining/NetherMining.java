package me.morphie.MorphMining.Mining;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.morphie.MorphMining.Main;

public class NetherMining implements Listener {
	
	private Main plugin;
	  
	public NetherMining(Main plugin) {
		this.plugin = plugin;
	}

    private void dropArt(World world, Location loc, ItemStack artifact) {
	    loc.setY(loc.getY());
	    world.dropItem(loc, artifact);
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		World w = p.getWorld();
		Block b = event.getBlock();
		ItemStack i = event.getPlayer().getItemInHand();
		
		if (w.getWorldType().getName() != "NETHER") {
			if (!i.containsEnchantment(Enchantment.SILK_TOUCH)) {
				if(i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLD_PICKAXE || i.getType() == Material.IRON_PICKAXE || i.getType() == Material.STONE_PICKAXE || i.getType() == Material.WOOD_PICKAXE) {
					if (b.getType().equals(Material.QUARTZ_ORE)) {
							
					}
				}
			}
		}
	}
}
