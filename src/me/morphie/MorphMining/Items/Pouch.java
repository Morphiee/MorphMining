package me.morphie.MorphMining.Items;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
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
import me.morphie.MorphMining.Files.playerFileMethods;
import me.morphie.MorphMining.Market.ArtifactShop;
import me.morphie.MorphMining.Market.Market;
import net.md_5.bungee.api.ChatColor;

public class Pouch implements Listener {
	
	private Main plugin;
	  
	public Pouch(Main plugin) {
		this.plugin = plugin;
	}
    
    public ItemMeta getPouch(Player player, ItemStack item) {
    	UUID uuid = player.getUniqueId();
 
		ItemMeta im = item.getItemMeta();
		ArrayList<String> itemlore = new ArrayList();
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.TextColor() + "Right-Click to use this pouch."));
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
		
		if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.CommonUpgrade") == true) {
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Common Capacity&8: " + this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Common") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getInt("Pouches.Common.UpgradedCapacity")));
		} else {
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Common Capacity&8: " + this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Common") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getInt("Pouches.Common.StartCapacity")));
		}
		
		if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.RareUpgrade") == true) {
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Rare Capacity&8: " + this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getInt("Pouches.Rare.UpgradedCapacity")));
		} else {
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Rare Capacity&8: " + this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getInt("Pouches.Rare.StartCapacity")));
		}
		
		if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.LegendaryUpgrade") == true) {
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Legendary Capacity&8: " + this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getInt("Pouches.Legendary.UpgradedCapacity")));
		} else {
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Legendary Capacity&8: " + this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getInt("Pouches.Legendary.StartCapacity")));
		}
		
		if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.MythicUpgrade") == true) {
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Mythic Capacity&8: " + this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getInt("Pouches.Mythic.UpgradedCapacity")));
		} else {
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Mythic Capacity&8: " + this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getInt("Pouches.Mythic.StartCapacity")));
		}
		
		itemlore.add(" ");
		itemlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"));
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Miner's Pouch"));
		im.setLore(itemlore);
		item.setItemMeta(im);
    	return (ItemMeta) item;
    }
    
	public void openGUIPouch(Player player) {
		Inventory MineLog = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.GUIColor() + "Pouch: " + player.getName()));
		
		UUID uuid = player.getUniqueId();
	    
		ItemStack Misc = new ItemStack(Material.SUGAR);
  	  	ItemMeta MiscMeta = Misc.getItemMeta();
  	  	MiscMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Misc"));
  	  	Misc.setItemMeta(MiscMeta);
	    MineLog.setItem(28, Misc);
	    
		ItemStack Common = new ItemStack(Material.BRICK);
  	  	ItemMeta CommonMeta = Common.getItemMeta();
	    ArrayList<String> Commonlore = new ArrayList();
		Commonlore.add(" ");
		Commonlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Capacity&8:"));
		if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.CommonUpgrade") == false) {
			Commonlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Common") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getString("Pouches.Common.StartCapacity")));
		} else {
			Commonlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Common") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getString("Pouches.Common.UpgradedCapacity")));
		}
	    CommonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Common Slot"));
	    CommonMeta.setLore(Commonlore);
	    Common.setItemMeta(CommonMeta);
	    MineLog.setItem(10, Common);
		    
		ItemStack Rare = new ItemStack(Material.IRON_INGOT);
  	  	ItemMeta RareMeta = Rare.getItemMeta();
	    ArrayList<String> Rarelore = new ArrayList();
		Rarelore.add(" ");
		Rarelore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Capacity&8:"));
		if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.RareUpgrade") == false) {
			Rarelore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getString("Pouches.Rare.StartCapacity")));
		} else {
			Rarelore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getString("Pouches.Rare.UpgradedCapacity")));
		}
	    RareMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Rare Slot"));
	    RareMeta.setLore(Rarelore);
	    Rare.setItemMeta(RareMeta);
	    MineLog.setItem(19, Rare);
	    
		ItemStack Legend = new ItemStack(Material.GOLD_INGOT);
  	  	ItemMeta LegendMeta = Legend.getItemMeta();
	    ArrayList<String> Legendlore = new ArrayList();
		Legendlore.add(" ");
		Legendlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Capacity&8:"));
		if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.LegendaryUpgrade") == false) {
			Legendlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getString("Pouches.Legendary.StartCapacity")));
		} else {
			Legendlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getString("Pouches.Legendary.UpgradedCapacity")));
		}
	    LegendMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Legendary Slot"));
	    LegendMeta.setLore(Legendlore);
	    Legend.setItemMeta(LegendMeta);
	    MineLog.setItem(28, Legend);
	    
		ItemStack Mythic = new ItemStack(Material.DIAMOND);
  	  	ItemMeta MythicMeta = Mythic.getItemMeta();
	    ArrayList<String> Mythiclore = new ArrayList();
		Mythiclore.add(" ");
	    Mythiclore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Capacity&8:"));
		if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.MythicUpgrade") == false) {
			Mythiclore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getString("Pouches.Mythic.StartCapacity")));
		} else {
			Mythiclore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic") + TextColor() + "/" + this.HighlightColor() + this.plugin.getConfig().getString("Pouches.Mythic.UpgradedCapacity")));
		}
	    MythicMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Mythic Slot"));
	    MythicMeta.setLore(Mythiclore);
	    Mythic.setItemMeta(MythicMeta);
	    MineLog.setItem(37, Mythic);
	    
		ItemStack cUp = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
  	  	ItemMeta cUpMeta = cUp.getItemMeta();
	    ArrayList<String> cUplore = new ArrayList();
	    cUplore.add(" ");
	    cUplore.add(ChatColor.GRAY + "Click to purchase upgrade.");
	    cUplore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Requirements&8:"));
	    cUplore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + ChatColor.GRAY + this.plugin.getConfig().getInt("Pouches.Common.GemCost") + " Gems"));
	    cUplore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + ChatColor.GRAY + "$" + this.plugin.getConfig().getInt("Pouches.Common.CurrencyCost")));
	    cUpMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Common Capacity Upgrade"));
	    cUpMeta.setLore(cUplore);
	    cUp.setItemMeta(cUpMeta);
	    
		ItemStack rUp = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
  	  	ItemMeta rUpMeta = rUp.getItemMeta();
	    ArrayList<String> rUplore = new ArrayList();
	    rUplore.add(" ");
	    rUplore.add(ChatColor.GRAY + "Click to purchase upgrade.");
	    rUplore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Requirements&8:"));
	    rUplore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + ChatColor.GRAY + this.plugin.getConfig().getInt("Pouches.Rare.GemCost") + " Gems"));
	    rUplore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + ChatColor.GRAY + "$" + this.plugin.getConfig().getInt("Pouches.Rare.CurrencyCost")));
	    rUpMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Rare Capacity Upgrade"));
	    rUpMeta.setLore(rUplore);
	    rUp.setItemMeta(rUpMeta);
	    
		ItemStack lUp = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
  	  	ItemMeta lUpMeta = lUp.getItemMeta();
	    ArrayList<String> lUplore = new ArrayList();
	    lUplore.add(" ");
	    lUplore.add(ChatColor.GRAY + "Click to purchase upgrade.");
	    lUplore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Requirements&8:"));
	    lUplore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + ChatColor.GRAY + this.plugin.getConfig().getInt("Pouches.Legendary.GemCost") + " Gems"));
	    lUplore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + ChatColor.GRAY + "$" + this.plugin.getConfig().getInt("Pouches.Legendary.CurrencyCost")));
	    lUpMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Legendary Capacity Upgrade"));
	    lUpMeta.setLore(lUplore);
	    lUp.setItemMeta(lUpMeta);
	    
		ItemStack mUp = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
  	  	ItemMeta mUpMeta = mUp.getItemMeta();
	    ArrayList<String> mUplore = new ArrayList();
	    mUplore.add(" ");
	    mUplore.add(ChatColor.GRAY + "Click to purchase upgrade.");
	    mUplore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Requirements&8:"));
	    mUplore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + ChatColor.GRAY + this.plugin.getConfig().getInt("Pouches.Mythic.GemCost") + " Gems"));
	    mUplore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + ChatColor.GRAY + "$" + this.plugin.getConfig().getInt("Pouches.Mythic.CurrencyCost")));
	    mUpMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Mythic Capacity Upgrade"));
	    mUpMeta.setLore(mUplore);
	    mUp.setItemMeta(mUpMeta);
	    
	    ItemStack sell = new ItemStack(Material.EMERALD);
	    ItemMeta sellMeta = sell.getItemMeta();
	    ArrayList<String> sellLore = new ArrayList();
	    sellLore.add(" ");
	    sellLore.add(ChatColor.translateAlternateColorCodes('&', TextColor() + "Click me to automatically sell"));
	    sellLore.add(ChatColor.translateAlternateColorCodes('&', TextColor() + "all artifacts in your pouch!"));
	    sellLore.add(" ");
	    sellLore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "&oComing soon!"));
	    sellMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ItemColor() + "Auto-Sell"));
	    sellMeta.setLore(sellLore);
	    sell.setItemMeta(sellMeta);
	    MineLog.setItem(43, sell);
	    
		ItemStack upP = new ItemStack(Material.STRUCTURE_VOID);
  	  	ItemMeta upPMeta = upP.getItemMeta();
	    upPMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Upgrade Purchased"));
	    upP.setItemMeta(upPMeta);
	    
	    if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.CommonUpgrade") == false) {
	    	MineLog.setItem(13, cUp);
	    } else {
	    	MineLog.setItem(13, upP);
	    }
	    
	    if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.RareUpgrade") == false) {
	    	MineLog.setItem(22, rUp);
	    } else {
	    	MineLog.setItem(22, upP);
	    }
	    
	    if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.LegendaryUpgrade") == false) {
	    	MineLog.setItem(31, lUp);
	    } else {
	    	MineLog.setItem(31, upP);
	    }
	    
	    if(new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.MythicUpgrade") == false) {
	    	MineLog.setItem(40, mUp);
	    } else {
	    	MineLog.setItem(40, upP);
	    }
		     
	    if (new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.Enabled") == true) {
			ItemStack Enable = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
			ItemMeta EnableMeta = Enable.getItemMeta();
			ArrayList<String> Enablelore = new ArrayList();
			Enablelore.add(" ");
			Enablelore.add(ChatColor.GRAY + "Click to disable your pouch.");
			EnableMeta.setLore(Enablelore);
			EnableMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aEnabled&8:"));
			Enable.setItemMeta(EnableMeta);
		    MineLog.setItem(16, Enable);
	    } else {
			ItemStack Disable = new ItemStack(Material.RED_STAINED_GLASS_PANE);
			ItemMeta DisableMeta = Disable.getItemMeta();
			ArrayList<String> Disablelore = new ArrayList();
			Disablelore.add(" ");
			Disablelore.add(ChatColor.GRAY + "Click to enable your pouch.");
			DisableMeta.setLore(Disablelore);
			DisableMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cDisable&8:"));
			Disable.setItemMeta(DisableMeta);
		    MineLog.setItem(16, Disable);	
	    }
	    
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    MineLog.setItem(0, bGlass);
	    MineLog.setItem(2, bGlass);
	    MineLog.setItem(6, bGlass);
	    MineLog.setItem(8, bGlass);
	    MineLog.setItem(9, bGlass);
	    MineLog.setItem(11, bGlass);
	    MineLog.setItem(15, bGlass);
	    MineLog.setItem(17, bGlass);
	    MineLog.setItem(18, bGlass);
	    MineLog.setItem(20, bGlass);
	    MineLog.setItem(24, bGlass);
	    MineLog.setItem(26, bGlass);
	    MineLog.setItem(27, bGlass);
	    MineLog.setItem(29, bGlass);
	    MineLog.setItem(33, bGlass);
	    MineLog.setItem(35, bGlass);
	    MineLog.setItem(36, bGlass);
	    MineLog.setItem(38, bGlass);
	    MineLog.setItem(42, bGlass);
	    MineLog.setItem(44, bGlass);
	    MineLog.setItem(45, bGlass);
	    MineLog.setItem(47, bGlass);
	    MineLog.setItem(51, bGlass);
	    MineLog.setItem(53, bGlass);
	    
        ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
        ItemMeta GlassMeta = Glass.getItemMeta();
        GlassMeta.setDisplayName(" ");
        Glass.setItemMeta(GlassMeta);
        MineLog.setItem(1, Glass);
        MineLog.setItem(3, Glass);
        MineLog.setItem(4, Glass);
        MineLog.setItem(5, Glass);
        MineLog.setItem(7, Glass);
        MineLog.setItem(12, Glass);
        MineLog.setItem(14, Glass);
        MineLog.setItem(21, Glass);
        MineLog.setItem(23, Glass);
        MineLog.setItem(25, Glass);
        MineLog.setItem(30, Glass);
        MineLog.setItem(32, Glass);
        MineLog.setItem(34, Glass);
        MineLog.setItem(39, Glass);
        MineLog.setItem(41, Glass);
        MineLog.setItem(46, Glass);
        MineLog.setItem(48, Glass);
        MineLog.setItem(49, Glass);
        MineLog.setItem(50, Glass);
        MineLog.setItem(52, Glass);
	    
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
