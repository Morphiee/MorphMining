package me.morphie.MorphMining.Items;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import net.md_5.bungee.api.ChatColor;

public class CrafterItems implements Listener {
	
	private Main plugin;
	  
	public CrafterItems(Main plugin) {
		this.plugin = plugin;
	}
	
	public ItemStack recipeItems(String string) {
		if (string == "trashcan") {
			ItemStack item = new ItemStack(Material.CAULDRON, this.plugin.getConfig().getInt("Recipes.Trashcan.Amount"));
			ItemMeta im = item.getItemMeta();
			ArrayList<String> itemlore = new ArrayList();
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Dump all unwanted things here!"));
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Level" + this.plugin.getMessage("Menus.SpacerColor") + ": [" + this.plugin.getMessage("Menus.HighlightColor") + "●" + this.plugin.getMessage("Menus.LoreColor") + "●●" + this.plugin.getMessage("Menus.SpacerColor") +"]"));
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Nullifier" + this.plugin.getMessage("Menus.SpacerColor") +": " + this.plugin.getMessage("Menus.HighlightColor") + "Disabled"));
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Right-Click to use."));
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "TrashCan"));
			im.setLore(itemlore);
			item.setItemMeta(im);
			return item;
		} else if (string == "pouch") {
			ItemStack item = new ItemStack(Material.FLOWER_POT, this.plugin.getConfig().getInt("Recipes.Pouch.Amount"));
			ItemMeta im = item.getItemMeta();
			ArrayList<String> itemlore = new ArrayList();
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Automatically stores your artifacts!"));
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Right-Click to use."));
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Miner's Pouch"));
			im.setLore(itemlore);
			item.setItemMeta(im);
			return item;
		} else if (string == "datalog") {
			ItemStack DataLog = new ItemStack(Material.BOOK, this.plugin.getConfig().getInt("Recipes.Datalog.Amount"));
			ItemMeta DataMeta = DataLog.getItemMeta();
			ArrayList<String> Datalore = new ArrayList();
			Datalore.add(" ");
			Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "The infinite wisdom of MorphMining"));
			Datalore.add(" ");
			Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
			Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Version" + this.plugin.getMessage("Menus.SpacerColor") + ": " + this.plugin.getMessage("Menus.LoreColor") + new Station(plugin).Version));
			Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Author" + this.plugin.getMessage("Menus.SpacerColor") + "&8:" + this.plugin.getMessage("Menus.LoreColor") + " Morphie"));
			Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "➛ " + this.plugin.getMessage("Menus.LoreColor") + "Right-Click to use."));
			Datalore.add(" ");
			Datalore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
			DataMeta.setLore(Datalore);
			DataMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining DataLog"));
			DataLog.setItemMeta(DataMeta);
			return DataLog;
		}
		return null;
	}
	
	public void removeAllRecipes(String string){
        Iterator<Recipe> it = this.plugin.getServer().recipeIterator();
    
        while(it.hasNext()){
            ItemStack result = it.next().getResult();
            if(result.hasItemMeta() && result.getType().equals(Material.matchMaterial(string))){
                it.remove();
            }
        }
    }
	
	public void createRecipeTrashcan() {
		ItemStack item = recipeItems("trashcan");
		NamespacedKey key = new NamespacedKey(this.plugin, "trashcan");
		ShapedRecipe craftItem = new ShapedRecipe(key, item);
		craftItem.shape(this.plugin.getConfig().getString("Recipes.Trashcan.Line1"),this.plugin.getConfig().getString("Recipes.Trashcan.Line2"),this.plugin.getConfig().getString("Recipes.Trashcan.Line3"));
		
	    int Count = 0;
	    while (plugin.getConfig().getString("Recipes.Trashcan.Ingredients." + Count) != null) {
	      Count++;
	    }
	    Count--;
	    
	    while (Count > -1) {
	    	craftItem.setIngredient(this.plugin.getConfig().getString("Recipes.Trashcan.Ingredients." + Count + ".Key").charAt(0), Material.matchMaterial(this.plugin.getConfig().getString("Recipes.Trashcan.Ingredients." + Count + ".Material")));
	    	Count--;
	    }
		
		this.plugin.getServer().addRecipe(craftItem);
	}
	
	public void createRecipePouch() {
		ItemStack item = recipeItems("pouch");
		NamespacedKey key = new NamespacedKey(this.plugin, "pouch");
		ShapedRecipe craftItem = new ShapedRecipe(key, item);
		craftItem.shape(this.plugin.getConfig().getString("Recipes.Pouch.Line1"),this.plugin.getConfig().getString("Recipes.Pouch.Line2"),this.plugin.getConfig().getString("Recipes.Pouch.Line3"));
		
	    int Count = 0;
	    while (plugin.getConfig().getString("Recipes.Pouch.Ingredients." + Count) != null) {
	      Count++;
	    }
	    Count--;
	    while (Count > -1) {
	    	craftItem.setIngredient(this.plugin.getConfig().getString("Recipes.Pouch.Ingredients." + Count + ".Key").charAt(0), Material.matchMaterial(this.plugin.getConfig().getString("Recipes.Pouch.Ingredients." + Count + ".Material")));
	    	Count--;
	    }
	    
	    this.plugin.getServer().addRecipe(craftItem);
	}
	
	public void createRecipeDatalog() {
		ItemStack item = recipeItems("datalog");
		NamespacedKey key = new NamespacedKey(this.plugin, "datalog");
		ShapedRecipe craftItem = new ShapedRecipe(key, item);
		craftItem.shape(this.plugin.getConfig().getString("Recipes.Datalog.Line1"),this.plugin.getConfig().getString("Recipes.Datalog.Line2"),this.plugin.getConfig().getString("Recipes.Datalog.Line3"));
		
	    int Count = 0;
	    while (plugin.getConfig().getString("Recipes.Datalog.Ingredients." + Count) != null) {
	      Count++;
	    }
	    Count--;
	    while (Count > -1) {
	    	craftItem.setIngredient(this.plugin.getConfig().getString("Recipes.Datalog.Ingredients." + Count + ".Key").charAt(0), Material.matchMaterial(this.plugin.getConfig().getString("Recipes.Datalog.Ingredients." + Count + ".Material")));
	    	Count--;
	    }
	    
	    this.plugin.getServer().addRecipe(craftItem);
	}
}
