package com.pinnoocle.royalstarshop.event;

public class CanSettlement {
    private  boolean b;

    public boolean canSettlement() {
        return b;
    }

    public CanSettlement(boolean b) {
        this.b = b;
    }
}
