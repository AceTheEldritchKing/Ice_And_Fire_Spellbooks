package net.acetheeldritchking.ice_and_fire_spellbooks.registries;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber
public class CreativeTabRegistry {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IceAndFireSpellbooks.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MOD_TAB.register(eventBus);
    }

    public static final RegistryObject<CreativeModeTab> ARMOR_TAB = CREATIVE_MOD_TAB.
            register("ice_and_fire_spellbooks", () -> CreativeModeTab.builder()
                    .title(Component.translatable("tab.ice_and_fire_spellbooks.armor"))
                    .icon(() -> new ItemStack(ItemRegistries.DRAGONMANCERS_OATHBOOK.get()))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ItemRegistries.FIRE_DRAGON_PRIEST_HELMET.get());
                        pOutput.accept(ItemRegistries.FIRE_DRAGON_PRIEST_CHESTPLATE.get());
                        pOutput.accept(ItemRegistries.FIRE_DRAGON_PRIEST_LEGGINGS.get());
                        pOutput.accept(ItemRegistries.FIRE_DRAGON_PRIEST_BOOTS.get());
                        pOutput.accept(ItemRegistries.ICE_DRAGON_PRIEST_HELMET.get());
                        pOutput.accept(ItemRegistries.ICE_DRAGON_PRIEST_CHESTPLATE.get());
                        pOutput.accept(ItemRegistries.ICE_DRAGON_PRIEST_LEGGINGS.get());
                        pOutput.accept(ItemRegistries.ICE_DRAGON_PRIEST_BOOTS.get());
                        pOutput.accept(ItemRegistries.LIGHTNING_DRAGON_PRIEST_HELMET.get());
                        pOutput.accept(ItemRegistries.LIGHTNING_DRAGON_PRIEST_CHESTPLATE.get());
                        pOutput.accept(ItemRegistries.LIGHTNING_DRAGON_PRIEST_LEGGINGS.get());
                        pOutput.accept(ItemRegistries.LIGHTNING_DRAGON_PRIEST_BOOTS.get());
                        pOutput.accept(ItemRegistries.DRAGONMANCERS_OATHBOOK.get());
                        pOutput.accept(ItemRegistries.DRAGON_PRIEST_STAFF.get());
                        pOutput.accept(ItemRegistries.FIRE_DRAGON_PRIEST_STAFF.get());
                        pOutput.accept(ItemRegistries.ICE_DRAGON_PRIEST_STAFF.get());
                        pOutput.accept(ItemRegistries.LIGHTNING_DRAGON_PRIEST_STAFF.get());
                        pOutput.accept(ItemRegistries.TOORNAHKRIIN_MASK_HELMET.get());
                        pOutput.accept(ItemRegistries.FODAAN_MASK_HELMET.get());
                        pOutput.accept(ItemRegistries.VULONQO_MASK_HELMET.get());
                        pOutput.accept(ItemRegistries.VULNILVIIR_MASK_HELMET.get());
                        pOutput.accept(ItemRegistries.VULSILAH_MASK_HELMET.get());
                        pOutput.accept(ItemRegistries.WOODEN_DRAGON_PRIEST_MASK.get());
                    }))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .build());
}
