package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.FodaanDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FodaanDragonPriestMaskModel extends AnimatedGeoModel<FodaanDragonPriestMaskItem> {
    public FodaanDragonPriestMaskModel()
    {
        super();
    }

    @Override
    public ResourceLocation getModelResource(FodaanDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/fodaan.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FodaanDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/fodaan.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FodaanDragonPriestMaskItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/wizard_armor_animation.json");
    }
}
