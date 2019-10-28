package borrowing.thesis.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl1, rl2;
    Button btnLogin;
    EditText etPw_handler, etUsername_handler;
    String stUsername, stPw;
    int ctr = 0;

    Handler handler = new Handler();
    Runnable run = new Runnable() {
        @Override
        public void run() {

            rl1.setVisibility(View.VISIBLE);
            rl2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl1 = findViewById(R.id.rl1);
        rl2 = findViewById(R.id.rl2);

        etUsername_handler = findViewById(R.id.etUser);
        etPw_handler = findViewById(R.id.etPassword);


        handler.postDelayed(run, 3000);

        btnLogin  = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent in;
                ctr = 2;

                stUsername = etUsername_handler.getText().toString();
                stPw = etPw_handler.getText().toString();

                //validate username
                if (stUsername.equals("")) {

                    etUsername_handler.setError(getString(R.string.errormsg));
                    ctr--;
                //validate pw
                }if (stPw.equals("")) {

                    etPw_handler.setError(getString(R.string.errormsg));
                    ctr--;

                }if (ctr==2) {
                    //login testing--delete portion
                    Toast.makeText(getApplicationContext(), "going to profile", Toast.LENGTH_SHORT).show();

                    in = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(in);

                }


            }
        });

        ;
    }
}
