package view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.durak_od.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import view.fragment.FilterSettingsDialog;
import view.fragment.LockedFragment;
import view.fragment.MoneyFragment;
import view.fragment.NewGameDialog;
import view.fragment.NewsFragment;
import view.fragment.OpenGamesFragment;
import view.fragment.ProfileFragment;

public class BoardActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    //    RangeSeekBar rangeSeekBar;
    View topMenull;
    View profile_container;
    FrameLayout frameLayout, frameContainerProfile;
    ImageView openFilterImageView;
    DialogFragment fragmentFilterSettings;
    DialogFragment fragmentNewGame;
    ImageView newsImageView, friendsImageView, achievementsImageView, assetsImageView,
            leaderboardImageView, settingsImageView, shareImageView, rulesImageView, moreGamesImageView;
    View.OnClickListener imageOnClickListener;

    NewsFragment newsFragment;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();
        setupFAB();
        setupBottomNavigationMenu();
    }

    private void setupBottomNavigationMenu() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment selectedFragment = null;


                switch (menuItem.getItemId()) {
                    case R.id.navigation_profile:
                        Toast.makeText(BoardActivity.this, "Profile", Toast.LENGTH_SHORT).show();

                        selectedFragment = new ProfileFragment();
                        topMenull.setVisibility(View.INVISIBLE);
                        profile_container.setVisibility(View.VISIBLE);


                        break;


                    case R.id.navigation_open:
                        Toast.makeText(BoardActivity.this, "Open", Toast.LENGTH_SHORT).show();
                        selectedFragment = new OpenGamesFragment();

                        profile_container.setVisibility(View.GONE);
                        topMenull.setVisibility(View.VISIBLE);
                        break;
                    case R.id.navigation_locked:
                        Toast.makeText(BoardActivity.this, "Locked", Toast.LENGTH_SHORT).show();
                        selectedFragment = new LockedFragment();

                        profile_container.setVisibility(View.INVISIBLE);
                        topMenull.setVisibility(View.VISIBLE);
                        break;
                    case R.id.navigation_money:
                        Toast.makeText(BoardActivity.this, "Money", Toast.LENGTH_SHORT).show();
                        selectedFragment = new MoneyFragment();

                        profile_container.setVisibility(View.INVISIBLE);

                        topMenull.setVisibility(View.VISIBLE);
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });


    }

    private void setupFAB() {
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentNewGame
                        .show(getSupportFragmentManager(), "Dialog");

            }
        });
    }


    private void init() {
        newsFragment = new NewsFragment();
        bundle = new Bundle();

        BottomAppBar bar = findViewById(R.id.bar);
        navigationView = findViewById(R.id.bottom_navigation);
        frameLayout = findViewById(R.id.top_fragment_menu);

        topMenull = findViewById(R.id.top_menu_ll);
        profile_container = findViewById(R.id.fragment_container_profile);

        initOnImageViewClickListener();

        openFilterImageView = frameLayout.findViewById(R.id.open_filter_button);
        newsImageView = profile_container.findViewById(R.id.news_profile_circle_btn);
        friendsImageView = profile_container.findViewById(R.id.friends_profile_circle_btn);
        assetsImageView = profile_container.findViewById(R.id.assets_profile_circle_btn);
        leaderboardImageView = profile_container.findViewById(R.id.leaderboard_profile_circle_btn);
        achievementsImageView = profile_container.findViewById(R.id.achievements_profile_circle_btn);
        settingsImageView = profile_container.findViewById(R.id.settings_profile_circle_btn);
        rulesImageView = profile_container.findViewById(R.id.rules_profile_circle_btn);
        shareImageView = profile_container.findViewById(R.id.share_profile_circle_btn);
        moreGamesImageView = profile_container.findViewById(R.id.more_games_profile_circle_btn);

        openFilterImageView.setOnClickListener(imageOnClickListener);
        newsImageView.setOnClickListener(imageOnClickListener);
        friendsImageView.setOnClickListener(imageOnClickListener);
        assetsImageView.setOnClickListener(imageOnClickListener);
        leaderboardImageView.setOnClickListener(imageOnClickListener);
        achievementsImageView.setOnClickListener(imageOnClickListener);
        settingsImageView.setOnClickListener(imageOnClickListener);
        rulesImageView.setOnClickListener(imageOnClickListener);
        shareImageView.setOnClickListener(imageOnClickListener);
        moreGamesImageView.setOnClickListener(imageOnClickListener);

        fragmentFilterSettings = new FilterSettingsDialog();
        fragmentNewGame = new NewGameDialog();

        setSupportActionBar(bar);

        openFilterImageView.setOnClickListener(imageOnClickListener);

    }

    private void initOnImageViewClickListener() {



        imageOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.open_filter_button:
                        fragmentFilterSettings
                                .show(getSupportFragmentManager(),"Dialog");
                        break;
                    case R.id.news_profile_circle_btn:
                        final Intent intent = new Intent(BoardActivity.this, NewsActivity.class);

                        intent.putExtra("news", "news");
                        startActivity(intent);

                        break;
                    case R.id.friends_profile_circle_btn:

                        break;
                    case R.id.assets_profile_circle_btn:

                        break;
                    case R.id.leaderboard_profile_circle_btn:

                        break;
                    case R.id.achievements_profile_circle_btn:


                        break;
                    case R.id.settings_profile_circle_btn:
                        final Intent settings = new Intent(BoardActivity.this, NewsActivity.class);
                        settings.putExtra("settings", "settings");
                        startActivity(settings);

                        break;
                    case R.id.share_profile_circle_btn:


                        break;
                    case R.id.rules_profile_circle_btn:

                        final Intent rules = new Intent(BoardActivity.this, NewsActivity.class);

                        rules.putExtra("rules", "rules");
                        startActivity(rules);
                        break;
                    case R.id.more_games_profile_circle_btn:

                        break;
                }
            }
        };
    }

}
