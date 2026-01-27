package net.acetheeldritchking.ice_and_fire_spellbooks.entity.item;

import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.FireDragonPriestStaff;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.IceDragonPriestStaff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class IceDragonPriestStaffModel extends DefaultedItemGeoModel<IceDragonPriestStaff> {
    public IceDragonPriestStaffModel() {
        super(ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(IceDragonPriestStaff object) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "geo/draconic_cryonic_staff.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IceDragonPriestStaff object) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "textures/item/staff/draconic_cryonic_staff.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IceDragonPriestStaff animatable) {
        return ResourceLocation.fromNamespaceAndPath(IceAndFireSpellbooks.MOD_ID, "animations/fire_dragon_priest.animation.json");
    }
}
