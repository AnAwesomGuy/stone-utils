package net.anawesomguy.stoneshears;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.dispenser.ShearsDispenserBehavior;
import net.minecraft.block.DispenserBlock;

public class StoneShears implements ModInitializer {
 
  public static final Item STONE_SHEARS = new ShearsItem(new Item.Settings().maxDamage(93).group(ItemGroup.TOOLS));
 
  private static final Identifier COAL_ORE_LOOT_TABLE_ID = Blocks.COAL_ORE.getLootTableId();
 
  @Override
  public void onInitialize() {
    Registry.register(Registry.ITEM, new Identifier("stone_shears", "stone_shears"), STONE_SHEARS);

    DispenserBlock.registerBehavior(STONE_SHEARS, new ShearsDispenserBehavior());

    LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
      if (source.isBuiltin() && COAL_ORE_LOOT_TABLE_ID.equals(id)) {
        LootPool.Builder poolBuilder = LootPool.builder()
          .with(ItemEntry.builder(STONE_SHEARS));
        tableBuilder.pool(poolBuilder);
      }
    });
  }
}
