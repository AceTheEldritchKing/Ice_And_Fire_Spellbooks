package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ImbuableDragonChestplateArmorItem extends DragonArmorItem implements IPresetSpellContainer {
    public ImbuableDragonChestplateArmorItem(Holder<ArmorMaterial> material, Type slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) return;
        if (itemStack.getItem() instanceof DragonArmorItem armorItem && armorItem.getEquipmentSlot() == EquipmentSlot.CHEST) {
            if (!ISpellContainer.isSpellContainer(itemStack)) {
                ISpellContainer spellContainer = ISpellContainer.create(1, true, true);
                itemStack.set(ComponentRegistry.SPELL_CONTAINER, spellContainer);
            }
        }
    }

    @Override
    public GeoArmorRenderer<?> supplyRenderer() {
        return null;
    }
}
