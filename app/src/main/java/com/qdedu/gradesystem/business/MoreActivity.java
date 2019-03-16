package com.qdedu.gradesystem.business;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.qdedu.gradesystem.R;
import com.qdedu.gradesystem.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_more;
    }

    @Override
    protected void setUpView() {

    }


    @OnClick({R.id.tv_commit_grade, R.id.tv_view_grade})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_commit_grade:
                startActivity(new Intent(MoreActivity.this, UploadScoreActivity.class));
                break;
            case R.id.tv_view_grade:
                startActivity(new Intent(MoreActivity.this, GradeActivity.class));
                break;
        }
    }
}
