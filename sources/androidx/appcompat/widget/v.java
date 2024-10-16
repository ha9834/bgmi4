package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* loaded from: classes.dex */
final class v {

    /* renamed from: a, reason: collision with root package name */
    private TextView f368a;
    private TextClassifier b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(TextView textView) {
        this.f368a = (TextView) androidx.core.e.e.a(textView);
    }

    public void a(TextClassifier textClassifier) {
        this.b = textClassifier;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f368a.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }
}
