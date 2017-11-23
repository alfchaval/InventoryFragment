package com.example.usuario.inventoryfragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.pojo.Dependency;
import com.example.usuario.inventoryfragment.db.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * @author Alfonso Chamorro Valle
 * Segunda opción no optimizada
 */

public class DependencyAdapterB extends ArrayAdapter<Dependency> {
    /**
     public DependencyAdapter(@NonNull Context context, int resource, @NonNull Dependency[] objetcs) {
     super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
     }*/

    public DependencyAdapterB(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortName;
        View view = convertView;

        if(convertView == null) {
            //1. Obtener el servicio dle sistema Layout Inflater
            //LayoutInflater inflater = LayoutInflater.from(getContext());
            //LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //2. Inflar la vista. Crea en memoria el objeto View con todos los widget del xml: item_dependency.xml
            view = inflater.inflate(R.layout.item_dependency, null);
        }

        //3. Inicializar las variables a los objetos ya creados de los widget del xml
        icon = (MaterialLetterIcon) view.findViewById(R.id.materialLetterIcon);
        txvName = (TextView) view.findViewById(R.id.txvName);
        txvShortName = (TextView) view.findViewById(R.id.txvShortName);

        //4. Mostrar los datos del ArrayList mediante la posición.
        icon.setLetter(getItem(position).getShortName().substring(0));
        txvName.setText(getItem(position).getName());
        txvShortName.setText(getItem(position).getShortName());

        return view;
    }
}
