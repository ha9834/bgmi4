package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.ads.zzard;
import java.util.Map;

@zzard
@Deprecated
/* loaded from: classes.dex */
public class NativeAdMapper {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f1169a;
    protected boolean b;
    protected Bundle c = new Bundle();
    protected View d;
    private View e;
    private VideoController f;
    private boolean g;

    public void handleClick(View view) {
    }

    public void recordImpression() {
    }

    @Deprecated
    public void trackView(View view) {
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.f1169a = z;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.b = z;
    }

    public final void setExtras(Bundle bundle) {
        this.c = bundle;
    }

    public void setAdChoicesContent(View view) {
        this.d = view;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.f1169a;
    }

    public final boolean getOverrideClickHandling() {
        return this.b;
    }

    public final Bundle getExtras() {
        return this.c;
    }

    public View getAdChoicesContent() {
        return this.d;
    }

    public void setMediaView(View view) {
        this.e = view;
    }

    public final View zzacd() {
        return this.e;
    }

    public final void zza(VideoController videoController) {
        this.f = videoController;
    }

    public final VideoController getVideoController() {
        return this.f;
    }

    public void setHasVideoContent(boolean z) {
        this.g = z;
    }

    public boolean hasVideoContent() {
        return this.g;
    }
}
