package net.milan.milanores.datagen.loot;

import net.milan.milanores.block.ModBlocks;
import net.milan.milanores.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.TOPAZ_BLOCK.get());

        this.dropOther(ModBlocks.RAW_RUBY_BLOCK.get(), ModItems.RUBY.get());
        this.dropOther(ModBlocks.RAW_TOPAZ_BLOCK.get(), ModItems.TOPAZ.get());
        this.dropOther(ModBlocks.RAW_DEEPSLATE_TOPAZ_BLOCK.get(), ModItems.TOPAZ.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
