package net.anawesomguy.stone_shears.mixin;

import com.google.gson.JsonObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(JsonObject.class)
public interface JsonObjectInvoker {
    @Invoker("deepCopy")
    JsonObject invokeDeepCopy();
}