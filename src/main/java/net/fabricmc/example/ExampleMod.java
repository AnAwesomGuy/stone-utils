package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ExampleMod implements ModInitializer {
 
    // an instance of our new item
    public static final Item SHEARS = new ShearsItem(new Item.Settings().maxDamage(238).group(ItemGroup.TOOLS));
 
    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"), CUSTOM_ITEM);
    }
}
