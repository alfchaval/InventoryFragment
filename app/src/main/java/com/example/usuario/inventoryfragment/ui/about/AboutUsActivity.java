package com.example.usuario.inventoryfragment.ui.about;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.usuario.inventoryfragment.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

/**
 * @author Alfonso Chamorro Valle
 */

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.profile_picture)
                .setCover(R.mipmap.profile_cover)
                .setName("Alfonso Chamorro Valle")
                .setSubTitle("Someone")
                .setBrief("I write descriptions, sometimes")
                .setAppIcon(R.mipmap.ic_icon)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("")
                .addGitHubLink("alfchaval")
                .addFacebookLink("alfchaval")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        addContentView(view, view.getLayoutParams());
    }
}