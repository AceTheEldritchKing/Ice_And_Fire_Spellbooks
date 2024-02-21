package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor.LightningDragonPriestArmorModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class LightningDragonPriestArmorItem extends DragonArmorItem{
    public LightningDragonPriestArmorItem(Type type, Properties settings) {
        super(DragonArmorMaterials.LIGHTNING_DRAGON_PRIEST, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new LightningDragonPriestArmorModel());
    }
}
