package com.orangeburrito.trailmix.init;

import com.orangeburrito.trailmix.TrailMix;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = TrailMix.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(TrailMix.MOD_ID)
public class ItemInit {
    public static final Item baguette = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC))
                .setRegistryName("baguette"));
    }
}
