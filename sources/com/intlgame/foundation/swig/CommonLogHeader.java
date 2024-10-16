package com.intlgame.foundation.swig;

/* loaded from: classes2.dex */
public class CommonLogHeader {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected CommonLogHeader(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(CommonLogHeader commonLogHeader) {
        if (commonLogHeader == null) {
            return 0L;
        }
        return commonLogHeader.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                INTLFoundationJNI.delete_CommonLogHeader(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setActual_size_(long j) {
        INTLFoundationJNI.CommonLogHeader_actual_size__set(this.swigCPtr, this, j);
    }

    public long getActual_size_() {
        return INTLFoundationJNI.CommonLogHeader_actual_size__get(this.swigCPtr, this);
    }

    public void setReserved_space(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        INTLFoundationJNI.CommonLogHeader_reserved_space_set(this.swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char));
    }

    public SWIGTYPE_p_unsigned_char getReserved_space() {
        long CommonLogHeader_reserved_space_get = INTLFoundationJNI.CommonLogHeader_reserved_space_get(this.swigCPtr, this);
        if (CommonLogHeader_reserved_space_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_unsigned_char(CommonLogHeader_reserved_space_get, false);
    }

    public CommonLogHeader() {
        this(INTLFoundationJNI.new_CommonLogHeader(), true);
    }
}
