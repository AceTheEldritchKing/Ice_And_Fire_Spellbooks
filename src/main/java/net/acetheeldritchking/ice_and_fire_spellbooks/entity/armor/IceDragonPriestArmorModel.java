package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.FireDragonPriestArmorItem;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.IceDragonPriestArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IceDragonPriestArmorModel extends AnimatedGeoModel<IceDragonPriestArmorItem> {
    public IceDragonPriestArmorModel()
    {
        super();
    }

    @Override
    public ResourceLocation getModelResource(IceDragonPriestArmorItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/ice_dragon_priest.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IceDragonPriestArmorItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/ice_dragon_priest.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IceDragonPriestArmorItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/ice_dragon_priest.animation.json");
    }
}
