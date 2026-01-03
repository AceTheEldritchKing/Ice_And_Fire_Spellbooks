package net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import io.redspace.ironsspellbooks.item.weapons.StaffTier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class IFSStaffTier extends StaffTier implements IronsWeaponTier {
    public static IFSStaffTier DRAGON_PRIEST_STAFF = new IFSStaffTier(6, -3,
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.10f, AttributeModifier.Operation.MULTIPLY_BASE),
            new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.10f, AttributeModifier.Operation.MULTIPLY_BASE),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.10f, AttributeModifier.Operation.MULTIPLY_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.10f, AttributeModifier.Operation.MULTIPLY_BASE)
    );

    public static IFSStaffTier FIRE_DRAGON_PRIEST_STAFF = new IFSStaffTier(7, -3,
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.25f, AttributeModifier.Operation.MULTIPLY_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.20f, AttributeModifier.Operation.MULTIPLY_BASE)
    );

    public static IFSStaffTier ICE_DRAGON_PRIEST_STAFF = new IFSStaffTier(7, -3,
            new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.25f, AttributeModifier.Operation.MULTIPLY_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.20f, AttributeModifier.Operation.MULTIPLY_BASE)
    );

    public static IFSStaffTier LIGHTNING_DRAGON_PRIEST_STAFF = new IFSStaffTier(7, -3,
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.25f, AttributeModifier.Operation.MULTIPLY_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.20f, AttributeModifier.Operation.MULTIPLY_BASE)
    );

    float damage;
    float speed;
    AttributeContainer[] attributes;

    public IFSStaffTier(float damage, float speed, AttributeContainer... attributes)
    {
        super(damage, speed, attributes);
        this.damage = damage;
        this.speed = speed;
        this.attributes = attributes;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return this.attributes;
    }
}
