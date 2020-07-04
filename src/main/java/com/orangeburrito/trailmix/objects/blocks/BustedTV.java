package com.orangeburrito.trailmix.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class BustedTV extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1.5, 0, 6.5, 14.5, 11, 12),
            Block.makeCuboidShape(14.5, 4, 8, 15.5, 7, 11),
            Block.makeCuboidShape(0.5, 4, 8, 1.5, 7, 11),
            Block.makeCuboidShape(5.5, 11, 7.5, 10.5, 13, 11.5),
            Block.makeCuboidShape(6.5, 13, 9, 9.5, 14, 10),
            Block.makeCuboidShape(4.5, 14, 9, 10.5, 16, 10),
            Block.makeCuboidShape(3, 0, 12, 13, 9.75, 15.75)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1.5, 0, 4, 14.5, 11, 9.5),
            Block.makeCuboidShape(0.5, 4, 5, 1.5, 7, 8),
            Block.makeCuboidShape(14.5, 4, 5, 15.5, 7, 8),
            Block.makeCuboidShape(5.5, 11, 4.5, 10.5, 13, 8.5),
            Block.makeCuboidShape(6.5, 13, 6, 9.5, 14, 7),
            Block.makeCuboidShape(5.5, 14, 6, 11.5, 16, 7),
            Block.makeCuboidShape(3, 0, 0.25, 13, 9.75, 4)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(4, 0, 1.5, 9.5, 11, 14.5),
            Block.makeCuboidShape(5, 4, 14.5, 8, 7, 15.5),
            Block.makeCuboidShape(5, 4, 0.5, 8, 7, 1.5),
            Block.makeCuboidShape(4.5, 11, 5.5, 8.5, 13, 10.5),
            Block.makeCuboidShape(6, 13, 6.5, 7, 14, 9.5),
            Block.makeCuboidShape(6, 14, 4.5, 7, 16, 10.5),
            Block.makeCuboidShape(0.25, 0, 3, 4, 9.75, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(6.5, 0, 1.5, 12, 11, 14.5),
            Block.makeCuboidShape(8, 4, 0.5, 11, 7, 1.5),
            Block.makeCuboidShape(8, 4, 14.5, 11, 7, 15.5),
            Block.makeCuboidShape(7.5, 11, 5.5, 11.5, 13, 10.5),
            Block.makeCuboidShape(9, 13, 6.5, 10, 14, 9.5),
            Block.makeCuboidShape(9, 14, 5.5, 10, 16, 11.5),
            Block.makeCuboidShape(12, 0, 3, 15.75, 9.75, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public BustedTV(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override // deprecated code
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override // deprecated code
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
