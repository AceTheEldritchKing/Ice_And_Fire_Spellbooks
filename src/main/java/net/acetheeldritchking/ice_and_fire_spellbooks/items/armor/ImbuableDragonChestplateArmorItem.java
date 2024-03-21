package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public abstract class ImbuableDragonChestplateArmorItem extends DragonArmorItem implements IPresetSpellContainer {
    public ImbuableDragonChestplateArmorItem(IFSArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }

        if (itemStack.getItem() instanceof DragonArmorItem armorItem && armorItem.getSlot() == EquipmentSlot.CHEST) {
            if (!ISpellContainer.isSpellContainer(itemStack)) {
                var spellContainer = ISpellContainer.create(1, true, true);
                spellContainer.save(itemStack);
            }
        }
    }
}
