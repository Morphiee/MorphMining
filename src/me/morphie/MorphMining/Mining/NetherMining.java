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

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Files.playerFileMethods;
import me.morphie.MorphMining.Items.Artifacts;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;

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
				if(i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLDEN_PICKAXE || i.getType() == Material.IRON_PICKAXE || i.getType() == Material.STONE_PICKAXE || i.getType() == Material.WOODEN_PICKAXE) {
					if (b.getType().equals(Material.NETHER_QUARTZ_ORE)) {
						int rand = random.nextInt(100);		      
						if (rand > 93) {
							new Artifacts(this.plugin).getArts("HellStone", 1, p);
							new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
							new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedHellstone", 1);
							ActionBar(HighlightColor() + "+1 " + MainColor() + "HellStone!", p);
						}	
					}
				}
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
