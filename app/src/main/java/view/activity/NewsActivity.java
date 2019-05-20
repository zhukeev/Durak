package view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.durak_od.R;

public class NewsActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        init();
        getExtras();
    }

    private void getExtras() {
        if (getIntent().hasExtra("news")){
            webView.loadUrl("http://static.rstgames.com/durak/public/android/ru/news.html");
        } else if (getIntent().hasExtra("rules")){
            webView.loadUrl("http://static.rstgames.com/durak/public/android/ru/help.html");
        }
    }

    private void init() {
        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.setBackgroundResource(R.drawable.background);
    }
}
