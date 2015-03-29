package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseUser;

/**
 * Created by User on 3/8/2015.
 */
public class YourClubsActivity extends Activity {

    private Intent i;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_clubs);
        
        //getInit();
        
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
                attendance();
                return true;
            case R.id.your_clubs:
                return true;
            case R.id.new_club:
                newClub();
                return true;
            case R.id.logout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void attendance () {
        i = new Intent(YourClubsActivity.this, AttendanceActivity.class);
        startActivity(i);
    }

    public void newClub () {
        i = new Intent(YourClubsActivity.this, NewClubActivity.class);
        startActivity(i);
    }

    public void logout () {
        ParseUser.logOut();
        i = new Intent(YourClubsActivity.this, LoginActivity.class);
        startActivity(i);
    }

}
