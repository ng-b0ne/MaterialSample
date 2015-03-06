package me.b0ne.app.materialsample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import me.b0ne.app.materialsample.R;
import me.b0ne.app.materialsample.adapters.MainListAdapter;


public class MainActivity extends ActionBarActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();

        mListView = (ListView)findViewById(R.id.list_view);
        String[] items = getResources().getStringArray(R.array.main_item_list);
        MainListAdapter adapter = new MainListAdapter(this, items);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(onListClick);
    }

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent();
            switch (position) {
                case 0:
                    intent = new Intent(getApplicationContext(), DrawerActivity.class);
                    intent.putExtra("type", 1);
                    break;
                case 1:
                    intent = new Intent(getApplicationContext(), DrawerActivity.class);
                    intent.putExtra("type", 2);
                    break;
                case 2:
                    intent = new Intent(getApplicationContext(), TabNaviActivity.class);
                    break;
                case 3:
                    intent = new Intent(getApplicationContext(), FABActivity.class);
                    break;
                case 4:
                    intent = new Intent(getApplicationContext(), ParallaxToolbarScrollviewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
