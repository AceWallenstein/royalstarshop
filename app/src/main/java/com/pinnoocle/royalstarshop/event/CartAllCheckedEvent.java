package com.pinnoocle.royalstarshop.event;

public class CartAllCheckedEvent {
    private Boolean isAllChecked;

    public Boolean getAllChecked() {
        return isAllChecked;
    }

    public CartAllCheckedEvent(Boolean isAllChecked) {
        this.isAllChecked = isAllChecked;
    }
}
