package net.acetheeldritchking.ice_and_fire_spellbooks.config;

import net.minecraft.world.entity.EquipmentSlot;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class ArmorValueConfig {
    private static final ModConfigSpec.Builder configBuilder = new ModConfigSpec.Builder();

    public static final ModConfigSpec SPEC;

    // Config Values
    public static ArmorValues dragonsteelArmorValue;
    public static ArmorValues dragonsteelMaskArmorValue;

    static {
        dragonsteelArmorValue = setupConfig(configBuilder, List.of(6, 9, 12, 7));
        dragonsteelMaskArmorValue = setupConfig(configBuilder, List.of(5, 0, 0, 0));
        SPEC = configBuilder.build();
    }

    private static ArmorValues setupConfig(ModConfigSpec.Builder builder, List<Integer> armorPoints) {
        ArmorValues config = new ArmorValues(
                builder.worldRestart()
                        .comment("Defines armor values for Dragon Priest armor. Default is [6, 9, 12, 7]")
                        .comment("[head, legs, chest, feet]")
                        .defineList("dragonsteel_armor_values", () -> armorPoints, (p) -> true)
        );
        return config;
    }

    public record ArmorValues(ModConfigSpec.ConfigValue<List<? extends Integer>> armor) {
        //
        public int getProtectionValues(EquipmentSlot slot) {
            if (this.armor.get().size() != 4) {
                return this.armor.getDefault().get(slot.getIndex());
            } else {
                return this.armor.get().get(slot.getIndex());
            }
        }
    }

    /*private static void setupConfig(ModConfigSpec.Builder builder)
    {
        builder.comment("Defines the armor value of Dragon Priest armor");
        builder.push("Dragon Priest armor values");

        dragonsteelHelmetValue = builder
                .comment("Defines armor value for helmet. Default is 4 - You can set the value between 0 and 500")
                .defineInRange("dragonsteel_helmet_armor", 4, 0, 500);
        dragonsteelChestValue = builder
                .comment("Defines armor value for chestplate. Default is 9 - You can set the value between 0 and 500")
                .defineInRange("dragonsteel_helmet_armor", 9, 0, 500);
        dragonsteelLegsValue = builder
                .comment("Defines armor value for leggings. Default is 7 - You can set the value between 0 and 500")
                .defineInRange("dragonsteel_helmet_armor", 7, 0, 500);
        dragonsteelBootsValue = builder
                .comment("Defines armor value for boots. Default is 4 - You can set the value between 0 and 500")
                .defineInRange("dragonsteel_helmet_armor", 4, 0, 500);

        builder.pop();
    }*/
}