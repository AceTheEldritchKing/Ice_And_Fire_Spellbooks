package net.acetheeldritchking.ice_and_fire_spellbooks;

import com.mojang.logging.LogUtils;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import net.acetheeldritchking.ice_and_fire_spellbooks.config.ArmorValueConfig;
import net.acetheeldritchking.ice_and_fire_spellbooks.loot.IFSLootModifiers;
import net.acetheeldritchking.ice_and_fire_spellbooks.registries.ArmorMaterialRegistries;
import net.acetheeldritchking.ice_and_fire_spellbooks.registries.CreativeTabRegistry;
import net.acetheeldritchking.ice_and_fire_spellbooks.registries.ItemRegistries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(IceAndFireSpellbooks.MOD_ID)
public class IceAndFireSpellbooks {
    public static final String MOD_ID = "ice_and_fire_spellbooks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public IceAndFireSpellbooks(ModContainer container, IEventBus bus) {
        // Configs
        container.registerConfig(ModConfig.Type.STARTUP, ArmorValueConfig.SPEC, MOD_ID + ".toml");

        // Armor Materials
        ArmorMaterialRegistries.register(bus);
        // Items
        ItemRegistries.register(bus);
        // Creative Menu
        CreativeTabRegistry.register(bus);
        // Loot Tables
        IFSLootModifiers.register(bus);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // curios :3c
            event.enqueueWork(() -> {
                ItemRegistries.getIFSItems().stream().filter(item -> item.get() instanceof SpellBook).forEach((item) -> CuriosRendererRegistry.register(item.get(), SpellBookCurioRenderer::new));
            });
        }
    }
}
