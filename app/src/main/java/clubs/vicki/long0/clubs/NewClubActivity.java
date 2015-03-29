package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;

/**
 * Created by User on 3/8/2015.
 */
public class NewClubActivity extends Activity {
	
	private EditText newClubName, presidentInput, presidentOSISInput, vicePresidentInput, vicePresidentOSISInput, secretaryInput, secretaryOSISInput;
	private Button newClubButton;
	
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

}
