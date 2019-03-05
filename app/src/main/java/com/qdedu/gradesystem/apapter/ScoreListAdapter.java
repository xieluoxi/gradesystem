package com.qdedu.gradesystem.apapter;


import android.content.Context;
import android.widget.TextView;

import com.qdedu.gradesystem.R;
import com.qdedu.gradesystem.base.BaseAdapter;
import com.qdedu.gradesystem.base.BaseViewHolder;
import com.qdedu.gradesystem.entity.ScoreEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * desc :
 * author：xiedong
 * date：2019/3/5
 */
public class ScoreListAdapter extends BaseAdapter<ScoreEntity, BaseViewHolder> {
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_user_id)
    TextView tvUserId;
    @BindView(R.id.tv_score)
    TextView tvScore;

    public ScoreListAdapter(List<ScoreEntity> mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected void converData(BaseViewHolder myViewHolder, ScoreEntity scoreEntity, int position) {
        ButterKnife.bind(this, myViewHolder.itemView);

        tvType.setText(scoreEntity.getScoreTypeName());
        tvUserName.setText("姓名：" + scoreEntity.getUserName());
        tvUserId.setText("学号：" + scoreEntity.getUserId() + "");
        tvScore.setText(scoreEntity.getScore() + "分");
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_score_list;
    }
}
