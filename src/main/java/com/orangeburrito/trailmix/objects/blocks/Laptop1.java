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

public class Laptop1 extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(1, 9, 15, 15, 10, 16),
            Block.makeCuboidShape(1, 0, 1, 15, 1, 11),
            Block.makeCuboidShape(1, 1, 11, 15, 3, 12),
            Block.makeCuboidShape(1, 3, 12, 15, 5, 13),
            Block.makeCuboidShape(1, 5, 13, 15, 7, 14),
            Block.makeCuboidShape(1, 7, 14, 15, 9, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(1, 9, 0, 15, 10, 1),
            Block.makeCuboidShape(1, 0, 5, 15, 1, 15),
            Block.makeCuboidShape(1, 1, 4, 15, 3, 5),
            Block.makeCuboidShape(1, 3, 3, 15, 5, 4),
            Block.makeCuboidShape(1, 5, 2, 15, 7, 3),
            Block.makeCuboidShape(1, 7, 1, 15, 9, 2)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 9, 1, 1, 10, 15),
            Block.makeCuboidShape(5, 0, 1, 15, 1, 15),
            Block.makeCuboidShape(4, 1, 1, 5, 3, 15),
            Block.makeCuboidShape(3, 3, 1, 4, 5, 15),
            Block.makeCuboidShape(2, 5, 1, 3, 7, 15),
            Block.makeCuboidShape(1, 7, 1, 2, 9, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(15, 9, 1, 16, 10, 15),
            Block.makeCuboidShape(1, 0, 1, 11, 1, 15),
            Block.makeCuboidShape(11, 1, 1, 12, 3, 15),
            Block.makeCuboidShape(12, 3, 1, 13, 5, 15),
            Block.makeCuboidShape(13, 5, 1, 14, 7, 15),
            Block.makeCuboidShape(14, 7, 1, 15, 9, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Laptop1(Properties properties) {
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
