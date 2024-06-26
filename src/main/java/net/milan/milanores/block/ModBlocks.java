package net.milan.milanores.block;

import net.milan.milanores.MilanOres;
import net.milan.milanores.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MilanOres.MODID);

    public static final RegistryObject<Block> RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> RAW_TOPAZ_BLOCK = registerBlock("raw_topaz_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK), UniformInt.of(1, 2)));

    public static final RegistryObject<Block> RAW_DEEPSLATE_TOPAZ_BLOCK = registerBlock("raw_deepslate_topaz_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE), UniformInt.of(2, 2)));

    public static final RegistryObject<Block> RAW_ENDSTONE_SAPPHIRE_BLOCK = registerBlock("raw_endstone_sapphire_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE), UniformInt.of(2, 7)));

    /*
    Credits For Textures: https://www.youtube.com/watch?v=o6Xbp2dTEGA&list=PLKGarocXCE1H9Y21-pxjt5Pt8bW14twa-&index=2&t=781s
     */
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> TOPAZ_BLOCK = registerBlock("topaz_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
