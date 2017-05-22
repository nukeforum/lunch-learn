package com.rook.lunchandlearn;

import java.lang.ref.WeakReference;

/**
 * Created by Rook on 5/21/2017.
 */

public abstract class Presenter<V> {
    protected final String TAG = getClass().getSimpleName();
    private WeakReference<V> view = null;

    protected void onBind() {

    }

    protected  void onUnbind() {

    }

    public void takeView(V view) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }

        if (this.view != null) {
            if (this.view.get() != view) {
                this.view.clear();
                this.view = new WeakReference<>(view);
            } else {
                this.view = new WeakReference<>(view);
            }
        }

        this.onBind();
    }
}
