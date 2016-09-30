package pratikjoy7.embedded.CalcV1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HistoryActivity extends Activity implements OnClickListener {

	private Button previous, delete;
	private TextView tView;
	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;
	private static int increment = 0;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.history);
		increment = getIntent().getIntExtra("increment", -1);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		previous = (Button)findViewById(R.id.previous);
		delete = (Button)findViewById(R.id.delete);
		tView = (TextView)findViewById(R.id.historyText);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		previous.setOnClickListener(this);
		delete.setOnClickListener(this);
		
		sharedPreferences = getSharedPreferences("calculationHistory", Context.MODE_PRIVATE);
		
		for(int i=0; i<=increment; i++)
		{
			String memory = sharedPreferences.getString("history" + i, "N/A");
	    	if(memory=="N/A")
	    	{
	    		Toast.makeText(HistoryActivity.this, "No more History Available", Toast.LENGTH_SHORT).show();
	    	}
	    	else
	    	{
	    		HistoryActivity.this.tView.append(memory);
	    		HistoryActivity.this.tView.append("\n");
	    	}
		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.delete:
			sharedPreferences = getSharedPreferences("calculationHistory", Context.MODE_PRIVATE);
        	editor = sharedPreferences.edit();
        	editor.clear();
        	editor.commit();
        	HistoryActivity.this.tView.setText("");
        	increment = 0;
        	Toast.makeText(HistoryActivity.this, "All History Deleted", Toast.LENGTH_SHORT).show();
        	break;
			
		case R.id.previous:
			Intent intent = new Intent(this, CalculatorActivity.class);
			intent.putExtra("increment", increment);
			startActivity(intent);
			break;
		}
	}
}