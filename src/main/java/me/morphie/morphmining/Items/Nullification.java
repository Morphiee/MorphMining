package me.morphie.morphmining.Items;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.morphie.morphmining.Files.playerFileMethods;
import me.morphie.morphmining.MorphMining;

public class Nullification {
	
	private MorphMining plugin;
	  
	public Nullification(MorphMining plugin) {
		this.plugin = plugin;
	}

	public void openGUINullifier(Player player) {
		Inventory Nullifier = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "Nullification"));
	
		UUID uuid = player.getUniqueId();
		
		ArrayList<String> Enabled = new ArrayList();
		Enabled.add(" ");
		
		ArrayList<String> Slot1 = new ArrayList();
		Slot1.add(" ");
		
		ArrayList<String> Slot2 = new ArrayList();
		Slot2.add(" ");
		
		ArrayList<String> Slot3 = new ArrayList();
		Slot3.add(" ");
		
		ArrayList<String> Slot4 = new ArrayList();
		Slot4.add(" ");
		
		if (new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Enabled") == false) {
			Enabled.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to enable your nullifier."));
			Nullifier.setItem(4, this.plugin.createInventoryItem("RED_STAINED_GLASS_PANE", 1, "&cDisabled" + this.plugin.getMessage("Menus.SpacerColor") + ":", Enabled, false, 10000));
		} else {
			Enabled.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to disable your nullifier."));
			Nullifier.setItem(4, this.plugin.createInventoryItem("LIME_STAINED_GLASS_PANE", 1, "&aEnabled" + this.plugin.getMessage("Menus.SpacerColor") + ":", Enabled, false, 10000));
		}
		
		if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot1.Material") == null && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot1.Enabled") == false) {
			Slot1.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Slot currently empty. Click then"));
			Slot1.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "add an item in the empty slot below!"));
			Nullifier.setItem(1, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 1" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot1, false, 10000));
		} else if (new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot1.Enabled") == true) {
			Slot1.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "To change the nullified item."));
			Slot1.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Add an item to the empty slot below"));
			Slot1.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "then click the activation button."));
			Nullifier.setItem(1, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 1" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot1, true, 10000));
		} else {
			ItemStack item = new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot1.Material");
			Slot1.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Item currently being nullified!"));
			Slot1.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + " "));
			Slot1.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to change the item being nullified."));
			Nullifier.setItem(1, this.plugin.createInventoryItem(item.getType().name(), 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 1" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot1, false, 10000));
		}
		
		if (new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot2.Purchased") == false) {
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to select purchase option."));
			Slot2.add("");
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Requirements" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + this.plugin.getConfig().getInt("Trashcan.Slot2.GemCost") + " Gems"));
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + "$" + this.plugin.getConfig().getInt("Trashcan.Slot2.CurrencyCost")));
			Nullifier.setItem(2, this.plugin.createInventoryItem("WHITE_STAINED_GLASS_PANE", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 2" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot2, false, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot2.Material") == null && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot2.Purchased") == true && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot2.Enabled") == false) {
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "To change the nullified item."));
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Add an item to the empty slot below"));
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "then click the activation button."));
			Nullifier.setItem(2, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 2" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot2, false, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot2.Material") == null && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot2.Purchased") == true && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot2.Enabled") == true) {
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "To change the nullified item."));
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Add an item to the empty slot below"));
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "then click the activation button."));
			Nullifier.setItem(2, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 2" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot2, true, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot2.Material") != null && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot2.Purchased") == true && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot2.Enabled") == true) {
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "To change the nullified item."));
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Add an item to the empty slot below"));
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "then click the activation button."));
			Nullifier.setItem(2, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 2" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot2, true, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot2.Material") != null) {
			ItemStack item = new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot2.Material");
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Item currently being nullified!"));
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + " "));
			Slot2.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to change the item being nullified."));
			Nullifier.setItem(2, this.plugin.createInventoryItem(item.getType().name(), 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 2" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot2, false, 10000));
		}
		
		if (new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot3.Purchased") == false) {
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to select purchase option."));
			Slot3.add("");
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Requirements" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + this.plugin.getConfig().getInt("Trashcan.Slot3.GemCost") + " Gems"));
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + "$" + this.plugin.getConfig().getInt("Trashcan.Slot3.CurrencyCost")));
			Nullifier.setItem(6, this.plugin.createInventoryItem("WHITE_STAINED_GLASS_PANE", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 3" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot3, false, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot3.Material") == null && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot3.Purchased") == true && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot3.Enabled") == false) {
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "To change the nullified item."));
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Add an item to the empty slot below"));
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "then click the activation button."));
			Nullifier.setItem(6, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 3" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot3, false, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot3.Material") == null && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot3.Purchased") == true && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot3.Enabled") == true) {
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "To change the nullified item."));
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Add an item to the empty slot below"));
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "then click the activation button."));
			Nullifier.setItem(6, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 3" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot3, true, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot3.Material") != null && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot3.Purchased") == true && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot3.Enabled") == true) {
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "To change the nullified item."));
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Add an item to the empty slot below"));
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "then click the activation button."));
			Nullifier.setItem(6, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 3" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot3, true, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot3.Material") != null) {
			ItemStack item = new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot3.Material");
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Item currently being nullified!"));
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + " "));
			Slot3.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to change the item being nullified."));
			Nullifier.setItem(6, this.plugin.createInventoryItem(item.getType().name(), 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 3" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot3, false, 10000));
		}
		
		if (new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot4.Purchased") == false) {
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to select purchase option."));
			Slot4.add("");
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Requirements" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + this.plugin.getConfig().getInt("Trashcan.Slot4.GemCost") + " Gems"));
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + "$" + this.plugin.getConfig().getInt("Trashcan.Slot4.CurrencyCost")));
			Nullifier.setItem(7, this.plugin.createInventoryItem("WHITE_STAINED_GLASS_PANE", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 4" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot4, false, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot4.Material") == null && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot4.Purchased") == true && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot4.Enabled") == false) {
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "To change the nullified item."));
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Add an item to the empty slot below"));
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "then click the activation button."));
			Nullifier.setItem(7, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 4" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot4, false, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot4.Material") == null && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot4.Purchased") == true && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot4.Enabled") == true) {
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "To change the nullified item."));
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Add an item to the empty slot below"));
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "then click the activation button."));
			Nullifier.setItem(7, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 4" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot4, true, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot4.Material") != null && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot4.Purchased") == true && new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot4.Enabled") == true) {
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "To change the nullified item."));
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Add an item to the empty slot below"));
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "then click the activation button."));
			Nullifier.setItem(7, this.plugin.createInventoryItem("STRUCTURE_VOID", 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 4" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot4, true, 10000));
		} else if (new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot4.Material") != null) {
			ItemStack item = new playerFileMethods(this.plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot4.Material");
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Item currently being nullified!"));
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + " "));
			Slot4.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to change the item being nullified."));
			Nullifier.setItem(7, this.plugin.createInventoryItem(item.getType().name(), 1, this.plugin.getMessage("Menus.ItemColor") + "Slot 4" + this.plugin.getMessage("Menus.SpacerColor") + ":", Slot4, false, 10000));
		}
		
		ArrayList<String> LavaRepair = new ArrayList();
		LavaRepair.add(" ");
		LavaRepair.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to select this option."));
		LavaRepair.add(" ");
		LavaRepair.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		LavaRepair.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + "Durability" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + new playerFileMethods(this.plugin).getStat(uuid, "Trashcan.LavaRepair.Durability")));
		
		if (new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.LavaRepair.Enabled") == false) {
			LavaRepair.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + "Enabled" + this.plugin.getMessage("Menus.SpacerColor") + ": &c" + new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.LavaRepair.Enabled")));
			Nullifier.setItem(27, this.plugin.createInventoryItem("FLINT_AND_STEEL", 1, this.plugin.getMessage("Menus.ItemColor") + "Lava Tank" + this.plugin.getMessage("Menus.SpacerColor") + ":", LavaRepair, false, new playerFileMethods(this.plugin).getStat(uuid, "Trashcan.LavaRepair.Durability") * -1));
		} else {
			LavaRepair.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + "Enabled" + this.plugin.getMessage("Menus.SpacerColor") + ": &a" + new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.LavaRepair.Enabled")));
			Nullifier.setItem(27, this.plugin.createInventoryItem("FLINT_AND_STEEL", 1, this.plugin.getMessage("Menus.ItemColor") + "Lava Tank" + this.plugin.getMessage("Menus.SpacerColor") + ":", LavaRepair, true, new playerFileMethods(this.plugin).getStat(uuid, "Trashcan.LavaRepair.Durability") * -1));
		}
		
		ArrayList<String> IronRepair = new ArrayList();
		IronRepair.add(" ");
		IronRepair.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to select this option."));
		IronRepair.add(" ");
		IronRepair.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		IronRepair.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + "Durability" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + new playerFileMethods(this.plugin).getStat(uuid, "Trashcan.IronRepair.Durability")));
		
		if (new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.IronRepair.Enabled") == false) {
			IronRepair.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + "Enabled" + this.plugin.getMessage("Menus.SpacerColor") + ": &c" + new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.IronRepair.Enabled")));
			Nullifier.setItem(35, this.plugin.createInventoryItem("ANVIL", 1, this.plugin.getMessage("Menus.ItemColor") + "Structure Integrity" + this.plugin.getMessage("Menus.SpacerColor") + ":", IronRepair, false, new playerFileMethods(this.plugin).getStat(uuid, "Trashcan.IronRepair.Durability") * -1));
		} else {
			IronRepair.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➙ " + this.plugin.getMessage("Menus.LoreColor") + "Enabled" + this.plugin.getMessage("Menus.SpacerColor") + ": &a" + new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.IronRepair.Enabled")));
			Nullifier.setItem(35, this.plugin.createInventoryItem("ANVIL", 1, this.plugin.getMessage("Menus.ItemColor") + "Structure Integrity" + this.plugin.getMessage("Menus.SpacerColor") + ":", IronRepair, true, new playerFileMethods(this.plugin).getStat(uuid, "Trashcan.IronRepair.Durability") * -1));
		}
		
		ArrayList<String> Back = new ArrayList();
		Back.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to close menu!"));

		Nullifier.setItem(47, this.plugin.createInventoryItem("REDSTONE", 1, this.plugin.getMessage("Menus.ItemColor") + "Close" + this.plugin.getMessage("Menus.SpacerColor") + ":", Back, false, 10000));
		
		ArrayList<String> Activate = new ArrayList();
		Activate.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to activate the"));
		Activate.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "selected function above."));

		Nullifier.setItem(51, this.plugin.createInventoryItem("EMERALD", 1, this.plugin.getMessage("Menus.ItemColor") + "Activation" + this.plugin.getMessage("Menus.SpacerColor") + ":", Activate, false, 10000));
		
		Nullifier.setItem(0, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(3, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(5, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(8, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(9, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(10, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(11, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(12, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(13, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(14, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(15, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(16, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(17, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(20, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(24, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(29, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(33, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(38, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(42, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(45, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(46, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(48, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(49, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(50, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(52, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(53, this.plugin.createInventoryItem("BLACK_STAINED_GLASS_PANE", 1, " ", null, false, 10000));
		Nullifier.setItem(18, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(19, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(21, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(22, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(23, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(25, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(26, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(28, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(30, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(32, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(34, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(36, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(37, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(39, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(40, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(41, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(43, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		Nullifier.setItem(44, this.plugin.createInventoryGlassItem("LEGACY_STAINED_GLASS_PANE", this.plugin.getConfig().getInt("Settings.MainGlassColor"), 1, " ", null, false));
		
		player.openInventory(Nullifier);
	}
}
