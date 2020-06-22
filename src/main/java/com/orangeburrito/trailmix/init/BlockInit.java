package com.orangeburrito.trailmix.init;

import com.orangeburrito.trailmix.TrailMix;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = TrailMix.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(TrailMix.MOD_ID)
public class BlockInit {
    public static final Block old_stonecutter = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5f, 3.5f).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)).setRegistryName("old_stonecutter"));
    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(old_stonecutter, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName("old_stonecutter"));
    }
}
