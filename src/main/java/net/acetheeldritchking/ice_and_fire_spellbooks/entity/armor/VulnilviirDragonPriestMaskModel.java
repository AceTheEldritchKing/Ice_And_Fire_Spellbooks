package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.VulnilviirDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VulnilviirDragonPriestMaskModel extends AnimatedGeoModel<VulnilviirDragonPriestMaskItem> {
    public VulnilviirDragonPriestMaskModel()
    {
        super();
    }

    @Override
    public ResourceLocation getModelResource(VulnilviirDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/vulnilviir.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VulnilviirDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/vulnilviir.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VulnilviirDragonPriestMaskItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/dragon_priest.animation.json");
    }
}
