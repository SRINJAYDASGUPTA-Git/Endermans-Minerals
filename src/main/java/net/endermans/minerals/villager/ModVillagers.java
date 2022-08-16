package net.endermans.minerals.villager;

import com.google.common.collect.ImmutableSet;
import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.blocks.ModBlocks;
import net.endermans.minerals.items.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final PointOfInterestType REDSTONE_TABLE_POI = registerPOI("redstone_table_poi", ModBlocks.REDSTONE_TABLE);
    public static final VillagerProfession ENGINEER = registerProfession("engineer",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY,
                    new Identifier(EndermansMinerals.MOD_ID, "redstone_table_poi")));







    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(
                Registry.VILLAGER_PROFESSION, new Identifier(EndermansMinerals.MOD_ID,name),
                VillagerProfessionBuilder.create()
                        .id(new Identifier(EndermansMinerals.MOD_ID,name))
                        .workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER)
                        .build());
    }

    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(EndermansMinerals.MOD_ID,name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerVillagers(){
        EndermansMinerals.LOGGER.debug("Registering villagers for"+EndermansMinerals.MOD_ID);
    }

    public static void registerTraders(){
        TradeOfferHelper.registerVillagerOffers(ENGINEER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.REDSTONE, 1),
                            6, 2, 0.02f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.REDSTONE_TORCH, 4),
                            6, 3, 0.02f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.TRIPWIRE_HOOK, 4),
                            new ItemStack(Items.EMERALD, 1),
                            6, 5, 0.02f
                    )));

                });
        TradeOfferHelper.registerVillagerOffers(ENGINEER, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Items.REPEATER, 1),
                            6, 5, 0.02f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(Items.COMPARATOR, 1),
                            6, 6, 0.02f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.COPPER_INGOT, 4),
                            new ItemStack(Items.EMERALD, 1),
                            6, 8, 0.02f
                    )));

                });
        TradeOfferHelper.registerVillagerOffers(ENGINEER, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(Items.OBSERVER, 1),
                            6, 5, 0.02f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Items.DISPENSER, 1),
                            6, 6, 0.02f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 6),
                            new ItemStack(Items.DROPPER, 1),
                            6, 8, 0.02f
                    )));

                });
        TradeOfferHelper.registerVillagerOffers(ENGINEER, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Items.SLIME_BLOCK, 1),
                            6, 5, 0.02f
                    )));


                });
        TradeOfferHelper.registerVillagerOffers(ENGINEER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Items.HOPPER, 1),
                            6, 6, 0.02f
                    )));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Items.PISTON, 4),
                            6, 8, 0.02f
                    )));

                });
    }
}
