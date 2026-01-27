package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.registries.ArmorMaterialRegistries;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public abstract class DragonArmorItem extends ArmorItem implements GeoItem {
    // Looking at how ISS does this...
    // And how ALTWG does this...
    // Please never ask me to do armor configs ever again /j
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public DragonArmorItem(Holder<ArmorMaterial> material, Type type, Properties settings) {
        super(material, type, settings.stacksTo(1).attributes(ArmorMaterialRegistries.makeAttributeMap(material, type)));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 20, this::predicate));
    }

    private PlayState predicate(AnimationState<DragonArmorItem> dragonArmorItemAnimationState) {
        dragonArmorItemAnimationState.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @SuppressWarnings("removal")
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null) this.renderer = DragonArmorItem.this.supplyRenderer();
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @OnlyIn(Dist.CLIENT)
    public abstract GeoArmorRenderer<?> supplyRenderer();
}
