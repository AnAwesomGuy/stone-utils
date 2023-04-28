package net.anawesomguy.stone_shears;

import com.oroarmor.multiitemlib.api.UniqueItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.block.DispenserBlock;

public class StoneShears implements ModInitializer {
  public static final String MOD_ID = "stone_shears";
  public static final Item STONE_SHEARS = new ShearsItem(new Item.Settings().maxDamage(93));
  @Override
  public void onInitialize() {
    UniqueItemRegistry.SHEARS.addItemToRegistry(STONE_SHEARS);
    Registry.register(Registries.ITEM, new Identifier(MOD_ID, "stone_shears"), STONE_SHEARS);
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.add(STONE_SHEARS));
    DispenserBlock.registerBehavior(STONE_SHEARS, new ShearsDispenserBehavior());
  }
}
