package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.masks;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor.IceDragonPriestMaskModel;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.DragonArmorItem;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.DragonArmorMaterials;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class IceDragonPriestMaskItem extends DragonArmorItem implements IPresetSpellContainer {
    public IceDragonPriestMaskItem(Type slot, Properties settings) {
        super(DragonArmorMaterials.ICE_DRAGON_PRIEST_MASK, slot, settings);
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
        return new GenericCustomArmorRenderer<>(new IceDragonPriestMaskModel());
    }
}
