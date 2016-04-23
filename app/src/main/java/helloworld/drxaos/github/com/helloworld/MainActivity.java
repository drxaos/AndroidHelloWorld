package helloworld.drxaos.github.com.helloworld;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends NavActivity {

    ArrayList<Map<String, String>> data = new ArrayList<>();
    SimpleAdapter adapter;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                final EditText taskEditText = new EditText(MainActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Add a new item")
                        .setMessage("Enter new item title:")
                        .setView(taskEditText)
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String title = String.valueOf(taskEditText.getText());

                                data.add(Collections.singletonMap("title", title));
                                adapter.notifyDataSetChanged();

                                Snackbar.make(view, "New item added", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                dialog.show();
            }
        });

        ListView list = (ListView) findViewById(R.id.listMain);
        data.add(Collections.singletonMap("title", "Blue"));
        data.add(Collections.singletonMap("title", "Green"));
        data.add(Collections.singletonMap("title", "Red"));
        data.add(Collections.singletonMap("title", "Yellow"));
        data.add(Collections.singletonMap("title", "White"));
        data.add(Collections.singletonMap("title", "Brown"));
        adapter = new SimpleAdapter(
                this, data,
                R.layout.list_item,
                new String[]{"title"},
                new int[]{R.id.textView3}
        );
        list.setAdapter(adapter);
    }

    public void deleteItem(View view) {
        View parent = (View) view.getParent();
        TextView textView = (TextView) parent.findViewById(R.id.textView3);
        String title = String.valueOf(textView.getText());
        for (Iterator it = data.iterator(); it.hasNext(); ) {
            Map<String, String> item = (Map<String, String>) it.next();
            if (item.get("title").equals(title)) {
                it.remove();
            }
        }

        adapter.notifyDataSetChanged();
    }

}
