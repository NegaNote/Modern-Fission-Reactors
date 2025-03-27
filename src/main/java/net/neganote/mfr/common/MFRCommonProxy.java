package net.neganote.mfr.common;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neganote.mfr.common.block.MFRBlocks;
import net.neganote.mfr.common.item.MFRItems;
import net.neganote.mfr.data.MFRDataGen;

import static net.neganote.mfr.ModernFissionReactors.REGISTRATE;

public class MFRCommonProxy {
    public MFRCommonProxy() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.register(this);
    }

    public static void init() {
        REGISTRATE.registerRegistrate();
        MFRBlocks.init();
        MFRItems.init();
        MFRDataGen.init();
    }

    @SubscribeEvent
    public void modConstruct(FMLConstructModEvent event) {
        // this is done to delay initialization of content to be after KJS has set up.
        event.enqueueWork(MFRCommonProxy::init);
    }
}
