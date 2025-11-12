package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor.VulonqoDragonPriestMaskModel;
import net.acetheeldritchking.ice_and_fire_spellbooks.registries.ArmorMaterialRegistries;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class VulonqoDragonPriestMaskItem extends DragonArmorItem implements IPresetSpellContainer {
    public VulonqoDragonPriestMaskItem(Type slot, Properties settings) {
        super(ArmorMaterialRegistries.VULONQO_MASK, slot, settings);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        if (!ISpellContainer.isSpellContainer(itemStack)) {
            ISpellContainer spellContainer = ISpellContainer.create(2, true, true);
            itemStack.set(ComponentRegistry.SPELL_CONTAINER, spellContainer);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new VulonqoDragonPriestMaskModel());
    }
}
