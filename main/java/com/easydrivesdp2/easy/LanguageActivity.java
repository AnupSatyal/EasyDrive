package com.easydrivesdp2.easy;
        import android.content.Intent;
        import android.content.res.Configuration;
        import android.content.res.TypedArray;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.util.Log;
        import android.view.Menu;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.Spinner;
        import android.widget.TextView;

        import java.util.Locale;

public class LanguageActivity extends ActionBarActivity {

    private String[] listOfObjects;

    private TypedArray images;

    private ImageView itemImage;

    private void setLocale(String localeCode){
        Locale locale = new Locale(localeCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.language);

        listOfObjects = getResources().getStringArray(R.array.object_array);

        images = getResources().obtainTypedArray(R.array.object_image);

        TextView spinnerHeader = (TextView)findViewById(R.id.textView);

        itemImage = (ImageView)findViewById(R.id.imageView);

        final Spinner spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, listOfObjects);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemImage.setImageResource(images.getResourceId(spinner.getSelectedItemPosition(), -1));
                Log.v("Value", "Language Value: " + position);
                if (position == 0) {
                    setLocale("en");
                } else if (position == 1) {
                    setLocale("ru");
                } else if (position == 2) {
                    setLocale("sk");

                } else {
                    setLocale("ne");
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }


    public void openlogin(View view) {
        Intent intent = new Intent(LanguageActivity.this, LoginActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}

