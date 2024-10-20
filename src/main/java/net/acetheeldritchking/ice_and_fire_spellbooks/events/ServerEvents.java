package net.acetheeldritchking.ice_and_fire_spellbooks.events;

import com.github.alexthe666.iceandfire.entity.props.EntityDataProvider;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.DragonArmorItem;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ServerEvents {
    @SubscribeEvent
    public static void onLivingTickEvent(LivingEvent.LivingTickEvent event)
    {
        // Add compat for Frostward ring here
        LivingEntity livingEntity = event.getEntity();
        if (livingEntity instanceof ServerPlayer player)
        {
            // Remove I&F frozen effect if it has the ring
            if (ItemRegistry.FROSTWARD_RING.get().isEquippedBy(player) && EntityDataProvider.getCapability(livingEntity).isPresent())
            {
                EntityDataProvider.getCapability(livingEntity).ifPresent(data -> data.frozenData.setFrozen(livingEntity, 0));
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDamageEvent(LivingHurtEvent event)
    {
        // Hopefully this should apply dragon damage reduction to the Dragon Priest armor
        String damageType = event.getSource().getMsgId();
        String DRAGON_FIRE = "dragon_fire";
        String DRAGON_ICE = "dragon_ice";
        String DRAGON_LIGHTNING = "dragon_lightning";
        if(DRAGON_FIRE.equals(damageType) || DRAGON_ICE.equals(damageType) || DRAGON_LIGHTNING.equals(damageType))
        {
            float multiplier = 1.0F;
            if (event.getEntity().getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof DragonArmorItem)
            {
                //System.out.println("Did head");
                multiplier -= 0.1F;
            }
            if (event.getEntity().getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof DragonArmorItem)
            {
                //System.out.println("Did chest");
                multiplier -= 0.3F;
            }
            if (event.getEntity().getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof DragonArmorItem)
            {
                //System.out.println("Did legs");
                multiplier -= 0.2F;
            }
            if (event.getEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof DragonArmorItem)
            {
                //System.out.println("Did feet");
                multiplier -= 0.1F;
            }

            //System.out.println("Reduced damage...");
            float baseAmount = event.getAmount();
            event.setAmount(baseAmount * multiplier);
        }
    }
}
