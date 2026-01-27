package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.VulonqoDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class VulonqoDragonPriestMaskModel extends DefaultedItemGeoModel<VulonqoDragonPriestMaskItem> {
    public VulonqoDragonPriestMaskModel() {
        super(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(VulonqoDragonPriestMaskItem object) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "geo/dragon_priest_masks_new_lightning.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VulonqoDragonPriestMaskItem object) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/dragon_priest_mask_lightning.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VulonqoDragonPriestMaskItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "animations/dragon_priest.animation.json");
    }
}
