package com.roshank.grihaestate.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.roshank.grihaestate.MapsActivity;
import com.roshank.grihaestate.PropertyList_Activity;
import com.roshank.grihaestate.R;
import com.roshank.grihaestate.RegisterActivity;


public class FragmentForSale extends Fragment implements View.OnClickListener {

    TextView findproperties, resetfilter, price, propertytype, bedroom;
    ImageView mylocation, map;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepage_layout, null);

        findproperties = (TextView) view.findViewById(R.id.findproperties);
        resetfilter = (TextView) view.findViewById(R.id.resetfilter);
        price = (TextView) view.findViewById(R.id.price);
        propertytype = (TextView) view.findViewById(R.id.propertytype);
        bedroom = (TextView) view.findViewById(R.id.bedroom);
        mylocation = (ImageView) view.findViewById(R.id.mylocation);
        map = (ImageView) view.findViewById(R.id.map);

        findproperties.setOnClickListener(this);
        resetfilter.setOnClickListener(this);
        price.setOnClickListener(this);
        propertytype.setOnClickListener(this);
        bedroom.setOnClickListener(this);
        mylocation.setOnClickListener(this);
        map.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.findproperties) {
            startActivity(new Intent(getActivity(), PropertyList_Activity.class));
        } else if (v.getId() == R.id.resetfilter) {
            bedroom.setText("Bedroom");
            propertytype.setText("Property Type");
            price.setText("Price");
        } else if (v.getId() == R.id.price) {
            ShowPriceDialog();
        } else if (v.getId() == R.id.propertytype) {
            ShowPropertytypeDialog();
        } else if (v.getId() == R.id.bedroom) {
            ShowbedroomDialog();
        } else if (v.getId() == R.id.mylocation) {
            startActivity(new Intent(getActivity(), MapsActivity.class));
        } else if (v.getId() == R.id.map) {
            startActivity(new Intent(getActivity(), MapsActivity.class));
        }
    }

    public void ShowPriceDialog() {
        final Dialog pricedialog = new Dialog(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.showpricedialog, null);

        final Spinner minimumprice = view.findViewById(R.id.minimumprice);
        final Spinner maximumprice = view.findViewById(R.id.maximumprice);

        view.findViewById(R.id.apply).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                price.setText(minimumprice.getSelectedItem().toString() + " to " + maximumprice.getSelectedItem().toString());
                pricedialog.dismiss();
            }

        });

        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pricedialog.dismiss();
            }
        });
        pricedialog.setContentView(view);
        pricedialog.setTitle("Choose value");
        pricedialog.show();
    }

    public void ShowbedroomDialog() {
        final Dialog bedroomdialog = new Dialog(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.showbedroomdialog, null);

        final Spinner minimumbed = view.findViewById(R.id.minimumbed);
        final Spinner maximumbed = view.findViewById(R.id.maximumbed);

        view.findViewById(R.id.apply).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bedroom.setText(minimumbed.getSelectedItem().toString() + " to " + maximumbed.getSelectedItem().toString());
                bedroomdialog.dismiss();
            }

        });

        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bedroomdialog.dismiss();
            }
        });
        bedroomdialog.setContentView(view);
        bedroomdialog.setTitle("Choose value");
        bedroomdialog.show();
    }

    public void ShowPropertytypeDialog() {
        final Dialog propertyDialog = new Dialog(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.showpropertytypedialog, null);

        final Spinner propertyclass = view.findViewById(R.id.propertyclass);


        view.findViewById(R.id.apply).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                propertytype.setText(propertyclass.getSelectedItem().toString());
                propertyDialog.dismiss();
            }

        });

        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                propertyDialog.dismiss();
            }
        });
        propertyDialog.setContentView(view);
        propertyDialog.setTitle("Choose value");
        propertyDialog.show();
    }
}
