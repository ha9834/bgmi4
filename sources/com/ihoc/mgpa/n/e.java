package com.ihoc.mgpa.n;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class e implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+$", file.getName());
    }
}
