package danilo.moreno.verduritassa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CultivoAdapter extends RecyclerView.Adapter<CultivoAdapter.CultivoViewHolder> {

    private List<Cultivo> cultivoList;

    public CultivoAdapter(List<Cultivo> cultivoList) {
        this.cultivoList = cultivoList;
    }

    @NonNull
    @Override
    public CultivoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cultivo, parent, false);
        return new CultivoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CultivoViewHolder holder, int position) {
        Cultivo cultivo = cultivoList.get(position);
        holder.alias.setText(cultivo.getAlias());
        holder.fechaSiembra.setText(cultivo.getFechaSiembra());
        holder.planta.setText(cultivo.getPlanta());
    }

    @Override
    public int getItemCount() {
        return cultivoList.size();
    }

    static class CultivoViewHolder extends RecyclerView.ViewHolder {
        TextView alias, fechaSiembra, planta;

        public CultivoViewHolder(@NonNull View itemView) {
            super(itemView);
            alias = itemView.findViewById(R.id.Alias);
            fechaSiembra = itemView.findViewById(R.id.FechaSiembra);
            planta = itemView.findViewById(R.id.Planta);
        }
    }
}
