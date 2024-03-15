package net.acetheeldritchking.ice_and_fire_spellbooks.registries;

import io.redspace.ironsspellbooks.item.spell_books.SimpleAttributeSpellBook;
import io.redspace.ironsspellbooks.registries.AttributeRegistry;
import io.redspace.ironsspellbooks.spells.AbstractSpell;
import io.redspace.ironsspellbooks.spells.SpellRarity;
import io.redspace.ironsspellbooks.spells.fire.FireBreathSpell;
import io.redspace.ironsspellbooks.spells.ice.ConeOfColdSpell;
import io.redspace.ironsspellbooks.spells.lightning.ElectrocuteSpell;
import io.redspace.ironsspellbooks.util.SpellbookModCreativeTabs;
import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.DragonPriestStaffItem;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.FireDragonPriestArmorItem;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.IceDragonPriestArmorItem;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.LightningDragonPriestArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IceAndFireSpellbooks.MOD_ID);

    // Dragonmancer's Oathbook
    public static final RegistryObject<Item> DRAGONMANCERS_OATHBOOK = ITEMS.register
            ("dragonmancers_oathbook", () -> new SimpleAttributeSpellBook
                    (10, SpellRarity.LEGENDARY, AttributeRegistry.SPELL_POWER, 0.2D));

    // Dragon Priest Staff
    public static final RegistryObject<Item> DRAGON_PRIEST_STAFF = ITEMS.register("dragon_priest_staff", () -> new DragonPriestStaffItem
            (new AbstractSpell[]
                    {
                            new ElectrocuteSpell(8),
                            new ConeOfColdSpell(8),
                            new FireBreathSpell(8)
                    }));

    //       //
    // ARMOR //
    //       //

    // Fire Dragon Priest
    public static final RegistryObject<Item> FIRE_DRAGON_PRIEST_HELMET = ITEMS.register("fire_dragon_priest_helmet",
            () -> new FireDragonPriestArmorItem(EquipmentSlot.HEAD, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));
    public static final RegistryObject<Item> FIRE_DRAGON_PRIEST_CHESTPLATE = ITEMS.register("fire_dragon_priest_chestplate",
            () -> new FireDragonPriestArmorItem(EquipmentSlot.CHEST, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));
    public static final RegistryObject<Item> FIRE_DRAGON_PRIEST_LEGGINGS = ITEMS.register("fire_dragon_priest_leggings",
            () -> new FireDragonPriestArmorItem(EquipmentSlot.LEGS, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));
    public static final RegistryObject<Item> FIRE_DRAGON_PRIEST_BOOTS = ITEMS.register("fire_dragon_priest_boots",
            () -> new FireDragonPriestArmorItem(EquipmentSlot.FEET, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));

    // Ice Dragon Priest
    public static final RegistryObject<Item> ICE_DRAGON_PRIEST_HELMET = ITEMS.register("ice_dragon_priest_helmet",
            () -> new IceDragonPriestArmorItem(EquipmentSlot.HEAD, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));
    public static final RegistryObject<Item> ICE_DRAGON_PRIEST_CHESTPLATE = ITEMS.register("ice_dragon_priest_chestplate",
            () -> new IceDragonPriestArmorItem(EquipmentSlot.CHEST, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));
    public static final RegistryObject<Item> ICE_DRAGON_PRIEST_LEGGINGS = ITEMS.register("ice_dragon_priest_leggings",
            () -> new IceDragonPriestArmorItem(EquipmentSlot.LEGS, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));
    public static final RegistryObject<Item> ICE_DRAGON_PRIEST_BOOTS = ITEMS.register("ice_dragon_priest_boots",
            () -> new IceDragonPriestArmorItem(EquipmentSlot.FEET, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));

    // Lightning Dragon Priest
    public static final RegistryObject<Item> LIGHTNING_DRAGON_PRIEST_HELMET = ITEMS.register("lightning_dragon_priest_helmet",
            () -> new LightningDragonPriestArmorItem(EquipmentSlot.HEAD, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));
    public static final RegistryObject<Item> LIGHTNING_DRAGON_PRIEST_CHESTPLATE = ITEMS.register("lightning_dragon_priest_chestplate",
            () -> new LightningDragonPriestArmorItem(EquipmentSlot.CHEST, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));
    public static final RegistryObject<Item> LIGHTNING_DRAGON_PRIEST_LEGGINGS = ITEMS.register("lightning_dragon_priest_leggings",
            () -> new LightningDragonPriestArmorItem(EquipmentSlot.LEGS, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));
    public static final RegistryObject<Item> LIGHTNING_DRAGON_PRIEST_BOOTS = ITEMS.register("lightning_dragon_priest_boots",
            () -> new LightningDragonPriestArmorItem(EquipmentSlot.FEET, new Item.Properties().tab(SpellbookModCreativeTabs.SPELL_EQUIPMENT_TAB).fireResistant()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
