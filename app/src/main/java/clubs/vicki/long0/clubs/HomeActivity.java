package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;

/**
 * Created by User on 3/8/2015.
 */
public class HomeActivity extends Activity {

    private Button login, register;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Enable Local Datastore.
        //Parse.enableLocalDatastore(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        login = (Button) findViewById(R.id.home_to_login_button);
        register = (Button) findViewById(R.id.home_to_register_button);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }

}
