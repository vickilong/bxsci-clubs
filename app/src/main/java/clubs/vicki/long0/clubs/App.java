package clubs.vicki.long0.clubs;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by vicki on 3/24/2015.
 */
public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "KuauNlNi5sL9O5GhCleBJxIR7st2FxInU3WNkR57", "PTQCavJmc2gTHNrgKd35K9AXooLVDBHPk5uZhV3R");
    }
}