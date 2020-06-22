package com.orangeburrito.trailmix.init;

import com.orangeburrito.trailmix.TrailMix;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = TrailMix.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(TrailMix.MOD_ID)
public class ItemInit {
    public static final Item baguette = null;
    public static final Item chicken_nugget = null;
    public static final Item cooked_chicken_nugget = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item(new Item.Properties().group(TrailMix.TrailMixItemGroup.instance).food(new Food.Builder().hunger(15).saturation(6.0F).build())).setRegistryName("baguette"));
        event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.8F).effect(new EffectInstance(Effects.POISON, 60, 1), 0.3f).build())).setRegistryName("chicken_nugget"));
        event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(3).saturation(1.4F).build())).setRegistryName("cooked_chicken_nugget"));
    }
}
