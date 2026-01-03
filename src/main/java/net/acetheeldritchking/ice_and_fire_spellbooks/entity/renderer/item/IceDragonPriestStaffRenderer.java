package net.acetheeldritchking.ice_and_fire_spellbooks.entity.renderer.item;

import net.acetheeldritchking.ice_and_fire_spellbooks.entity.item.FireDragonPriestStaffModel;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.item.IceDragonPriestStaffModel;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.FireDragonPriestStaff;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.IceDragonPriestStaff;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class IceDragonPriestStaffRenderer extends GeoItemRenderer<IceDragonPriestStaff> {
    public IceDragonPriestStaffRenderer() {
        super(new IceDragonPriestStaffModel());
    }
}
