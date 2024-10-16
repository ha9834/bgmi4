package com.tencent.grobot.lite.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class EndlessRecyclerView extends RecyclerView {
    public static final int LIST_HAS_FOOTER = 2;
    public static final int LIST_HAS_HEADER = 1;
    public static final int LIST_NONE = 0;
    public static final int STATE_END = 0;
    public static final int STATE_LOADING = 1;
    private static final String TAG = "EndlessRecyclerView";
    private static final int TYPE_FOOTER = 122000;
    private static final int TYPE_HEADER = 121000;
    private LoadMoreListener loadMoreListener;
    private int state;

    /* loaded from: classes2.dex */
    public interface CreateExtraViewHolder {
        RecyclerView.w createFooter(ViewGroup viewGroup, int i);

        RecyclerView.w createHeader(ViewGroup viewGroup, int i);

        int footerCount();

        int headerCount();
    }

    /* loaded from: classes2.dex */
    public interface LoadMoreListener {
        void onLoadMore();
    }

    public EndlessRecyclerView(Context context) {
        this(context, null);
    }

    public EndlessRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EndlessRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        addOnScrollListener(new ScrollMotionDelegate(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.a aVar) {
        if (aVar instanceof EndlessAdapterWrapper) {
            super.setAdapter(aVar);
        } else {
            super.setAdapter(new EndlessAdapterWrapper(aVar));
        }
    }

    public void setLoadMoreListener(LoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }

    public void setState(int i) {
        this.state = i;
        if (getAdapter() instanceof EndlessAdapterWrapper) {
            EndlessAdapterWrapper endlessAdapterWrapper = (EndlessAdapterWrapper) getAdapter();
            if (i == 1) {
                endlessAdapterWrapper.listState |= 2;
            } else {
                endlessAdapterWrapper.listState &= -3;
            }
            endlessAdapterWrapper.notifyDataSetChanged();
        }
    }

    public int getState() {
        return this.state;
    }

    public void setDelegate(CreateExtraViewHolder createExtraViewHolder) {
        RecyclerView.a adapter = getAdapter();
        if (adapter instanceof EndlessAdapterWrapper) {
            ((EndlessAdapterWrapper) adapter).extradelegate = createExtraViewHolder;
        }
    }

    /* loaded from: classes2.dex */
    public static final class EndlessAdapterWrapper extends RecyclerView.a<RecyclerView.w> {
        private CreateExtraViewHolder extradelegate;
        final RecyclerView.a<RecyclerView.w> innerAdapter;
        int listState = 1;

        EndlessAdapterWrapper(RecyclerView.a<RecyclerView.w> aVar) {
            this.innerAdapter = aVar;
            this.innerAdapter.registerAdapterDataObserver(new WrapperDataObserver(this));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i) {
            CreateExtraViewHolder createExtraViewHolder = this.extradelegate;
            if (createExtraViewHolder == null || i < EndlessRecyclerView.TYPE_HEADER) {
                return this.innerAdapter.onCreateViewHolder(viewGroup, i);
            }
            return i >= EndlessRecyclerView.TYPE_FOOTER ? createExtraViewHolder.createFooter(viewGroup, i - EndlessRecyclerView.TYPE_FOOTER) : createExtraViewHolder.createHeader(viewGroup, i - EndlessRecyclerView.TYPE_HEADER);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public void onBindViewHolder(RecyclerView.w wVar, int i) {
            if (isHeaderPos(i) || isFooterPos(i)) {
                return;
            }
            CreateExtraViewHolder createExtraViewHolder = this.extradelegate;
            if (createExtraViewHolder != null) {
                this.innerAdapter.onBindViewHolder(wVar, i - createExtraViewHolder.headerCount());
            } else {
                this.innerAdapter.onBindViewHolder(wVar, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int getItemCount() {
            CreateExtraViewHolder createExtraViewHolder = this.extradelegate;
            if (createExtraViewHolder == null) {
                return this.innerAdapter.getItemCount();
            }
            if ((this.listState & 2) != 2) {
                return createExtraViewHolder.headerCount() + this.innerAdapter.getItemCount();
            }
            return createExtraViewHolder.headerCount() + this.innerAdapter.getItemCount() + this.extradelegate.footerCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int getItemViewType(int i) {
            if (isHeaderPos(i)) {
                return i + EndlessRecyclerView.TYPE_HEADER;
            }
            if (isFooterPos(i)) {
                return ((i - this.extradelegate.headerCount()) - this.innerAdapter.getItemCount()) + EndlessRecyclerView.TYPE_FOOTER;
            }
            return this.innerAdapter.getItemViewType(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.i layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                gridLayoutManager.a(new EndlessGridLayoutSpanSizeLookup(this, gridLayoutManager));
            }
        }

        private boolean isFooterPos(int i) {
            CreateExtraViewHolder createExtraViewHolder = this.extradelegate;
            return createExtraViewHolder != null && (this.listState & 2) == 2 && i >= createExtraViewHolder.headerCount() + this.innerAdapter.getItemCount();
        }

        private boolean isHeaderPos(int i) {
            CreateExtraViewHolder createExtraViewHolder = this.extradelegate;
            return createExtraViewHolder != null && (this.listState & 1) == 1 && i < createExtraViewHolder.headerCount();
        }

        public int headerCount() {
            CreateExtraViewHolder createExtraViewHolder = this.extradelegate;
            if (createExtraViewHolder != null) {
                return createExtraViewHolder.headerCount();
            }
            return 0;
        }

        int footerCount() {
            CreateExtraViewHolder createExtraViewHolder = this.extradelegate;
            if (createExtraViewHolder != null) {
                return createExtraViewHolder.footerCount();
            }
            return 0;
        }
    }

    /* loaded from: classes2.dex */
    static final class EndlessGridLayoutSpanSizeLookup extends GridLayoutManager.c {
        final EndlessAdapterWrapper adapter;
        final GridLayoutManager layoutManager;

        EndlessGridLayoutSpanSizeLookup(EndlessAdapterWrapper endlessAdapterWrapper, GridLayoutManager gridLayoutManager) {
            this.adapter = endlessAdapterWrapper;
            this.layoutManager = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i) {
            if (this.adapter.getItemViewType(i) >= EndlessRecyclerView.TYPE_HEADER) {
                return this.layoutManager.b();
            }
            return 1;
        }
    }

    /* loaded from: classes2.dex */
    static final class WrapperDataObserver extends RecyclerView.c {
        final EndlessAdapterWrapper adapter;

        WrapperDataObserver(EndlessAdapterWrapper endlessAdapterWrapper) {
            this.adapter = endlessAdapterWrapper;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onChanged() {
            this.adapter.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeChanged(int i, int i2) {
            EndlessAdapterWrapper endlessAdapterWrapper = this.adapter;
            endlessAdapterWrapper.notifyItemRangeChanged(i + endlessAdapterWrapper.headerCount(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeChanged(int i, int i2, Object obj) {
            EndlessAdapterWrapper endlessAdapterWrapper = this.adapter;
            endlessAdapterWrapper.notifyItemRangeChanged(i + endlessAdapterWrapper.headerCount(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeInserted(int i, int i2) {
            EndlessAdapterWrapper endlessAdapterWrapper = this.adapter;
            endlessAdapterWrapper.notifyItemRangeInserted(i + endlessAdapterWrapper.headerCount(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeRemoved(int i, int i2) {
            EndlessAdapterWrapper endlessAdapterWrapper = this.adapter;
            endlessAdapterWrapper.notifyItemRangeRemoved(i + endlessAdapterWrapper.headerCount(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void onItemRangeMoved(int i, int i2, int i3) {
            this.adapter.notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    static final class ScrollMotionDelegate extends RecyclerView.n {
        private boolean isSlidingUpward = false;
        private int state;
        final EndlessRecyclerView target;

        ScrollMotionDelegate(EndlessRecyclerView endlessRecyclerView) {
            this.target = endlessRecyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.target.loadMoreListener != null) {
                if (i == 0) {
                    loadMore(recyclerView);
                }
                this.state = i;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (this.target.loadMoreListener != null) {
                this.isSlidingUpward = i2 > 0;
                if (this.state == 1) {
                    loadMore(recyclerView);
                }
            }
        }

        private void loadMore(RecyclerView recyclerView) {
            if (recyclerView instanceof EndlessRecyclerView) {
                EndlessRecyclerView endlessRecyclerView = (EndlessRecyclerView) recyclerView;
                RecyclerView.i layoutManager = endlessRecyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    if (linearLayoutManager.q() == linearLayoutManager.I() - 1 && this.isSlidingUpward && endlessRecyclerView.getState() != 1) {
                        this.target.loadMoreListener.onLoadMore();
                    }
                }
            }
        }
    }
}
