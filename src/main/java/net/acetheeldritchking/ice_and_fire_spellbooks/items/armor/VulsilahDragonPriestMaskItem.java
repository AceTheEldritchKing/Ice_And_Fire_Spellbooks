package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class VulsilahDragonPriestMaskItem extends DragonArmorItem implements IPresetSpellContainer {
    public VulsilahDragonPriestMaskItem(EquipmentSlot slot, Properties settings) {
        super(DragonArmorMaterials.VULSILAH_MASK, slot, settings);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null)
        {
            return;
        }
        if (!ISpellContainer.isSpellContainer(itemStack))
        {
            var spellContainer = ISpellContainer.create(2, true, true);
            spellContainer.save(itemStack);
        }
    }
}
