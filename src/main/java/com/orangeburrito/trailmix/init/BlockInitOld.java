//package com.orangeburrito.trailmix.init;
//
//import com.orangeburrito.trailmix.TrailMix;
//import com.orangeburrito.trailmix.objects.blocks.OldStonecutter;
//import com.orangeburrito.trailmix.objects.blocks.SodaMachine;
//import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.SoundType;
//import net.minecraft.block.material.Material;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraftforge.common.ToolType;
//import net.minecraftforge.event.RegistryEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.registries.ObjectHolder;
//
//@Mod.EventBusSubscriber(modid = TrailMix.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
//@ObjectHolder(TrailMix.MOD_ID)
//public class BlockInit {
//    public static final Block old_stonecutter = null;
//    public static final Block soda_machine = null;
//
//    @SubscribeEvent
//    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
//        event.getRegistry().register(new OldStonecutter(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5f, 3.5f).harvestTool(ToolType.PICKAXE).harvestLevel(0).sound(SoundType.STONE)).setRegistryName("old_stonecutter"));
//        event.getRegistry().register(new SodaMachine(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).lightValue(4).harvestLevel(0).sound(SoundType.STONE)).setRegistryName("soda_machine"));
//    }
//
//    @SubscribeEvent
//    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
//        event.getRegistry().register(new BlockItem(old_stonecutter, new Item.Properties().group(TrailMix.TrailMixItemGroup.instance)).setRegistryName("old_stonecutter"));
//        event.getRegistry().register(new BlockItem(soda_machine, new Item.Properties().group(TrailMix.TrailMixItemGroup.instance)).setRegistryName("soda_machine"));
//    }
//}
