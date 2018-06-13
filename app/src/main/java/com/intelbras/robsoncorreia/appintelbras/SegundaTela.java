package com.intelbras.robsoncorreia.appintelbras;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class SegundaTela extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private EditText ramaisAnalogicosEditText;
    private EditText ramaisDigitaisEditText;
    private EditText ramaisIP;
    private EditText semDisplay;
    private EditText comDisplay;
    private EditText comVideochamada;
    private EditText softPhone;

    Troncos troncos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Bundle params = getIntent().getExtras();
        troncos = (Troncos) params.getSerializable("Troncos") ;


        ramaisAnalogicosEditText = findViewById(R.id.idEditTextSegundaTela1);
        ramaisDigitaisEditText = findViewById(R.id.idEditTextSegundaTela2);
        ramaisIP = findViewById(R.id.idEditTextSegundaTela3);
        semDisplay = findViewById(R.id.idEditTextSegundaTela4);
        comDisplay = findViewById(R.id.idEditTextSegundaTela5);
        comVideochamada = findViewById(R.id.idEditTextSegundaTela6);
        softPhone = findViewById(R.id.idEditTextSegundaTela7);


    }

    public void continuar(View v){
        String analogicosText = ramaisAnalogicosEditText.getText().toString();
        String digitaisText = ramaisDigitaisEditText.getText().toString();
        String ipsText = ramaisIP.getText().toString();
        String semDisplayText = semDisplay.getText().toString();
        String comDisplayText = comDisplay.getText().toString();
        String comVideoChamadaText = comVideochamada.getText().toString();
        String softPhoneText = softPhone.getText().toString();

        int analogicos = Integer.parseInt(analogicosText);
        int digitais = Integer.parseInt(analogicosText);
        int ips = Integer.parseInt(ipsText);
        int semDisplay = Integer.parseInt(semDisplayText);
        int comDisplay = Integer.parseInt(comDisplayText);
        int comVideoChamada = Integer.parseInt(comVideoChamadaText);
        int softPhone = Integer.parseInt(softPhoneText);

        Ramais r = new Ramais();

        r.ramaisAnalogicos = analogicos;
        r.ramaisDigitais = digitais;
        r.ramaisIP = ips;
        r.comDisplay = comDisplay;
        r.semDisplay = semDisplay;
        r.comVideoChamada = comVideoChamada;
        r.softphone = softPhone;

        Intent it = new Intent(this, TerceiraTela.class);
        it.putExtra("Ramais", r);
        startActivity(it);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.segunda_tela, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
