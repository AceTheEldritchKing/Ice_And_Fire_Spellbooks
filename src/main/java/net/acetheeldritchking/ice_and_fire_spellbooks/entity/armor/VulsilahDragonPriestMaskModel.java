package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.VulonqoDragonPriestMaskItem;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.VulsilahDragonPriestMaskItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class VulsilahDragonPriestMaskModel extends DefaultedItemGeoModel<VulsilahDragonPriestMaskItem> {
    public VulsilahDragonPriestMaskModel()
    {
        super(new ResourceLocation(IceAndFireSpellbooks.MOD_ID, ""));
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
