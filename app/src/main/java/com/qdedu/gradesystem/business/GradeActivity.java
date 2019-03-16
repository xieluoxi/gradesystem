package com.qdedu.gradesystem.business;


import android.os.Bundle;
import android.widget.TextView;

import com.qdedu.gradesystem.R;
import com.qdedu.gradesystem.base.BaseActivity;
import com.qdedu.gradesystem.entity.ScoreEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class GradeActivity extends BaseActivity {


    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.tv_score)
    TextView tvScore;
    private int count60 = 0;
    private int count60_80 = 0;
    private int count80_90 = 0;
    private int count90 = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_grade;
    }

    @Override
    protected void setUpView() {
        BmobQuery<ScoreEntity> query = new BmobQuery<>();
        query.findObjects(new FindListener<ScoreEntity>() {
            @Override
            public void done(List<ScoreEntity> list, BmobException e) {
                if (e == null) {
                    for (ScoreEntity scoreEntity : list) {
                        if (scoreEntity.getScore() < 60) {
                            count60++;
                        } else if (scoreEntity.getScore() > 60 && scoreEntity.getScore() < 80) {
                            count60_80++;
                        } else if (scoreEntity.getScore() > 80 && scoreEntity.getScore() < 90) {
                            count80_90++;
                        } else if (scoreEntity.getScore() > 90) {
                            count90++;
                        }
                    }

                    tvScore.setText(String.format("成绩分布：\n\n60分以下：%s人 \n60-80人数： %s人 \n80-90分： %s人\n90分以上：%s人",
                            count60, count60_80, count80_90, count90
                    ));
                }
            }
        });
    }


}
