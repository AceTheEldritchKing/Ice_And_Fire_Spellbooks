package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.VulsilahDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class VulsilahDragonPriestMaskModel extends AnimatedGeoModel<VulsilahDragonPriestMaskItem> {
    public VulsilahDragonPriestMaskModel()
    {
        super();
    }

    @Override
    public ResourceLocation getModelResource(VulsilahDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/vulsilah.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VulsilahDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/vulsilah.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VulsilahDragonPriestMaskItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/dragon_priest.animation.json");
    }
}
