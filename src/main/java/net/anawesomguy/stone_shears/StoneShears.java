package net.anawesomguy.stone_shears;

import com.oroarmor.multiitemlib.api.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.block.DispenserBlock;

public class StoneShears implements ModInitializer {
  public static final String MOD_ID = "stone_shears";
  public static final Item STONE_SHEARS = new ShearsItem(new Item.Settings().maxDamage(93).group(ItemGroup.TOOLS));
  @Override
  public void onInitialize() {
    UniqueItemRegistry.SHEARS.addItemToRegistry(STONE_SHEARS);
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stone_shears"), STONE_SHEARS);
    DispenserBlock.registerBehavior(STONE_SHEARS, new ShearsDispenserBehavior());
  }
}
