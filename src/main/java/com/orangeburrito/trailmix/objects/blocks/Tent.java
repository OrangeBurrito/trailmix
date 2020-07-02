package com.orangeburrito.trailmix.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class Tent extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_NS = Stream.of(
            Block.makeCuboidShape(-14, 2, -16, -13, 3, 32),
            Block.makeCuboidShape(7, 23, -16, 9, 24, 32),
            Block.makeCuboidShape(-2, 14, -16, -1, 15, 32),
            Block.makeCuboidShape(4, 20, -16, 5, 21, 32),
            Block.makeCuboidShape(5, 21, -16, 6, 22, 32),
            Block.makeCuboidShape(6, 22, -16, 7, 23, 32),
            Block.makeCuboidShape(2, 18, -16, 3, 19, 32),
            Block.makeCuboidShape(3, 19, -16, 4, 20, 32),
            Block.makeCuboidShape(1, 17, -16, 2, 18, 32),
            Block.makeCuboidShape(-1, 15, -16, 0, 16, 32),
            Block.makeCuboidShape(0, 16, -16, 1, 17, 32),
            Block.makeCuboidShape(-4, 12, -16, -3, 13, 32),
            Block.makeCuboidShape(-3, 13, -16, -2, 14, 32),
            Block.makeCuboidShape(-8, 8, -16, -7, 9, 32),
            Block.makeCuboidShape(-5, 11, -16, -4, 12, 32),
            Block.makeCuboidShape(-7, 9, -16, -6, 10, 32),
            Block.makeCuboidShape(-6, 10, -16, -5, 11, 32),
            Block.makeCuboidShape(-10, 6, -16, -9, 7, 32),
            Block.makeCuboidShape(-9, 7, -16, -8, 8, 32),
            Block.makeCuboidShape(-11, 5, -16, -10, 6, 32),
            Block.makeCuboidShape(-13, 3, -16, -12, 4, 32),
            Block.makeCuboidShape(20, 11, -16, 21, 12, 32),
            Block.makeCuboidShape(21, 10, -16, 22, 11, 32),
            Block.makeCuboidShape(9, 22, -16, 10, 23, 32),
            Block.makeCuboidShape(22, 9, -16, 23, 10, 32),
            Block.makeCuboidShape(10, 21, -16, 11, 22, 32),
            Block.makeCuboidShape(23, 8, -16, 24, 9, 32),
            Block.makeCuboidShape(11, 20, -16, 12, 21, 32),
            Block.makeCuboidShape(31, 0, -16, 32, 1, 32),
            Block.makeCuboidShape(19, 12, -16, 20, 13, 32),
            Block.makeCuboidShape(30, 1, -16, 31, 2, 32),
            Block.makeCuboidShape(18, 13, -16, 19, 14, 32),
            Block.makeCuboidShape(29, 2, -16, 30, 3, 32),
            Block.makeCuboidShape(17, 14, -16, 18, 15, 32),
            Block.makeCuboidShape(28, 3, -16, 29, 4, 32),
            Block.makeCuboidShape(16, 15, -16, 17, 16, 32),
            Block.makeCuboidShape(27, 4, -16, 28, 5, 32),
            Block.makeCuboidShape(15, 16, -16, 16, 17, 32),
            Block.makeCuboidShape(26, 5, -16, 27, 6, 32),
            Block.makeCuboidShape(14, 17, -16, 15, 18, 32),
            Block.makeCuboidShape(25, 6, -16, 26, 7, 32),
            Block.makeCuboidShape(13, 18, -16, 14, 19, 32),
            Block.makeCuboidShape(24, 7, -16, 25, 8, 32),
            Block.makeCuboidShape(12, 19, -16, 13, 20, 32),
            Block.makeCuboidShape(-12, 4, -16, -11, 5, 32),
            Block.makeCuboidShape(-16, 0, -16, -15, 1, 32),
            Block.makeCuboidShape(-15, 1, -16, -14, 2, 32)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_EW = Stream.of(
            Block.makeCuboidShape(-16, 2, -14, 32, 3, -13),
            Block.makeCuboidShape(-16, 23, 7, 32, 24, 9),
            Block.makeCuboidShape(-16, 14, -2, 32, 15, -1),
            Block.makeCuboidShape(-16, 20, 4, 32, 21, 5),
            Block.makeCuboidShape(-16, 21, 5, 32, 22, 6),
            Block.makeCuboidShape(-16, 22, 6, 32, 23, 7),
            Block.makeCuboidShape(-16, 18, 2, 32, 19, 3),
            Block.makeCuboidShape(-16, 19, 3, 32, 20, 4),
            Block.makeCuboidShape(-16, 17, 1, 32, 18, 2),
            Block.makeCuboidShape(-16, 15, -1, 32, 16, 0),
            Block.makeCuboidShape(-16, 16, 0, 32, 17, 1),
            Block.makeCuboidShape(-16, 12, -4, 32, 13, -3),
            Block.makeCuboidShape(-16, 13, -3, 32, 14, -2),
            Block.makeCuboidShape(-16, 8, -8, 32, 9, -7),
            Block.makeCuboidShape(-16, 11, -5, 32, 12, -4),
            Block.makeCuboidShape(-16, 9, -7, 32, 10, -6),
            Block.makeCuboidShape(-16, 10, -6, 32, 11, -5),
            Block.makeCuboidShape(-16, 6, -10, 32, 7, -9),
            Block.makeCuboidShape(-16, 7, -9, 32, 8, -8),
            Block.makeCuboidShape(-16, 5, -11, 32, 6, -10),
            Block.makeCuboidShape(-16, 3, -13, 32, 4, -12),
            Block.makeCuboidShape(-16, 11, 20, 32, 12, 21),
            Block.makeCuboidShape(-16, 10, 21, 32, 11, 22),
            Block.makeCuboidShape(-16, 22, 9, 32, 23, 10),
            Block.makeCuboidShape(-16, 9, 22, 32, 10, 23),
            Block.makeCuboidShape(-16, 21, 10, 32, 22, 11),
            Block.makeCuboidShape(-16, 8, 23, 32, 9, 24),
            Block.makeCuboidShape(-16, 20, 11, 32, 21, 12),
            Block.makeCuboidShape(-16, 0, 31, 32, 1, 32),
            Block.makeCuboidShape(-16, 12, 19, 32, 13, 20),
            Block.makeCuboidShape(-16, 1, 30, 32, 2, 31),
            Block.makeCuboidShape(-16, 13, 18, 32, 14, 19),
            Block.makeCuboidShape(-16, 2, 29, 32, 3, 30),
            Block.makeCuboidShape(-16, 14, 17, 32, 15, 18),
            Block.makeCuboidShape(-16, 3, 28, 32, 4, 29),
            Block.makeCuboidShape(-16, 15, 16, 32, 16, 17),
            Block.makeCuboidShape(-16, 4, 27, 32, 5, 28),
            Block.makeCuboidShape(-16, 16, 15, 32, 17, 16),
            Block.makeCuboidShape(-16, 5, 26, 32, 6, 27),
            Block.makeCuboidShape(-16, 17, 14, 32, 18, 15),
            Block.makeCuboidShape(-16, 6, 25, 32, 7, 26),
            Block.makeCuboidShape(-16, 18, 13, 32, 19, 14),
            Block.makeCuboidShape(-16, 7, 24, 32, 8, 25),
            Block.makeCuboidShape(-16, 19, 12, 32, 20, 13),
            Block.makeCuboidShape(-16, 4, -12, 32, 5, -11),
            Block.makeCuboidShape(-16, 0, -16, 32, 1, -15),
            Block.makeCuboidShape(-16, 1, -15, 32, 2, -14)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


    public Tent(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return SHAPE_NS;
            case SOUTH:
                return SHAPE_NS;
            case EAST:
                return SHAPE_EW;
            case WEST:
                return SHAPE_EW;
            default:
                return SHAPE_NS;
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
