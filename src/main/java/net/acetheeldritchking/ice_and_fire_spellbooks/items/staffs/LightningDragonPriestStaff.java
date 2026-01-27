package net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs;

import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.renderer.item.IceDragonPriestStaffRenderer;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.renderer.item.LightningDragonPriestStaffRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class LightningDragonPriestStaff extends StaffItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public LightningDragonPriestStaff() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), IFSStaffTier.LIGHTNING_DRAGON_PRIEST_STAFF);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private LightningDragonPriestStaffRenderer renderer = null;

            // Don't instantiate until ready. This prevents race conditions breaking things
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null)
                    this.renderer = new LightningDragonPriestStaffRenderer();

                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
