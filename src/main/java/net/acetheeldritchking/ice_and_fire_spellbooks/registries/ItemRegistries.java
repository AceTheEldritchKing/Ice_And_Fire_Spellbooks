package net.acetheeldritchking.ice_and_fire_spellbooks.registries;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.*;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.misc.WoodenDragonPriestMask;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.FireDragonPriestStaff;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.IceDragonPriestStaff;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.LightningDragonPriestStaff;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;

public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, IceAndFireSpellbooks.MOD_ID);

    // Dragonmancer's Oathbook
    public static final DeferredHolder<Item, Item> DRAGONMANCERS_OATHBOOK = ITEMS.register("dragonmancers_oathbook", () -> new SpellBook(12).withSpellbookAttributes(new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.2D, AttributeModifier.Operation.ADD_VALUE), new AttributeContainer(AttributeRegistry.MAX_MANA, 300, AttributeModifier.Operation.ADD_VALUE)));

    // Dragon Priest Staff
    public static final DeferredHolder<Item, StaffItem> DRAGON_PRIEST_STAFF = ITEMS.register("dragon_priest_staff", () -> new StaffItem(ItemPropertiesHelper.equipment().stacksTo(1).rarity(Rarity.EPIC).attributes(ItemAttributeModifiers.builder()
            .add(AttributeRegistry.FIRE_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "weapon_modifier"), .10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.MAINHAND)
            .add(AttributeRegistry.ICE_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "weapon_modifier"), 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.MAINHAND)
            .add(AttributeRegistry.LIGHTNING_SPELL_POWER, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "weapon_modifier"), 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.MAINHAND)
            .add(AttributeRegistry.COOLDOWN_REDUCTION, new AttributeModifier(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "weapon_modifier"), 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.MAINHAND)
            .build())));

    // Fire Dragon Priest Staff
    public static final DeferredHolder<Item, Item> FIRE_DRAGON_PRIEST_STAFF = ITEMS.register("crimson_dragon_priest_staff", FireDragonPriestStaff::new);

    // Ice Dragon Priest Staff
    public static final DeferredHolder<Item, Item> ICE_DRAGON_PRIEST_STAFF = ITEMS.register("silver_dragon_priest_staff", IceDragonPriestStaff::new);

    // Lightning Dragon Priest Staff
    public static final DeferredHolder<Item, Item> LIGHTNING_DRAGON_PRIEST_STAFF = ITEMS.register("thunderous_dragon_priest_staff", LightningDragonPriestStaff::new);

    // Wooden Dragon Priest Mask (Crafting item)
    public static final DeferredHolder<Item, Item> WOODEN_DRAGON_PRIEST_MASK = ITEMS.register("wooden_mask", () -> new WoodenDragonPriestMask(ItemPropertiesHelper.equipment()));

    //       //
    // ARMOR //
    //       //

    // Fire Dragon Priest
    public static final DeferredHolder<Item, Item> FIRE_DRAGON_PRIEST_HELMET = ITEMS.register("fire_dragon_priest_helmet",
            () -> new FireDragonPriestArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().fireResistant().durability(429)));
    public static final DeferredHolder<Item, Item> FIRE_DRAGON_PRIEST_CHESTPLATE = ITEMS.register("fire_dragon_priest_chestplate",
            () -> new FireDragonPriestArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment().fireResistant().durability(624)));
    public static final DeferredHolder<Item, Item> FIRE_DRAGON_PRIEST_LEGGINGS = ITEMS.register("fire_dragon_priest_leggings",
            () -> new FireDragonPriestArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment().fireResistant().durability(585)));
    public static final DeferredHolder<Item, Item> FIRE_DRAGON_PRIEST_BOOTS = ITEMS.register("fire_dragon_priest_boots",
            () -> new FireDragonPriestArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment().fireResistant().durability(507)));

    // Ice Dragon Priest
    public static final DeferredHolder<Item, Item> ICE_DRAGON_PRIEST_HELMET = ITEMS.register("ice_dragon_priest_helmet",
            () -> new IceDragonPriestArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().fireResistant().durability(429)));
    public static final DeferredHolder<Item, Item> ICE_DRAGON_PRIEST_CHESTPLATE = ITEMS.register("ice_dragon_priest_chestplate",
            () -> new IceDragonPriestArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment().fireResistant().durability(624)));
    public static final DeferredHolder<Item, Item> ICE_DRAGON_PRIEST_LEGGINGS = ITEMS.register("ice_dragon_priest_leggings",
            () -> new IceDragonPriestArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment().fireResistant().durability(585)));
    public static final DeferredHolder<Item, Item> ICE_DRAGON_PRIEST_BOOTS = ITEMS.register("ice_dragon_priest_boots",
            () -> new IceDragonPriestArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment().fireResistant().durability(507)));

    // Lightning Dragon Priest
    public static final DeferredHolder<Item, Item> LIGHTNING_DRAGON_PRIEST_HELMET = ITEMS.register("lightning_dragon_priest_helmet",
            () -> new LightningDragonPriestArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().fireResistant().durability(429)));
    public static final DeferredHolder<Item, Item> LIGHTNING_DRAGON_PRIEST_CHESTPLATE = ITEMS.register("lightning_dragon_priest_chestplate",
            () -> new LightningDragonPriestArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper.equipment().fireResistant().durability(624)));
    public static final DeferredHolder<Item, Item> LIGHTNING_DRAGON_PRIEST_LEGGINGS = ITEMS.register("lightning_dragon_priest_leggings",
            () -> new LightningDragonPriestArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper.equipment().fireResistant().durability(585)));
    public static final DeferredHolder<Item, Item> LIGHTNING_DRAGON_PRIEST_BOOTS = ITEMS.register("lightning_dragon_priest_boots",
            () -> new LightningDragonPriestArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper.equipment().fireResistant().durability(507)));

    // Toornahkriin Dragon Mask (Fire)
    public static final DeferredHolder<Item, Item> TOORNAHKRIIN_MASK_HELMET = ITEMS.register("toornahkriin",
            () -> new ToornahkriinDragonPriestMaskItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().fireResistant().durability(275)));

    // Fodaan Dragon Mask (Ice)
    public static final DeferredHolder<Item, Item> FODAAN_MASK_HELMET = ITEMS.register("fodaan",
            () -> new FodaanDragonPriestMaskItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().fireResistant().durability(275)));

    // Vulonqo Dragon Mask (Lightning)
    public static final DeferredHolder<Item, Item> VULONQO_MASK_HELMET = ITEMS.register("vulonqo",
            () -> new VulonqoDragonPriestMaskItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().fireResistant().durability(275)));

    // Vulnilviir Dragon Mask (Ender)
    public static final DeferredHolder<Item, Item> VULNILVIIR_MASK_HELMET = ITEMS.register("vulnilviir",
            () -> new VulnilviirDragonPriestMaskItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().fireResistant().durability(275)));

    // Vulsilah Dragon Mask (Eldritch)
    public static final DeferredHolder<Item, Item> VULSILAH_MASK_HELMET = ITEMS.register("vulsilah",
            () -> new VulsilahDragonPriestMaskItem(ArmorItem.Type.HELMET, ItemPropertiesHelper.equipment().fireResistant().durability(275)));

    public static Collection<DeferredHolder<Item, ? extends Item>> getIFSItems() {
        return ITEMS.getEntries();
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
