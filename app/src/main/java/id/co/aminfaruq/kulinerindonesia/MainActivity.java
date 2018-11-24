package id.co.aminfaruq.kulinerindonesia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.myRecycleView)
    RecyclerView myRecycleView;


    String[] daftar,info;
    int[] gambar = {R.drawable.saturendang,R.drawable.duanasigoreng,R.drawable.tigabakso,R.drawable.empatsate,R.drawable.limatempe,R.drawable.enammie,R.drawable.tujuhsoto,R.drawable.delapangado,R.drawable.sembilangudeg,R.drawable.sepuluhsopbuntut};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        daftar = getResources().getStringArray(R.array.nama);
        info = getResources().getStringArray(R.array.info);

        AdapterMakanan adapterMakanan = new AdapterMakanan(this,daftar,gambar,info);

        GridLayoutManager manager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        myRecycleView.setLayoutManager(manager);
        myRecycleView.setAdapter(adapterMakanan);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);//klik cntrol + o lalu pilih onCreateOptionsMenu

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_profile:
                Intent intent = new Intent(this, Profile.class);
                startActivity(intent);
                finish();
                break;

            case R.id.action_about:
                intent = new Intent(this, About.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
