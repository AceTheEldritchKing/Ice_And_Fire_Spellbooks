package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.IceDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class IceDragonPriestMaskModel extends DefaultedItemGeoModel<IceDragonPriestMaskItem> {
    public IceDragonPriestMaskModel() {
        super(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(IceDragonPriestMaskItem object) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "geo/dragon_priest_masks_new_ice.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IceDragonPriestMaskItem object) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/dragon_priest_mask_ice.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IceDragonPriestMaskItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "animations/dragon_priest.animation.json");
    }
}
