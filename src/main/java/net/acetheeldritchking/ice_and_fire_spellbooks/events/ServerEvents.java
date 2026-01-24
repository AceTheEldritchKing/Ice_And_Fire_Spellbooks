package net.acetheeldritchking.ice_and_fire_spellbooks.events;

import com.iafenvoy.iceandfire.registry.IafStatusEffects;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.DragonArmorItem;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class ServerEvents {
    @SubscribeEvent
    public static void onLivingTickEvent(PlayerTickEvent.Post event) {
        // Add compat for Frostward ring here
        Player livingEntity = event.getEntity();
        if (livingEntity instanceof ServerPlayer player) {
            // Remove I&F frozen effect if it has the ring
            if (ItemRegistry.FROSTWARD_RING.get().isEquippedBy(player)) {
                player.removeEffect((Holder) IafStatusEffects.FROZEN);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDamageEvent(LivingDamageEvent.Pre event) {
        // Hopefully this should apply dragon damage reduction to the Dragon Priest armor
        String damageType = event.getSource().getMsgId();
        String DRAGON_FIRE = "dragon_fire";
        String DRAGON_ICE = "dragon_ice";
        String DRAGON_LIGHTNING = "dragon_lightning";
        if (DRAGON_FIRE.equals(damageType) || DRAGON_ICE.equals(damageType) || DRAGON_LIGHTNING.equals(damageType)) {
            float multiplier = 1.0F;
            if (event.getEntity().getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof DragonArmorItem) {
                //System.out.println("Did head");
                multiplier -= 0.1F;
            }
            if (event.getEntity().getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof DragonArmorItem) {
                //System.out.println("Did chest");
                multiplier -= 0.3F;
            }
            if (event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof DragonArmorItem) {
                //System.out.println("Did legs");
                multiplier -= 0.2F;
            }
            if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof DragonArmorItem) {
                //System.out.println("Did feet");
                multiplier -= 0.1F;
            }

            //System.out.println("Reduced damage...");
            float baseAmount = event.getOriginalDamage();
            event.setNewDamage(baseAmount * multiplier);
        }
    }
}
