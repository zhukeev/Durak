package view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.durak_od.R;

public class MainActivity extends AppCompatActivity {


    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        progressBar.setProgress(50);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);

    }

    private void init() {
        progressBar = findViewById(R.id.progressBarSplash);
    }
}
