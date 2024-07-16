package net.acetheeldritchking.ice_and_fire_spellbooks;

import com.mojang.logging.LogUtils;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import net.acetheeldritchking.ice_and_fire_spellbooks.config.ArmorValueConfig;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor.*;
import net.acetheeldritchking.ice_and_fire_spellbooks.events.ServerEvents;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.*;
import net.acetheeldritchking.ice_and_fire_spellbooks.registries.ItemRegistries;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
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
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(IceAndFireSpellbooks.MOD_ID)
public class IceAndFireSpellbooks
{
    public static final String MOD_ID = "ice_and_fire_spellbooks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public IceAndFireSpellbooks()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Event Handlers
        MinecraftForge.EVENT_BUS.register(new ServerEvents());
        // Items
        ItemRegistries.register(modEventBus);

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
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.AddLayers event)
        {
            // Dragon Priest Armor
            GeoArmorRenderer.registerArmorRenderer(FireDragonPriestArmorItem.class, () -> new GenericCustomArmorRenderer(new FireDragonPriestArmorModel()));
            GeoArmorRenderer.registerArmorRenderer(IceDragonPriestArmorItem.class, () -> new GenericCustomArmorRenderer(new IceDragonPriestArmorModel()));
            GeoArmorRenderer.registerArmorRenderer(LightningDragonPriestArmorItem.class, () -> new GenericCustomArmorRenderer(new LightningDragonPriestArmorModel()));

            // Dragon Priest Masks
            GeoArmorRenderer.registerArmorRenderer(ToornahkriinDragonPriestMaskItem.class, () -> new GenericCustomArmorRenderer(new ToornahkriinDragonPriestMaskModel()));
            GeoArmorRenderer.registerArmorRenderer(FodaanDragonPriestMaskItem.class, () -> new GenericCustomArmorRenderer(new FodaanDragonPriestMaskModel()));
            GeoArmorRenderer.registerArmorRenderer(VulonqoDragonPriestMaskItem.class, () -> new GenericCustomArmorRenderer(new VulonqoDragonPriestMaskModel()));
            GeoArmorRenderer.registerArmorRenderer(VulnilviirDragonPriestMaskItem.class, () -> new GenericCustomArmorRenderer(new VulnilviirDragonPriestMaskModel()));
            GeoArmorRenderer.registerArmorRenderer(VulsilahDragonPriestMaskItem.class, () -> new GenericCustomArmorRenderer(new VulsilahDragonPriestMaskModel()));
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // curio :3c
            event.enqueueWork(() -> {
                ItemRegistries.getIFSItems().stream().filter(item -> item.get() instanceof SpellBook).forEach((item) -> CuriosRendererRegistry.register(item.get(), SpellBookCurioRenderer::new));
            });
        }
    }
}
