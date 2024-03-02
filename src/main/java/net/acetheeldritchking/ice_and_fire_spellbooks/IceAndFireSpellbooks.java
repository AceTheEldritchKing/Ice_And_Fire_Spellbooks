package net.acetheeldritchking.ice_and_fire_spellbooks;

import com.mojang.logging.LogUtils;
import net.acetheeldritchking.ice_and_fire_spellbooks.config.ArmorValueConfig;
import net.acetheeldritchking.ice_and_fire_spellbooks.registries.CreativeTabRegistry;
import net.acetheeldritchking.ice_and_fire_spellbooks.registries.ItemRegistries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IceAndFireSpellbooks.MOD_ID)
public class IceAndFireSpellbooks
{
    public static final String MOD_ID = "ice_and_fire_spellbooks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public IceAndFireSpellbooks()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Items
        ItemRegistries.register(modEventBus);
        // Creative Menu
        CreativeTabRegistry.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        // Configs
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ArmorValueConfig.SPEC, "ice_and_fire_spellbooks.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // nada
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        // Rendering armor
        /*@SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.AddLayers event)
        {
            GeoArmorRenderer.registerArmorRenderer(FireDragonPriestArmorItem.class, () -> new GenericCustomArmorRenderer(new FireDragonPriestArmorModel()));
            GeoArmorRenderer.registerArmorRenderer(IceDragonPriestArmorItem.class, () -> new GenericCustomArmorRenderer(new IceDragonPriestArmorModel()));
            GeoArmorRenderer.registerArmorRenderer(LightningDragonPriestArmorItem.class, () -> new GenericCustomArmorRenderer(new LightningDragonPriestArmorModel()));
        }*/

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // nada
        }
    }
}
