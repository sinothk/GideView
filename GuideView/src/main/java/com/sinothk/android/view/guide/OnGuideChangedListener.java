package com.sinothk.android.view.guide;

/**
 * Created by hubert
 * <p>
 * Created on 2017/7/27.
 */
public interface OnGuideChangedListener {
    void onShowed(Controller controller);

    void onRemoved(Controller controller);
}