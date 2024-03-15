package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.LightningDragonPriestArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LightningDragonPriestArmorModel extends AnimatedGeoModel<LightningDragonPriestArmorItem> {
    public LightningDragonPriestArmorModel()
    {
        super();
    }

    @Override
    public ResourceLocation getModelLocation(LightningDragonPriestArmorItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/lightning_dragon_priest.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(LightningDragonPriestArmorItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/lightning_dragon_priest.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(LightningDragonPriestArmorItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/lightning_dragon_priest.animation.json");
    }
}
