package net.acetheeldritchking.ice_and_fire_spellbooks.entity.renderer.item;

import net.acetheeldritchking.ice_and_fire_spellbooks.entity.item.FireDragonPriestStaffModel;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.FireDragonPriestStaff;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FireDragonPriestStaffRenderer extends GeoItemRenderer<FireDragonPriestStaff> {
    public FireDragonPriestStaffRenderer() {
        super(new FireDragonPriestStaffModel());
    }
}
