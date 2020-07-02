package com.orangeburrito.trailmix.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class SodaMachine extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(2, 1.75, 15.5, 2.5, 5.75, 16),
            Block.makeCuboidShape(2.5, 5, 15, 7, 5.5, 15.75),
            Block.makeCuboidShape(7, 1.75, 15.5, 7.5, 5.75, 16),
            Block.makeCuboidShape(2.5, 4.25, 15, 7, 4.75, 15.75),
            Block.makeCuboidShape(2.5, 3.5, 15, 7, 4, 15.75),
            Block.makeCuboidShape(2.5, 2.75, 15, 7, 3.25, 15.75),
            Block.makeCuboidShape(2.5, 2, 15, 7, 2.5, 15.75),
            Block.makeCuboidShape(1, 0, 6.5, 15, 22, 14),
            Block.makeCuboidShape(0, 0, 6.5, 1, 22, 15.5),
            Block.makeCuboidShape(15, 0, 6.5, 16, 22, 15.5),
            Block.makeCuboidShape(7.5, 0, 14, 15, 22, 15.5),
            Block.makeCuboidShape(1, 0, 14, 7.5, 2, 15.5),
            Block.makeCuboidShape(1, 5.5, 14, 7.5, 22, 15.5),
            Block.makeCuboidShape(12, 22, 6.5, 16, 23, 15.5),
            Block.makeCuboidShape(4, 22, 6.5, 12, 23, 8.5),
            Block.makeCuboidShape(4, 22, 13.5, 12, 23, 15.5),
            Block.makeCuboidShape(4, 22, 12.5, 12, 23.5, 13.5),
            Block.makeCuboidShape(4, 22, 8.5, 12, 23.5, 9.5),
            Block.makeCuboidShape(3, 22, 10.5, 13, 23.5, 11.5),
            Block.makeCuboidShape(0, 22, 6.5, 4, 23, 15.5),
            Block.makeCuboidShape(2, 8, 5.5, 6, 14, 6.5),
            Block.makeCuboidShape(3, 8, 5, 5, 14, 5.5),
            Block.makeCuboidShape(3, 14, 5.5, 5, 15, 6.5),
            Block.makeCuboidShape(3, 7, 5.5, 5, 8, 6.5),
            Block.makeCuboidShape(1, 2, 13.5, 2, 5.5, 15.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(13.5, 1.75, 0, 14, 5.75, 0.5),
            Block.makeCuboidShape(9, 5, 0.25, 13.5, 5.5, 1),
            Block.makeCuboidShape(8.5, 1.75, 0, 9, 5.75, 0.5),
            Block.makeCuboidShape(9, 4.25, 0.25, 13.5, 4.75, 1),
            Block.makeCuboidShape(9, 3.5, 0.25, 13.5, 4, 1),
            Block.makeCuboidShape(9, 2.75, 0.25, 13.5, 3.25, 1),
            Block.makeCuboidShape(9, 2, 0.25, 13.5, 2.5, 1),
            Block.makeCuboidShape(1, 0, 2, 15, 22, 9.5),
            Block.makeCuboidShape(15, 0, 0.5, 16, 22, 9.5),
            Block.makeCuboidShape(0, 0, 0.5, 1, 22, 9.5),
            Block.makeCuboidShape(1, 0, 0.5, 8.5, 22, 2),
            Block.makeCuboidShape(8.5, 0, 0.5, 15, 2, 2),
            Block.makeCuboidShape(8.5, 5.5, 0.5, 15, 22, 2),
            Block.makeCuboidShape(0, 22, 0.5, 4, 23, 9.5),
            Block.makeCuboidShape(4, 22, 7.5, 12, 23, 9.5),
            Block.makeCuboidShape(4, 22, 0.5, 12, 23, 2.5),
            Block.makeCuboidShape(4, 22, 2.5, 12, 23.5, 3.5),
            Block.makeCuboidShape(4, 22, 6.5, 12, 23.5, 7.5),
            Block.makeCuboidShape(3, 22, 4.5, 13, 23.5, 5.5),
            Block.makeCuboidShape(12, 22, 0.5, 16, 23, 9.5),
            Block.makeCuboidShape(10, 8, 9.5, 14, 14, 10.5),
            Block.makeCuboidShape(11, 8, 10.5, 13, 14, 11),
            Block.makeCuboidShape(11, 14, 9.5, 13, 15, 10.5),
            Block.makeCuboidShape(11, 7, 9.5, 13, 8, 10.5),
            Block.makeCuboidShape(14, 2, 0.5, 15, 5.5, 2.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0.25, 2.75, 2.5, 1, 3.25, 7),
            Block.makeCuboidShape(2, 0, 1, 9.5, 22, 15),
            Block.makeCuboidShape(0.5, 0, 0, 9.5, 22, 1),
            Block.makeCuboidShape(0.5, 0, 15, 9.5, 22, 16),
            Block.makeCuboidShape(0.5, 0, 7.5, 2, 22, 15),
            Block.makeCuboidShape(0.5, 0, 1, 2, 2, 7.5),
            Block.makeCuboidShape(0.5, 5.5, 1, 2, 22, 7.5),
            Block.makeCuboidShape(0.5, 22, 12, 9.5, 23, 16),
            Block.makeCuboidShape(7.5, 22, 4, 9.5, 23, 12),
            Block.makeCuboidShape(0.5, 22, 4, 2.5, 23, 12),
            Block.makeCuboidShape(2.5, 22, 4, 3.5, 23.5, 12),
            Block.makeCuboidShape(6.5, 22, 4, 7.5, 23.5, 12),
            Block.makeCuboidShape(4.5, 22, 3, 5.5, 23.5, 13),
            Block.makeCuboidShape(0.5, 22, 0, 9.5, 23, 4),
            Block.makeCuboidShape(9.5, 8, 2, 10.5, 14, 6),
            Block.makeCuboidShape(10.5, 8, 3, 11, 14, 5),
            Block.makeCuboidShape(9.5, 14, 3, 10.5, 15, 5),
            Block.makeCuboidShape(9.5, 7, 3, 10.5, 8, 5),
            Block.makeCuboidShape(0.5, 2, 1, 2.5, 5.5, 2),
            Block.makeCuboidShape(0.25, 2, 2.5, 1, 2.5, 7),
            Block.makeCuboidShape(0, 1.75, 2, 0.5, 5.75, 2.5),
            Block.makeCuboidShape(0.25, 5, 2.5, 1, 5.5, 7),
            Block.makeCuboidShape(0, 1.75, 7, 0.5, 5.75, 7.5),
            Block.makeCuboidShape(0.25, 4.25, 2.5, 1, 4.75, 7),
            Block.makeCuboidShape(0.25, 3.5, 2.5, 1, 4, 7)

    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(15, 2.75, 9, 15.75, 3.25, 13.5),
            Block.makeCuboidShape(6.5, 0, 1, 14, 22, 15),
            Block.makeCuboidShape(6.5, 0, 15, 15.5, 22, 16),
            Block.makeCuboidShape(6.5, 0, 0, 15.5, 22, 1),
            Block.makeCuboidShape(14, 0, 1, 15.5, 22, 8.5),
            Block.makeCuboidShape(14, 0, 8.5, 15.5, 2, 15),
            Block.makeCuboidShape(14, 5.5, 8.5, 15.5, 22, 15),
            Block.makeCuboidShape(6.5, 22, 0, 15.5, 23, 4),
            Block.makeCuboidShape(6.5, 22, 4, 8.5, 23, 12),
            Block.makeCuboidShape(13.5, 22, 4, 15.5, 23, 12),
            Block.makeCuboidShape(12.5, 22, 4, 13.5, 23.5, 12),
            Block.makeCuboidShape(8.5, 22, 4, 9.5, 23.5, 12),
            Block.makeCuboidShape(10.5, 22, 3, 11.5, 23.5, 13),
            Block.makeCuboidShape(6.5, 22, 12, 15.5, 23, 16),
            Block.makeCuboidShape(5.5, 8, 10, 6.5, 14, 14),
            Block.makeCuboidShape(5, 8, 11, 5.5, 14, 13),
            Block.makeCuboidShape(5.5, 14, 11, 6.5, 15, 13),
            Block.makeCuboidShape(5.5, 7, 11, 6.5, 8, 13),
            Block.makeCuboidShape(13.5, 2, 14, 15.5, 5.5, 15),
            Block.makeCuboidShape(15, 2, 9, 15.75, 2.5, 13.5),
            Block.makeCuboidShape(15.5, 1.75, 13.5, 16, 5.75, 14),
            Block.makeCuboidShape(15, 5, 9, 15.75, 5.5, 13.5),
            Block.makeCuboidShape(15.5, 1.75, 8.5, 16, 5.75, 9),
            Block.makeCuboidShape(15, 4.25, 9, 15.75, 4.75, 13.5),
            Block.makeCuboidShape(15, 3.5, 9, 15.75, 4, 13.5)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public SodaMachine(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
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
