package com.easydrivesdp2.easy;
        import android.content.Intent;
        import android.content.res.Configuration;
        import android.content.res.TypedArray;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.Spinner;
        import android.widget.TextView;

        import java.util.Locale;

        import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class LanguageActivity extends ActionBarActivity {

    private String[] listOfObjects;

    private TypedArray images;

    private ImageView itemImage;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        boolean change=false;

        String languageToLoad;

        switch (item.getItemId()) {
            case R.id.en:
                languageToLoad = "en";
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_main);
                change=true;
                break;
            case R.id.ne:
                languageToLoad = "ne";
                locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_main);
                change=true;
                break;
            case R.id.ru:
                languageToLoad = "ru";
                locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_main);
                change=true;
                break;
            case R.id.sk:
                languageToLoad = "sk";
                locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_main);
                change=true;
                break;
            case R.id.vi:
                languageToLoad = "vi";
                locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                this.setContentView(R.layout.activity_main);
                change=true;
                break;
            default:
                break;
        }
        if (change == true){
            recreate();
        }
        return super.onOptionsItemSelected(item);
    }
    public void openlogin(View view) {
        Intent intent = new Intent(LanguageActivity.this, LoginActivity.class);
        startActivity(intent);

    }
}

