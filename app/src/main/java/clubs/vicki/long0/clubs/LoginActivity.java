package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginActivity extends Activity {

    private EditText email, password;
    private Button login, register;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getInit();

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ParseUser.logInInBackground( email.getText().toString(), password.getText().toString(), new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            i = new Intent(LoginActivity.this, AttendanceActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                        }
                    }
                });
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void getInit() {
        email = (EditText) findViewById(R.id.login_email);
        password = (EditText) findViewById(R.id.login_password);

        login = (Button) findViewById(R.id.login_button);
        register = (Button) findViewById(R.id.login_to_register_button);
    }

}
