package coda.roasted.registry;

import coda.roasted.Roasted;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RoastedCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Roasted.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("roasted", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.roasted"))
            .icon(RoastedItems.MARSHMALLOW_ON_A_STICK.get()::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {
                RoastedItems.ITEMS.getEntries().forEach(itemRegistryObject -> output.accept(itemRegistryObject.get()));
            })
            .build()
    );

}
