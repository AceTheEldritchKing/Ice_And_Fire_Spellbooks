package net.acetheeldritchking.ice_and_fire_spellbooks.entity.item;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.FireDragonPriestStaff;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.LightningDragonPriestStaff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class LightningDragonPriestStaffModel extends DefaultedItemGeoModel<LightningDragonPriestStaff> {
    public LightningDragonPriestStaffModel()
    {
        super(new ResourceLocation(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(LightningDragonPriestStaff object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "geo/draconic_tempest_staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LightningDragonPriestStaff object) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "textures/item/staff/draconic_tempest_staff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LightningDragonPriestStaff animatable) {
        return new ResourceLocation(IceAndFireSpellbooks.MOD_ID, "animations/fire_dragon_priest.animation.json");
    }
}
