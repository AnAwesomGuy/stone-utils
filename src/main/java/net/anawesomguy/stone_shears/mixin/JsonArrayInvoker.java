package net.anawesomguy.stone_shears.mixin;

import com.google.gson.JsonArray;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(JsonArray.class)
public interface JsonArrayInvoker {
    @Invoker("deepCopy")
    JsonArray invokeDeepCopy();
}