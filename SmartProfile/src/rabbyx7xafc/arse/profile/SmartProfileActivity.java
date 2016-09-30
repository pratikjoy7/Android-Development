package rabbyx7xafc.arse.profile;

import pratikjoy7.embedded.smartProfile.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class SmartProfileActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
    }
    
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
     }

     // Method to stop the service
     public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
     }
}