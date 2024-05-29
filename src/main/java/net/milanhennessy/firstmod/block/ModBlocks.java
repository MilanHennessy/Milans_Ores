package net.milanhennessy.firstmod.block;

import net.milanhennessy.firstmod.FirstMod;
import net.milanhennessy.firstmod.item.Moditems;
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
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMod.MODID);

    public static final RegistryObject<Block> RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.RAW_GOLD_BLOCK), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return Moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
