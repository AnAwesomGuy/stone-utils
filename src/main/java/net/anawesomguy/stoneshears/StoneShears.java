package net.anawesomguy.stoneshears;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class StoneShears extends ModInitializer {
 
    public static final Item STONE_SHEARS = new ShearsItem(new Item.Settings().maxDamage(87).group(ItemGroup.TOOLS));
 
    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("stone_shears", "fabric_item"), FABRIC_ITEM);
    }
}
