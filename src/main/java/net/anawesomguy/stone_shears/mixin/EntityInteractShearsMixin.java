package net.anawesomguy.stone_shears.mixin;

import net.anawesomguy.stone_shears.StoneShears;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({SheepEntity.class, SnowGolemEntity.class})
public abstract class EntityInteractShearsMixin {
    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"), method = {"interactMob"})
    private boolean isShears(ItemStack stack, Item item) {
        return stack.isOf(StoneShears.STONE_SHEARS) || stack.isOf(item);
    }
}