package view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.durak_od.R;

public class NewsActivity extends AppCompatActivity{

    WebView webView;
    FrameLayout frameLayout;
    CheckBox checkBoxSound,checkBoxVibration,checkBoxTurnSorting,checkBoxRightClick,checkBoxSortByValue,checkBoxAlwaysMyCartShirt,checkBoxDoubleAction;
    CompoundButton.OnCheckedChangeListener listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        init();
        getExtras();
    }

    private void getExtras() {

        if (getIntent().hasExtra("news")){
            webView.setVisibility(View.VISIBLE);
            Toast.makeText(this, "TRUE NEWS", Toast.LENGTH_SHORT).show();
            webView.loadUrl("http://static.rstgames.com/durak/public/android/ru/news.html");
        } else if (getIntent().hasExtra("rules")){
            webView.setVisibility(View.VISIBLE);
            Toast.makeText(this, "TRUE RULES", Toast.LENGTH_SHORT).show();

            webView.loadUrl("http://static.rstgames.com/durak/public/android/ru/help.html");
        } else if (getIntent().hasExtra("settings")){
            webView.setVisibility(View.INVISIBLE);
            frameLayout.setVisibility(View.VISIBLE);


        }



    }

    private void init() {
        webView = findViewById(R.id.webView);
        frameLayout = findViewById(R.id.fragment_container_news);
        checkBoxSound = frameLayout.findViewById(R.id.sound_settings_IV);
        checkBoxVibration = frameLayout.findViewById(R.id.vibration_settings_IV);
        checkBoxDoubleAction = frameLayout.findViewById(R.id.vibration_settings_IV);
        checkBoxAlwaysMyCartShirt = frameLayout.findViewById(R.id.vibration_settings_IV);
        checkBoxRightClick = frameLayout.findViewById(R.id.right_click_action_settings_IV);
        checkBoxSortByValue = frameLayout.findViewById(R.id.sort_by_value_settings_IV);
        checkBoxTurnSorting = frameLayout.findViewById(R.id.turn_sorting_settings_IV);
        setListener();

        checkBoxSound.setOnCheckedChangeListener(listener);

        checkBoxVibration.setOnCheckedChangeListener(listener);
        checkBoxDoubleAction.setOnCheckedChangeListener(listener);
        checkBoxAlwaysMyCartShirt.setOnCheckedChangeListener(listener);
        checkBoxRightClick.setOnCheckedChangeListener(listener);
        checkBoxSortByValue.setOnCheckedChangeListener(listener);
        checkBoxTurnSorting.setOnCheckedChangeListener(listener);

        checkBoxSound.setButtonDrawable(R.drawable.sound_32_combined);
        checkBoxVibration.setButtonDrawable(R.drawable.vibration_36);
        checkBoxDoubleAction.setButtonDrawable(R.drawable.double_tap_action);
        checkBoxAlwaysMyCartShirt.setButtonDrawable(R.drawable.always_my_card_shirt);
        checkBoxRightClick.setButtonDrawable(R.drawable.right_action_button_36);
        checkBoxSortByValue.setButtonDrawable(R.drawable.sort_by_value_36);
        checkBoxTurnSorting.setButtonDrawable(R.drawable.turn_sorting_32);
        frameLayout.setVisibility(View.INVISIBLE);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.setBackgroundResource(R.drawable.background);
    }

    private void setListener() {
        listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()){
                    case R.id.sound_settings_IV:
                        checkBoxSound.setButtonDrawable(checkBoxSound.isChecked()?
                                R.drawable.sound_32_combined:
                                R.drawable.sound_32_combined_gray);
                        break;

                }
            }
        };
    }


    public Drawable setTint(Drawable d, int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(d);
        DrawableCompat.setTint(wrappedDrawable, color);
        return wrappedDrawable;
    }

}
