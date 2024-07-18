package net.acetheeldritchking.ice_and_fire_spellbooks.registries;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.item.spell_books.SimpleAttributeSpellBook;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IceAndFireSpellbooks.MOD_ID);

    // Dragonmancer's Oathbook
    public static final RegistryObject<Item> DRAGONMANCERS_OATHBOOK = ITEMS.register
            ("dragonmancers_oathbook", () -> new SimpleAttributeSpellBook
                    (12, SpellRarity.LEGENDARY, AttributeRegistry.SPELL_POWER.get(), 0.2D, 250));

    // Dragon Priest Staff
    public static final RegistryObject<Item> DRAGON_PRIEST_STAFF = ITEMS.register("dragon_priest_staff",
            () -> new StaffItem(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), 9, -3,
                    Map.of(AttributeRegistry.FIRE_SPELL_POWER.get(),
                            new AttributeModifier(UUID.fromString("4c3d32f7-a3ce-413d-b797-85416731ebc8"), "Weapon modifier", 0.10, AttributeModifier.Operation.MULTIPLY_BASE),
                            AttributeRegistry.ICE_SPELL_POWER.get(),
                            new AttributeModifier(UUID.fromString("4c3d32f7-a3ce-413d-b797-85416731ebc8"), "Weapon modifier", 0.10, AttributeModifier.Operation.MULTIPLY_BASE),
                            AttributeRegistry.LIGHTNING_SPELL_POWER.get(),
                            new AttributeModifier(UUID.fromString("4c3d32f7-a3ce-413d-b797-85416731ebc8"), "Weapon modifier", 0.10, AttributeModifier.Operation.MULTIPLY_BASE),
                            AttributeRegistry.COOLDOWN_REDUCTION.get(),
                            new AttributeModifier(UUID.fromString("4c3d32f7-a3ce-413d-b797-85416731ebc8"), "Weapon modifier", 0.10, AttributeModifier.Operation.MULTIPLY_BASE)
                            )));

    // Fire Dragon Priest Staff
    public static final RegistryObject<Item> FIRE_DRAGON_PRIEST_STAFF = ITEMS.register("crimson_dragon_priest_staff",
            () -> new StaffItem(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), 9, -3,
                    Map.of(AttributeRegistry.FIRE_SPELL_POWER.get(),
                            new AttributeModifier(UUID.fromString("4c3d32f7-a3ce-413d-b797-85416731ebc8"), "Weapon modifier", 0.25, AttributeModifier.Operation.MULTIPLY_BASE),
                            AttributeRegistry.COOLDOWN_REDUCTION.get(),
                            new AttributeModifier(UUID.fromString("4c3d32f7-a3ce-413d-b797-85416731ebc8"), "Weapon modifier", 0.20, AttributeModifier.Operation.MULTIPLY_BASE)
                    )));

    // Ice Dragon Priest Staff
    public static final RegistryObject<Item> ICE_DRAGON_PRIEST_STAFF = ITEMS.register("silver_dragon_priest_staff",
            () -> new StaffItem(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), 9, -3,
                    Map.of(AttributeRegistry.ICE_SPELL_POWER.get(),
                            new AttributeModifier(UUID.fromString("4c3d32f7-a3ce-413d-b797-85416731ebc8"), "Weapon modifier", 0.25, AttributeModifier.Operation.MULTIPLY_BASE),
                            AttributeRegistry.COOLDOWN_REDUCTION.get(),
                            new AttributeModifier(UUID.fromString("4c3d32f7-a3ce-413d-b797-85416731ebc8"), "Weapon modifier", 0.20, AttributeModifier.Operation.MULTIPLY_BASE)
                    )));

    // Lightning Dragon Priest Staff
    public static final RegistryObject<Item> LIGHTNING_DRAGON_PRIEST_STAFF = ITEMS.register("thunderous_dragon_priest_staff",
            () -> new StaffItem(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC), 9, -3,
                    Map.of(AttributeRegistry.LIGHTNING_SPELL_POWER.get(),
                            new AttributeModifier(UUID.fromString("4c3d32f7-a3ce-413d-b797-85416731ebc8"), "Weapon modifier", 0.25, AttributeModifier.Operation.MULTIPLY_BASE),
                            AttributeRegistry.COOLDOWN_REDUCTION.get(),
                            new AttributeModifier(UUID.fromString("4c3d32f7-a3ce-413d-b797-85416731ebc8"), "Weapon modifier", 0.20, AttributeModifier.Operation.MULTIPLY_BASE)
                    )));

    //       //
    // ARMOR //
    //       //

    // Fire Dragon Priest
    public static final RegistryObject<Item> FIRE_DRAGON_PRIEST_HELMET = ITEMS.register("fire_dragon_priest_helmet",
            () -> new FireDragonPriestArmorItem(EquipmentSlot.HEAD, ItemPropertiesHelper.equipment().fireResistant()));
    public static final RegistryObject<Item> FIRE_DRAGON_PRIEST_CHESTPLATE = ITEMS.register("fire_dragon_priest_chestplate",
            () -> new FireDragonPriestArmorItem(EquipmentSlot.CHEST, ItemPropertiesHelper.equipment().fireResistant()));
    public static final RegistryObject<Item> FIRE_DRAGON_PRIEST_LEGGINGS = ITEMS.register("fire_dragon_priest_leggings",
            () -> new FireDragonPriestArmorItem(EquipmentSlot.LEGS, ItemPropertiesHelper.equipment().fireResistant()));
    public static final RegistryObject<Item> FIRE_DRAGON_PRIEST_BOOTS = ITEMS.register("fire_dragon_priest_boots",
            () -> new FireDragonPriestArmorItem(EquipmentSlot.FEET, ItemPropertiesHelper.equipment().fireResistant()));

    // Ice Dragon Priest
    public static final RegistryObject<Item> ICE_DRAGON_PRIEST_HELMET = ITEMS.register("ice_dragon_priest_helmet",
            () -> new IceDragonPriestArmorItem(EquipmentSlot.HEAD, ItemPropertiesHelper.equipment().fireResistant()));
    public static final RegistryObject<Item> ICE_DRAGON_PRIEST_CHESTPLATE = ITEMS.register("ice_dragon_priest_chestplate",
            () -> new IceDragonPriestArmorItem(EquipmentSlot.CHEST, ItemPropertiesHelper.equipment().fireResistant()));
    public static final RegistryObject<Item> ICE_DRAGON_PRIEST_LEGGINGS = ITEMS.register("ice_dragon_priest_leggings",
            () -> new IceDragonPriestArmorItem(EquipmentSlot.LEGS, ItemPropertiesHelper.equipment().fireResistant()));
    public static final RegistryObject<Item> ICE_DRAGON_PRIEST_BOOTS = ITEMS.register("ice_dragon_priest_boots",
            () -> new IceDragonPriestArmorItem(EquipmentSlot.FEET, ItemPropertiesHelper.equipment().fireResistant()));

    // Lightning Dragon Priest
    public static final RegistryObject<Item> LIGHTNING_DRAGON_PRIEST_HELMET = ITEMS.register("lightning_dragon_priest_helmet",
            () -> new LightningDragonPriestArmorItem(EquipmentSlot.HEAD, ItemPropertiesHelper.equipment().fireResistant()));
    public static final RegistryObject<Item> LIGHTNING_DRAGON_PRIEST_CHESTPLATE = ITEMS.register("lightning_dragon_priest_chestplate",
            () -> new LightningDragonPriestArmorItem(EquipmentSlot.CHEST, ItemPropertiesHelper.equipment().fireResistant()));
    public static final RegistryObject<Item> LIGHTNING_DRAGON_PRIEST_LEGGINGS = ITEMS.register("lightning_dragon_priest_leggings",
            () -> new LightningDragonPriestArmorItem(EquipmentSlot.LEGS, ItemPropertiesHelper.equipment().fireResistant()));
    public static final RegistryObject<Item> LIGHTNING_DRAGON_PRIEST_BOOTS = ITEMS.register("lightning_dragon_priest_boots",
            () -> new LightningDragonPriestArmorItem(EquipmentSlot.FEET, ItemPropertiesHelper.equipment().fireResistant()));

    // Toornahkriin Dragon Mask (Fire)
    public static final RegistryObject<Item> TOORNAHKRIIN_MASK_HELMET = ITEMS.register("toornahkriin",
            () -> new ToornahkriinDragonPriestMaskItem(EquipmentSlot.HEAD, ItemPropertiesHelper.equipment().fireResistant()));

    // Fodaan Dragon Mask (Ice)
    public static final RegistryObject<Item> FODAAN_MASK_HELMET = ITEMS.register("fodaan",
            () -> new FodaanDragonPriestMaskItem(EquipmentSlot.HEAD, ItemPropertiesHelper.equipment().fireResistant()));

    // Vulonqo Dragon Mask (Lightning)
    public static final RegistryObject<Item> VULONQO_MASK_HELMET = ITEMS.register("vulonqo",
            () -> new VulonqoDragonPriestMaskItem(EquipmentSlot.HEAD, ItemPropertiesHelper.equipment().fireResistant()));

    // Vulnilviir Dragon Mask (Ender)
    public static final RegistryObject<Item> VULNILVIIR_MASK_HELMET = ITEMS.register("vulnilviir",
            () -> new VulnilviirDragonPriestMaskItem(EquipmentSlot.HEAD, ItemPropertiesHelper.equipment().fireResistant()));

    // Vulsilah Dragon Mask (Eldritch)
    public static final RegistryObject<Item> VULSILAH_MASK_HELMET = ITEMS.register("vulsilah",
            () -> new VulsilahDragonPriestMaskItem(EquipmentSlot.HEAD, ItemPropertiesHelper.equipment().fireResistant()));

    public static Collection<RegistryObject<Item>> getIFSItems()
    {
        return ITEMS.getEntries();
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
