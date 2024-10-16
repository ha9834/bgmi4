package com.tencent.msdk.stat.common;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
class l implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
