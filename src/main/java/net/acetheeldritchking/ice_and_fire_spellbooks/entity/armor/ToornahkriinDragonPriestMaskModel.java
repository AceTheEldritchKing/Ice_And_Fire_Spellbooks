package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.ToornahkriinDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ToornahkriinDragonPriestMaskModel extends DefaultedItemGeoModel<ToornahkriinDragonPriestMaskItem> {
    public ToornahkriinDragonPriestMaskModel()
    {
        super(new ResourceLocation(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(ToornahkriinDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/toornahkriin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ToornahkriinDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/toornahkriin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ToornahkriinDragonPriestMaskItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/dragon_priest.animation.json");
    }
}
