package com.example.g572_528r.as0518_news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import com.example.g572_528r.as0518_news.R;
import com.example.g572_528r.as0518_news.data.CommentData;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ReadActivity extends AppCompatActivity {
    public static final String URL_EXTRA = "URL_EXTRA";
    public static final String KEY_EXTRA = "KEY_EXTRA";
    public static final String TITLE_EXTRA = "TITLE_EXTRA";
    private WebView newsWebView;
    private String url;
    private String newsKey;
    private String newsTitle;
    private EditText edtComment;
    private Button btnComment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        newsWebView = (WebView) findViewById(R.id.news_webView);
        url = getIntent().getStringExtra(URL_EXTRA);
        newsKey = getIntent().getStringExtra(KEY_EXTRA);
        newsTitle = getIntent().getStringExtra(TITLE_EXTRA);

        if (url != null && url.length()>0){
            newsWebView.loadUrl(url);
        }

        initCommentViews();
    }

    private void initCommentViews() {
        edtComment = (EditText) findViewById(R.id.edt_comment);
        btnComment = (Button) findViewById(R.id.btn_comment);

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser user = BmobUser.getCurrentUser();
                if(user == null){
                    startActivity(new Intent(ReadActivity.this, LoginActivity.class));
                    return;
                }
                String phone = "15019888652";
                String content = edtComment.getText().toString();
                CommentData data = new CommentData();
                data.setContent(content);
                data.setNewsKey(newsKey);
                data.setNewsTitle(newsTitle);
                data.setPhone(phone);

                data.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if(e == null){
                            Log.e("AAA", "save comment success");
                        }
                    }
                });
            }
        });
    }
}
