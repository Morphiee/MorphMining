package me.morphie.MorphMining.Mining;

import java.util.Random;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.morphie.MorphMining.Files.playerFileMethods;
import me.morphie.MorphMining.Items.Artifacts;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import me.morphie.MorphMining.Main;

public class NetherMining implements Listener {
	
	private Main plugin;
	  
	public NetherMining(Main plugin) {
		this.plugin = plugin;
	}
	
	public void ActionBar (String message, Player player ) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', message)).create());
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		UUID uuid = p.getUniqueId();
		World w = p.getWorld();
		Block b = event.getBlock();
		ItemStack i = event.getPlayer().getItemInHand();
		Random random = new Random();
		
		if (p.getWorld().getEnvironment().equals(World.Environment.NETHER)) {
			if (!i.containsEnchantment(Enchantment.SILK_TOUCH)) {
				if(i.getType().toString().toLowerCase().contains("pickaxe")) {
					if (b.getType().equals(Material.NETHER_QUARTZ_ORE)) {
						int chance = random.nextInt(100);
						int hellstoneChance = plugin.getConfig().getInt("Settings.ArtifactChances.HellStone");
						if (chance <= hellstoneChance) {
							new Artifacts(this.plugin).getArts("HellStone", 1, p);
							new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
							new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedHellstone", 1);
							ActionBar(this.plugin.getMessage("ArtifactActionMessage").replace("ARTIFACT", "Hellstone!"), p);
						}	
					}
				}
			}
		}
	}
}
