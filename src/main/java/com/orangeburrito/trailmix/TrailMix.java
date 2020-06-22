package com.orangeburrito.trailmix;

import com.orangeburrito.trailmix.init.BlockInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("trailmix")
public class TrailMix {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "trailmix";
    public static TrailMix instance;


    public TrailMix() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    public static class TrailMixItemGroup extends ItemGroup {
        public static final TrailMixItemGroup instance = new TrailMixItemGroup(ItemGroup.GROUPS.length, "trailmixtab");
        private TrailMixItemGroup(int index, String label) {
            super(index, label);
        }
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockInit.old_stonecutter);
        }
    }
}
