package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by User on 3/7/2015.
 */
public class RegisterActivity extends Activity {

    private Button register, login;
    private Intent i;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = (Button) findViewById(R.id.register_button);
        login = (Button) findViewById(R.id.register_to_login_button);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                user.setUsername("my name");
                user.setPassword("my pass");
                user.setEmail("email@example.com");

                // other fields can be set just like with ParseObject
                user.put("OSIS", 123456789);
                user.put("Homeroom", "A01");

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            System.out.println("ASFKEWF");
                            goToLogin();
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                        }
                    }
                });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToLogin();
            }
        });
    }

    public void goToLogin () {
        i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

}
