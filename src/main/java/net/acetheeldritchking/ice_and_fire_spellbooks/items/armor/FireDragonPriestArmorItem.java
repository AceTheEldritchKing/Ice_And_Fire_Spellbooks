package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor.FireDragonPriestArmorModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FireDragonPriestArmorItem extends DragonArmorItem{
    public FireDragonPriestArmorItem(Type type, Properties settings) {
        super(DragonArmorMaterials.FIRE_DRAGON_PRIEST, type, settings);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new FireDragonPriestArmorModel());
    }
}
