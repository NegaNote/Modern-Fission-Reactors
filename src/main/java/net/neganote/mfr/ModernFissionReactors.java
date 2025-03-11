package net.neganote.mfr;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neganote.mfr.common.MFRCommonProxy;
import net.neganote.mfr.client.MFRClientProxy;
import net.neganote.mfr.registrate.MFRRegistrate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModernFissionReactors.MOD_ID)
@SuppressWarnings("unused")
public class ModernFissionReactors
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "modernfissionreactors";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LoggerFactory.getLogger("ModernFissionReactors");

    public static final MFRRegistrate REGISTRATE = MFRRegistrate.create(MOD_ID);

    public static RegistryEntry<CreativeModeTab> MFR_CREATIVE_TAB = REGISTRATE
            .defaultCreativeTab(MOD_ID, builder -> builder
                    .title(REGISTRATE.addLang("itemGroup", id("creative_tab"), "Modern Fission Reactors"))
                    .build())
            .register();


    public ModernFissionReactors() {
        ModernFissionReactors.init();

        DistExecutor.unsafeRunForDist(() -> MFRClientProxy::new, () -> MFRCommonProxy::new);
    }

    private static void init() {
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        MFRCommonProxy.init();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
