package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.VulnilviirDragonPriestMaskItem;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.VulonqoDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class VulnilviirDragonPriestMaskModel extends DefaultedItemGeoModel<VulnilviirDragonPriestMaskItem> {
    public VulnilviirDragonPriestMaskModel()
    {
        super(new ResourceLocation(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(VulnilviirDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/dragon_priest_masks_new_ender.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VulnilviirDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/dragon_priest_mask_ender.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VulnilviirDragonPriestMaskItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/dragon_priest.animation.json");
    }
}
