package mx.itsur.audiolibros_2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SelectorFragment selectorFregment = new SelectorFragment();

        if (findViewById(R.id.contenedor_pequeno)!=null){
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor_pequeno, selectorFregment).commit();
        }

    }

    public void mostrarDetalle(int index){
        FragmentManager fragmentManager= getSupportFragmentManager();
        if (fragmentManager.findFragmentById(R.id.fragment_detalle)!=null){

        }else{
            DetalleFragment detalleFragment = new DetalleFragment();

            Bundle bundle = new Bundle();

            bundle.putInt(DetalleFragment.ARS_ID_LIBRO, index);

            detalleFragment.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.contenedor_pequeno, detalleFragment).addToBackStack(null).commit();
        }
    }
}