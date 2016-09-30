package pratikjoy7.embedded.currencyConverter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CurrencyConverterActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	
	private EditText editText1, editText2;
	private TextView textView1;
	private Button button;
	private Double val1, val2, takaRate, dollarRate;
	private String val, convertTo;
	JSONObject jsonObject;
	HttpURLConnection urlConnection = null;
	private RadioGroup radioGroup;
	private RadioButton radioButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		editText1 = (EditText)findViewById(R.id.editText1);
		editText2 = (EditText)findViewById(R.id.editText2);
		textView1 = (TextView)findViewById(R.id.textView1);
		radioGroup = (RadioGroup)findViewById(R.id.radioGroup1);
		button = (Button)findViewById(R.id.button1);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		button.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		try
		{
			val1 = Double.parseDouble(this.editText1.getText().toString());
			
			int selected_id = radioGroup.getCheckedRadioButtonId();
			radioButton = (RadioButton)findViewById(selected_id);
			convertTo = radioButton.getText().toString();
			
			URL url = new URL("http://hrhafiz.com/converter/");
			urlConnection = (HttpURLConnection) url.openConnection();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			val = br.readLine();
			
			String[] valArray = val.split(",");
			
			if(convertTo.equals("Taka"))
			{
				jsonObject = new JSONObject(valArray[1]);
		        dollarRate = jsonObject.getDouble("BDT-USD");
		        val2 = val1*dollarRate;
			}
			
			else
			{
				jsonObject = new JSONObject(valArray[0]);
		        takaRate = jsonObject.getDouble("USD-BDT");
		        val2 = val1*takaRate;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.editText2.setText(val2.toString());
			urlConnection.disconnect();
		}
	}
}