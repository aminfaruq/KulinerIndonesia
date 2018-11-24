package id.co.aminfaruq.kulinerindonesia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends AppCompatActivity {

    @BindView(R.id.imgInfo)
    ImageView imgInfo;
    @BindView(R.id.txtNamaMakanan)
    TextView txtNamaMakanan;
    @BindView(R.id.txtInfoMakanan)
    TextView txtInfoMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        Glide.with(this).load(getIntent().getIntExtra("gambar",0)).into(imgInfo);
        txtNamaMakanan.setText(getIntent().getStringExtra("nama"));
        txtInfoMakanan.setText(getIntent().getStringExtra("info"));
    }
}
