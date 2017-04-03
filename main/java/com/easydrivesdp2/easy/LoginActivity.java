package com.easydrivesdp2.easy;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import android.content.Intent;
        import android.view.View;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.EditText;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;
    private  EditText email;
    private EditText pass;

    private Button bLogin;
    private Button bregister;

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        // Set up the login form.
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);
/*

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#e12929'>Sign In</font>"));*/

        Button button= (Button) findViewById(R.id.btn_login);
        Button button1= (Button) findViewById(R.id.btn_signup);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               /* if(CheckFieldValidation()) {
                    Intent i= new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                }*/
               Signin(v);
               }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               /* if(CheckFieldValidation()) {
                    Intent i= new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                }*/
                SignUp(v);
            }
        });
    }

    // When Button Login clicked
    public void Signin(View v){
        if(CheckFieldValidation()) {
        Intent i= new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);

    }
        //Calling method of field validation
       }
    //checking field are empty
    private boolean CheckFieldValidation(){

        boolean valid=true;
        if(email.getText().toString().equals("")){
            email.setError("Can't be Empty");
            valid=false;
        }else if(pass.getText().toString().equals("")){
            pass.setError("Can't be Empty");
            valid=false;
        }

        return valid;

    }
    //When Button Sign up clicked
    public void SignUp(View v){

        Intent i= new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i);


    }
}
