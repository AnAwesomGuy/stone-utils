package net.anawesomguy.stone_utils.mixin;

import net.anawesomguy.stone_utils.StoneUtils;
import net.minecraft.block.TripwireBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TripwireBlock.class)
public abstract class TripwireBlockMixin {
    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"), method = "onBreak")
    private boolean isShears(ItemStack stack, Item item) {
        return stack.isOf(StoneUtils.STONE_SHEARS) || stack.isOf(item);
    }
}