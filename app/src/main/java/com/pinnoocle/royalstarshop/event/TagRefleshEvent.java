package com.pinnoocle.royalstarshop.event;

public class TagRefleshEvent {
    public String getId() {
        return id;
    }

    private  String id;

    public TagRefleshEvent(String id) {
        this.id = id;
    }
}
