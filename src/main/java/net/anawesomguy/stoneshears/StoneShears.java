package net.anawesomguy.stoneshears;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.core.dispenser.ShearsDispenseItemBehavior;
import net.minecraft.world.level.block.DispenserBlock;

public class StoneShears implements ModInitializer {
 
    public static final Item STONE_SHEARS = new ShearsItem(new Item.Settings().maxDamage(93).group(ItemGroup.TOOLS));
 
    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("stone_shears", "stone_shears"), STONE_SHEARS);
    }
    
    public static void addDispenserBehaviours() {
        DispenserBlock.registerBehavior(STONE_SHEARS, new ShearsDispenseItemBehavior());
    }
}
