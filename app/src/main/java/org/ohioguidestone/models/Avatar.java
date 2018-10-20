package org.ohioguidestone.models;

import android.graphics.drawable.Drawable;

public class Avatar {
    private Drawable avatar;

    public Drawable getAvatar() {
        return this.avatar;
    }

    public Avatar(Drawable avatar) {
        this.avatar = avatar;
    }

}
