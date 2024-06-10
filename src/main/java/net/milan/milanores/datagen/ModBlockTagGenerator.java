package net.milan.milanores.datagen;

import net.milan.milanores.MilanOres;
import net.milan.milanores.block.ModBlocks;
import net.milan.milanores.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MilanOres.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.TOPAZ_BLOCK.get(),
                ModBlocks.RAW_TOPAZ_BLOCK.get(),
                ModBlocks.RAW_DEEPSLATE_TOPAZ_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.RUBY_BLOCK.get(),
                ModBlocks.RAW_RUBY_BLOCK.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                ModBlocks.RAW_ENDSTONE_SAPPHIRE_BLOCK.get()
        );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.RUBY_BLOCK.get(),
                ModBlocks.TOPAZ_BLOCK.get(),
                ModBlocks.RAW_RUBY_BLOCK.get(),
                ModBlocks.RAW_TOPAZ_BLOCK.get(),
                ModBlocks.RAW_DEEPSLATE_TOPAZ_BLOCK.get(),
                ModBlocks.RAW_ENDSTONE_SAPPHIRE_BLOCK.get());


    }
}
