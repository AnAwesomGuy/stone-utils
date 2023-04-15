import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.util.Identifier

public class ShearsFunctionality {
    private static final Identifier COAL_ORE_LOOT_TABLE_ID = Blocks.COAL_ORE.getLootTableId();
    LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
        if (source.isBuiltin() && COAL_ORE_LOOT_TABLE_ID.equals(id)) {
            LootPool.Builder poolBuilder = LootPool.builder()
                    .with(ItemEntry.builder(Items.EGG));
                    
            tableBuilder.pool(poolBuilder);
        }
    });
}
