package net.anawesomguy.stone_shears.mixin;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.predicate.item.ItemPredicate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static net.anawesomguy.stone_shears.StoneShears.STONE_SHEARS_ITEM_ID;
import static net.anawesomguy.stone_shears.StoneShears.deepCopy;

@Mixin(MatchToolLootCondition.class)
public abstract class MatchToolLootConditionMixin {
    @ModifyVariable(at = @At("HEAD"), method = "<init>", argsOnly = true)
    private static ItemPredicate shearsLoot(ItemPredicate predicate) {
        JsonElement element = deepCopy(predicate.toJson());
        JsonObject object = element.isJsonObject() ? element.getAsJsonObject() : null;
        if (object != null) {
            JsonArray items = object.getAsJsonArray("items");
            if (items != null) {
                for (JsonElement jsonElement : deepCopy(items)) {
                    if (jsonElement.getAsString().equals("minecraft:shears")) {
                        items.add(STONE_SHEARS_ITEM_ID.toString());
                    }
                }
            }
        }
        return ItemPredicate.fromJson(element);
    }
}