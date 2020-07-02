package com.orangeburrito.trailmix.init;

import com.orangeburrito.trailmix.TrailMix;
import com.orangeburrito.trailmix.objects.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TrailMix.MOD_ID);


    public static final RegistryObject<Block> OLD_STONECUTTER = BLOCKS.register("old_stonecutter", () -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.5f).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SODA_MACHINE = BLOCKS.register("soda_machine", () -> new SodaMachine(Block.Properties.create(Material.IRON).hardnessAndResistance(3.5f, 4.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL).lightValue(4)));
    public static final RegistryObject<Block> TENT = BLOCKS.register("tent", () -> new Tent(Block.Properties.create(Material.WOOL).hardnessAndResistance(1.0f, 1.0f).harvestLevel(0).harvestTool(ToolType.AXE).sound(SoundType.CLOTH)));
    public static final RegistryObject<Block> SACK = BLOCKS.register("sack", () -> new Sack(Block.Properties.create(Material.WOOL).hardnessAndResistance(1.0f, 1.0f).harvestLevel(0).harvestTool(ToolType.AXE).sound(SoundType.CLOTH)));
    public static final RegistryObject<Block> LAPTOP_0 = BLOCKS.register("laptop_0", () -> new Laptop0(Block.Properties.create(Material.IRON).hardnessAndResistance(4.5f, 5f).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
    public static final RegistryObject<Block> GAMECUBE = BLOCKS.register("gamecube", () -> new Gamecube(Block.Properties.create(Material.IRON).hardnessAndResistance(4.5f, 5f).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
    public static final RegistryObject<Block> CRT = BLOCKS.register("crt", () -> new CRT(Block.Properties.create(Material.IRON).hardnessAndResistance(4.5f, 5f).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
    public static final RegistryObject<Block> BUSTED_TV = BLOCKS.register("busted_tv", () -> new BustedTV(Block.Properties.create(Material.IRON).hardnessAndResistance(4.5f, 5f).harvestLevel(0).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
}
