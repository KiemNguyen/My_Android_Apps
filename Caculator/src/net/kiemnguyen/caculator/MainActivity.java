package net.kiemnguyen.caculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText operand1;
	EditText operand2;
	Button btnPlus;
	Button btnSubtract;
	Button btnDivide;
	Button btnMultiply;
	Button btnClear;
	TextView result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Operand fields from the main screen
		operand1 = (EditText) findViewById(R.id.editOperand1);
		operand2 = (EditText) findViewById(R.id.editOperand2);
		
		//Associate buttons
		btnPlus = (Button) findViewById(R.id.btnPlus);
		btnSubtract = (Button) findViewById(R.id.btnSubtract);
		btnDivide = (Button) findViewById(R.id.btnDivide);
		btnMultiply = (Button) findViewById(R.id.btnMultiply);
		btnClear = (Button) findViewById(R.id.btnClear);
		
		//Associate result TextField
		result = (TextView) findViewById(R.id.textResult);
		
		//Add function with inner class OnCLickListener
		btnPlus.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float oper1 = Float.parseFloat(operand1.getText().toString());
				float oper2 = Float.parseFloat(operand2.getText().toString());
				
				float theResult = oper1 + oper2;
				//Put result on the result TextView
				result.setText(Float.toString(theResult));
			}
		});
		
		//Subtract function with inner class OnCLickListener
		btnSubtract.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float oper1 = Float.parseFloat(operand1.getText().toString());
				float oper2 = Float.parseFloat(operand2.getText().toString());
				
				float theResult = oper1 - oper2;
				//Put result on the result TextView
				result.setText(Float.toString(theResult));
			}
		});
		
		//Divide function with inner class OnClickListener
		btnDivide.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float oper1 = Float.parseFloat(operand1.getText().toString());
				float oper2 = Float.parseFloat(operand2.getText().toString());
				
				float theResult = oper1 / oper2;
				//Put result on the result TextView
				result.setText(Float.toString(theResult));
			}
		});
		
		//Multiple function with inner class OnClickListener
		btnMultiply.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float oper1 = Float.parseFloat(operand1.getText().toString());
				float oper2 = Float.parseFloat(operand2.getText().toString());
				
				float theResult = oper1 * oper2;
				//Put result on the result TextView
				result.setText(Float.toString(theResult));
			}
		});
		
		//Clear function with inner class OnCLickListener
		btnClear.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				operand1.setText("");
				operand2.setText("");
				result.setText("0.00");
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
