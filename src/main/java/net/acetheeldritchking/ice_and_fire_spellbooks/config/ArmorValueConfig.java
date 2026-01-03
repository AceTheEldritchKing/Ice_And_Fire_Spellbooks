package net.acetheeldritchking.ice_and_fire_spellbooks.config;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class ArmorValueConfig {
    private static final ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec SPEC;

    // Config Values
    public static ArmorValues dragonsteelArmorValue;
    public static ArmorValues dragonsteelMaskArmorValue;

    static
    {
        configBuilder.push("ArmorConfig");

        dragonsteelArmorValue = setupConfig(configBuilder, "DragonPriestArmor", List.of(6, 9, 12, 6));
        dragonsteelMaskArmorValue = setupConfig(configBuilder, "DragonPriestMasks", List.of(1, 1, 1, 5));

        configBuilder.pop();
        SPEC = configBuilder.build();
    }

    private static ArmorValues setupConfig(ForgeConfigSpec.Builder builder, String name, List<Integer> armorPoints)
    {
        builder.push(name);
        var config = new ArmorValues(
                builder.worldRestart()
                        .comment("Defines armor values for Dragon Priest armor. Default is [6, 9, 12, 6]")
                        .comment("[feet, legs, chest, head]")
                        .defineList("dragonsteel_armor_values", () -> armorPoints, (p) -> true)
        );
        builder.pop();
        return config;
    }

    public static record ArmorValues (ForgeConfigSpec.ConfigValue<List<? extends Integer>> armor)
    {
        //
        public int getProtectionValues(EquipmentSlot slot)
        {
            if (armor.get().size() != 4)
            {
                return armor.getDefault().get(slot.getIndex());
            }
            else
            {
                return armor.get().get(slot.getIndex());
            }
        }
    }

    /*private static void setupConfig(ForgeConfigSpec.Builder builder)
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