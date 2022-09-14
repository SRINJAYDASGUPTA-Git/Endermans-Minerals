package net.endermans.minerals.blocks.custom;

import net.endermans.minerals.blocks.entity.ModBlockEntities;
import net.endermans.minerals.blocks.entity.MortarPestleBlockEntity;
import net.endermans.minerals.blocks.entity.SmelterBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class SmelterBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    private final VoxelShape VoxelShape_N = Stream.of(
            Block.createCuboidShape(6,  6, 8, 10,  17, 9),
            Block.createCuboidShape(8,  6, 7, 8,   17, 11),
            Block.createCuboidShape(8,  6, 7, 8,   17, 11),
            Block.createCuboidShape(7,  6, 6, 8,   17, 11),
            Block.createCuboidShape(7,  6, 6, 8,   17, 11),
            Block.createCuboidShape(6,  6, 8, 10,  17, 9),
            Block.createCuboidShape(6,  6, 8, 10,  17, 9),
            Block.createCuboidShape(6,  6, 8, 10,  17, 9),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(7,  6, 11, 8,  16, 12),
            Block.createCuboidShape(7,  6, 10, 8,  16, 11),
            Block.createCuboidShape(10, 6, 8,  11, 16, 9),
            Block.createCuboidShape(7,  6, 6,  9,  16, 7),
            Block.createCuboidShape(7,  6, 6,  9,  16, 7),
            Block.createCuboidShape(7,  6, 6,  8,  16, 7),
            Block.createCuboidShape(7,  6, 5,  8,  16, 6),
            Block.createCuboidShape(10, 6, 8,  11, 16, 9),
            Block.createCuboidShape(10, 6, 8,  11, 16, 9),
            Block.createCuboidShape(10, 6, 8,  11, 16, 9),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(11, 6, 8,  12, 16, 9),
            Block.createCuboidShape(7,  6, 5,  9,  16, 6),
            Block.createCuboidShape(7,  6, 5,  9,  16, 6),
            Block.createCuboidShape(7,  6, 5,  9,  16, 6),
            Block.createCuboidShape(7,  6, 4,  9,  16, 5),
            Block.createCuboidShape(11, 6, 8,  12, 16, 9),
            Block.createCuboidShape(11, 6, 8,  12, 16, 9),
            Block.createCuboidShape(11, 6, 8,  12, 16, 9),
            Block.createCuboidShape(4,  6, 8,  5,  16, 9),
            Block.createCuboidShape(4,  6, 8,  5,  16, 9),
            Block.createCuboidShape(4,  6, 8,  5,  16, 9),
            Block.createCuboidShape(0,  0, 1,  16, 1,  17),
            Block.createCuboidShape(0,  5, 1,  16, 6,  17),
            Block.createCuboidShape(3,  6, 4,  13, 6,  14),
            Block.createCuboidShape(15, 6, 6,  16, 9,  12),
            Block.createCuboidShape(0,  6, 6,  1,  9,  12),
            Block.createCuboidShape(0,  1, 1,  1,  5,  17),
            Block.createCuboidShape(15, 1, 1,  16, 5,  17),
            Block.createCuboidShape(0,  0, 16, 16, 6,  17),
            Block.createCuboidShape(0,  0, 0,  16, 6,  1),
            Block.createCuboidShape(3,  2, 0,  4,  4,  0),
            Block.createCuboidShape(12, 1, 0,  14, 4,  0),
            Block.createCuboidShape(6,  2, 0,  9,  4,  0)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private final VoxelShape VoxelShape_S=Stream.of(
            Block.createCuboidShape(6,  6, 8,  10, 17, 9),
            Block.createCuboidShape(7,  6, 6,  8,  17, 10),
            Block.createCuboidShape(8,  6, 6,  8,  17, 10),
            Block.createCuboidShape(8,  6, 6,  9,  17, 10),
            Block.createCuboidShape(8,  6, 6,  9,  17, 10),
            Block.createCuboidShape(6,  6, 8,  10, 17, 8),
            Block.createCuboidShape(6,  6, 8,  10, 17, 8),
            Block.createCuboidShape(6,  6, 8,  10, 17, 9),
            Block.createCuboidShape(7,  6, 5,  8,  16, 6),
            Block.createCuboidShape(7,  6, 5,  9,  16, 6),
            Block.createCuboidShape(8,  6, 5,  9,  16, 6),
            Block.createCuboidShape(7,  6, 5,  9,  16, 6),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(7,  6, 10, 8,  16, 11),
            Block.createCuboidShape(7,  6, 10, 9,  16, 11),
            Block.createCuboidShape(8,  6, 10, 9,  16, 11),
            Block.createCuboidShape(8,  6, 10, 9,  16, 11),
            Block.createCuboidShape(5,  6, 7,  6,  16, 9),
            Block.createCuboidShape(5,  6, 7,  6,  16, 9),
            Block.createCuboidShape(5,  6, 7,  6,  16, 9),
            Block.createCuboidShape(10, 6, 7,  11, 16, 9),
            Block.createCuboidShape(10, 6, 7,  11, 16, 9),
            Block.createCuboidShape(10, 6, 7,  11, 16, 9),
            Block.createCuboidShape(10, 6, 7,  11, 16, 9),
            Block.createCuboidShape(4,  6, 7,  5,  16, 9),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(4,  6, 7,  5,  16, 9),
            Block.createCuboidShape(4,  6, 7,  5,  16, 9),
            Block.createCuboidShape(4,  6, 7,  5,  16, 9),
            Block.createCuboidShape(11, 6, 7,  12, 16, 9),
            Block.createCuboidShape(11, 6, 7,  12, 16, 9),
            Block.createCuboidShape(11, 6, 7,  12, 16, 9),
            Block.createCuboidShape(0,  0, 0,  16, 1, 16),
            Block.createCuboidShape(0,  5, 0,  16, 6, 16),
            Block.createCuboidShape(3,  6, 3,  13, 6, 13),
            Block.createCuboidShape(0,  6, 5,  1,  9, 11),
            Block.createCuboidShape(15, 6, 5,  16, 9, 11),
            Block.createCuboidShape(15, 1, 0,  16, 5, 16),
            Block.createCuboidShape(0,  1, 0,  1,  5, 16),
            Block.createCuboidShape(0,  0, 0,  16, 6, 0),
            Block.createCuboidShape(0,  0, 16, 16, 6, 16),
            Block.createCuboidShape(12, 2, 16, 13, 4, 17),
            Block.createCuboidShape(2,  1, 16, 4,  4, 16),
            Block.createCuboidShape(7,  2, 16, 10, 4, 16)
            ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();


    private final VoxelShape VoxelShape_E = Stream.of(
            Block.createCuboidShape(7,  6, 6,  8,  17, 10),
            Block.createCuboidShape(6,  6, 8,  10, 17, 9),
            Block.createCuboidShape(6,  6, 8,  10, 17, 9),
            Block.createCuboidShape(6,  6, 8,  10, 17, 9),
            Block.createCuboidShape(6,  6, 8,  10, 17, 9),
            Block.createCuboidShape(7,  6, 6,  8,  17, 10),
            Block.createCuboidShape(7,  6, 6,  8,  17, 10),
            Block.createCuboidShape(7,  6, 6,  8,  17, 10),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(5,  6, 7,  6,  16, 9),
            Block.createCuboidShape(7,  6, 10, 8,  16, 11),
            Block.createCuboidShape(10, 6, 8,  11, 16, 9),
            Block.createCuboidShape(10, 6, 7,  11, 16, 9),
            Block.createCuboidShape(10, 6, 7,  11, 16, 9),
            Block.createCuboidShape(10, 6, 7,  11, 16, 9),
            Block.createCuboidShape(7,  6, 10, 8,  16, 11),
            Block.createCuboidShape(7,  6, 10, 8,  16, 11),
            Block.createCuboidShape(7,  6, 10, 8,  16, 11),
            Block.createCuboidShape(7,  6, 5,  8,  16, 6),
            Block.createCuboidShape(7,  6, 5,  8,  16, 6),
            Block.createCuboidShape(7,  6, 5,  8,  16, 6),
            Block.createCuboidShape(7,  6, 5,  8,  16, 6),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(11, 6, 8,  12, 16, 9),
            Block.createCuboidShape(11, 6, 7,  12, 16, 9),
            Block.createCuboidShape(11, 6, 7,  12, 16, 9),
            Block.createCuboidShape(11, 6, 7,  12, 16, 9),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(7,  6, 4,  9,  16, 5),
            Block.createCuboidShape(7,  6, 4,  9,  16, 5),
            Block.createCuboidShape(7,  6, 4,  9,  16, 5),
            Block.createCuboidShape(0,  0, 0,  16, 1,  16),
            Block.createCuboidShape(0,  5, 0,  16, 6,  16),
            Block.createCuboidShape(3,  6, 3,  13, 6,  13),
            Block.createCuboidShape(5,  6, 15, 11, 9,  16),
            Block.createCuboidShape(5,  6, 0,  11, 9,  0),
            Block.createCuboidShape(0,  1, 0,  16, 5,  1),
            Block.createCuboidShape(0,  1, 15, 16, 5,  16),
            Block.createCuboidShape(0,  0, 0,  0,  6,  16),
            Block.createCuboidShape(16, 0, 0,  16, 6,  16),
            Block.createCuboidShape(16, 2, 3,  16, 4,  4),
            Block.createCuboidShape(16, 1, 12, 16, 4,  14),
            Block.createCuboidShape(16, 2, 7,  16, 4,  9)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;

    private final VoxelShape VoxelShape_W = Stream.of(
            Block.createCuboidShape(8,  6, 6,  9,  17, 11),
            Block.createCuboidShape(6,  6, 8,  10, 17, 9),
            Block.createCuboidShape(6,  6, 8,  10, 17, 9),
            Block.createCuboidShape(6,  6, 8,  10, 17, 9),
            Block.createCuboidShape(6,  6, 8,  10, 17, 9),
            Block.createCuboidShape(8,  6, 6,  9,  17, 10),
            Block.createCuboidShape(8,  6, 6,  9,  17, 10),
            Block.createCuboidShape(8,  6, 6,  9,  17, 10),
            Block.createCuboidShape(10, 6, 8,  11, 16, 9),
            Block.createCuboidShape(10, 6, 8,  11, 16, 9),
            Block.createCuboidShape(10, 6, 8,  11, 16, 9),
            Block.createCuboidShape(10, 6, 8,  11, 16, 9),
            Block.createCuboidShape(8,  6, 5,  9,  16, 7),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(5,  6, 8,  6,  16, 9),
            Block.createCuboidShape(8,  6, 5,  9,  16, 6),
            Block.createCuboidShape(8,  6, 5,  9,  16, 6),
            Block.createCuboidShape(8,  6, 5,  9,  16, 6),
            Block.createCuboidShape(8,  6, 10, 9,  16, 11),
            Block.createCuboidShape(8,  6, 10, 9,  16, 11),
            Block.createCuboidShape(8,  6, 10, 9,  16, 11),
            Block.createCuboidShape(8,  6, 10, 9,  16, 12),
            Block.createCuboidShape(7,  6, 4,  9,  16, 5),
            Block.createCuboidShape(4,  6, 7,  5,  16, 9),
            Block.createCuboidShape(4,  6, 7,  5,  16, 9),
            Block.createCuboidShape(4,  6, 8,  5,  16, 9),
            Block.createCuboidShape(4,  6, 8,  5,  16, 9),
            Block.createCuboidShape(7,  6, 4,  9,  16, 5),
            Block.createCuboidShape(7,  6, 4,  9,  16, 5),
            Block.createCuboidShape(7,  6, 4,  9,  16, 5),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(7,  6, 11, 9,  16, 12),
            Block.createCuboidShape(0,  0, 0,  16, 1,  16),
            Block.createCuboidShape(0,  5, 0,  16, 6,  16),
            Block.createCuboidShape(3,  6, 3,  13, 6,  13),
            Block.createCuboidShape(5,  6, 0,  11, 9,  1),
            Block.createCuboidShape(5,  6, 16, 11, 9,  17),
            Block.createCuboidShape(0,  1, 15, 16, 5,  16),
            Block.createCuboidShape(0,  1, 0,  16, 5,  1),
            Block.createCuboidShape(16, 0, 0,  16, 6,  16),
            Block.createCuboidShape(0,  0, 0,  0,  6,  16),
            Block.createCuboidShape(0,  2, 12, 0,  4,  13),
            Block.createCuboidShape(0,  1, 2,  0,  4,  4),
            Block.createCuboidShape(0,  2, 7,  0,  4,  10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();;


    public SmelterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch(state.get(FACING)){
            case NORTH :
                return VoxelShape_N;
            case SOUTH:
                return VoxelShape_S;
            case EAST:
                return VoxelShape_E;
            case WEST:
                return VoxelShape_W;
            default: return VoxelShape_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /*BLOCK ENTITY*/

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof SmelterBlockEntity){
                ItemScatterer.spawn(world, pos, (SmelterBlockEntity)blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand,
                              BlockHitResult hit) {
        if(!world.isClient){
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if(screenHandlerFactory != null){
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SmelterBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.SMELTER, SmelterBlockEntity::tick);
    }
}
