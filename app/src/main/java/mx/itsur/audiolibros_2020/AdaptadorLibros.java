package mx.itsur.audiolibros_2020;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class AdaptadorLibros extends RecyclerView.Adapter<AdaptadorLibros.ViewHolder> {

    private Vector<Libro> vectorLibros;
    private Context contexto;
    private LayoutInflater inflador;

    private View.OnLongClickListener onLongClickListener;
    private View.OnClickListener onClickListener;

    public void setOnItemLongClickListener(View.OnLongClickListener onLongClickListener){
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public AdaptadorLibros(Context context, Vector<Libro> vectorLibros){
        inflador = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.vectorLibros = vectorLibros;
        this.contexto = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.elemento_selector, null);

        v.setOnClickListener(this.onClickListener);
        v.setOnLongClickListener(this.onLongClickListener);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Libro libro = vectorLibros.get(position);
        holder.portada.setImageResource(libro.recursoImagen);
        holder.titulo.setText(libro.titulo);
    }

    @Override
    public int getItemCount() {
        return vectorLibros.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView portada;
        public TextView titulo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            portada = (ImageView) itemView.findViewById(R.id.portada);
            portada.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
        }
    }
}
