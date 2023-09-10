package net.anawesomguy.stone_utils;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class StoneUtils implements ModInitializer {
  public static final String MOD_ID = "stone_utils";
  public static final Identifier STONE_SHEARS_ITEM_ID = new Identifier(MOD_ID, "stone_shears");
  public static final Item STONE_SHEARS = new ShearsItem(new Item.Settings().maxDamage(93).group(ItemGroup.TOOLS));
  @Override
  public void onInitialize() {
    Registry.register(Registry.ITEM, STONE_SHEARS_ITEM_ID, STONE_SHEARS);
    DispenserBlock.registerBehavior(STONE_SHEARS, new ShearsDispenserBehavior());
  }
}