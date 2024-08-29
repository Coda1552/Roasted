package coda.roasted.registry;

import coda.roasted.Roasted;
import coda.roasted.blocks.CharredMarshmallowBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class RoastedBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Roasted.MOD_ID);

    public static final RegistryObject<Block> PILE_OF_MARSHMALLOWS = register("pile_of_marshmallows", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.FUNGUS).strength(1.0F)));
    public static final RegistryObject<Block> PILE_OF_WARM_MARSHMALLOWS = register("pile_of_warm_marshmallows", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.FUNGUS).strength(1.0F)));
    public static final RegistryObject<Block> PILE_OF_PERFECT_MARSHMALLOWS = register("pile_of_perfect_marshmallows", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.FUNGUS).strength(1.0F)));
    public static final RegistryObject<Block> PILE_OF_BURNT_MARSHMALLOWS = register("pile_of_burnt_marshmallows", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.FUNGUS).strength(1.0F)));
    public static final RegistryObject<Block> PILE_OF_CHARRED_MARSHMALLOWS = register("pile_of_charred_marshmallows", () -> new CharredMarshmallowBlock(BlockBehaviour.Properties.of().sound(SoundType.FUNGUS).strength(1.0F)));


    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        return register(name, block, new Item.Properties());
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Item.Properties itemProperties) {
        return register(name, block, BlockItem::new, itemProperties);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, BiFunction<Block, Item.Properties, BlockItem> item, Item.Properties itemProperties) {
        final RegistryObject<T> registryObject = BLOCKS.register(name, block);
        if (itemProperties != null) RoastedItems.ITEMS.register(name, () -> item == null ? new BlockItem(registryObject.get(), itemProperties) : item.apply(registryObject.get(), itemProperties));
        return registryObject;
    }
}
