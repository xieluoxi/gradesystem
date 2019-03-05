package com.qdedu.gradesystem.business;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qdedu.gradesystem.R;
import com.qdedu.gradesystem.base.BaseActivity;
import com.qdedu.gradesystem.entity.ScoreEntity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * desc :
 * author：xiedong
 * date：2019/3/5
 */
public class UploadScoreActivity extends BaseActivity {
    @BindView(R.id.et_type)
    EditText etType;
    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_user_id)
    EditText etUserId;
    @BindView(R.id.et_score)
    EditText etScore;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload_score;
    }

    @Override
    protected void setUpView() {

    }


    @OnClick(R.id.tv_submit)
    public void onClick() {
        String score = etScore.getText().toString();
        String type = etType.getText().toString();
        String userName = etUserName.getText().toString();
        String userId = etUserId.getText().toString();

        if (TextUtils.isEmpty(score) || TextUtils.isEmpty(type) || TextUtils.isEmpty(userName) || TextUtils.isEmpty(userId)) {
            Toast.makeText(this, "请完善所有必填项...", Toast.LENGTH_SHORT).show();
        } else {
            ScoreEntity scoreEntity = new ScoreEntity();
            scoreEntity.setScore(Integer.parseInt(score));
            scoreEntity.setScoreTypeName(type);
            scoreEntity.setUserName(userName);
            scoreEntity.setUserId(Integer.parseInt(userId));

            scoreEntity.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e == null) {
                        Toast.makeText(UploadScoreActivity.this, "录入成功...", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}
