package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by User on 3/7/2015.
 */
public class RegisterActivity extends Activity {

    private EditText name, password, email, OSIS, homeroom;
    private Button register, login;
    private Intent i;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getInit();

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                user.setUsername( email.getText().toString() );
                user.setPassword( password.getText().toString() );
                user.setEmail( email.getText().toString() );

                // other fields can be set just like with ParseObject
                user.put("name", name.getText().toString() );
                user.put("osis", Integer.parseInt(OSIS.getText().toString()) );
                user.put("homeroom", homeroom.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            registerSuccess();
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

    public void getInit () {
        name = (EditText) findViewById(R.id.register_name);
        password = (EditText) findViewById(R.id.register_password);
        email = (EditText) findViewById(R.id.register_email);
        OSIS = (EditText) findViewById(R.id.register_OSIS);
        homeroom = (EditText) findViewById(R.id.register_homeroom);

        register = (Button) findViewById(R.id.register_button);
        login = (Button) findViewById(R.id.register_to_login_button);
    }

    public void registerSuccess () {
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(R.string.register_success);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void goToLogin () {
        i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }

}
