package net.neganote.mfr.common.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static net.neganote.mfr.ModernFissionReactors.REGISTRATE;

@SuppressWarnings("unused")
public class MFRItems {
    public static ItemEntry<Item> DEBUG_ITEM = REGISTRATE
            .item("debug_item", Item::new)
            .lang("Debug Item")
            .defaultModel()
            .register();

    public static void init() {}
}
