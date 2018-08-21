package com.watson.motocyclerentals;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class main_page extends ActionBarActivity implements AdapterView.OnItemClickListener{


    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] NavigationPanel;
    private ActionBarDrawerToggle drawerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        NavigationPanel=getResources().getStringArray(R.array.NavigationPanel);
        listView=(ListView) findViewById(R.id.drawerList);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,NavigationPanel));
        listView.setOnItemClickListener(this);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
        //////////////////////////////////////////////////
        //////////NULL DRAWERLISTENER//////////////////////
        //////////////////////////// //////////////////////
        drawerListener=new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close)
        {
            @Override
            public void onDrawerClosed(View drawerView){
                Toast.makeText(main_page.this, " Drawer Closed ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerOpened(View drawerView){
                Toast.makeText(main_page.this, "Drawer Opened ", Toast.LENGTH_SHORT).show();
            }
        };


        drawerLayout.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerListener.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerListener.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch( position )
        {
            case 0:  Intent add_prod = new Intent(this, home_page.class);
                startActivity(add_prod);
                break;
            case 1:  Intent view_prod = new Intent(this, about_us.class);
                startActivity(view_prod);
                break;
            case 2:  Intent add_emp = new Intent(this, customer_details.class);
                startActivity(add_emp);
                break;
            case 3:  Intent view_emp = new Intent(this, contact_us.class);
                startActivity(view_emp);
                break;
        }
    }

    public void selectItem(int position)
    {
        listView.setItemChecked(position, true);
        setTitle(NavigationPanel[position]);
    }

    public void setTitle(String title)
    {
        getSupportActionBar().setTitle(title);
    }









//
  //  @Override
  //  protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_page);
    //}

    public void cu(View view) {

        Intent intent = new Intent(main_page.this, customer_details.class);
        main_page.this.startActivity(intent);//


}
}//





