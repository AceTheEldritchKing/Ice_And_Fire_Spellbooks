package net.acetheeldritchking.ice_and_fire_spellbooks.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.item.UniqueSpellBook;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.util.LazyOptional;

import java.util.UUID;

public class DragonPriestStaffItem extends UniqueSpellBook {
    private final LazyOptional<Multimap<Attribute, AttributeModifier>> lazyOptional;

    public DragonPriestStaffItem(SpellDataRegistryHolder[] spells) {
        super(SpellRarity.EPIC, spells);
        lazyOptional = LazyOptional.of(this::buildAttributeMap);
    }

    private Multimap<Attribute, AttributeModifier> buildAttributeMap()
    {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", 8, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", -3, AttributeModifier.Operation.ADDITION));
        builder.put(AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", 0.20, AttributeModifier.Operation.MULTIPLY_BASE));
        builder.put(AttributeRegistry.ICE_SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", 0.20, AttributeModifier.Operation.MULTIPLY_BASE));
        builder.put(AttributeRegistry.LIGHTNING_SPELL_POWER.get(), new AttributeModifier(UUID.fromString("667ad88f-901d-4691-b2a2-3664e42026d3"), "Weapon modifier", 0.20, AttributeModifier.Operation.MULTIPLY_BASE));
        return builder.build();
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot)
    {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.lazyOptional.resolve().get() : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }
}
