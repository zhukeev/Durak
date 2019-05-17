package view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.durak_od.R;

public class SigninAcitvity extends AppCompatActivity {

    EditText password,username;
    Button signIn,signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_acitvity);

        init();
    }

    private void init() {
        password = findViewById(R.id.ET_password_sign_in_activity);
        username = findViewById(R.id.ET_login_sign_in_activity);

        signIn = findViewById(R.id.btn_signin_sign_in_activity);
        signUp = findViewById(R.id.btn_signUp__sign_in_activity);

        //BUTTON CLICK

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninAcitvity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninAcitvity.this,BoardActivity.class);

                startActivity(intent);
            }
        });
    }
}
