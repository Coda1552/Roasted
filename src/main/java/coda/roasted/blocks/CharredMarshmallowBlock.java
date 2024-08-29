package coda.roasted.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class CharredMarshmallowBlock extends Block {

    public CharredMarshmallowBlock(Properties p_49795_) {
        super(p_49795_);
    }

    public void stepOn(Level p_153777_, BlockPos p_153778_, BlockState p_153779_, Entity p_153780_) {
        if (!p_153780_.fireImmune() && p_153780_ instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)p_153780_)) {
            p_153780_.hurt(p_153780_.damageSources().hotFloor(), 1.0F);
        }
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextFloat() > 0.5F) {
            double d0 = (double) pPos.getX() + 0.5;
            double d1 = (double) pPos.getY() + 0.5;
            double d2 = (double) pPos.getZ() + 0.5;
            double d3 = ((double) pRandom.nextFloat() - 0.5D) * 0.25D;
            double d4 = ((double) pRandom.nextFloat() - 0.5D) * 0.25D;
            double d5 = ((double) pRandom.nextFloat() - 0.5D) * 0.25D;

            pLevel.addParticle(ParticleTypes.SMALL_FLAME, d0, d1, d2, d3, d4, d5);
        }
    }

}
