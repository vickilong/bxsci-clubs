package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by User on 3/8/2015.
 */
public class NewClubActivity extends Activity {
	
	private EditText newClubName, presidentInput, presidentOSISInput, vicePresidentInput, vicePresidentOSISInput, secretaryInput, secretaryOSISInput;
	private Button newClubButton;
    private Intent i;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_club);
        
        getInit();
        
        newClubButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	createNewParseObjects();
            	
            }
        });
        
	}
	
	public void getInit () {
		newClubName = (EditText) findViewById(R.id.new_club_name);
		presidentInput = (EditText) findViewById(R.id.new_club_president);
		presidentOSISInput = (EditText) findViewById(R.id.new_club_president_osis);
		vicePresidentInput = (EditText) findViewById(R.id.new_club_vice_president);
		vicePresidentOSISInput = (EditText) findViewById(R.id.new_club_vice_president_osis);
		secretaryInput = (EditText) findViewById(R.id.new_club_secretary);
		secretaryOSISInput = (EditText) findViewById(R.id.new_club_secretary_osis);
		
		newClubButton = (Button) findViewById(R.id.new_club_button);
	}
	
	public void createNewParseObjects () {
		ParseObject club = new ParseObject("Club");
    	club.put("name", newClubName.getText().toString() );
    	club.saveInBackground();
    	
    	ParseObject president = new ParseObject("Officer");
    	president.put("name", presidentInput.getText().toString() );
    	president.put("osis", Integer.parseInt(presidentOSISInput.getText().toString()) );
    	president.put("position", "president");
    	president.put("clubPointer", club);
    	president.saveInBackground();
    	
    	ParseObject vicePresident = new ParseObject("Officer");
    	vicePresident.put("name", vicePresidentInput.getText().toString() );
    	vicePresident.put("osis", Integer.parseInt(vicePresidentOSISInput.getText().toString()) );
    	vicePresident.put("position", "vicePresident");
    	vicePresident.put("clubPointer", club);
    	vicePresident.saveInBackground();
    	
    	ParseObject secretary = new ParseObject("Officer");
    	secretary.put("name", secretaryInput.getText().toString() );
    	secretary.put("osis", Integer.parseInt(secretaryOSISInput.getText().toString()) );
    	secretary.put("position", "secretary");
    	secretary.put("clubPointer", club);
    	secretary.saveInBackground();
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
                yourClubs();
                return true;
            case R.id.new_club:
                return true;
            case R.id.logout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void attendance () {
        i = new Intent(NewClubActivity.this, AttendanceActivity.class);
        startActivity(i);
    }

    public void yourClubs () {
        i = new Intent(NewClubActivity.this, YourClubsActivity.class);
        startActivity(i);
    }

    public void logout () {
        ParseUser.logOut();
        i = new Intent(NewClubActivity.this, LoginActivity.class);
        startActivity(i);
    }

}
