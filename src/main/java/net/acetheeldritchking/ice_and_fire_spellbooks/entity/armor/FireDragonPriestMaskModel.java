package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.masks.FireDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class FireDragonPriestMaskModel extends DefaultedItemGeoModel<FireDragonPriestMaskItem> {
    public FireDragonPriestMaskModel()
    {
        super(new ResourceLocation(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(FireDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/dragon_priest_masks_new_fire.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FireDragonPriestMaskItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/dragon_priest_mask_fire.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FireDragonPriestMaskItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/dragon_priest.animation.json");
    }
}
