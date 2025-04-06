package net.anawesomguy.stone_utils;

import net.anawesomguy.wsmlmb.block.CustomCraftingTableBlock;
import net.anawesomguy.wsmlmb.block.chest.TexturedChestBlock;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShearsItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class StoneUtils implements ModInitializer {
    public static final String MOD_ID = "stone_utils";
    public static final Item STONE_SHEARS = registerItem(new ShearsItem(new Item.Settings().maxDamage(93).group(ItemGroup.TOOLS)), "stone_shears");
    public static final Item CERAMIC_SHEARS = registerItem(new ShearsItem(new Item.Settings().maxDamage(121).group(ItemGroup.TOOLS)), "ceramic_shears");
    public static final Item RAW_SHEARS_PART = registerMaterial("raw_shears_part");
    public static final Item BAKED_SHEARS_PART = registerMaterial("baked_shears_part");
    public static final Item STONE_ROD = registerMaterial("stone_rod");
    public static final Item STONE_PART = registerMaterial("stone_part");
    public static final Block STONE_CRAFTING_TABLE = registerBlock(
        new CustomCraftingTableBlock(
            Block.Settings.of(Material.STONE, MapColor.STONE_GRAY)
                .strength(2.2F, 5.5F)
                .sounds(BlockSoundGroup.STONE)
                .requiresTool()
        ), "stone_crafting_table"
    );
    public static final Item STONE_CRAFTING_TABLE_ITEM = registerBlockItem(STONE_CRAFTING_TABLE, "stone_crafting_table");
    public static final Block STONE_CHEST = registerBlock(
        new TexturedChestBlock.Builder(
            Block.Settings.of(Material.STONE, MapColor.STONE_GRAY)
                .strength(2.2F, 5.5F)
                .sounds(BlockSoundGroup.STONE)
                .requiresTool()
        ).setTextures(
            newID("entity/chest/stone_chest_normal"),
            newID("entity/chest/stone_chest_left"),
            newID("entity/chest/stone_chest_right")
        ).build(), "stone_chest"
    );
    public static final Item STONE_CHEST_ITEM = registerBlockItem(STONE_CHEST, "stone_chest");

    @Override
    public void onInitialize() {
        // nothing here
    }

    private static Block registerBlock(Block block, String id) {
        return Registry.register(Registry.BLOCK, newID(id), block);
    }

    private static Item registerBlockItem(Block block, String id) {
        // group is always decorations
        return registerItem(new BlockItem(block, new Item.Settings().group(ItemGroup.DECORATIONS)), id);
    }

    private static Item registerMaterial(String id) {
        return registerItem(new Item(new Item.Settings().group(ItemGroup.MATERIALS)), id);
    }

    private static Item registerItem(Item item, String id) {
        return Registry.register(Registry.ITEM, newID(id), item);
    }

    static Identifier newID(String id) {
        return new Identifier(MOD_ID, id);
    }
}