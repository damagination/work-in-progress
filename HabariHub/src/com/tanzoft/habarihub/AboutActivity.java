package com.tanzoft.habarihub;

import org.apache.http.protocol.HTTP;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class AboutActivity extends SherlockActivity {

    Button developers;
    Button github;
    Button paypal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        developers = (Button) findViewById(R.id.button_developers);
        github = (Button) findViewById(R.id.button_github);
        paypal = (Button) findViewById(R.id.button_paypal);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        // open a web browser to developer's google+ page when button is pressed
        developers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent dev = new Intent(AboutActivity.this,
                        com.tanzoft.habarihub.Developers.class);
                startActivity(dev);

            }
        });

        // open web browser to github source page
        github.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // url to github source page
                String url = "https://github.com/tanzoft/work-in-progress/tree/master/HabariHub";
                Intent gh = new Intent(Intent.ACTION_VIEW);
                gh.setData(Uri.parse(url));
                startActivity(gh);
            }
        });

        paypal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getSupportMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

        case android.R.id.home:
            // app icon in action bar clicked; finish activity to go home
            finish();
            return true;

            // rate application
        case R.id.rate:
            String myUrl = "https://play.google.com/store/apps/details?id=com.tanzoft.habarihub";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myUrl)));
            break;

        case R.id.report:
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            /*
             * The intent does not have a URI, so declare the "text/plain" MIME
             * type, emailIntent.setType("text/plain");
             */
            emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {
                    "damas@tanzoft.com", "cmeo226@yahoo.com",
                    "pkinasha@gmail.com", "igotti47@gmail.com" }); // recipients
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Habari Hub Error");
            startActivity(Intent.createChooser(emailIntent,
                    "Choose Email Client"));
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    // kill activity when it goes in the background
    public void onPause() {
        super.onPause();
    }

}
