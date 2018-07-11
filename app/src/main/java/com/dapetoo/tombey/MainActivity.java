package com.dapetoo.tombey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.dapetoo.tombey.fragments.BlogFragment;
import com.dapetoo.tombey.fragments.ChatFragment;
import com.dapetoo.tombey.fragments.ContactFragment;
import com.dapetoo.tombey.fragments.CounsellingFragment;
import com.dapetoo.tombey.fragments.DatingFragment;
import com.dapetoo.tombey.fragments.FunFactsFragment;
import com.dapetoo.tombey.fragments.HomeFragment;
import com.dapetoo.tombey.fragments.SRHCentersFragment;
import com.dapetoo.tombey.fragments.SRHPartnersFragment;
import com.dapetoo.tombey.fragments.SuggestCenterFragment;
import com.dapetoo.tombey.fragments.VideosFragment;
import com.dapetoo.tombey.fragments.WriterFragment;
import com.dapetoo.tombey.fragments.YouthConversationFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
//        fab = (FloatingActionButton) findViewById(R.id.fab);
//
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new HomeFragment()).commit();
                break;
            case R.id.contraception:
                startActivity(new Intent(MainActivity.this, ContraceptionActivity.class));
                drawer.closeDrawers();
                return true;
            case R.id.counselling:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new CounsellingFragment()).commit();
                break;
            case R.id.dating:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new DatingFragment()).commit();
                break;
            case R.id.sti:
                startActivity(new Intent(MainActivity.this, STIsActivity.class));
                drawer.closeDrawers();
                return true;

            case R.id.writer:
                //Writer Fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new WriterFragment()).commit();
                break;
            case R.id.suggest_a_center:
                //Suggest a Center Fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new SuggestCenterFragment()).commit();
                break;
            case R.id.start_a_youth_conversation:
                //Youth Conversation Fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new YouthConversationFragment()).commit();
                break;
            case R.id.contact:
                //Contact Fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new ContactFragment()).commit();
                break;
            case R.id.faqs:
                //FAQs
                startActivity(new Intent(MainActivity.this, FAQsActivity.class));
                drawer.closeDrawers();
                return true;
            case R.id.resource_Pool:
                //Resource Pool
                startActivity(new Intent(MainActivity.this, ResourcePoolActivity.class));
                drawer.closeDrawers();
                return true;
            case R.id.srh_centers:
                //SRH Centers
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new SRHCentersFragment()).commit();
                break;
            case R.id.srh_terms:
                //SRH Terms
                startActivity(new Intent(MainActivity.this, SRHTermsActivity.class));
                drawer.closeDrawers();
                return true;
            case R.id.videos:
                //Videos
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new VideosFragment()).commit();
                break;
            case R.id.didYouKnow:
                //Fun Facts
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new FunFactsFragment()).commit();
                break;
            case R.id.blog:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new BlogFragment()).commit();
            case R.id.partner:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new SRHPartnersFragment()).commit();
                break;
            case R.id.chat:
                //SRH Partners
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new ChatFragment()).commit();
            break;
            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
                        new HomeFragment()).commit();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}