package com.col.commo.menu_1;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.SubMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.imageView5);
        button = (Button) findViewById(R.id.button2);

        registerForContextMenu(imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, button);
                popupMenu.getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // TODO Auto-generated method stub
                        switch (item.getItemId()) {
                            case R.id.action_settings:
                                Toast.makeText(MainActivity.this, "setting", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_SB:
                                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_NC:
                                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_ZZ:
                                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);

        try {
            Class<?> menuClass =Class.forName("com.android.internal.view.menu.MenuBuilder");
            Method menuMethod = menuClass.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            menuMethod.setAccessible(true);
            menuMethod.invoke(menu, true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        MenuItem show_item = menu.add(0, Menu.FIRST, 0, "1").setIcon(R.drawable.i1);
//		MenuItem share_item = menu.add(0, Menu.FIRST+1, 0, "1");
        SubMenu shareMenu = menu.addSubMenu(0, Menu.FIRST+1, 0, "2").setIcon(R.drawable.i2);
        shareMenu.setHeaderIcon(R.mipmap.ic_launcher);
        shareMenu.setHeaderTitle("ok");
        shareMenu.add(0, 100, 0, "a");
        shareMenu.add(0, 101, 0, "b");
        shareMenu.add(0, 102, 0, "c");

        MenuItem detail_item = menu.add(0, Menu.FIRST+2, 0, "Q");
        MenuItem delete_item = menu.add(0, Menu.FIRST+3, 0, "W");
        MenuItem help_item = menu.add(0, Menu.FIRST+4, 0, "E");
        MenuItem save_item = menu.add(0, Menu.FIRST+5, 0, "R").setIcon(R.drawable.i3);
        MenuItem other_item = menu.add(0, Menu.FIRST+6, 0, "T");

//		return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case Menu.FIRST:
                Toast.makeText(MainActivity.this, "first", Toast.LENGTH_SHORT).show();
                break;

            case 100:
                Toast.makeText(MainActivity.this, "text", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()) {
            case R.id.imageView5:
                menu.add(0, 200, 0, "1");
                menu.add(0, 201, 0, "2");
                menu.add(0, 202, 0, "3");
                menu.add(0, 203, 0, "4");
                menu.setHeaderIcon(R.mipmap.ic_launcher);
                menu.setHeaderTitle("ok......");
                break;

            default:
                break;
        }
    }


}
