package clubs.vicki.long0.clubs;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by User on 3/8/2015.
 */
public class YourClubsActivity extends Activity {
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_clubs);
        
        getInit();
        
	}
}
