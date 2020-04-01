package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private RecyclerView recyclerView;
    private Ex3recycleviewAdapter viewAdapter;
    private AnimatorSet animatorSet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View v=inflater.inflate(R.layout.fragment_placeholder, container, false);
//        添加Lottie动画
        animationView=v.findViewById(R.id.Lottie_ex3);
        animationView.playAnimation();
        animationView.setRepeatCount(View.INVISIBLE);
        recyclerView=v.findViewById(R.id.rv_ex3);
//        设置recycleview
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        viewAdapter=new Ex3recycleviewAdapter(30);
        recyclerView.setAdapter(viewAdapter);
        recyclerView.setAlpha(0f);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
//                用这种方式实现渐入渐出感觉不符合载入的时候加载，但是没办法了
                ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(animationView,"alpha",1f,0f);
                ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(recyclerView,"alpha",0f,1f);
                objectAnimator1.setDuration(500);
                objectAnimator2.setDuration(500);
                animatorSet=new AnimatorSet();
                animatorSet.playTogether(objectAnimator1,objectAnimator2);
                animatorSet.start();
            }
        }, 5000);
    }
}
