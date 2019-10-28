package borrowing.thesis.com;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
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

            Toast.makeText(getApplicationContext(),"profile",Toast.LENGTH_LONG).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_page);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Tab_Dashboard(),"");
        adapter.AddFragment(new Tab_Library(),"");
        adapter.AddFragment(new Tab_Laboratory(),"");
        adapter.AddFragment(new Tab_Penalty(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dashboard);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_library);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_lab);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_penalty);

    }


}
