package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.masks.EnderDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class EnderDragonPriestMaskModel extends DefaultedItemGeoModel<EnderDragonPriestMaskItem> {
    public EnderDragonPriestMaskModel()
    {
        super(new ResourceLocation(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(EnderDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/dragon_priest_masks_new_ender.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnderDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/dragon_priest_mask_ender.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnderDragonPriestMaskItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/dragon_priest.animation.json");
    }
}
