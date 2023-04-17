package net.anawesomguy.stoneshears;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.predicate.item.ItemPredicate;
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
    Registry.register(Registry.ITEM, new Identifier(MOD_ID, "stone_shears"), STONE_SHEARS);

    DispenserBlock.registerBehavior(STONE_SHEARS, new ShearsDispenserBehavior());

    LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
      if (source.isBuiltin() && Blocks.GRASS.getLootTableId().equals(id)) {
        LootPool.Builder poolBuilder = LootPool.builder()
          .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(STONE_SHEARS)))
          .with(ItemEntry.builder(Items.GRASS));

        tableBuilder.pool(poolBuilder);
      }
      if (source.isBuiltin() && Blocks.TALL_GRASS.getLootTableId().equals(id)) {
        LootPool.Builder poolBuilder = LootPool.builder()
          .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(STONE_SHEARS)))
          .with(ItemEntry.builder(Items.GRASS));

        tableBuilder.pool(poolBuilder);
      }
      if (source.isBuiltin() && Blocks.TALL_GRASS.getLootTableId().equals(id)) {
        LootPool.Builder poolBuilder = LootPool.builder()
          .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(STONE_SHEARS)))
          .with(ItemEntry.builder(Items.GRASS));

        tableBuilder.pool(poolBuilder);
      }
      if (source.isBuiltin() && Blocks.SEAGRASS.getLootTableId().equals(id)) {
        LootPool.Builder poolBuilder = LootPool.builder()
          .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(STONE_SHEARS)))
          .with(ItemEntry.builder(Items.SEAGRASS));

        tableBuilder.pool(poolBuilder);
      }
    });
  }
}
