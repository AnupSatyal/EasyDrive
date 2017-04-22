package com.easydrivesdp2.easy;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;

        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;


public class RegisterActivity extends Activity {


    DatabaseHelper helper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


    }
    public void onButtonClick(View v){
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }


    public void onRegisterClick(View v) {

        {
            if (v.getId() == R.id.Bregister) {
                EditText name = (EditText) findViewById(R.id.TFname);
                EditText licence = (EditText) findViewById(R.id.TFlicence);
                EditText email = (EditText) findViewById(R.id.TFemail);
                EditText pass1 = (EditText) findViewById(R.id.TFpass1);
                EditText pass2 = (EditText) findViewById(R.id.TFpass2);


                String namestr = name.getText().toString();
                String licencestr = licence.getText().toString();
                String emailstr = email.getText().toString();
                String pass1str = pass1.getText().toString();
                String pass2str = pass2.getText().toString();


                if (!pass1str.equals(pass2str)) {
                    //popup msg

                    Toast pass = Toast.makeText(RegisterActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT);
                    pass.show();
                } else

                {


                    //insert the details in database
                    Contact c = new Contact();
                    c.setName(namestr);
                    c.setLicence(licencestr);
                    c.setEmail(emailstr);
                    c.setPass(pass1str);

                    helper.insertContact(c);


                }
            }


        }

    }
}