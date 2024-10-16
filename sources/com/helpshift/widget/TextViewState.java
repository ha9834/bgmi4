package com.helpshift.widget;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class TextViewState extends HSBaseObservable {
    public static final Pattern specialCharactersPattern = Pattern.compile("\\W+");
    protected TextViewStatesError error;
    private boolean isRequired;
    protected String text;

    /* loaded from: classes2.dex */
    public enum TextViewStatesError {
        EMPTY,
        LESS_THAN_MINIMUM_LENGTH,
        ONLY_SPECIAL_CHARACTERS,
        INVALID_EMAIL
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextViewState(boolean z) {
        this.isRequired = z;
    }

    public TextViewStatesError getError() {
        return this.error;
    }

    public String getText() {
        String str = this.text;
        return str == null ? "" : str.trim();
    }

    public boolean isRequired() {
        return this.isRequired;
    }

    @Override // com.helpshift.widget.HSBaseObservable
    protected void notifyInitialState() {
        notifyChange(this);
    }
}
