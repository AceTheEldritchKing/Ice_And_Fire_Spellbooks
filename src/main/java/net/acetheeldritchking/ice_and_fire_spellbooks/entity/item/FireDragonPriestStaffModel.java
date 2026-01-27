package net.acetheeldritchking.ice_and_fire_spellbooks.entity.item;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.FireDragonPriestStaff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class FireDragonPriestStaffModel extends DefaultedItemGeoModel<FireDragonPriestStaff> {
    public FireDragonPriestStaffModel() {
        super(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(FireDragonPriestStaff object) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "geo/draconic_inferno_staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FireDragonPriestStaff object) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "textures/item/staff/draconic_interno_staff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FireDragonPriestStaff animatable) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "animations/fire_dragon_priest.animation.json");
    }
}
