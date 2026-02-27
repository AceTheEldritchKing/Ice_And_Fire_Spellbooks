package net.acetheeldritchking.ice_and_fire_spellbooks.registries;

import com.iafenvoy.iceandfire.registry.IafItems;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.config.ArmorValueConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public final class ArmorMaterialRegistries {
    public static final DeferredRegister<ArmorMaterial> REGISTRY = DeferredRegister.create(Registries.ARMOR_MATERIAL, IceAndFireSpellbooks.MOD_ID);
    /*
        Netherite
        NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
          return Ingredient.of(Items.NETHERITE_INGOT);
        });
    */
    // Fire Dragon Priest Regalia
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> FIRE_DRAGON_PRIEST = REGISTRY.register("fire_dragon_priest", () -> new ArmorMaterial(buildProtection(ArmorValueConfig.dragonsteelArmorValue), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(IafItems.DRAGONSTEEL_FIRE_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "fire_dragon_priest"))), 6.0F, 0.1F));
    /*
    , Map.of(
            //AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 150, AttributeModifier.Operation.ADD_VALUE),
            //AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier("Fire Power", .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
     */

    // Ice Dragon Priest Regalia
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ICE_DRAGON_PRIEST = REGISTRY.register("ice_dragon_priest", () -> new ArmorMaterial(buildProtection(ArmorValueConfig.dragonsteelArmorValue), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(IafItems.DRAGONSTEEL_ICE_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "ice_dragon_priest"))), 6.0F, 0.1F));
    /*
    , Map.of(
            //AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 150, AttributeModifier.Operation.ADD_VALUE),
            //AttributeRegistry.ICE_SPELL_POWER.get(), new AttributeModifier("Ice Power", .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
     */

    // Lightning Dragon Priest Regalia
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> LIGHTNING_DRAGON_PRIEST = REGISTRY.register("lightning_dragon_priest", () -> new ArmorMaterial(buildProtection(ArmorValueConfig.dragonsteelArmorValue), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(IafItems.DRAGONSTEEL_LIGHTNING_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "lightning_dragon_priest"))), 6.0F, 0.1F));
   /*
    , Map.of(
            //AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 150, AttributeModifier.Operation.ADD_VALUE),
            //AttributeRegistry.LIGHTNING_SPELL_POWER.get(), new AttributeModifier("Lightning Power", .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
     */

    // Toornahkriin Dragon Mask (Fire)
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> TOORNAHKRIIN_MASK = REGISTRY.register("toornahkriin", () -> new ArmorMaterial(buildProtection(ArmorValueConfig.dragonsteelMaskArmorValue), 15, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(IafItems.DRAGONSTEEL_FIRE_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "toornahkriin"))), 2.0F, 0.1F));
    // Fodaan Dragon Mask (Ice)
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> FODAAN_MASK = REGISTRY.register("fodaan", () -> new ArmorMaterial(buildProtection(ArmorValueConfig.dragonsteelMaskArmorValue), 15, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(IafItems.DRAGONSTEEL_ICE_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "fodaan"))), 2.0F, 0.1F));
    // Vulonqo Dragon Mask (Lightning)
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> VULONQO_MASK = REGISTRY.register("vulonqo", () -> new ArmorMaterial(buildProtection(ArmorValueConfig.dragonsteelMaskArmorValue), 15, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(IafItems.DRAGONSTEEL_LIGHTNING_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "vulonqo"))), 2.0F, 0.1F));
    // Vulnilviir Dragon Mask (Ender)
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> VULNILVIIR_MASK = REGISTRY.register("vulnilviir", () -> new ArmorMaterial(buildProtection(ArmorValueConfig.dragonsteelMaskArmorValue), 15, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "vulnilviir"))), 2.0F, 0.1F));
    // Vulsilah Dragon Mask (Eldritch)
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> VULSILAH_MASK = REGISTRY.register("vulsilah", () -> new ArmorMaterial(buildProtection(ArmorValueConfig.dragonsteelMaskArmorValue), 15, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "vulsilah"))), 2.0F, 0.1F));

    public static EnumMap<ArmorItem.Type, Integer> buildProtection(ArmorValueConfig.ArmorValues protectionMap) {
        EnumMap<ArmorItem.Type, Integer> map = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values())
            if (type.hasTrims())
                map.put(type, protectionMap.getProtectionValues(type.getSlot()));
        return map;
    }

    public static ItemAttributeModifiers makeAttributeMap(Holder<ArmorMaterial> material, ArmorItem.Type type) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        float toughness = material.value().toughness();
        float knockbackResistance = material.value().knockbackResistance();
        double maxMana = 150;
        double firePower = 0.1D;
        double icePower = 0.1D;
        double lightningPower = 0.1D;
        double spellPower = 0.05D;
        // Dragon Priest
        double maxManaMask = 225;
        double manaRegen = 0.30D;
        double firePowerMask = 0.15D;
        double icePowerMask = 0.15D;
        double lightningPowerMask = 0.15D;
        double enderPowerMask = 0.15D;
        double eldritchPowerMask = 0.15D;
        double reduceDamage = -0.20D;

        int protection = material.value().defense().get(type);
        if (protection != 0) {
            builder.add(Attributes.ARMOR, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "armor." + type.getName()), protection, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.bySlot(type.getSlot()));
        }
        if (toughness != 0) {
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "armor." + type.getName()), toughness, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.ARMOR);
        }
        if (knockbackResistance > 0) {
            builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "armor_knockback_resistance." + type.getName()),
                    knockbackResistance, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.ARMOR);
        }
        builder.add(AttributeRegistry.SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "base_power." + type.getName()),
                spellPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ARMOR);
        if (material == FIRE_DRAGON_PRIEST || material == ICE_DRAGON_PRIEST || material == LIGHTNING_DRAGON_PRIEST) {
            builder.add(AttributeRegistry.MAX_MANA, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "armor_max_mana." + type.getName()),
                    maxMana, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.ARMOR);
        }
        if (material == FIRE_DRAGON_PRIEST) {
            builder.add(AttributeRegistry.FIRE_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "fire_power." + type.getName()),
                    firePower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ARMOR);
        }
        if (material == ICE_DRAGON_PRIEST) {
            builder.add(AttributeRegistry.ICE_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "ice_power." + type.getName()),
                    icePower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ARMOR);
        }
        if (material == LIGHTNING_DRAGON_PRIEST) {
            builder.add(AttributeRegistry.LIGHTNING_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "lightning_power." + type.getName()),
                    lightningPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ARMOR);
        }

        // Dragon Priest Masks //
        if (material == TOORNAHKRIIN_MASK || material == FODAAN_MASK || material == VULONQO_MASK || material == VULNILVIIR_MASK || material == VULSILAH_MASK) {
            builder.add(AttributeRegistry.MAX_MANA, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "armor_max_mana." + type.getName()),
                    maxManaMask, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.ARMOR);
        }
        if (material == TOORNAHKRIIN_MASK || material == FODAAN_MASK || material == VULONQO_MASK || material == VULNILVIIR_MASK || material == VULSILAH_MASK) {
            builder.add(AttributeRegistry.MANA_REGEN, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "mana_regen." + type.getName()),
                    manaRegen, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), EquipmentSlotGroup.ARMOR);
        }
        if (material == TOORNAHKRIIN_MASK || material == FODAAN_MASK || material == VULONQO_MASK || material == VULNILVIIR_MASK || material == VULSILAH_MASK) {
            builder.add(Attributes.ATTACK_DAMAGE, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "minus_damage." + type.getName()),
                    reduceDamage, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL), EquipmentSlotGroup.ARMOR);
        }
        if (material == TOORNAHKRIIN_MASK) {
            builder.add(AttributeRegistry.FIRE_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "fire_power." + type.getName()),
                    firePowerMask, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ARMOR);
        }
        if (material == FODAAN_MASK) {
            builder.add(AttributeRegistry.ICE_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "ice_power." + type.getName()),
                    icePowerMask, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ARMOR);
        }
        if (material == VULONQO_MASK) {
            builder.add(AttributeRegistry.LIGHTNING_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "lightning_power." + type.getName()),
                    lightningPowerMask, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ARMOR);
        }
        if (material == VULNILVIIR_MASK) {
            builder.add(AttributeRegistry.ENDER_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "ender_power." + type.getName()),
                    enderPowerMask, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ARMOR);
        }
        if (material == VULSILAH_MASK) {
            builder.add(AttributeRegistry.ELDRITCH_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "eldritch_power." + type.getName()),
                    eldritchPowerMask, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.ARMOR);
        }

        return builder.build();
    }

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}

