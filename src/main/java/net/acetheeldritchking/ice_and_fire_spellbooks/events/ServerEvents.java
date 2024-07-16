package net.acetheeldritchking.ice_and_fire_spellbooks.events;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ServerEvents {
    @SubscribeEvent
    public static void onLivingTickEvent(LivingEvent.LivingTickEvent event)
    {
        // Add compat for Frostward ring here
        Player player = (Player) event.getEntity();
        if (player != null)
        {
            // Remove I&F frozen effect if it has the ring
        }
    }
}
