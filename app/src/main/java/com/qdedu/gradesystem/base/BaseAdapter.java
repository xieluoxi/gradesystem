package com.qdedu.gradesystem.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * desc :
 * author：xiedong
 * date：2019/3/5
 */
public abstract class BaseAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {

    private List<T> mDatas;
    private Context mContext;

    public BaseAdapter(List<T> mDatas, Context context) {
        this.mDatas = mDatas;
        this.mContext = context;
    }

    @NonNull
    @Override
    public K onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return (K) new BaseViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getItemLayoutId(), viewGroup, false));
    }


    @Override
    public void onBindViewHolder(@NonNull K myViewHolder, int position) {
        converData(myViewHolder, mDatas.get(position), position);
    }

    protected abstract void converData(BaseViewHolder myViewHolder, T t, int position);

    public abstract int getItemLayoutId();

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }


}
