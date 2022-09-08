package net.endermans.minerals.blocks.entity;

import net.endermans.minerals.blocks.custom.SmelterBlock;
import net.endermans.minerals.fluid.ModFluids;
import net.endermans.minerals.items.ModItems;
import net.endermans.minerals.network.ModMessages;
import net.endermans.minerals.recipe.SmelterRecipe;
import net.endermans.minerals.screen.SmelterScreenHandler;
import net.endermans.minerals.util.FluidStack;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class SmelterBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(30000, 32, 32){
        @Override
        protected void onFinalCommit() {
            markDirty();
            if(!world.isClient()){
                PacketByteBuf data = PacketByteBufs.create();
                data.writeLong(amount);
                data.writeBlockPos(getPos());

                for(ServerPlayerEntity player: PlayerLookup.tracking(((ServerWorld) world), getPos())){
                    ServerPlayNetworking.send(player, ModMessages.ENERGY_SYNC, data);
                }
            }
        }
    };

    public final SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 20;//20k Mb
        }

        @Override
        protected void onFinalCommit() {
            markDirty();
            if(!world.isClient()){
                PacketByteBuf data = PacketByteBufs.create();
                variant.toPacket(data);
                data.writeLong(amount);
                data.writeBlockPos(getPos());

                for(ServerPlayerEntity player: PlayerLookup.tracking(((ServerWorld) world), getPos())) {
                    ServerPlayNetworking.send(player, ModMessages.FLUID_SYNC, data);
                }
            }

        }
    };

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    public SmelterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SMELTER, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return SmelterBlockEntity.this.progress;
                    case 1: return SmelterBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: SmelterBlockEntity.this.progress = value; break;
                    case 1: SmelterBlockEntity.this.maxProgress = value; break;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Smelter");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new SmelterScreenHandler(syncId, inv, this, this.propertyDelegate);
    }
    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("smelter.progress", progress);
        nbt.putLong("smelter.energy", energyStorage.amount);
        nbt.put("smelter.fluidVariant", fluidStorage.variant.toNbt());
        nbt.putLong("smelter.fluidLevel", fluidStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("smelter.progress");
        energyStorage.amount = nbt.getLong("smelter.energy");
        fluidStorage.variant = FluidVariant.fromNbt((NbtCompound) nbt.get("smelter.fluidVariant"));
        fluidStorage.amount = nbt.getLong("smelter.fluidLevel");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(SmelterBlock.FACING);

        if(side == Direction.UP || side == Direction.DOWN){
            return false;
        }


        return switch (localDir){
            default ->
                side.getOpposite() == Direction.NORTH && slot == 1 ||
                        side.getOpposite() == Direction.EAST && slot == 1 ||
                        side.getOpposite() == Direction.WEST && slot == 0;
            case EAST ->
                side.rotateYClockwise() == Direction.NORTH && slot == 1||
                        side.rotateYClockwise() == Direction.EAST && slot == 1||
                        side.rotateYClockwise() == Direction.WEST && slot == 0;
            case SOUTH ->
                    side == Direction.NORTH && slot == 1||
                            side == Direction.EAST && slot == 1||
                            side == Direction.WEST && slot == 0;
            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == 1||
                            side.rotateYCounterclockwise() == Direction.EAST && slot == 1||
                            side.rotateYCounterclockwise() == Direction.WEST && slot == 0;
        };
    }


    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(SmelterBlock.FACING);

        if(side == Direction.UP) {
            return false;
        }

        // Down extract 2
        if(side == Direction.DOWN) {
            return slot == 2;
        }

        // bottom extract 2
        // right extract 2
        return switch (localDir) {
            default -> side.getOpposite() == Direction.SOUTH && slot == 2 ||
                    side.getOpposite() == Direction.EAST && slot == 2;
            case EAST -> side.rotateYClockwise() == Direction.SOUTH && slot == 2 ||
                    side.rotateYClockwise() == Direction.EAST && slot == 2;
            case SOUTH -> side == Direction.SOUTH && slot == 2 ||
                    side == Direction.EAST && slot == 2;
            case WEST -> side.rotateYCounterclockwise() == Direction.SOUTH && slot == 2 ||
                    side.rotateYCounterclockwise() == Direction.EAST && slot == 2;
        };
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, SmelterBlockEntity entity) {
        if(world.isClient()) {
            return;
        }

        if(hasEnergyItem(entity)){
            try(Transaction transaction = Transaction.openOuter()){
                entity.energyStorage.insert(16, transaction);
                transaction.commit();
            }
        }

        if(hasRecipe(entity) && hasEnoughEnergy(entity) && hasEnoughFluid(entity)) {
            entity.progress++;
            extractEnergy(entity);
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
                extractFluid(entity);
            }
        } else {
            entity.resetProgress();
            markDirty(world, blockPos, state);
        }

        if(hasFluidSourceInSlot(entity)){
            transferFluidIntoFluidStorage(entity);
        }
    }

    private static void extractFluid(SmelterBlockEntity entity) {
        try(Transaction transaction = Transaction.openOuter()){
            entity.fluidStorage.extract(FluidVariant.of(ModFluids.STILL_ELEMENTX),
                    500, transaction);
            transaction.commit();
        }

    }

    private static void transferFluidIntoFluidStorage(SmelterBlockEntity entity) {
        try(Transaction transaction = Transaction.openOuter()){
            entity.fluidStorage.insert(FluidVariant.of(ModFluids.STILL_ELEMENTX),
                    FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
            transaction.commit();
            entity.setStack(0, new ItemStack(Items.BUCKET));
        }
    }

    private static boolean hasFluidSourceInSlot(SmelterBlockEntity entity) {
        return entity.getStack(0).getItem() == ModFluids.ELEMENTX_BUCKET;
    }

    private static boolean hasEnoughFluid(SmelterBlockEntity entity) {
        return entity.fluidStorage.amount >= 500;//in milliBucket, 1Bucket = 1000mB
    }

    private static void extractEnergy(SmelterBlockEntity entity) {

        try(Transaction transaction = Transaction.openOuter()){
            entity.energyStorage.extract(32, transaction);
            transaction.commit();
        }
    }

    private static boolean hasEnoughEnergy(SmelterBlockEntity entity) {
        return entity.energyStorage.amount >= 32;
    }

    private static boolean hasEnergyItem(SmelterBlockEntity entity) {
        return entity.getStack(0).getItem() == ModItems.LITHIUM;
    }

    private static void craftItem(SmelterBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<SmelterRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(SmelterRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            entity.removeStack(1, 1);

            entity.setStack(2, new ItemStack(recipe.get().getOutput().getItem(),
                    entity.getStack(2).getCount() + 1));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(SmelterBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }
        Optional<SmelterRecipe> match = entity.getWorld().getRecipeManager().getFirstMatch(SmelterRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }


    public void setEnergyLevel(long energy) {
        this.energyStorage.amount = energy;
    }
    public void setFluidLevel(FluidVariant fluidVariant, long fluidLevel){
        this.fluidStorage.variant = fluidVariant;
        this.fluidStorage.amount = fluidLevel;
    }
}
