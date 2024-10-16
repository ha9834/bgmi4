package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: classes.dex */
public class x extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    ListAdapter f699a;
    ListView b;
    View c;
    TextView d;
    View e;
    View f;
    CharSequence g;
    boolean h;
    private final Handler i = new Handler();
    private final Runnable j = new Runnable() { // from class: androidx.fragment.app.x.1
        @Override // java.lang.Runnable
        public void run() {
            x.this.b.focusableViewAvailable(x.this.b);
        }
    };
    private final AdapterView.OnItemClickListener k = new AdapterView.OnItemClickListener() { // from class: androidx.fragment.app.x.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            x.this.a((ListView) adapterView, view, i, j);
        }
    };

    public void a(ListView listView, View view, int i, long j) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context requireContext = requireContext();
        FrameLayout frameLayout = new FrameLayout(requireContext);
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(requireContext, null, R.attr.progressBarStyleLarge), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(requireContext);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(requireContext);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(requireContext);
        listView.setId(R.id.list);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.i.removeCallbacks(this.j);
        this.b = null;
        this.h = false;
        this.f = null;
        this.e = null;
        this.c = null;
        this.d = null;
        super.onDestroyView();
    }

    public void a(ListAdapter listAdapter) {
        boolean z = this.f699a != null;
        this.f699a = listAdapter;
        ListView listView = this.b;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (this.h || z) {
                return;
            }
            a(true, requireView().getWindowToken() != null);
        }
    }

    private void a(boolean z, boolean z2) {
        a();
        View view = this.e;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.h == z) {
            return;
        }
        this.h = z;
        if (z) {
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
                this.f.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            } else {
                view.clearAnimation();
                this.f.clearAnimation();
            }
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            return;
        }
        if (z2) {
            view.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
            this.f.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_out));
        } else {
            view.clearAnimation();
            this.f.clearAnimation();
        }
        this.e.setVisibility(0);
        this.f.setVisibility(8);
    }

    private void a() {
        if (this.b != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        if (view instanceof ListView) {
            this.b = (ListView) view;
        } else {
            this.d = (TextView) view.findViewById(16711681);
            TextView textView = this.d;
            if (textView == null) {
                this.c = view.findViewById(R.id.empty);
            } else {
                textView.setVisibility(8);
            }
            this.e = view.findViewById(16711682);
            this.f = view.findViewById(16711683);
            View findViewById = view.findViewById(R.id.list);
            if (!(findViewById instanceof ListView)) {
                if (findViewById == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                }
                throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
            }
            this.b = (ListView) findViewById;
            View view2 = this.c;
            if (view2 != null) {
                this.b.setEmptyView(view2);
            } else {
                CharSequence charSequence = this.g;
                if (charSequence != null) {
                    this.d.setText(charSequence);
                    this.b.setEmptyView(this.d);
                }
            }
        }
        this.h = true;
        this.b.setOnItemClickListener(this.k);
        ListAdapter listAdapter = this.f699a;
        if (listAdapter != null) {
            this.f699a = null;
            a(listAdapter);
        } else if (this.e != null) {
            a(false, false);
        }
        this.i.post(this.j);
    }
}
