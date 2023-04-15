package net.fabricmc.example;

import net.minecraft.item.ShearsItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExampleMod {
 
    public static final Item STONE_SHEARS = new ShearsItem(new Item.Settings().maxDamage(87).group(ItemGroup.TOOLS));
 
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("kubejs", "stone_shears"), STONE_SHEARS);
    }
}
