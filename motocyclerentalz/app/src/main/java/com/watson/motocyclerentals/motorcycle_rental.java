package com.watson.motocyclerentals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Long on 2018/08/01.
 */
public class motorcycle_rental extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorcycle_rental);
    }

    public void registerLogin(View view)
    {
        EditText firstName = (EditText)findViewById(R.id.txtFirstName);
        String name = firstName.getText().toString();

        EditText lastName = (EditText)findViewById(R.id.txtSerialNumber);
        String surname = lastName.getText().toString();

        EditText phoneNumber = (EditText)findViewById(R.id.txtPhoneNumber);
       String phone = phoneNumber.getText().toString();

       EditText address = (EditText)findViewById(R.id.txtAddress);
        String addr = address.getText().toString();

       EditText place = (EditText)findViewById(R.id.txtCity);
        String city = place.getText().toString();

        EditText code = (EditText)findViewById(R.id.txtPostalCode);
        String postalCode = code.getText().toString();

       // EditText user = (EditText)findViewById(R.id.txtUsername);
      //  String username = user.getText().toString();

      //  EditText pass = (EditText)findViewById(R.id.txtPassword2);
       // String password2 = pass.getText().toString();

      // EditText passConfirm = (EditText)findViewById(R.id.txtConfirm);
      //  String passwordConfirmation = passConfirm.getText().toString();

        if(name.equals(""))
        {
            firstName.setError("Please enter you first name");
        }else if(surname.equals(""))
           {
                lastName.setError("Please enter your last name");
            }else if(phone.equals(""))
                {
                   phoneNumber.setError("Please enter your contact number");
               }else if(addr.equals(""))
                    {
                        address.setError("Please enter your address");
                    }else if(city.equals(""))
                        {
                            place.setError("Please enter the city you from");
                       }else if(postalCode.equals(""))
                            {
                               code.setError("Please enter your postal code");
                            }
        else {
                Intent intent = new Intent(motorcycle_rental.this, customer_details.class);
                motorcycle_rental.this.startActivity(intent);
        }
    }
}
