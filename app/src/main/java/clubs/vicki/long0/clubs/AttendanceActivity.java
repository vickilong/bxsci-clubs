package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by User on 3/8/2015.
 */
public class AttendanceActivity extends Activity {

    private EditText inputAttendance;
    private Button logAttendance;
    private Intent i;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        getInit();

        logAttendance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String userCode = inputAttendance.getText().toString();

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Meeting");
                query.whereEqualTo("attendanceCode", userCode);
                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    public void done(ParseObject clubMeeting, ParseException e) {
                        if (clubMeeting == null) {
                            Log.d("score", "The getFirst request failed.");
                        } else {
                        	logAttendance(clubMeeting);
                            attendanceSuccess();
                        }
                    }
                });
            }
        });
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
                yourClubs();
                return true;
            case R.id.new_club:
                newClub();
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

    public void getInit () {
        inputAttendance = (EditText) findViewById(R.id.attendance_input);
        logAttendance = (Button) findViewById(R.id.attendance_button);
    }
    
    public void logAttendance (ParseObject meeting) {
    	ParseObject attendance = new ParseObject("Attendance");
    	attendance.put("studentPointer", ParseUser.getCurrentUser());
    	attendance.put("meetingPointer", meeting);
    	attendance.saveInBackground();
    }

    public void attendanceSuccess () {
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(R.string.attendance_success);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void yourClubs () {
        i = new Intent(AttendanceActivity.this, YourClubsActivity.class);
        startActivity(i);
    }

    public void newClub () {
        i = new Intent(AttendanceActivity.this, NewClubActivity.class);
        startActivity(i);
    }

    public void logout () {
        ParseUser.logOut();
        i = new Intent(AttendanceActivity.this, LoginActivity.class);
        startActivity(i);
    }

}
