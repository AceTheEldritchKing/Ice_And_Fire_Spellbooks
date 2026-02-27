package net.acetheeldritchking.ice_and_fire_spellbooks.items.armor;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import net.acetheeldritchking.aces_spell_utils.entity.render.armor.EmissiveGenericCustomArmorRenderer;
import net.acetheeldritchking.ice_and_fire_spellbooks.IceAndFireSpellbooks;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor.FireDragonPriestMaskModel;
import net.acetheeldritchking.ice_and_fire_spellbooks.entity.armor.IceDragonPriestMaskModel;
import net.acetheeldritchking.ice_and_fire_spellbooks.registries.ArmorMaterialRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class IceDragonPriestMaskItem extends DragonArmorItem implements IPresetSpellContainer {
    public IceDragonPriestMaskItem(Type slot, Properties settings) {
        super(ArmorMaterialRegistries.FODAAN_MASK, slot, settings);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        if (!ISpellContainer.isSpellContainer(itemStack)) {
            ISpellContainer spellContainer = ISpellContainer.create(2, true, true);
            itemStack.set(ComponentRegistry.SPELL_CONTAINER, spellContainer);
        }
    }

    private static final ResourceLocation LAYER = ResourceLocation.fromNamespaceAndPath(
            IceAndFireSpellbooks.MOD_ID,
            "textures/models/armor/dragon_priest_mask_ice_glowmask.png");

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        RenderType GLOW_RENDER_TYPE = RenderType.breezeEyes(LAYER);

        return new EmissiveGenericCustomArmorRenderer<>(new IceDragonPriestMaskModel(), LAYER, GLOW_RENDER_TYPE);
    }
}
