package net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.armor.FireDragonPriestArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class FireDragonPriestArmorModel extends DefaultedItemGeoModel<FireDragonPriestArmorItem> {
    public FireDragonPriestArmorModel()
    {
        super(new ResourceLocation(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(FireDragonPriestArmorItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/fire_dragon_priest.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FireDragonPriestArmorItem object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/models/armor/fire_dragon_priest.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FireDragonPriestArmorItem animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/fire_dragon_priest.animation.json");
    }
}
