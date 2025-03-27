package net.neganote.mfr.common.block;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neganote.mfr.ModernFissionReactors;

@SuppressWarnings("unused")
public class MFRBlocks {
    public static BlockEntry<Block> DEBUG_BLOCK = ModernFissionReactors.REGISTRATE
            .block("debug_block", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Debug Block")
            .blockstate((ctx, prov) -> prov
                    .simpleBlock(ctx.getEntry(), prov.models()
                    .cubeAll("debug_block", ModernFissionReactors.id("block/debug_block"))))
            .item()
            .model((ctx, prov) -> {
                BlockItem item = ctx.getEntry();
                prov.blockItem(() -> item);
            })
            .build()
            .register();

    public static void init() {
        ModernFissionReactors.LOGGER.debug("Registering MFR blocks...");
    }
}
