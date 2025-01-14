package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;

/* loaded from: classes2.dex */
public class LibraryVersionComponent {
    private LibraryVersionComponent() {
    }

    public static Component<?> create(String str, String str2) {
        return Component.intoSet(LibraryVersion.create(str, str2), LibraryVersion.class);
    }
}
