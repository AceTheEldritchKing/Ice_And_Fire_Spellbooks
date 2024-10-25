package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.ice_and_fire_spellbooks.config.ArmorValueConfig;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Map;
import java.util.function.Supplier;

public enum DragonArmorMaterials implements IFSArmorMaterial {
    /*
        Netherite
        NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
          return Ingredient.of(Items.NETHERITE_INGOT);
        });
    */
    // Fire Dragon Priest Regalia
    FIRE_DRAGON_PRIEST("fire_dragon_priest", 39, ArmorValueConfig.dragonsteelArmorValue, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get()), Map.of(
            AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 175, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier("Fire Power", .1, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", .05, AttributeModifier.Operation.MULTIPLY_BASE)
    )),

    // Ice Dragon Priest Regalia
    ICE_DRAGON_PRIEST("ice_dragon_priest", 39, ArmorValueConfig.dragonsteelArmorValue, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get()), Map.of(
            AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 175, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.ICE_SPELL_POWER.get(), new AttributeModifier("Ice Power", .1, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", .05, AttributeModifier.Operation.MULTIPLY_BASE)
    )),

    // Lightning Dragon Priest Regalia
    LIGHTNING_DRAGON_PRIEST("lightning_dragon_priest", 39, ArmorValueConfig.dragonsteelArmorValue, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get()), Map.of(
            AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 175, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.LIGHTNING_SPELL_POWER.get(), new AttributeModifier("Lightning Power", .1, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", .05, AttributeModifier.Operation.MULTIPLY_BASE)
    )),

    // Toornahkriin Dragon Mask (Fire)
    TOORNAHKRIIN_MASK("toornahkriin", 25, ArmorValueConfig.dragonsteelMaskArmorValue, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get()), Map.of(
            AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 225, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.MANA_REGEN.get(), new AttributeModifier("Mana Regen", .30, AttributeModifier.Operation.MULTIPLY_TOTAL),
            AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier("Fire Power", .15, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", .05, AttributeModifier.Operation.MULTIPLY_BASE),
            Attributes.ATTACK_DAMAGE, new AttributeModifier("minus_damage", -0.20, AttributeModifier.Operation.MULTIPLY_TOTAL)
    )),

    // Fodaan Dragon Mask (Ice)
    FODAAN_MASK("fodaan", 25, ArmorValueConfig.dragonsteelMaskArmorValue, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get()), Map.of(
            AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 225, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.MANA_REGEN.get(), new AttributeModifier("Mana Regen", .30, AttributeModifier.Operation.MULTIPLY_TOTAL),
            AttributeRegistry.ICE_SPELL_POWER.get(), new AttributeModifier("Ice Power", .15, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", .05, AttributeModifier.Operation.MULTIPLY_BASE),
            Attributes.ATTACK_DAMAGE, new AttributeModifier("minus_damage", -0.20, AttributeModifier.Operation.MULTIPLY_TOTAL)
    )),

    // Vulonqo Dragon Mask (Lightning)
    VULONQO_MASK("vulonqo", 25, ArmorValueConfig.dragonsteelMaskArmorValue, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get()), Map.of(
            AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 225, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.MANA_REGEN.get(), new AttributeModifier("Mana Regen", .30, AttributeModifier.Operation.MULTIPLY_TOTAL),
            AttributeRegistry.LIGHTNING_SPELL_POWER.get(), new AttributeModifier("Lightning Power", .15, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", .05, AttributeModifier.Operation.MULTIPLY_BASE),
            Attributes.ATTACK_DAMAGE, new AttributeModifier("minus_damage", -0.20, AttributeModifier.Operation.MULTIPLY_TOTAL)
    )),

    // Vulnilviir Dragon Mask (Ender)
    VULNILVIIR_MASK("vulnilviir", 25, ArmorValueConfig.dragonsteelMaskArmorValue, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.1F, () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()), Map.of(
            AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 225, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.MANA_REGEN.get(), new AttributeModifier("Mana Regen", .30, AttributeModifier.Operation.MULTIPLY_TOTAL),
            AttributeRegistry.ENDER_SPELL_POWER.get(), new AttributeModifier("Ender Power", .15, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", .05, AttributeModifier.Operation.MULTIPLY_BASE),
            Attributes.ATTACK_DAMAGE, new AttributeModifier("minus_damage", -0.20, AttributeModifier.Operation.MULTIPLY_TOTAL)
    )),

    // Vulsilah Dragon Mask (Eldritch)
    VULSILAH_MASK("vulsilah", 25, ArmorValueConfig.dragonsteelMaskArmorValue, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.1F, () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()), Map.of(
            AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 225, AttributeModifier.Operation.ADDITION),
            AttributeRegistry.MANA_REGEN.get(), new AttributeModifier("Mana Regen", .30, AttributeModifier.Operation.MULTIPLY_TOTAL),
            AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier("Eldritch Power", .15, AttributeModifier.Operation.MULTIPLY_BASE),
            AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", .05, AttributeModifier.Operation.MULTIPLY_BASE),
            Attributes.ATTACK_DAMAGE, new AttributeModifier("minus_damage", -0.20, AttributeModifier.Operation.MULTIPLY_TOTAL)
    ));

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final ArmorValueConfig.ArmorValues slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;
    private final Map<Attribute, AttributeModifier> additionalAttributes;

    private DragonArmorMaterials(String pName, int pDurabilityMultiplier, ArmorValueConfig.ArmorValues pSlotProtections, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient, Map<Attribute, AttributeModifier> additionalAttributes) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.slotProtections = pSlotProtections;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
        this.additionalAttributes = additionalAttributes;
    }

    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot pSlot) {
        // FUCK YOU CONFIGS
        try{
            return ArmorValueConfig.dragonsteelArmorValue.armor().get().get(pSlot.getIndex());
        }catch (Exception e){
            return -1;
        }
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public Map<Attribute, AttributeModifier> getAdditionalAttributes() {
        return additionalAttributes;
    }

    /**
     * Gets the percentage of knockback resistance provided by armor of the material.
     */
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

