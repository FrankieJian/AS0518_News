package com.example.g572_528r.as0518_news.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.g572_528r.as0518_news.R;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LoginActivity extends AppCompatActivity {
    private EditText edtPhone;
    private EditText edtCode;
    private Button btnGetCode;
    private Button btnLog;
    private String phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        edtPhone = (EditText) findViewById(R.id.edt_phone);
        edtCode = (EditText) findViewById(R.id.edt_code);
        btnGetCode = (Button) findViewById(R.id.btn_getCode);
        btnLog = (Button) findViewById(R.id.btn_log);



        btnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = edtPhone.getText().toString();
                BmobSMS.requestSMSCode(phone, "LFJ0424", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer integer, BmobException e) {
                        if (e != null){
                            Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        final String code = edtCode.getText().toString();

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser.loginBySMSCode(phone, code, new LogInListener<Object>() {
                    @Override
                    public void done(Object o, BmobException e) {
                        if (e == null){
                            Log.e("AAA", "log success "+ BmobUser.getCurrentUser().getMobilePhoneNumber());
                        }
                    }
                });
            }
        });
    }
}
