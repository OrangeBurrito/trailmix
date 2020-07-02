package com.orangeburrito.trailmix.init;

import com.orangeburrito.trailmix.TrailMix;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<Item>(ForgeRegistries.ITEMS, TrailMix.MOD_ID);

    public static final RegistryObject<Item> BAGUETTE = ITEMS.register("baguette", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(15).saturation(6.0F).build())));
    public static final RegistryObject<Item> CHICKEN_NUGGET = ITEMS.register("chicken_nugget", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.8F).effect(new EffectInstance(Effects.POISON, 60, 1), 0.3f).build())));
    public static final RegistryObject<Item> COOKED_CHICKEN_NUGGET = ITEMS.register("cooked_chicken_nugget", () -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(3).saturation(1.4F).build())));
}
