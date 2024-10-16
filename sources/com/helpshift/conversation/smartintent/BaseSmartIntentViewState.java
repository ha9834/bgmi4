package com.helpshift.conversation.smartintent;

/* loaded from: classes2.dex */
public abstract class BaseSmartIntentViewState {
    public final boolean enforceIntentSelection;
    public final String promptTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseSmartIntentViewState(String str, boolean z) {
        this.promptTitle = str;
        this.enforceIntentSelection = z;
    }
}
