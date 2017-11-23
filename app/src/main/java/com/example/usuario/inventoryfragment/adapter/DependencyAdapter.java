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
 */

public class DependencyAdapter extends ArrayAdapter<Dependency> {

    /**
     * Se crea una copia del ArrayList que se tiene en DependencyRepository para tener
     * una copia local en el adapter que se pueda cambiar sin modificar los datos originales
     * @param context
     */
    public DependencyAdapter(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
        //sort(new Dependency.DependencyOrderByShortName());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DependencyHolder dependencyHolder;
        View view = convertView;

        if(convertView == null) {
            //1. Obtener el servicio dle sistema Layout Inflater
            //LayoutInflater inflater = LayoutInflater.from(getContext());
            //LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //2. Inflar la vista. Crea en memoria el objeto View con todos los widget del xml: item_dependency.xml
            view = inflater.inflate(R.layout.item_dependency, null);
            dependencyHolder = new DependencyHolder();

            //3. Inicializar las variables a los objetos ya creados de los widget del xml
            dependencyHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.materialLetterIcon);
            dependencyHolder.txvName = (TextView) view.findViewById(R.id.txvName);
            dependencyHolder.txvShortName = (TextView) view.findViewById(R.id.txvShortName);
            view.setTag(dependencyHolder);
        }
        else {
            dependencyHolder = (DependencyHolder) view.getTag();
        }

        //4. Mostrar los datos del ArrayList mediante la posición.
        dependencyHolder.icon.setLetter(getItem(position).getShortName().substring(0));
        dependencyHolder.txvName.setText(getItem(position).getName());
        dependencyHolder.txvShortName.setText(getItem(position).getShortName());

        return view;
    }

    class DependencyHolder {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortName;
    }
}