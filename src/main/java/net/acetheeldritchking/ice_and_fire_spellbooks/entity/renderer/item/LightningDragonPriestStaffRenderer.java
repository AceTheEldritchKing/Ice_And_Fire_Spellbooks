package net.acetheeldritchking.ice_and_fire_spellbooks.entity.renderer.item;

import net.acetheeldritchking.ice_and_fire_spellbooks.entity.item.FireDragonPriestStaffModel;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.item.LightningDragonPriestStaffModel;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.FireDragonPriestStaff;
import net.acetheeldritchking.ice_and_fire_spellbooks.items.staffs.LightningDragonPriestStaff;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LightningDragonPriestStaffRenderer extends GeoItemRenderer<LightningDragonPriestStaff> {
    public LightningDragonPriestStaffRenderer() {
        super(new LightningDragonPriestStaffModel());
    }
}
