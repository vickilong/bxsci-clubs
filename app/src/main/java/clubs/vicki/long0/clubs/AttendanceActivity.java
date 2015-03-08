package clubs.vicki.long0.clubs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseUser;

/**
 * Created by User on 3/8/2015.
 */
public class AttendanceActivity extends ActionBarActivity {

    private Intent i;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_clubs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.attendance:
                return true;
            case R.id.your_clubs:
                return true;
            case R.id.new_club:
                return true;
            case R.id.settings:
                return true;
            case R.id.logout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void logout () {
        ParseUser.logOut();
        i = new Intent(AttendanceActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

}
