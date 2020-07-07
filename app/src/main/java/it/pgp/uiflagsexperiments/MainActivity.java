package it.pgp.uiflagsexperiments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final List<Integer> x = Arrays.asList(R.id.LAYOUT_STABLE,
            R.id.LAYOUT_HIDE_NAVIGATION,
            R.id.LAYOUT_FULLSCREEN,
            R.id.HIDE_NAVIGATION,
            R.id.FULLSCREEN,
            R.id.IMMERSIVE_STICKY);
    public final List<Integer> x_off = Arrays.asList(R.id.LAYOUT_STABLE_OFF,
            R.id.LAYOUT_HIDE_NAVIGATION_OFF,
            R.id.LAYOUT_FULLSCREEN_OFF,
            R.id.HIDE_NAVIGATION_OFF,
            R.id.FULLSCREEN_OFF,
            R.id.IMMERSIVE_STICKY_OFF);
    public final List<Integer> y = Arrays.asList(View.SYSTEM_UI_FLAG_LAYOUT_STABLE,
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION,
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN,
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION,
            View.SYSTEM_UI_FLAG_FULLSCREEN,
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setUIFlags(View view) {

        final HashMap<Integer,Integer> m = new HashMap<Integer, Integer>(){{
            for(int i=0;i<x.size();i++) {
                put(x.get(i),y.get(i));
            }
        }};

        final HashMap<Integer,Integer> m_off = new HashMap<Integer, Integer>(){{
            for(int i=0;i<x_off.size();i++) {
                put(x_off.get(i),y.get(i));
            }
        }};

        int visibility = getWindow().getDecorView().getSystemUiVisibility();
        int id = view.getId();
        if(m.containsKey(id))
            visibility |= m.get(id);
        else if (m_off.containsKey(id))
            visibility &= ~m_off.get(id);
        else Toast.makeText(this, "No id found in maps", Toast.LENGTH_SHORT).show();
        getWindow().getDecorView().setSystemUiVisibility(visibility);
    }
}