package com.jfstudio.lib.world3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.tsz.afinal.FinalBitmap;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FirstFragment extends Fragment {

    private static final int IMAGE_CHANGE = 1;

    private FinalBitmap mFinalBitmap = null;
    public List<String> mImageList = new ArrayList<String>();
    private ImageView mImageView = null;
    private Handler mImageHandler = null;

    private boolean mImageThreadSwitch = true;
    private Thread mImageThread = new Thread() {
        
        @Override
        public void run() {
            while (mImageThreadSwitch) {

                Message msg = mImageHandler.obtainMessage();
                msg.what = IMAGE_CHANGE;
                mImageHandler.sendMessage(msg);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public FirstFragment() {
        loadImageList();
        mImageHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                case IMAGE_CHANGE:
                    mFinalBitmap = FinalBitmap.create(getActivity());
                    int random = new Random().nextInt(mImageList.size()) % mImageList.size();
                    mFinalBitmap.display(mImageView, mImageList.get(random));
                    mFinalBitmap.configLoadfailImage(R.drawable.demo);
                    break;

                default:
                    break;
                }
            }
        };

        mImageThread.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = null;
        rootView = inflater.inflate(R.layout.fragment_main_section_one,
                container, false);
        mImageView = (ImageView) rootView.findViewById(R.id.big_smile);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        mImageThreadSwitch = false;
    }

    private void loadImageList() {
        mImageList.add("http://t2.qpic.cn/mblogpic/8c7074a105e5081021fe/460");
        mImageList.add("http://t2.qpic.cn/mblogpic/afb1cf81b8d28d074fb2/460");
        mImageList.add("http://t2.qpic.cn/mblogpic/92a46564e48566c417a2/460");
        mImageList.add("http://t2.qpic.cn/mblogpic/1b31f3b5e422eff76456/460");
        mImageList.add("http://t2.qpic.cn/mblogpic/cbf5515e0c29cd28c502/460");
        mImageList.add("http://t2.qpic.cn/mblogpic/19721e446346c9943a16/460");
        mImageList.add("http://t2.qpic.cn/mblogpic/31de6a44c3f92ab4ca04/2000");
        mImageList.add("http://t2.qpic.cn/mblogpic/616c110188d0d2f355b4/2000");
        mImageList.add("http://t2.qpic.cn/mblogpic/70d7169390b176ff2dfa/2000");
        mImageList.add("http://t2.qpic.cn/mblogpic/78455e716b42cc6d9c9c/2000");
        mImageList.add("http://t2.qpic.cn/mblogpic/d374dd7b9269aee3a422/2000");
        mImageList.add("http://t2.qpic.cn/mblogpic/cddb72e10f03d53ca182/2000");
        mImageList.add("http://t2.qpic.cn/mblogpic/597d4fda8bad86f5fe46/2000");
        mImageList.add("http://t2.qpic.cn/mblogpic/358157706b816bf81ecc/2000");
        mImageList.add("http://t2.qpic.cn/mblogpic/cec7a8266c390db08f36/2000");
    }
}
