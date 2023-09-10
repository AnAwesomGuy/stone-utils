package net.anawesomguy.stone_utils.mixin;

import com.google.gson.JsonArray;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(JsonArray.class)
public interface JsonArrayInvoker {
    @Invoker(value = "deepCopy", remap = false)
    JsonArray invokeDeepCopy();
}