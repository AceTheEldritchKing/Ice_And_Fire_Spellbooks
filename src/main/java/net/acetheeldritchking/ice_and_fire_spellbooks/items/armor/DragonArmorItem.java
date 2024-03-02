package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public abstract class DragonArmorItem extends ArmorItem implements GeoItem {
    // Looking at how ISS does this...
    // And how ALTWG does this...
    // Please never ask me to do armor configs ever again /j
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private final DragonArmorMaterials material;

    public DragonArmorItem(DragonArmorMaterials material, Type type, Properties settings) {
        super(material, type, settings.stacksTo(1));
        this.material = material;
    }

    public DragonArmorMaterials getMaterial()
    {
        return this.material;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        if (pEquipmentSlot == this.type.getSlot())
        {
            return this.material.getSlotToAttributeMap().get(pEquipmentSlot);
        }
        else
        {
            return ImmutableMultimap.of();
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<DragonArmorItem>(this, "controller", 20, this::predicate));
    }

    private PlayState predicate(AnimationState<DragonArmorItem> dragonArmorItemAnimationState) {
        dragonArmorItemAnimationState.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache()
    {
        return this.cache;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original)
            {
                if (this.renderer == null)
                {
                    this.renderer = supplyRenderer();
                }

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    @OnlyIn(Dist.CLIENT)
    public abstract GeoArmorRenderer<?> supplyRenderer();
}
