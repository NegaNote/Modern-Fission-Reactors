package net.neganote.mfr.registrate;

import com.tterrag.registrate.Registrate;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.atomic.AtomicBoolean;

// Class partially copied from GTRegistrate from GTm
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MFRRegistrate extends Registrate {
    private final AtomicBoolean registered = new AtomicBoolean(false);

    protected MFRRegistrate(String modid) {
        super(modid);
    }

    public static MFRRegistrate create(String modid) {
        return new MFRRegistrate(modid);
    }

    public void registerRegistrate() {
        registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @Override
    public Registrate registerEventListeners(IEventBus bus) {
        if (!registered.getAndSet(true)) {
            return super.registerEventListeners(bus);
        }
        return this;
    }
}
