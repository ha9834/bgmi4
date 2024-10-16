package com.tencent.grobot.lite.ui.view.ticket;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.ui.adapter.ImageAdapter;
import com.tencent.grobot.lite.ui.view.component.HorizontalView;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TicketUploadView extends TicketView {
    private ImageAdapter imageAdapter;
    private HorizontalView picHorizontalView;

    public void onDestory() {
    }

    public TicketUploadView(Context context) {
        this(context, null, 0);
    }

    public TicketUploadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TicketUploadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.tencent.grobot.lite.ui.view.ticket.TicketView
    public void buildSubView() {
        this.rootView = LayoutInflater.from(this.context).inflate(R.layout.ticketitem_picview, (ViewGroup) this, true);
        this.picHorizontalView = (HorizontalView) this.rootView.findViewById(R.id.picLayout);
        this.imageAdapter = new ImageAdapter(this.context);
        this.picHorizontalView.setAdapter(this.imageAdapter);
    }

    @Override // com.tencent.grobot.lite.ui.view.ticket.TicketView
    public void setData(JSONObject jSONObject) {
        String optString;
        super.setData(jSONObject);
        if (jSONObject == null || (optString = jSONObject.optString("msg")) == null || TextUtils.isEmpty(optString)) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (optString.contains("|")) {
            arrayList.addAll(Arrays.asList(optString.split("\\|")));
        } else {
            arrayList.add(optString);
        }
        this.imageAdapter.setImages(arrayList);
    }
}
