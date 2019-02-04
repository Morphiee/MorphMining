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

public class LogMenu implements Listener {
	
	private Main plugin;
	  
	public LogMenu(Main plugin) {
		this.plugin = plugin;
	}

	public void openGUIMineLog(Player player) {
		Inventory MineLog = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.GUIColor() + "DataLog"));
		
		ItemStack Coming = new ItemStack(Material.STRUCTURE_VOID);
		ItemMeta ComingMeta = Coming.getItemMeta();
		ComingMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Coming Soon!"));
		Coming.setItemMeta(ComingMeta);
		MineLog.setItem(33, Coming);
		MineLog.setItem(34, Coming);
		
		ItemStack Art = new ItemStack(Material.GOLD_NUGGET);
  	  	ItemMeta ArtMeta = Art.getItemMeta();
	    ArrayList<String> Artlore = new ArrayList();
		Artlore.add(ChatColor.GRAY + "Click to view all artifacts");
		Artlore.add(ChatColor.GRAY + "in the given tier.");
		ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Artifact Types"));
		ArtMeta.setLore(Artlore);
	    Art.setItemMeta(ArtMeta);
	    MineLog.setItem(10, Art);
	    
		ItemStack Common = new ItemStack(Material.BRICK);
  	  	ItemMeta CommonMeta = Common.getItemMeta();
	    ArrayList<String> Commonlore = new ArrayList();
	    Commonlore.add(ChatColor.GRAY + "Click to view all Common artifacts!");
	    CommonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Common Artifacts"));
	    CommonMeta.setLore(Commonlore);
	    Common.setItemMeta(CommonMeta);
	    MineLog.setItem(12, Common);
		    
		ItemStack Rare = new ItemStack(Material.IRON_INGOT);
  	  	ItemMeta RareMeta = Rare.getItemMeta();
	    ArrayList<String> Rarelore = new ArrayList();
	    Rarelore.add(ChatColor.GRAY + "Click to view all Rare artifacts!");
	    RareMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Rare Artifacts"));
	    RareMeta.setLore(Rarelore);
	    Rare.setItemMeta(RareMeta);
	    MineLog.setItem(13, Rare);
	    
		ItemStack Legend = new ItemStack(Material.GOLD_INGOT);
  	  	ItemMeta LegendMeta = Legend.getItemMeta();
	    ArrayList<String> Legendlore = new ArrayList();
	    Legendlore.add(ChatColor.GRAY + "Click to view all Legendary artifacts!");
	    LegendMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Legendary Artifacts"));
	    LegendMeta.setLore(Legendlore);
	    Legend.setItemMeta(LegendMeta);
	    MineLog.setItem(14, Legend);
	    
		ItemStack Mythic = new ItemStack(Material.DIAMOND);
  	  	ItemMeta MythicMeta = Mythic.getItemMeta();
	    ArrayList<String> Mythiclore = new ArrayList();
	    Mythiclore.add(ChatColor.GRAY + "Click to view all Mythic artifacts!");
	    MythicMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Mythic Artifacts"));
	    MythicMeta.setLore(Mythiclore);
	    Mythic.setItemMeta(MythicMeta);
	    MineLog.setItem(15, Mythic);
	    
		ItemStack Hell = new ItemStack(Material.NETHER_BRICK);
  	  	ItemMeta HellMeta = Hell.getItemMeta();
	    ArrayList<String> Helllore = new ArrayList();
	    Helllore.add(ChatColor.GRAY + "Click to view all Hellstone artifacts!");
	    HellMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Hellstone Artifacts"));
	    HellMeta.setLore(Helllore);
	    Hell.setItemMeta(HellMeta);
	    MineLog.setItem(16, Hell);
		    
		ItemStack Craft = new ItemStack(Material.CRAFTING_TABLE);
  	  	ItemMeta CraftMeta = Craft.getItemMeta();
  	  	ArrayList<String> CraftLore = new ArrayList();
  	  	CraftLore.add(ChatColor.translateAlternateColorCodes('&', TextColor() + "Click to view the given recipe!"));
	    CraftMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Recipe's"));
	    CraftMeta.setLore(CraftLore);
	    Craft.setItemMeta(CraftMeta);
	    MineLog.setItem(28, Craft);
	    
		ItemStack data = new ItemStack(Material.BOOK);
  	  	ItemMeta dataMeta = data.getItemMeta();
	    ArrayList<String> datalore = new ArrayList();
	    datalore.add(ChatColor.GRAY + "Click to view the datalog recipe.");
	    dataMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Datalog Recipe"));
	    dataMeta.setLore(datalore);
	    data.setItemMeta(dataMeta);
	    MineLog.setItem(30, data);
	    
		ItemStack pouch = new ItemStack(Material.FLOWER_POT);
  	  	ItemMeta pouchMeta = pouch.getItemMeta();
	    ArrayList<String> pouchlore = new ArrayList();
	    pouchlore.add(ChatColor.GRAY + "Click to view the pouch recipe.");
	    pouchMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Pouch Recipe"));
	    pouchMeta.setLore(pouchlore);
	    pouch.setItemMeta(pouchMeta);
	    MineLog.setItem(31, pouch);
	    
		ItemStack trash = new ItemStack(Material.CAULDRON);
  	  	ItemMeta trashMeta = trash.getItemMeta();
	    ArrayList<String> trashlore = new ArrayList();
	    trashlore.add(ChatColor.GRAY + "Click to view the trashcan recipe.");
	    trashMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Trashcan Recipe"));
	    trashMeta.setLore(trashlore);
	    trash.setItemMeta(trashMeta);
	    MineLog.setItem(32, trash);
		     
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Back&8:"));
	    Back.setItemMeta(BackMeta);
	    MineLog.setItem(48, Back);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.GRAY + "Hover over each item for");
		Infolore.add(ChatColor.GRAY + "more information!");
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Information" + "&8:"));
		Info.setItemMeta(InfoMeta);
		MineLog.setItem(50, Info);
	    
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    MineLog.setItem(9, bGlass);
	    MineLog.setItem(11, bGlass);
	    MineLog.setItem(17, bGlass);
	    MineLog.setItem(18, bGlass);
	    MineLog.setItem(20, bGlass);
	    MineLog.setItem(26, bGlass);
	    MineLog.setItem(27, bGlass);
	    MineLog.setItem(29, bGlass);
	    MineLog.setItem(35, bGlass);
	    
	    int glass = 0;
	    while (glass < 54) {
	    	if ((glass != 9) && (glass != 10) && (glass != 11) && (glass != 12) && (glass != 13) && (glass != 14)  && (glass != 15) && (glass != 16) && (glass != 17) && (glass != 18) && (glass != 20) && (glass != 26) && (glass != 27) && (glass != 28) && (glass != 29) && (glass != 30) && (glass != 31) && (glass != 32) && (glass != 33) && (glass != 34) && (glass != 35) && (glass != 48) && (glass != 50)) {
	            ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	            ItemMeta GlassMeta = Glass.getItemMeta();
	            GlassMeta.setDisplayName(" ");
	            Glass.setItemMeta(GlassMeta);
	            MineLog.setItem(glass, Glass);
	    	}
	    	glass ++;
	    }
	    
	    player.openInventory(MineLog);
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
