package net.endermans.minerals.blocks.entity;

import net.endermans.minerals.items.ModItems;
import net.endermans.minerals.screen.MortarPestleScreenHandler;
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
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MortarPestleBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(2, ItemStack.EMPTY);


    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public MortarPestleBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MORTAL_PESTLE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                switch(index){
                    case 0: return MortarPestleBlockEntity.this.progress;
                    case 1: return MortarPestleBlockEntity.this.maxProgress;
                    default:return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch(index){
                    case 0: MortarPestleBlockEntity.this.progress = value;break;
                    case 1: MortarPestleBlockEntity.this.maxProgress = value;break;
                }

            }

            @Override
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
        return Text.literal("Mortar and Pestle");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new MortarPestleScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
        nbt.putInt("mortar_pestle.progress", progress);

    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("mortar_pestle.progress");
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, MortarPestleBlockEntity entity) {
        if(world.isClient()) {
            return;
        }

        if(hasRecipe(entity)){
            entity.progress++;
            markDirty(world, blockPos, blockState);
            if(entity.progress >= entity.maxProgress){
                craftItem(entity);
            }
        }
        else{
            entity.resetProgress();
            markDirty(world, blockPos, blockState);
        }

    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(MortarPestleBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i< entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        if(hasRecipe(entity)){
            entity.removeStack(0, 1);

            entity.setStack(1, new ItemStack(ModItems.LITHIUM_DUST,
                    entity.getStack(1).getCount() + 1));
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(MortarPestleBlockEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i< entity.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        boolean hasIntactIngotInFirstSlot =
                entity.getStack(0).getItem() == ModItems.LITHIUM;
        return hasIntactIngotInFirstSlot && canInsertAmountIntoOutputSlot(inventory, 1)
                && canInsertAmountIntoOutputSlot(inventory, ModItems.LITHIUM_DUST);

    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, int count) {
        return inventory.getStack(1).getMaxCount() > inventory.getStack(1).getCount()+count;
    }
    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory, Item item) {
        return inventory.getStack(1).getItem() == item || inventory.getStack(1).isEmpty();

    }
}
