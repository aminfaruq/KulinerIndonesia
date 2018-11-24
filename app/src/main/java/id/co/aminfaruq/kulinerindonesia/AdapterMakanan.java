package id.co.aminfaruq.kulinerindonesia;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.ViewHolder> {
    Context context;
    String[] nama,info;
    int[] gambar;

    public AdapterMakanan(Context context, String[] nama, int[] gambar, String[] info) {
        this.context = context;
        this.nama = nama;
        this.gambar = gambar;
        this.info = info;
    }

    @NonNull
    @Override
    public AdapterMakanan.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_makanan,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMakanan.ViewHolder viewHolder, final int i) {
        Glide.with(context).load(gambar[i]).into(viewHolder.imgGambar);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,InfoActivity.class);
                intent.putExtra("gambar",gambar[i]);
                intent.putExtra("nama",nama[i]);
                intent.putExtra("info",info[i]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGambar = itemView.findViewById(R.id.imgGambarMakanan);
        }
    }
}
