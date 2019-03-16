package com.qdedu.gradesystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.qdedu.gradesystem.apapter.ScoreListAdapter;
import com.qdedu.gradesystem.base.BaseActivity;
import com.qdedu.gradesystem.business.MoreActivity;
import com.qdedu.gradesystem.business.UploadScoreActivity;
import com.qdedu.gradesystem.entity.ScoreEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    private boolean isLimit = false;
    private int userId;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {
        initData();
    }

    private void initData() {
        BmobQuery<ScoreEntity> query = new BmobQuery<>();
        if (isLimit) query.addWhereEqualTo("userId", userId);
        query.findObjects(new FindListener<ScoreEntity>() {
            @Override
            public void done(List<ScoreEntity> list, BmobException e) {
                if (e == null) {
                    rvList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rvList.setAdapter(new ScoreListAdapter(list, MainActivity.this));
                    isLimit = false;
                }
            }
        });
    }


    @OnClick({R.id.tv_add, R.id.tv_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
                startActivity(new Intent(MainActivity.this, MoreActivity.class));
                break;
            case R.id.tv_search:
                searchStudentScore();
                break;
        }

    }

    private void searchStudentScore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final EditText editText = new EditText(MainActivity.this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(editText);
        builder.setTitle("输入用户ID")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        isLimit = true;
                        if (TextUtils.isEmpty(editText.getText().toString()))
                            return;
                        userId = Integer.parseInt(editText.getText().toString());
                        initData();
                    }
                });
        builder.create().show();
    }
}
