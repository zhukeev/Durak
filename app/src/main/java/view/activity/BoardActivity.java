package view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.durak_od.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaygoo.widget.OnRangeChangedListener;
import com.jaygoo.widget.RangeSeekBar;

import view.fragment.LockedFragment;
import view.fragment.MoneyFragment;
import view.fragment.OpenGamesFragment;
import view.fragment.ProfileFragment;

public class BoardActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    RangeSeekBar rangeSeekBar;
    View topMenull;
    View profile_container;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();
        setupFAB();
        setupBottomNavigationMenu();
    }

    private void setupRangeSeekbar() {

        rangeSeekBar.setOnRangeChangedListener(new OnRangeChangedListener() {
            @Override
            public void onRangeChanged(RangeSeekBar view, float leftValue, float rightValue, boolean isFromUser) {
                rangeSeekBar.getLeftSeekBar().setIndicatorText(""+leftValue);
                rangeSeekBar.getRightSeekBar().setIndicatorText(""+leftValue);
            }

            @Override
            public void onStartTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }

            @Override
            public void onStopTrackingTouch(RangeSeekBar view, boolean isLeft) {

            }
        });
    }


    private void setupBottomNavigationMenu() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment selectedFragment=null;


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
                        selectedFragment = new LockedFragment() ;

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
                Toast.makeText(BoardActivity.this, "Add", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        BottomAppBar bar = findViewById(R.id.bar);
        navigationView = findViewById(R.id.bottom_navigation);

        setSupportActionBar(bar);

         topMenull = findViewById(R.id.top_menu_ll);
        profile_container = findViewById(R.id.fragment_container_profile);

    }

}
