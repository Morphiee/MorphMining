package me.morphie.MorphMining;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.morphie.MorphMining.Files.playerFileMethods;
import net.md_5.bungee.api.ChatColor;
import me.morphie.MorphMining.Main;

public class MineStats implements Listener {

	private Main plugin;
	  
	public MineStats(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
		if (ChatColor.stripColor(event.getView().getTitle()).contains("Mine Stats: ")) {
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case GOLD_NUGGET:
				event.setCancelled(true);
				break;
			case BRICK:
				event.setCancelled(true);
				break;
			case IRON_INGOT:
				event.setCancelled(true);
				break;
			case GOLD_INGOT:
				event.setCancelled(true);
				break;
			case DIAMOND:
				event.setCancelled(true);
				break;
			case NETHER_BRICK:
				event.setCancelled(true);
				break;
			case EMERALD:
				event.setCancelled(true);
				break;
			case STONE:
				event.setCancelled(true);
				break;
			case COAL_ORE:
				event.setCancelled(true);
				break;
			case REDSTONE_ORE:
				event.setCancelled(true);
				break;
			case IRON_ORE:
				event.setCancelled(true);
				break;
			case GOLD_ORE:
				event.setCancelled(true);
				break;
			case LAPIS_ORE:
				event.setCancelled(true);
				break;
			case DIAMOND_ORE:
				event.setCancelled(true);
				break;
			case EMERALD_ORE:
				event.setCancelled(true);
				break;
			case NETHER_QUARTZ_ORE:
				event.setCancelled(true);
				break;
			case PRISMARINE_CRYSTALS:
				event.setCancelled(true);
				break;
			case STRUCTURE_VOID:
				event.setCancelled(true);
				break;
			case BOOK:
				event.setCancelled(true);
				break;
			case REDSTONE:
				player.closeInventory();
				new Station(this.plugin).openGUIMining(player);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
				
			}
		}
	}
	
	public void openGUIStats(Player player, UUID uuid, String string) {
		Inventory Stats = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "Mine Stats: " + string));
		
		ItemStack Coming = new ItemStack(Material.STRUCTURE_VOID);
		ItemMeta ComingMeta = Coming.getItemMeta();
		ComingMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Coming Soon!"));
		Coming.setItemMeta(ComingMeta);
		Stats.setItem(31, Coming);
		Stats.setItem(32, Coming);
		Stats.setItem(33, Coming);
		Stats.setItem(34, Coming);
		Stats.setItem(37, Coming);
		Stats.setItem(38, Coming);
		Stats.setItem(39, Coming);
		Stats.setItem(40, Coming);
		Stats.setItem(41, Coming);
		Stats.setItem(42, Coming);
		Stats.setItem(43, Coming);
		
		ItemStack ArtAll = new ItemStack(Material.GOLD_NUGGET);
  	  	ItemMeta ArtAllMeta = ArtAll.getItemMeta();
	    ArrayList<String> ArtAlllore = new ArrayList();
	    ArtAlllore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.ArtifactsMinedAll")));
	    ArtAllMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Artifacts Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    ArtAllMeta.setLore(ArtAlllore);
	    ArtAll.setItemMeta(ArtAllMeta);
	    Stats.setItem(10, ArtAll);
		    
		ItemStack ArtCom = new ItemStack(Material.BRICK);
  	  	ItemMeta ArtComMeta = ArtAll.getItemMeta();
	    ArrayList<String> ArtComlore = new ArrayList();
	    ArtComlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.ArtifactsMinedCommon")));
	    ArtComMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Common Artifacts Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    ArtComMeta.setLore(ArtComlore);
	    ArtCom.setItemMeta(ArtComMeta);
	    Stats.setItem(11, ArtCom);
		    
		ItemStack ArtRare = new ItemStack(Material.IRON_INGOT);
  	  	ItemMeta ArtRareMeta = ArtRare.getItemMeta();
	    ArrayList<String> ArtRarelore = new ArrayList();
	    ArtRarelore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.ArtifactsMinedRare")));
	    ArtRareMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Rare Artifacts Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    ArtRareMeta.setLore(ArtRarelore);
	    ArtRare.setItemMeta(ArtRareMeta);
	    Stats.setItem(12, ArtRare);
		    
		ItemStack ArtLeg = new ItemStack(Material.GOLD_INGOT);
  	  	ItemMeta ArtLegMeta = ArtLeg.getItemMeta();
	    ArrayList<String> ArtLeglore = new ArrayList();
	    ArtLeglore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.ArtifactsMinedLegendary")));
	    ArtLegMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Legendary Artifacts Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    ArtLegMeta.setLore(ArtLeglore);
	    ArtLeg.setItemMeta(ArtLegMeta);
	    Stats.setItem(13, ArtLeg);
		    
		ItemStack ArtMyt = new ItemStack(Material.DIAMOND);
  	  	ItemMeta ArtMytMeta = ArtMyt.getItemMeta();
	    ArrayList<String> ArtMytlore = new ArrayList();
	    ArtMytlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.ArtifactsMinedMythic")));
	    ArtMytMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Mythic Artifacts Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    ArtMytMeta.setLore(ArtMytlore);
	    ArtMyt.setItemMeta(ArtMytMeta);
	    Stats.setItem(14, ArtMyt);
	    
		ItemStack ArtHel = new ItemStack(Material.NETHER_BRICK);
  	  	ItemMeta ArtHelMeta = ArtHel.getItemMeta();
	    ArrayList<String> ArtHellore = new ArrayList();
	    ArtHellore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.ArtifactsMinedHellstone")));
	    ArtHelMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Hellstone Artifacts Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    ArtHelMeta.setLore(ArtHellore);
	    ArtHel.setItemMeta(ArtHelMeta);
	    Stats.setItem(15, ArtHel);
	    
		ItemStack ArtMon = new ItemStack(Material.EMERALD);
  	  	ItemMeta ArtMonMeta = ArtMon.getItemMeta();
	    ArrayList<String> ArtMonlore = new ArrayList();
	    ArtMonlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "$" + new playerFileMethods(this.plugin).getStat(uuid, "Stats.MoneyEarned")));
	    ArtMonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Money Earned" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    ArtMonMeta.setLore(ArtMonlore);
	    ArtMon.setItemMeta(ArtMonMeta);
	    Stats.setItem(16, ArtMon);
	    
		ItemStack Stone = new ItemStack(Material.STONE);
  	  	ItemMeta StoneMeta = Stone.getItemMeta();
	    ArrayList<String> Stonelore = new ArrayList();
	    Stonelore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.StoneMined")));
	    StoneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Stone Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    StoneMeta.setLore(Stonelore);
	    Stone.setItemMeta(StoneMeta);
	    Stats.setItem(19, Stone);
	    
		ItemStack Coal = new ItemStack(Material.COAL_ORE);
  	  	ItemMeta CoalMeta = Coal.getItemMeta();
	    ArrayList<String> Coallore = new ArrayList();
	    Coallore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.CoalOreMined")));
	    CoalMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Coal Ore Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    CoalMeta.setLore(Coallore);
	    Coal.setItemMeta(CoalMeta);
	    Stats.setItem(20, Coal);
		
		ItemStack Redstone = new ItemStack(Material.REDSTONE_ORE);
  	  	ItemMeta RedstoneMeta = Redstone.getItemMeta();
	    ArrayList<String> Redstonelore = new ArrayList();
	    Redstonelore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.RedstoneOreMined")));
	    RedstoneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Redstone Ore Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    RedstoneMeta.setLore(Redstonelore);
	    Redstone.setItemMeta(RedstoneMeta);
	    Stats.setItem(21, Redstone);
	    
		ItemStack Iron = new ItemStack(Material.IRON_ORE);
  	  	ItemMeta IronMeta = Iron.getItemMeta();
	    ArrayList<String> Ironlore = new ArrayList();
	    Ironlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.IronOreMined")));
	    IronMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Iron Ore Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    IronMeta.setLore(Ironlore);
	    Iron.setItemMeta(IronMeta);
	    Stats.setItem(22, Iron);
	    
		ItemStack Gold = new ItemStack(Material.GOLD_ORE);
  	  	ItemMeta GoldMeta = Gold.getItemMeta();
	    ArrayList<String> Goldlore = new ArrayList();
	    Goldlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.GoldOreMined")));
	    GoldMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Gold Ore Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    GoldMeta.setLore(Goldlore);
	    Gold.setItemMeta(GoldMeta);
	    Stats.setItem(23, Gold);
	    
		ItemStack Lapis = new ItemStack(Material.LAPIS_ORE);
  	  	ItemMeta LapisMeta = Lapis.getItemMeta();
	    ArrayList<String> Lapislore = new ArrayList();
	    Lapislore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.LapisOreMined")));
	    LapisMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Lapis Ore Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    LapisMeta.setLore(Lapislore);
	    Lapis.setItemMeta(LapisMeta);
	    Stats.setItem(24, Lapis);
	    
		ItemStack Diamond = new ItemStack(Material.DIAMOND_ORE);
  	  	ItemMeta DiamondMeta = Diamond.getItemMeta();
	    ArrayList<String> Diamondlore = new ArrayList();
	    Diamondlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.DiamondOreMined")));
	    DiamondMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Diamond Ore Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    DiamondMeta.setLore(Diamondlore);
	    Diamond.setItemMeta(DiamondMeta);
	    Stats.setItem(25, Diamond);
	    
		ItemStack Emerald = new ItemStack(Material.EMERALD_ORE);
  	  	ItemMeta EmeraldMeta = Emerald.getItemMeta();
	    ArrayList<String> Emeraldlore = new ArrayList();
	    Emeraldlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.EmeraldOreMined")));
	    EmeraldMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Emerald Ore Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    EmeraldMeta.setLore(Emeraldlore);
	    Emerald.setItemMeta(EmeraldMeta);
	    Stats.setItem(28, Emerald);
	    
		ItemStack Quartz = new ItemStack(Material.NETHER_QUARTZ_ORE);
  	  	ItemMeta QuartzMeta = Quartz.getItemMeta();
	    ArrayList<String> Quartzlore = new ArrayList();
	    Quartzlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.QuartzOreMined")));
	    QuartzMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Quartz Ore Mined" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    QuartzMeta.setLore(Quartzlore);
	    Quartz.setItemMeta(QuartzMeta);
	    Stats.setItem(29, Quartz);
	    
		ItemStack Gem = new ItemStack(Material.PRISMARINE_CRYSTALS);
  	  	ItemMeta GemMeta = Gem.getItemMeta();
	    ArrayList<String> Gemlore = new ArrayList();
	    Gemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + new playerFileMethods(this.plugin).getStat(uuid, "Stats.Gems")));
	    GemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Gems" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    GemMeta.setLore(Gemlore);
	    Gem.setItemMeta(GemMeta);
	    Stats.setItem(30, Gem);
	    
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to go back!"));
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Back" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    Back.setItemMeta(BackMeta);
	    Stats.setItem(48, Back);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Hover to view stats!"));
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		Info.setItemMeta(InfoMeta);
		Stats.setItem(50, Info);
		    
	    ItemStack redGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("Settings.MainGlassColor"));
	    ItemMeta redGlassMeta = redGlass.getItemMeta();
	    ArrayList<String> redGlasslore = new ArrayList();
	    redGlasslore.add(" ");
	    redGlassMeta.setDisplayName(" ");
	    redGlass.setItemMeta(redGlassMeta);
	    Stats.setItem(0, redGlass);
	    Stats.setItem(8, redGlass);
	    Stats.setItem(45, redGlass);
	    Stats.setItem(53, redGlass);
	    
	    int x = 0;
	    while (x < 53) {
	      if ((x != 0) && (x != 8) && (x != 45) && (x != 48) && (x != 50) && ((x < 10) || (x >= 17)) && ((x < 19) || (x >= 26)) && ((x < 28) || (x >= 35)) && ((x < 37) || (x >= 44)))
	      {
	        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta glassMeta = glass.getItemMeta();
	        
	        glassMeta.setDisplayName(" ");
	        glass.setItemMeta(glassMeta);
	        Stats.setItem(x, glass);
	      }
	      x++;
	    }
	    
	    player.openInventory(Stats);
	}
}
