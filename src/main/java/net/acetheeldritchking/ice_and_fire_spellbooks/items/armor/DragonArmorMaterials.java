package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.ice_and_fire_spellbooks.config.ArmorValueConfig;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.UUID;
import java.util.function.Supplier;

public enum DragonArmorMaterials implements ArmorMaterial {
    /*
        Netherite
        NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
          return Ingredient.of(Items.NETHERITE_INGOT);
        });
    */
    // Fire Dragon Priest Regalia
    FIRE_DRAGON_PRIEST("fire_dragon_priest", 39, ArmorValueConfig.dragonsteelArmorValue, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get())
    ),
    /*
    , Map.of(
            //AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 150, AttributeModifier.Operation.ADDITION),
            //AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier("Fire Power", .1, AttributeModifier.Operation.MULTIPLY_BASE)
     */

    // Ice Dragon Priest Regalia
    ICE_DRAGON_PRIEST("ice_dragon_priest", 39, ArmorValueConfig.dragonsteelArmorValue, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get())
    ),
    /*
    , Map.of(
            //AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 150, AttributeModifier.Operation.ADDITION),
            //AttributeRegistry.ICE_SPELL_POWER.get(), new AttributeModifier("Ice Power", .1, AttributeModifier.Operation.MULTIPLY_BASE)
     */

    // Lightning Dragon Priest Regalia
    LIGHTNING_DRAGON_PRIEST("lightning_dragon_priest", 39, ArmorValueConfig.dragonsteelArmorValue, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get())
    ),
    /*
    , Map.of(
            //AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 150, AttributeModifier.Operation.ADDITION),
            //AttributeRegistry.LIGHTNING_SPELL_POWER.get(), new AttributeModifier("Lightning Power", .1, AttributeModifier.Operation.MULTIPLY_BASE)
     */

    // Toornahkriin Dragon Mask (Fire)
    TOORNAHKRIIN_MASK("toornahkriin", 25, ArmorValueConfig.dragonsteelMaskArmorValue, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get())
    ),

    // Fodaan Dragon Mask (Ice)
    FODAAN_MASK("fodaan", 25, ArmorValueConfig.dragonsteelMaskArmorValue, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get())
    ),

    // Vulonqo Dragon Mask (Lightning)
    VULONQO_MASK("vulonqo", 25, ArmorValueConfig.dragonsteelMaskArmorValue, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.1F, () -> Ingredient.of(IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get())
    ),

    // Vulnilviir Dragon Mask (Ender)
    VULNILVIIR_MASK("vulnilviir", 25, ArmorValueConfig.dragonsteelMaskArmorValue, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.1F, () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get())
    ),

    // Vulsilah Dragon Mask (Eldritch)
    VULSILAH_MASK("vulsilah", 25, ArmorValueConfig.dragonsteelMaskArmorValue, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 2.0F, 0.1F, () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get())
    );

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final ArmorValueConfig.ArmorValues protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private DragonArmorMaterials(String pName, int pDurabilityMultiplier, ArmorValueConfig.ArmorValues protectionMap, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.protectionFunctionForType = protectionMap;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
        slotToAttributeMap = null;
    }

    private EnumMap<EquipmentSlot, Multimap<Attribute, AttributeModifier>> slotToAttributeMap;

    public EnumMap<EquipmentSlot, Multimap<Attribute, AttributeModifier>> getSlotToAttributeMap()
    {
        if (slotToAttributeMap == null)
        {
            slotToAttributeMap = makeSlotToAttributeMap();
        }
        return slotToAttributeMap;
    }

    private EnumMap<EquipmentSlot, Multimap<Attribute, AttributeModifier>> makeSlotToAttributeMap()
    {
        return Util.make(new EnumMap<>(EquipmentSlot.class), (p_266655_) -> {
            p_266655_.put(EquipmentSlot.FEET, makeAttributeMap(EquipmentSlot.FEET));
            p_266655_.put(EquipmentSlot.LEGS, makeAttributeMap(EquipmentSlot.LEGS));
            p_266655_.put(EquipmentSlot.CHEST, makeAttributeMap(EquipmentSlot.CHEST));
            p_266655_.put(EquipmentSlot.HEAD, makeAttributeMap(EquipmentSlot.HEAD));
        });
    }

    private static final UUID[] ARMOR_ATTRIBUTE_UUID_PER_SLOT = new UUID[]
            {UUID.fromString("F7BFFA65-547A-49D2-8804-3D533070E432"),
                    UUID.fromString("B05AF2C0-5862-4CE6-860A-522C11E1571A"),
                    UUID.fromString("15C1FE6B-3596-412A-B6CF-4077CB37140F"),
                    UUID.fromString("82A575D1-366A-4BBD-91F8-25DB6B804F06")};

    private Multimap<Attribute, AttributeModifier> makeAttributeMap(EquipmentSlot slot)
    {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        UUID uuid = ARMOR_ATTRIBUTE_UUID_PER_SLOT[slot.getIndex()];
        int protection = this.protectionFunctionForType.getProtectionValues(slot);
        float toughness = this.toughness;
        float knockbackResistance = this.knockbackResistance;
        double maxMana = 150;
        double firePower = 0.1D;
        double icePower = 0.1D;
        double lightningPower = 0.1D;
        // Dragon Priest
        double maxManaMask = 225;
        double manaRegen = 0.30D;
        double firePowerMask = 0.15D;
        double icePowerMask = 0.15D;
        double lightningPowerMask = 0.15D;
        double enderPowerMask = 0.15D;
        double eldritchPowerMask = 0.15D;
        double reduceDamage = -0.20D;
        if (protection != 0)
        {
            builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "Armor modifier", protection, AttributeModifier.Operation.ADDITION));
        }
        if (toughness != 0)
        {
            builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(uuid, "Armor toughness", toughness, AttributeModifier.Operation.ADDITION));
        }
        if (knockbackResistance > 0)
        {
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Armor knockback resistance",
                    knockbackResistance, AttributeModifier.Operation.ADDITION));
        }
        if (maxMana != 0 && (DragonArmorMaterials.this == FIRE_DRAGON_PRIEST || DragonArmorMaterials.this == ICE_DRAGON_PRIEST || DragonArmorMaterials.this == LIGHTNING_DRAGON_PRIEST))
        {
            builder.put(AttributeRegistry.MAX_MANA.get(), new AttributeModifier(uuid, "Armor maxMana",
                    maxMana, AttributeModifier.Operation.ADDITION));
        }
        if (firePower != 0 && DragonArmorMaterials.this == FIRE_DRAGON_PRIEST)
        {
            builder.put(AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier(uuid, "Fire power",
                    firePower, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        if (icePower != 0 && DragonArmorMaterials.this == ICE_DRAGON_PRIEST)
        {
            builder.put(AttributeRegistry.ICE_SPELL_POWER.get(), new AttributeModifier(uuid, "Ice power",
                    icePower, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        if (lightningPower != 0 && DragonArmorMaterials.this == LIGHTNING_DRAGON_PRIEST)
        {
            builder.put(AttributeRegistry.LIGHTNING_SPELL_POWER.get(), new AttributeModifier(uuid, "Lightning power",
                    lightningPower, AttributeModifier.Operation.MULTIPLY_BASE));
        }

        // Dragon Priest Masks //
        if (maxManaMask != 0 && (DragonArmorMaterials.this == TOORNAHKRIIN_MASK || DragonArmorMaterials.this == FODAAN_MASK || DragonArmorMaterials.this == VULONQO_MASK || DragonArmorMaterials.this == VULNILVIIR_MASK || DragonArmorMaterials.this == VULSILAH_MASK))
        {
            builder.put(AttributeRegistry.MAX_MANA.get(), new AttributeModifier(uuid, "Armor maxMana",
                    maxManaMask, AttributeModifier.Operation.ADDITION));
        }
        if (manaRegen != 0 && (DragonArmorMaterials.this == TOORNAHKRIIN_MASK || DragonArmorMaterials.this == FODAAN_MASK || DragonArmorMaterials.this == VULONQO_MASK || DragonArmorMaterials.this == VULNILVIIR_MASK || DragonArmorMaterials.this == VULSILAH_MASK))
        {
            builder.put(AttributeRegistry.MANA_REGEN.get(), new AttributeModifier(uuid, "Mana Regen",
                    manaRegen, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        if (reduceDamage != 0 && (DragonArmorMaterials.this == TOORNAHKRIIN_MASK || DragonArmorMaterials.this == FODAAN_MASK || DragonArmorMaterials.this == VULONQO_MASK || DragonArmorMaterials.this == VULNILVIIR_MASK || DragonArmorMaterials.this == VULSILAH_MASK))
        {
            builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, "minus_damage",
                    reduceDamage, AttributeModifier.Operation.MULTIPLY_TOTAL));
        }
        if (firePowerMask != 0 && DragonArmorMaterials.this == TOORNAHKRIIN_MASK)
        {
            builder.put(AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier(uuid, "Fire power",
                    firePowerMask, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        if (icePowerMask != 0 && DragonArmorMaterials.this == FODAAN_MASK)
        {
            builder.put(AttributeRegistry.ICE_SPELL_POWER.get(), new AttributeModifier(uuid, "Ice power",
                    icePowerMask, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        if (lightningPowerMask != 0 && DragonArmorMaterials.this == VULONQO_MASK)
        {
            builder.put(AttributeRegistry.LIGHTNING_SPELL_POWER.get(), new AttributeModifier(uuid, "Lightning power",
                    lightningPowerMask, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        if (enderPowerMask != 0 && DragonArmorMaterials.this == VULNILVIIR_MASK)
        {
            builder.put(AttributeRegistry.ENDER_SPELL_POWER.get(), new AttributeModifier(uuid, "Ender power",
                    enderPowerMask, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        if (eldritchPowerMask != 0 && DragonArmorMaterials.this == VULSILAH_MASK)
        {
            builder.put(AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier(uuid, "Eldritch power",
                    eldritchPowerMask, AttributeModifier.Operation.MULTIPLY_BASE));
        }

        return builder.build();
    }

    static public EnumMap<ArmorItem.Type, Integer> makeArmorMap(int helmet, int chestplate, int leggings, int boots)
    {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266655_) -> {
            p_266655_.put(ArmorItem.Type.BOOTS, boots);
            p_266655_.put(ArmorItem.Type.LEGGINGS, leggings);
            p_266655_.put(ArmorItem.Type.CHESTPLATE, chestplate);
            p_266655_.put(ArmorItem.Type.HELMET, helmet);
        });
    }

    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    private static EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE =
            Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
                p_266653_.put(ArmorItem.Type.BOOTS, 13);
                p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
                p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
                p_266653_.put(ArmorItem.Type.HELMET, 11);
            });

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return -1;
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

    /*public Map<Attribute, AttributeModifier> getAdditionalAttributes() {
        return additionalAttributes;
    }*/

    /**
     * Gets the percentage of knockback resistance provided by armor of the material.
     */
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

