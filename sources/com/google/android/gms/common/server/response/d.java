package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes.dex */
final class d implements FastParser.a<Double> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Double a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        double h;
        h = fastParser.h(bufferedReader);
        return Double.valueOf(h);
    }
}
