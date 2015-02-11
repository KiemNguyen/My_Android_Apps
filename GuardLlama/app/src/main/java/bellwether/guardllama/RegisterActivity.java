package bellwether.guardllama;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends Activity {

    protected EditText mFirstName;
    protected EditText mMiddleName;
    protected EditText mLastName;
    protected EditText mUserEmail;
    protected EditText mPhoneNumber;
    protected EditText mAddressLine1;
    protected EditText mAddressLine2;
    protected EditText mEmergencyName;
    protected EditText mEmergencyPhone;
    protected EditText mEmergencyRelationship;
    protected EditText mEmergencyOtherInfo;
    //protected EditText mUserPassword;
    protected Button mNextPageButton;

    protected EditText mUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "XYWSpvZmgMcOmdnyeOMEx38pObYyybm5z8OL3ADQ", "NSpL3brco9nioVYdY7VCrgaQZiglmZd5d8Y3bsbq");

        //Initialize
        mFirstName = (EditText)findViewById(R.id.firstNameRegisterEditText);
        mMiddleName = (EditText)findViewById(R.id.middleNameRegisterEditText);
        mLastName = (EditText)findViewById(R.id.lastNameRegisterEditText);
        mUserEmail = (EditText)findViewById(R.id.emailRegisterEditText);
        mPhoneNumber = (EditText)findViewById(R.id.phoneRegisterEditText);
        mAddressLine1 = (EditText)findViewById(R.id.addressRegisterText);
        mAddressLine2 = (EditText)findViewById(R.id.address2RegisterText);
        mEmergencyName = (EditText)findViewById(R.id.emergencyNameEditText);
        mEmergencyPhone = (EditText)findViewById(R.id.emergencyPhoneEditText);
        mEmergencyRelationship = (EditText)findViewById(R.id.emergencyRelationshipEditText);
        mEmergencyOtherInfo = (EditText)findViewById(R.id.medicalInfoEditText);

        mUserPassword = (EditText)findViewById(R.id.passwordRegisterEditText);

        mNextPageButton = (Button)findViewById(R.id.nextPageButton);

        //Listen to register button click
        mNextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get first name, middle name, last name, user email, phone number, address line 1, address line 2,
                //emergency name, emergency phone, emergency relationship, emergency other info and convert them to string
                String firstName = mFirstName.getText().toString().trim();
                String middleName = mMiddleName.getText().toString().trim();
                String lastName = mLastName.getText().toString().trim();
                String userEmail = mUserEmail.getText().toString().trim();
                String phoneNumber = mPhoneNumber.getText().toString().trim();
                String addressLine1 = mAddressLine1.getText().toString().trim();
                String addressLine2 = mAddressLine2.getText().toString().trim();
                String emergencyName = mEmergencyName.getText().toString().trim();
                String emergencyPhone = mEmergencyPhone.getText().toString().trim();
                String emergencyRelationship = mEmergencyRelationship.getText().toString().trim();
                String emergencyOtherInfo = mEmergencyOtherInfo.getText().toString().trim();

                String password = mUserPassword.getText().toString().trim();

                //Store user in parse
                ParseUser user = new ParseUser();
                user.put("firstName", firstName);
                user.put("middleName", middleName);
                user.put("lastName", lastName);
                user.put("userEmail", userEmail);
                user.setEmail(userEmail);
                user.put("phoneNumber", phoneNumber);
                user.put("addressLine1", addressLine1);
                user.put("addressLine2", addressLine2);
                user.put("emergencyName", emergencyName);
                user.put("emergencyPhone", emergencyPhone);
                user.put("emergencyRelationship", emergencyRelationship);
                user.put("emergencyOtherInfo", emergencyOtherInfo);
                user.setUsername(userEmail);
                user.setPassword(password);

                //other fields can be set just like with ParseObject
                //user.put("phone", "650-253-0000");

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null){
                            //User signed up successfully
                            Toast.makeText(RegisterActivity.this, "Success!", Toast.LENGTH_LONG).show();

                            //Take user to appearance register page
                            Intent takeUserToAppearancePage = new Intent(RegisterActivity.this, AppearanceActivity.class);
                            startActivity(takeUserToAppearancePage);

                        }else{
                            //There was an error signing up user
                        }
                    }
                });
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
