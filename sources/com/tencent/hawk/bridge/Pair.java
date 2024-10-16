package com.tencent.hawk.bridge;

/* loaded from: classes2.dex */
public class Pair<L, R> {
    private final L left;
    private final R right;

    public Pair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    public int hashCode() {
        return this.left.hashCode() ^ this.right.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return this.left.equals(pair.getLeft()) && this.right.equals(pair.getRight());
    }
}
