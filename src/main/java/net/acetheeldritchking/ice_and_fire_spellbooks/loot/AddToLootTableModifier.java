package net.acetheeldritchking.ice_and_fire_spellbooks.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddToLootTableModifier extends LootModifier {
    public static final Supplier<MapCodec<AddToLootTableModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst).and(ResourceLocation.CODEC
            .fieldOf("loot_table").forGetter(m -> m.loot_table)).apply(inst, AddToLootTableModifier::new)));
    private final ResourceLocation loot_table;

    public AddToLootTableModifier(LootItemCondition[] conditionsIn, ResourceLocation item) {
        super(conditionsIn);
        this.loot_table = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        LootTable addedLootTable = context.getResolver().lookupOrThrow(Registries.LOOT_TABLE).getOrThrow(ResourceKey.create(Registries.LOOT_TABLE, this.loot_table)).value();
        addedLootTable.getRandomItemsRaw(context, LootTable.createStackSplitter(context.getLevel(), generatedLoot::add));

        //generatedLoot.add(new ItemStack(this.item));

        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
