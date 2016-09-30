package rabbyx7xafc.ars.webcalc;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class WebAppInterface {
	String num1="";
	String num2="";
	Double result;
	String res;
	int counter=0;
	boolean operatorPressed=false;
	String op;
	
	WebCalculatorActivity wa=null;
    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        wa=(WebCalculatorActivity)c;
    }
    
    public void addNum(String num) 
    {
    	counter++;
        if(operatorPressed)
        {
        	num2+=num;
        }
        else
        	num1+=num;
    }
    
    public void addOperator(String opr) 
    {
    	if(counter!=0){
    		op = opr;
        	operatorPressed = true;
    	}	
    }
    
    public String getResult()
    {
    	if(op.equals("+"))
    		result=Double.valueOf(num1)+Double.valueOf(num2);
    	else if(op.equals("-"))
    		result=Double.valueOf(num1)-Double.valueOf(num2);
    	else if(op.equals("*"))
    		result=Double.valueOf(num1)*Double.valueOf(num2);
    	else if(op.equals("/"))
    		result=Double.valueOf(num1)/Double.valueOf(num2);
    	
    	res=result.toString();
    	num1="";
    	num2="";
    	operatorPressed=false;
    	counter=0;
    	return res;
    }
    
    public void reload()
    {
    	wa.mHandler.post(new Runnable() {
			public void run() {
				WebAppInterface.this.wa.myWebView.reload();
				Log.d("try", "reload");
			}
		});
	}
    
    
}

