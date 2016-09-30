package rabbyx7xafc.arse.profile;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service implements SensorEventListener{

	private SensorManager sensorManager;
	private Sensor proximitySensor;
	private AudioManager audioManager;
	private boolean flag;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// Let it continue running until it is stopped.
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		sensorManager.registerListener((SensorEventListener) this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		return START_STICKY;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		sensorManager.unregisterListener(this);
		Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	}

	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if(event.sensor.getType() == Sensor.TYPE_PROXIMITY){
            if(event.values[0] == proximitySensor.getMaximumRange())
            {
                if(flag == true)
                {
                	audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                }
                    flag = false;
            }
            else
            {
            	audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                flag = true;
            }  
		}
	}
}
