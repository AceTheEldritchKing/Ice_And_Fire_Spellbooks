package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class FodaanDragonPriestMaskItem extends DragonArmorItem implements IPresetSpellContainer {
    public FodaanDragonPriestMaskItem(EquipmentSlot slot, Properties settings) {
        super(DragonArmorMaterials.FODAAN_MASK, slot, settings);
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
