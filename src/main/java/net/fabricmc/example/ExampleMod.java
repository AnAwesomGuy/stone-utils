package net.fabricmc.example;

import net.minecraft.item.ShearsItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ExampleMod {
 
    public static final Item SHEARS = Items.register("shears", (Item)new ShearsItem(new Item.Settings().maxDamage(238).group(ItemGroup.TOOLS)));
 
    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier("kubejs", "stone_grasscutters"), STONE_SHEARS);
    }
}
