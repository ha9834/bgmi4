package com.tencent.grobot.lite.recommends;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.grobot.lite.R;

/* loaded from: classes2.dex */
public class TimeOutIcon extends LinearLayout {
    private final TextView tvTime;

    public TimeOutIcon(Context context) {
        this(context, null);
    }

    public TimeOutIcon(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimeOutIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setGravity(1);
        setOrientation(0);
        setBackgroundResource(R.drawable.bg_slice_splash_a_vt);
        LayoutInflater.from(context).inflate(R.layout.layout_timeout_icon, (ViewGroup) this, true);
        this.tvTime = (TextView) findViewById(R.id.tv_vt);
    }

    public void setTime(int i) {
        String valueOf;
        String valueOf2;
        int i2 = i % 60;
        int i3 = i / 60;
        StringBuilder sb = new StringBuilder();
        if (i3 < 10) {
            valueOf = "0" + i3;
        } else {
            valueOf = String.valueOf(i3);
        }
        sb.append(valueOf);
        sb.append(CertificateUtil.DELIMITER);
        if (i2 < 10) {
            valueOf2 = "0" + i2;
        } else {
            valueOf2 = String.valueOf(i2);
        }
        sb.append(valueOf2);
        this.tvTime.setText(sb.toString());
    }
}
