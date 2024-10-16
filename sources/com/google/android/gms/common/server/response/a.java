package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* loaded from: classes.dex */
final class a implements FastParser.a<Integer> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Integer a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        int d;
        d = fastParser.d(bufferedReader);
        return Integer.valueOf(d);
    }
}
