package com.xiaohuijun.administrator.mymvp.common.Filepicker.fragments;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class FileBaseFragment extends Fragment {


    public FileBaseFragment() {
        // Required empty public constructor
    }

    protected void fadeIn(View view)
    {
        Animation bottomUp = AnimationUtils.loadAnimation(getActivity(),
                android.R.anim.fade_in);

        view.startAnimation(bottomUp);
        view.setVisibility(View.VISIBLE);
    }

    protected void fadeOut(View view)
    {
        Animation bottomUp = AnimationUtils.loadAnimation(getActivity(),
                android.R.anim.fade_out);

        view.startAnimation(bottomUp);
        view.setVisibility(View.GONE);
    }
}
