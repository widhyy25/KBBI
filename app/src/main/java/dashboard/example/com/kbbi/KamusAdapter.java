package dashboard.example.com.kbbi;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintSet;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class KamusAdapter extends RecyclerView.Adapter<KamusAdapter.KamusHolder> {
    List<String> artinya;
    Activity activity;

    public KamusAdapter(List<String> artinya, Activity activity) {
        this.artinya = artinya;
        this.activity = activity;
    }

    @NonNull
    @Override
    public KamusHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
       View view=LayoutInflater.from(activity).inflate(R.layout.rv_arti, parent,false);
       return new KamusHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KamusHolder holder, int position) {
        holder.txt_arti.setText(artinya.get(position));

    }

    @Override
    public int getItemCount() {
        return artinya.size();


    }

    static class KamusHolder extends RecyclerView.ViewHolder {
        TextView txt_arti;
        public KamusHolder(View itemView){
            super(itemView);
            txt_arti=(TextView)itemView.findViewById(R.id.txt_arti);


        }
    }


}
