package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.IceDragonPriestArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class IceDragonPriestArmorModel extends DefaultedItemGeoModel<IceDragonPriestArmorItem> {
    public IceDragonPriestArmorModel()
    {
        super(new ResourceLocation(IceAndFireSpellbooks.MOD_ID, ""));
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
