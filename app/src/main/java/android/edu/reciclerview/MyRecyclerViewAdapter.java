package android.edu.reciclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

    public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
        private List<String> mData;
        private Context contexto;
        private LayoutInflater mInflater;

        // data is passed into the constructor
        public MyRecyclerViewAdapter(Context context, List<String> data) {
            //Es el constructor
            this.mInflater = LayoutInflater.from(context);
            this.contexto=context;
            this.mData = data;
        }
        // inflates the row layout from xml when needed
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {   //Metodo que va creando los distintos HOLDER segun se necesitan
            //LLama al constructor de viewHolder definido mas abajo y lo devuelve
            View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int i) {
            //Una vez inflado, con este metodo lo rellenamos
            //Con esto rellenamos el holder con la fila correspondiente
            //holder es la vista definida por el XML en este caso de recyclerview_row
            String name =mData.get(i);
            holder.animalTxt.setText(name);
        }

        @Override
        public int getItemCount() {
            //Obligatorio, devuelve el numero de item que va a tener
            return mData.size();
        }
        // Por si necesitamos recuperar algun valor de alguna fila seleccionada
        public String getItem(int id) {
            return mData.get(id);
        }
     ///////Creamos la clase ViewHolder, quiero capturar el evento click por eso lo implemento
         public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

             TextView animalTxt;
            public ViewHolder(View v) {
                //Es necesario buscar todos los views del XML y crear variables en la clase para
                //poder acceder a ellas en el metodo onBindViewHolder
                //ya que si no, no podemos acceder a ellas
                super(v);
                //Le asigno el escuchador
                v.setOnClickListener(this);
                animalTxt = v.findViewById(R.id.animal);
            }

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "VIEWHOLDER --> position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
               // Toast.makeText(v.getContext(), "animal = " + animalTxt.getText(), Toast.LENGTH_SHORT).show();
                MainActivity.ItemClickListener (v, animalTxt.getText().toString());
          }
      }
   }


