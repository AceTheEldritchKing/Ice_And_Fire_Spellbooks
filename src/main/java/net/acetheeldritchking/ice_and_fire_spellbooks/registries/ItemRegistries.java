package net.acetheeldritchking.ice_and_fire_spellbooks.registries;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.item.spell_books.SimpleAttributeSpellBook;
import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.DragonPriestStaffItem;
import net.minecraft.world.entity.ai.attributes.Attribute;
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
                    (10, SpellRarity.LEGENDARY, (Attribute)AttributeRegistry.SPELL_POWER.get(), 0.2D));

    // Dragon Priest Staff
    public static final RegistryObject<Item> DRAGON_PRIEST_STAFF = ITEMS.register("dragon_priest_staff", () -> new DragonPriestStaffItem
            (new SpellDataRegistryHolder[]
                    {
                            new SpellDataRegistryHolder(SpellRegistry.ELECTROCUTE_SPELL, 8),
                            new SpellDataRegistryHolder(SpellRegistry.CONE_OF_COLD_SPELL, 8),
                            new SpellDataRegistryHolder(SpellRegistry.FIRE_BREATH_SPELL, 8)
                    }));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
