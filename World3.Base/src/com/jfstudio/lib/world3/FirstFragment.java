package com.jfstudio.lib.world3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FirstFragment extends Fragment {

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = null;
        rootView = inflater.inflate(R.layout.fragment_main_section_one,
                container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.big_smile);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        View mSecretGardenContainerView = rootView
                .findViewById(R.id.secret_garden_container);
        if (BaseApplication.sAppInstallTime - System.currentTimeMillis()
                > 1000 *60 *60 * 72) {
            mSecretGardenContainerView.setVisibility(View.VISIBLE);
        } else {
            mSecretGardenContainerView.setVisibility(View.GONE);
        }
        return rootView;
    }
}
