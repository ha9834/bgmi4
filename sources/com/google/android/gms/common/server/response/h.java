package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

/* loaded from: classes.dex */
final class h implements FastParser.a<BigDecimal> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ BigDecimal a(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        BigDecimal i;
        i = fastParser.i(bufferedReader);
        return i;
    }
}
