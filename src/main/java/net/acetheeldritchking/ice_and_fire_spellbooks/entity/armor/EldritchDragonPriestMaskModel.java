package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.EldritchDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class EldritchDragonPriestMaskModel extends DefaultedItemGeoModel<EldritchDragonPriestMaskItem> {
    public EldritchDragonPriestMaskModel() {
        super(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(EldritchDragonPriestMaskItem object) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "geo/dragon_priest_masks_new_sculk.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EldritchDragonPriestMaskItem object) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/dragon_priest_mask_sculk.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EldritchDragonPriestMaskItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "animations/dragon_priest.animation.json");
    }
}
