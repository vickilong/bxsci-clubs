package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseObject;


public class LoginActivity extends Activity {

    private Button login, register;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.login_button);
        register = (Button) findViewById(R.id.login_to_register_button);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("foo", "bar");
                testObject.saveInBackground();
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
}
