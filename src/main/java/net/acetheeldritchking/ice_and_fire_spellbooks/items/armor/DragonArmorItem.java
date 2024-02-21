package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
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

import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public abstract class DragonArmorItem extends ArmorItem implements GeoItem {
    // Looking at how ISS does this...
    private static final UUID[] ARMOR_ATTRIBUTE_UUID_PER_SLOT = new UUID[]
            {UUID.fromString("F7BFFA65-547A-49D2-8804-3D533070E432"),
                    UUID.fromString("B05AF2C0-5862-4CE6-860A-522C11E1571A"),
                    UUID.fromString("15C1FE6B-3596-412A-B6CF-4077CB37140F"),
                    UUID.fromString("82A575D1-366A-4BBD-91F8-25DB6B804F06")};
    private final Multimap<Attribute, AttributeModifier> ARMOR_ATTRIBUTES;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public DragonArmorItem(DragonArmorMaterials materialIn, Type type, Properties settings) {
        super(materialIn, type, settings);
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        float defense = materialIn.getDefenseForType(type);
        float toughness = materialIn.getToughness();
        float knockbackResistance = materialIn.getKnockbackResistance();
        UUID uuid = ARMOR_ATTRIBUTE_UUID_PER_SLOT[type.getSlot().getIndex()];
        builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier",
                defense, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness",
                toughness, AttributeModifier.Operation.ADDITION));
        if (knockbackResistance > 0)
        {
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance",
                    knockbackResistance, AttributeModifier.Operation.ADDITION));
        }
        for (Map.Entry<Attribute, AttributeModifier> modifierEntry : materialIn.getAdditionalAttributes().entrySet())
        {
            AttributeModifier atr = modifierEntry.getValue();
            atr = new AttributeModifier(uuid, atr.getName(), atr.getAmount(), atr.getOperation());
            builder.put(modifierEntry.getKey(), atr);
        }
        ARMOR_ATTRIBUTES = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        if (pEquipmentSlot == this.type.getSlot())
        {
            return ARMOR_ATTRIBUTES;
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
