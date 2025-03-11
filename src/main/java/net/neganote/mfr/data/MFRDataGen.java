package net.neganote.mfr.data;

import com.tterrag.registrate.providers.ProviderType;
import net.neganote.mfr.data.lang.MFRLangHandler;

import static net.neganote.mfr.ModernFissionReactors.REGISTRATE;

public class MFRDataGen {
    public static void init() { REGISTRATE.addDataGenerator(ProviderType.LANG, MFRLangHandler::init); }
}
