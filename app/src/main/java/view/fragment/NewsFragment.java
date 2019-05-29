package view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.durak_od.R;

import java.util.Objects;


public class NewsFragment extends Fragment {

    WebView webView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        init(v);
        getAllArguments();
        return v;
    }

    private void getAllArguments() {

        String rules = "no";
        String news = "no";

        rules = getArguments().getString("rules","rules");
        news = getArguments().getString("news","news");

        if (rules.equals("rules")) {
            webView.loadUrl("http://static.rstgames.com/durak/public/android/ru/help.html");
        } else if (news.equals("news")) {
            webView.loadUrl("http://static.rstgames.com/durak/public/android/ru/news.html");
        }



//        Objects.requireNonNull(getFragmentManager()).beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
    }

    private void init(View v) {
        webView = v.findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.setBackgroundResource(R.drawable.background);
    }

    @Override
    public void onStart() {
        super.onStart();


    }
}
