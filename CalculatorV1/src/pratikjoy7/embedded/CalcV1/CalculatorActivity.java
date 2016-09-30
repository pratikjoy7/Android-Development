package pratikjoy7.embedded.CalcV1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created.
     *  */
	private Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, mul, div, equal, point, plusMinus, ac, ce, back, mc, mr, ms, mPlus, mMinus, history;
	private EditText res;
	private TextView tView;
	private String operator, result;
	private Double firstNumber, secondNumber, finalResult;
	private boolean equalPressed, digitPressed, pointPressed, operatorPressed, plusMinusPressed;
	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;
	private static int increment = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.body);
        increment = getIntent().getIntExtra("increment", 0);
    }
    
    @Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        mul = (Button)findViewById(R.id.multiplication);
        div = (Button)findViewById(R.id.division);
        plusMinus = (Button)findViewById(R.id.plusMinus);
        equal = (Button)findViewById(R.id.equal);
        point = (Button)findViewById(R.id.point);
        res = (EditText)findViewById(R.id.editText1);
        tView = (TextView)findViewById(R.id.textView1);
        ce = (Button)findViewById(R.id.ce);
        ac = (Button)findViewById(R.id.ac);
        back = (Button)findViewById(R.id.back);
        mc = (Button)findViewById(R.id.mc);
        mr = (Button)findViewById(R.id.mr);
        ms = (Button)findViewById(R.id.ms);
        mPlus = (Button)findViewById(R.id.mPlus);
        mMinus = (Button)findViewById(R.id.mMinus);
        history = (Button)findViewById(R.id.history);
	}
    
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
        
		tView.setOnClickListener(this);
        res.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        point.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        plusMinus.setOnClickListener(this);
        equal.setOnClickListener(this);
        ce.setOnClickListener(this);
        ac.setOnClickListener(this);
        back.setOnClickListener(this);
        mc.setOnClickListener(this);
        mr.setOnClickListener(this);
        ms.setOnClickListener(this);
        mPlus.setOnClickListener(this);
        mMinus.setOnClickListener(this);
        history.setOnClickListener(this);
	}
    
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("editTextValue", CalculatorActivity.this.res.getText().toString());
		outState.putString("textViewValue", CalculatorActivity.this.tView.getText().toString());

	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		CalculatorActivity.this.res.setText(savedInstanceState.get("editTextValue").toString());
		CalculatorActivity.this.tView.setText(savedInstanceState.get("textViewValue").toString());
	}
	
	public void finalResult(double value)
	{
		DecimalFormat df = new DecimalFormat("############.#####");
		result = df.format(value);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
    public void add(double n1, double n2)
    {
    	finalResult = n1 + n2;
    	finalResult(finalResult);
    }
    
    public void sub(double n1, double n2)
    {
    	finalResult = n1 - n2;
    	finalResult(finalResult);
    }
    
    public void mul(double n1, double n2)
    {
    	finalResult = n1 * n2;
    	finalResult(finalResult);
    }
    
    public void div(double n1, double n2)
    {
    	try
    	{
    		finalResult = n1 / n2;
        	finalResult(finalResult);
    	}
    	catch(Exception e)
    	{
    		CalculatorActivity.this.res.setText("Result in Undefined");
    	}
    }
    
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.editText1:
			//InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); 
			//imm.hideSoftInputFromWindow(res.getWindowToken(), 0);
			break;
			
        case R.id.one:
        	digitPressed = true;
        	if(equalPressed == true)
        	{
        		CalculatorActivity.this.res.setText("1");
        		equalPressed = false;
        	}
        	else
        		CalculatorActivity.this.res.append("1");
        	break;
        	
        case R.id.two:
        	digitPressed = true;
        	if(equalPressed == true)
        	{
        		CalculatorActivity.this.res.setText("2");
        		equalPressed = false;
        	}
        	else
        		CalculatorActivity.this.res.append("2");
        	break;
        	
        case R.id.three:
        	digitPressed = true;
        	if(equalPressed == true)
        	{
        		CalculatorActivity.this.res.setText("3");
        		equalPressed = false;
        	}
        	else
        		CalculatorActivity.this.res.append("3");
        	break;
        	
        case R.id.four:
        	digitPressed = true;
        	if(equalPressed == true)
        	{
        		CalculatorActivity.this.res.setText("4");
        		equalPressed = false;
        	}
        	else
        		CalculatorActivity.this.res.append("4");
            break;
            
        case R.id.five:
        	digitPressed = true;
        	if(equalPressed == true)
        	{
        		CalculatorActivity.this.res.setText("5");
        		equalPressed = false;
        	}
        	else
        		CalculatorActivity.this.res.append("5");
        	break;
        	
        case R.id.six:
        	digitPressed = true;
        	if(equalPressed == true)
        	{
        		CalculatorActivity.this.res.setText("6");
        		equalPressed = false;
        	}
        	else
        		CalculatorActivity.this.res.append("6");
        	break;
        	
        case R.id.seven:
        	digitPressed = true;
        	if(equalPressed == true)
        	{
        		CalculatorActivity.this.res.setText("7");
        		equalPressed = false;
        	}
        	else
        		CalculatorActivity.this.res.append("7");
        	break;
        	
        case R.id.eight:
        	digitPressed = true;
        	if(equalPressed == true)
        	{
        		CalculatorActivity.this.res.setText("8");
        		equalPressed = false;
        	}
        	else
        		CalculatorActivity.this.res.append("8");
            break;
        
        case R.id.nine:
        	digitPressed = true;
        	if(equalPressed == true)
        	{
        		CalculatorActivity.this.res.setText("9");
        		equalPressed = false;
        	}
        	else
        		CalculatorActivity.this.res.append("9");
        	break;
        	
        case R.id.zero:
        	if(digitPressed != true)
        		CalculatorActivity.this.res.setText("");
        	else
        	{
	        	if(equalPressed == true)
	        	{
	        		CalculatorActivity.this.res.setText("");
	        		equalPressed = false;
	        	}
	        	else
	        		CalculatorActivity.this.res.append("0");
        	}
        	break;
        	        	
        case R.id.point:
        	digitPressed = true;
        	if(pointPressed == true)
        		CalculatorActivity.this.res.setText(CalculatorActivity.this.res.getText().toString());
        	else
        	{
	        	if(equalPressed == true)
	        	{
	        		CalculatorActivity.this.res.setText(".");
	        		equalPressed = false;
	        		pointPressed = true;
	        	}
	        	else
	        	{
	        		CalculatorActivity.this.res.append(".");
	        		pointPressed = true;       	
	        	}
        	}
	        break;
        	
        case R.id.plus:
        	try
        	{
	        	if(operatorPressed == true)
	        	{
		        	secondNumber = Double.parseDouble(CalculatorActivity.this.res.getText().toString());
		        	//equalPressed = true;
		        	digitPressed = false;
		        	pointPressed = false;
		        	plusMinusPressed = false;
		        	operator = "plus";
		        	//operatorPressed = false;
		        	//if(operator == "plus")
		        	add(firstNumber, secondNumber);
		        	
		        	CalculatorActivity.this.tView.setText(result);
		        	CalculatorActivity.this.res.setText(result);
		        	finalResult(secondNumber);
		        	CalculatorActivity.this.tView.append(result);
		        	
		        	/*CalculatorActivity.this.res.setText(result);
		        	//CalculatorActivity.this.res.setText("");
		        	finalResult(secondNumber);
		        	CalculatorActivity.this.tView.setText(result);
		        	CalculatorActivity.this.tView.append(" + ");*/
	        	}
	        	else
	        	{
	        		digitPressed = false;
		        	plusMinusPressed = false;
		        	firstNumber = Double.parseDouble(CalculatorActivity.this.res.getText().toString());
		        	finalResult(firstNumber);
		        	CalculatorActivity.this.tView.setText(result + " + ");
		        	CalculatorActivity.this.res.setText("");
		        	operator = "plus";
		        	pointPressed = false;
		        	operatorPressed = true;
	        	}
        	}
        	catch(Exception e)
        	{
        		CalculatorActivity.this.res.setText("");
        	}
	        break;
        	
        case R.id.minus:
        	try
        	{
	        	digitPressed = false;
	        	plusMinusPressed = false;
	        	firstNumber = Double.parseDouble(CalculatorActivity.this.res.getText().toString());
	        	finalResult(firstNumber);
	        	CalculatorActivity.this.tView.setText(result + " - ");
	        	CalculatorActivity.this.res.setText("");
	        	operator = "minus";
	        	pointPressed = false;
        	}
        	catch(Exception e)
        	{
        		CalculatorActivity.this.res.setText("");
        	}
        	break;
         
        case R.id.division:
        	try
        	{
	        	digitPressed = false;
	        	plusMinusPressed = false;
	        	firstNumber = Double.parseDouble(CalculatorActivity.this.res.getText().toString());
	        	finalResult(firstNumber);
	        	CalculatorActivity.this.tView.setText(result + " / ");
	        	CalculatorActivity.this.res.setText("");
	        	operator = "div";
	        	pointPressed = false;
        	}
        	catch(Exception e)
        	{
        		CalculatorActivity.this.res.setText("");
        	}
        	break;
        	
        case R.id.multiplication:
        	try
        	{
	        	digitPressed = false;
	        	plusMinusPressed = false;
	        	firstNumber = Double.parseDouble(CalculatorActivity.this.res.getText().toString());
	        	finalResult(firstNumber);
	        	CalculatorActivity.this.tView.setText(result + " * ");
	        	CalculatorActivity.this.res.setText("");
	        	operator = "mul";
	        	pointPressed = false;
        	}
        	catch(Exception e)
        	{
        		CalculatorActivity.this.res.setText("");
        	}
        	break;
        	
        case R.id.plusMinus:
        	String val = CalculatorActivity.this.res.getText().toString();
        	if(digitPressed == true)
        	{
        		if(plusMinusPressed == false)
        		{
        			CalculatorActivity.this.res.setText("-"+ CalculatorActivity.this.res.getText().toString());
        			plusMinusPressed = true;
        		}
        		else
        		{	
        			CalculatorActivity.this.res.setText(val.substring(1));
        			plusMinusPressed = false;
        		}
        	}
        	else
        	{
        		if(val.matches(""))
        		{
        			CalculatorActivity.this.res.setText("");
        		}
        		else
        		{
        			CalculatorActivity.this.res.setText("-"+ CalculatorActivity.this.res.getText().toString());
        			plusMinusPressed = true;
        		}
        	}
        	break;
        	
        case R.id.equal:
        	try
        	{
	        	if(equalPressed == false)
	        	{
		        	secondNumber = Double.parseDouble(CalculatorActivity.this.res.getText().toString());
		        	equalPressed = true;
		        	digitPressed = false;
		        	pointPressed = false;
		        	operatorPressed = false;
		        	plusMinusPressed = false;
		        	if(operator == "plus")
		        		add(firstNumber, secondNumber);
		        	else if(operator == "minus")
		        		sub(firstNumber, secondNumber);
		        	else if(operator == "mul")
		        		mul(firstNumber, secondNumber);
		        	else if(operator == "div")
		        		div(firstNumber, secondNumber);
		        	
		        	
		        	CalculatorActivity.this.res.setText(result);
		        	finalResult(secondNumber);
		        	CalculatorActivity.this.tView.append(result);
		        	
		        	sharedPreferences = getSharedPreferences("calculationHistory", Context.MODE_PRIVATE);
	            	editor = sharedPreferences.edit();
	            	editor.putString("history" + increment, CalculatorActivity.this.tView.getText().toString() + " = " + CalculatorActivity.this.res.getText().toString());
	            	editor.commit();
	            	increment++;
	            	}
	        	else
	        	{
	        		//CalculatorActivity.this.tView.setText(result);
	        		plusMinusPressed = false;
		        	pointPressed = false;
	        		if(operator == "plus")
		        		add(finalResult, secondNumber);
		        	else if(operator == "minus")
		        		sub(finalResult, secondNumber);
		        	else if(operator == "mul")
		        		mul(finalResult, secondNumber);
		        	else if(operator == "div")
		        		div(finalResult, secondNumber);
	        		
	        		/*if (finalResult != null && finalResult.toString().length() >= 2) {  
	        			lastTwo = finalResult.toString().substring(Math.max(0, finalResult.toString().length() - 2));	
	        		}*/
	        		CalculatorActivity.this.tView.setText(CalculatorActivity.this.res.getText().toString());
	        		CalculatorActivity.this.res.setText(result);
					finalResult(secondNumber);
					if(operator == "plus")
						CalculatorActivity.this.tView.append(" + ");
		        	else if(operator == "minus")
		        		CalculatorActivity.this.tView.append(" - ");
		        	else if(operator == "mul")
		        		CalculatorActivity.this.tView.append(" * ");
		        	else if(operator == "div")
		        		CalculatorActivity.this.tView.append(" / ");
		        	CalculatorActivity.this.tView.append(result);
		        	
		        	sharedPreferences = getSharedPreferences("calculationHistory", Context.MODE_PRIVATE);
	            	editor = sharedPreferences.edit();
	            	editor.putString("history" + increment, CalculatorActivity.this.tView.getText().toString() + " = " + CalculatorActivity.this.res.getText().toString());
	            	editor.commit();
	            	increment++;
	        	}
        	}
        	catch(Exception e)
        	{
        		CalculatorActivity.this.res.setText("");
        	}
	        break;
            
        case R.id.ce:
        	CalculatorActivity.this.res.setText("");
        	break;
        
        case R.id.ac:
        	CalculatorActivity.this.res.setText("");
        	CalculatorActivity.this.tView.setText("");
        	pointPressed = false;
        	operatorPressed = false;
        	digitPressed = false;
        	firstNumber = 0.0;
        	secondNumber = 0.0;
        	finalResult = 0.0;
        	break;
        	
        case R.id.back:
        	String value = CalculatorActivity.this.res.getText().toString();
        	if(value.matches(""))
        	{
        		CalculatorActivity.this.res.setText("");
        	}
        	else
        	{
        		CalculatorActivity.this.res.setText(value.substring(0, value.length()-1));
        	}
        	break;
        	
        case R.id.mc:
        	sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        	editor = sharedPreferences.edit();
        	editor.remove("value");
        	editor.commit();
        	Toast.makeText(CalculatorActivity.this, "Memory Cleared", Toast.LENGTH_SHORT).show();
        	break;
        	
        case R.id.ms:
        	try
        	{
        		sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
            	editor = sharedPreferences.edit();
            	editor.putString("value", CalculatorActivity.this.res.getText().toString());
            	editor.commit();
            	Toast.makeText(CalculatorActivity.this, "Value Saved in Memory", Toast.LENGTH_SHORT).show();
        	}
        	catch(Exception e)
        	{
        		
        	}
        	break;
        	
        case R.id.mr:
        	sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        	String memory = sharedPreferences.getString("value", "N/A");
        	if(memory=="N/A")
        	{
        		Toast.makeText(CalculatorActivity.this, "No Value inside Memory", Toast.LENGTH_SHORT).show();
        	}
        	else
        	{
        		CalculatorActivity.this.res.setText(memory);
        	}
        	break;
        	
        case R.id.mPlus:
        	try
        	{
        		sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
            	String memVal = sharedPreferences.getString("value", "N/A");
            	if(memVal=="N/A")
            	{
            		Toast.makeText(CalculatorActivity.this, "No Value inside Memory", Toast.LENGTH_SHORT).show();
            	}
            	else
            	{
            		String memPlus = CalculatorActivity.this.res.getText().toString();
            		firstNumber = Double.parseDouble(memVal);
            		secondNumber = Double.parseDouble(memPlus);
            		add(firstNumber, secondNumber);
            		editor = sharedPreferences.edit();
            		editor.putString("value", result.toString());
                	editor.commit();
                	Toast.makeText(CalculatorActivity.this, "New Value Saved in Memory", Toast.LENGTH_SHORT).show();
            	}
        	}
        	catch (Exception e) {
			}
        	break;
        	
        case R.id.mMinus:
        	try
        	{
        		sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
            	String memVal = sharedPreferences.getString("value", "N/A");
            	if(memVal=="N/A")
            	{
            		Toast.makeText(CalculatorActivity.this, "No Value inside Memory", Toast.LENGTH_SHORT).show();
            	}
            	else
            	{
            		String memPlus = CalculatorActivity.this.res.getText().toString();
            		firstNumber = Double.parseDouble(memVal);
            		secondNumber = Double.parseDouble(memPlus);
            		sub(firstNumber, secondNumber);
            		editor = sharedPreferences.edit();
            		editor.putString("value", result.toString());
                	editor.commit();
                	Toast.makeText(CalculatorActivity.this, "New Value Saved in Memory", Toast.LENGTH_SHORT).show();
            	}
        	}
        	catch (Exception e) {
			}
        	break;
        	
        case R.id.history:
        	Intent intent = new Intent(this, HistoryActivity.class);
        	intent.putExtra("increment", increment);
        	startActivity(intent);
        	break;
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
}
