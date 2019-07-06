package com.bawei.gaochenkai20190705.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.gaochenkai20190705.R;
import com.bawei.gaochenkai20190705.di.contract.IContract;
import com.bawei.gaochenkai20190705.di.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements IContract.IView {

    @BindView(R.id.et_userName)
    EditText etUserName;
    @BindView(R.id.et_passWord)
    EditText etPassWord;
    @BindView(R.id.btn_confirm)
    Button btnConfirm;
    private IContract.IPresenter iPresenter;
    //创建P层对象
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        iPresenter = new LoginPresenter();
        //P层和V层绑定
        iPresenter.attachView(this);
        btnConfirm.setOnClickListener((View.OnClickListener) this);
    }

    //获取账号密码进行回传
    @Override
    public void showData() {


    }

    @Override
    public void sshowResponseData() {

    }

    //解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.detachView();
    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        String userName = etUserName.getText().toString().trim();
        String passWord = etPassWord.getText().toString().trim();
        //将V层数据传递P层
        iPresenter.containInfo(userName,passWord);
    }
}
