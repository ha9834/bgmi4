package com.twitter.sdk.android.core.services;

import a.b;
import a.b.l;
import a.b.o;
import a.b.q;
import com.twitter.sdk.android.core.models.Media;
import okhttp3.aa;

/* loaded from: classes.dex */
public interface MediaService {
    @o(a = "https://upload.twitter.com/1.1/media/upload.json")
    @l
    b<Media> upload(@q(a = "media") aa aaVar, @q(a = "media_data") aa aaVar2, @q(a = "additional_owners") aa aaVar3);
}
