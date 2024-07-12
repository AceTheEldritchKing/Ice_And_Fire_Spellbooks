package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.VulonqoDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VulonqoDragonPriestMaskModel extends AnimatedGeoModel<VulonqoDragonPriestMaskItem> {
    public VulonqoDragonPriestMaskModel()
    {
        super();
    }

    @Override
    public ResourceLocation getModelResource(VulonqoDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/vulonqo.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VulonqoDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/vulonqo.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VulonqoDragonPriestMaskItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/wizard_armor_animation.json");
    }
}
