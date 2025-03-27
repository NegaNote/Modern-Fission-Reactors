package net.neganote.mfr.client;

import net.neganote.mfr.common.MFRCommonProxy;

public class MFRClientProxy extends MFRCommonProxy {
    public MFRClientProxy() {
        super();
        MFRCommonProxy.init();
        MFRClientProxy.init();
    }

    public static void init() {

    }
}
