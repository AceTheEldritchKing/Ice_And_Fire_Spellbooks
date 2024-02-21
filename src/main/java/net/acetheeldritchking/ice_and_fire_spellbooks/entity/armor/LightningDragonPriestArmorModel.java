package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.LightningDragonPriestArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class LightningDragonPriestArmorModel extends DefaultedItemGeoModel<LightningDragonPriestArmorItem> {
    public LightningDragonPriestArmorModel()
    {
        super(new ResourceLocation(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(LightningDragonPriestArmorItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/lightning_dragon_priest.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LightningDragonPriestArmorItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/lightning_dragon_priest.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LightningDragonPriestArmorItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/lightning_dragon_priest.animation.json");
    }
}
