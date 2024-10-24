package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor.VulonqoDragonPriestMaskModel;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor.VulsilahDragonPriestMaskModel;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class VulsilahDragonPriestMaskItem extends DragonArmorItem implements IPresetSpellContainer {
    public VulsilahDragonPriestMaskItem(Type slot, Properties settings) {
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

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new VulsilahDragonPriestMaskModel());
    }
}
