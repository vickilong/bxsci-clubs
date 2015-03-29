package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by User on 3/29/2015.
 */
public class ClubActivity extends Activity {

    private String mClubID;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        getInit(); //Initializes all variables

//        mFinalScore.setText(String.valueOf(mScore)); //Changes score shown to the user's final score
//
//        //When the restart button is clicked, closes activity and goes back to main activity
//        mRestartButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }

    public void getInit () {
        mClubID = getIntent().getStringExtra(getResources().getString(R.string.new_club_id));
    }

}
