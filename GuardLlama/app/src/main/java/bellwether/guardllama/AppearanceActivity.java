package bellwether.guardllama;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by Kiem on 2/11/15.
 */
public class AppearanceActivity extends Activity {
    protected Spinner mEthnicity;
    protected EditText mHeight;
    protected EditText mWeight;
    protected EditText mHairColor;
    protected EditText mEyeColor;
    protected EditText mBirthday;
    protected EditText mGender;
    protected Button mnNextPageButtonOnAppearance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance);

        //Parse.enableLocalDatastore(this);
        //Parse.initialize(this, "XYWSpvZmgMcOmdnyeOMEx38pObYyybm5z8OL3ADQ", "NSpL3brco9nioVYdY7VCrgaQZiglmZd5d8Y3bsbq");

        //Initialize
        Spinner ethnicitySpinner = (Spinner) findViewById(R.id.ethnicitySpinner);

        //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ethnicity, android.R.layout.simple_spinner_item);

        //Specific the layout to use when the list of choices show up
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Apply the adapter to the spinner
        ethnicitySpinner.setAdapter(adapter);

        NumberPicker[] heightPicker = new NumberPicker[2];
        heightPicker[0] = (NumberPicker)findViewById(R.id.heightNumberPicker);
        heightPicker[1] = (NumberPicker)findViewById(R.id.heightNumberPicker);


    }
}
