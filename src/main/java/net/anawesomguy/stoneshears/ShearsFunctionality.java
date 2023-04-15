package net.anawesomguy.stoneshears;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.anawesomguy.stoneshears.StoneShears;
import net.minecraft.loot.entry.ItemEntry;

public class ShearsFunctionality {
  static {
    LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
      if (source.isBuiltin() && COAL_ORE_LOOT_TABLE_ID.equals(id)) {
          LootPool.Builder poolBuilder = LootPool.builder()
            .with(ItemEntry.builder(Items.EGG));
          tableBuilder.pool(poolBuilder);
      }
    });
  }
}
