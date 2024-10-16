package com.tencent.grobot.lite.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.grobot.lite.model.node.AnsTextNode;
import com.tencent.grobot.lite.ui.adapter.ViewHolder.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseViewAdapter<T> extends RecyclerView.a<BaseViewHolder<T>> {
    protected Context context;
    protected BaseViewHolder.OnItemClickListener clickListener = null;
    protected List<T> datas = new ArrayList();

    protected abstract BaseViewHolder buildViewHolder(ViewGroup viewGroup, int i);

    protected abstract int getItemViewTypeByPosition(int i);

    protected boolean isLastTextItem(int i) {
        return false;
    }

    public BaseViewAdapter(Context context) {
        this.context = context;
    }

    public void setClickListener(BaseViewHolder.OnItemClickListener onItemClickListener) {
        this.clickListener = onItemClickListener;
    }

    public List<T> getDatas() {
        return this.datas;
    }

    public void setDatas(List<T> list) {
        this.datas.clear();
        if (list != null) {
            this.datas.addAll(list);
        }
        notifyDataSetChanged();
    }

    public boolean insertItems(List<T> list) {
        List<T> list2 = this.datas;
        if (list2 == null || list == null) {
            return false;
        }
        list2.addAll(0, list);
        return true;
    }

    public boolean addItems(List<T> list) {
        List<T> list2 = this.datas;
        if (list2 == null || list == null) {
            return false;
        }
        int size = list2.size();
        this.datas.addAll(list);
        if (hasTextNode(list)) {
            notifyDataSetChanged();
            return true;
        }
        notifyItemRangeInserted(size, this.datas.size() - size);
        return true;
    }

    public boolean addItems(List<T> list, int i) {
        List<T> list2 = this.datas;
        if (list2 == null || list == null) {
            return false;
        }
        list2.addAll(i, list);
        if (hasTextNode(list)) {
            notifyDataSetChanged();
            return true;
        }
        notifyDataSetChanged();
        return true;
    }

    private boolean hasTextNode(List<T> list) {
        if (list == null) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof AnsTextNode) {
                return true;
            }
        }
        return false;
    }

    public void refreshItem(int i, int i2, int i3) {
        notifyItemChanged(i);
    }

    public void deleteItem(int i) {
        List<T> list = this.datas;
        if (list == null || list.size() <= i) {
            return;
        }
        this.datas.remove(i);
        notifyItemRemoved(i);
        notifyDataSetChanged();
    }

    public void deleteItems(ArrayList<T> arrayList) {
        List<T> list = this.datas;
        if (list != null) {
            list.removeAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        List<T> list = this.datas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemViewType(int i) {
        return getItemViewTypeByPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return buildViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.bindData(this.datas.get(i));
        baseViewHolder.setIsLastItem(isLastTextItem(i));
    }
}
