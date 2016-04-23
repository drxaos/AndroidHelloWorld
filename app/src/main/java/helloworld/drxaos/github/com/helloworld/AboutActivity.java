package helloworld.drxaos.github.com.helloworld;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutActivity extends NavActivity {

    @Override
    protected void setContentView() {
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.about_icon_twitter)
                .addGroup("Connect with us")
                .addEmail("elmehdi.sakout@gmail.com")
                .addFacebook("the.medy")
                .addTwitter("medyo80")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.ideashower.readitlater.pro")
                .create();

        setContentView(R.layout.activity_about);

        ViewGroup layout = (ViewGroup) findViewById(R.id.content_about);
        layout.addView(aboutPage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
