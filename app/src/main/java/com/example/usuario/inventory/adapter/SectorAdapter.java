package com.example.usuario.inventory.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.usuario.inventory.R;
import com.example.usuario.inventory.pojo.Sector;
import com.example.usuario.inventory.repository.SectorRepository;

import java.util.ArrayList;

/**
 * @author Alfonso Chamorro Valle
 */

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder> {

    private ArrayList<Sector> sectors;

    //Array que almacenará los sectores que se han modificado en la inferfaz y no se han guardado aún en la base de datos
    //En nuestro caso en el Repository
    private ArrayList<Sector> sectorsModified;
    private OnSwitchCheckedChangeListener onSwitchCheckedChangeListener;

    /**
     * Constructor que se llamará cuando Sector Activity venga de un cambio de Configuración
     * y se haya salvado el estado dinámico
     * @param sectorsModified
     */
    public SectorAdapter(ArrayList<Sector> sectorsModified) {
        sectors = SectorRepository.getInstance().getSectors();
        this.sectorsModified = getSectorsModified();
    }

    public SectorAdapter() {
        sectors = SectorRepository.getInstance().getSectors();
    }

    @Override
    public SectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //1. Obtener el servicio dle sistema Layout Inflater
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //2. Inflar la vista. Crea en memoria el objeto View con todos los widget del xml: item_dependency.xml
        View view = inflater.inflate(R.layout.item_sector, null);

        //3. Se crea el objeto sectorViewHolder a partir de la vista
        SectorViewHolder sectorViewHolder = new SectorViewHolder(view);
        return sectorViewHolder;
    }

    @Override
    public void onBindViewHolder(SectorViewHolder sectorViewHolder, int position) {
        sectorViewHolder.switchSelector.setChecked(sectors.get(position).is_enabled());
        sectorViewHolder.txvName.setText(sectors.get(position).get_name());
        mostrarIsDefault(sectors.get(position).is_default(), sectorViewHolder.txvDefault);
        //TODO que se guarde el estado al girar la pantalla
    }

    @Override
    public int getItemCount() {
        return sectors.size();
    }

    public static class SectorViewHolder extends RecyclerView.ViewHolder {

        private Switch switchSelector;
        private TextView txvName;
        private TextView txvDefault;

        public SectorViewHolder(View view) {
            super(view);
            txvName = (TextView) view.findViewById(R.id.txvName);
            txvDefault = (TextView) view.findViewById(R.id.txvDefault);
            switchSelector = (Switch) view.findViewById(R.id.switchSelector);
            switchSelector.setOnCheckedChangeListener(new OnSwitchCheckedChangeListener(txvDefault, switchSelector.isChecked()));
        }
    }

    /**
     * Devuelve el array de los sectores que el usuario ha modificado cuando la activity estaba visible (estado dinámico)
     * y que no se ja guardado en la base de dats (persistente)
     * @return Arraylist de sectores modificados
     */
    public ArrayList<Sector> getSectorsModified() {
        return sectorsModified;
    }

    /**
     * Listener para los switch
     */
    static class OnSwitchCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        private TextView txv;
        private boolean checked;

        public OnSwitchCheckedChangeListener(TextView txv, boolean checked) {
            this.txv = txv;
            this.checked = checked;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            checked = !checked;
            mostrarIsDefault(checked, txv);
        }
    }

    /**
     * Este método muestra u oculta el texto que indica si el switch está en la opción por defecto.
     */
    private static void mostrarIsDefault(boolean mostrar, TextView texto) {
        if(mostrar) texto.setText(R.string.txtDefault);
        else texto.setText("");
    }
}