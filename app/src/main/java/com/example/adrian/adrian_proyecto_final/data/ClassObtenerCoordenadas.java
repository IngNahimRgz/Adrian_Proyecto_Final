package com.example.adrian.adrian_proyecto_final.data;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ClassObtenerCoordenadas {

    LatLng latLng;
    String[] sCoordenadas;
    Double latitud, longitud;

    public LatLng getLatLng() {
        DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mRootChild = mDatabaseReference.child("coordenadas_del_usuario");

        mRootChild.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
             sCoordenadas   = dataSnapshot.getValue().toString().split(",");
             latitud = Double.parseDouble(sCoordenadas[0]);
             longitud = Double.parseDouble(sCoordenadas[1]);

                latLng = new LatLng(latitud,longitud);





            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        latLng = new LatLng(latitud,longitud);

        return latLng;
    }



}
