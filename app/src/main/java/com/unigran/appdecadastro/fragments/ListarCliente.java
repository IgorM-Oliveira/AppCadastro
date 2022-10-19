package com.unigran.appdecadastro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unigran.appdecadastro.R;
import com.unigran.appdecadastro.dataBase.DBCliente;
import com.unigran.appdecadastro.dataBase.DBHelper;
import com.unigran.appdecadastro.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ListarCliente extends Fragment {

    static DBCliente dbCliente;
    ListView listaDados;
    static List<Cliente> listaClientes;
    static ArrayAdapter adapter;

    public ListarCliente() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected static void atualizarLista() {
        dbCliente.listar(listaClientes);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listar_cliente, container, false);

        listaDados = view.findViewById(R.id.listViewCliente);

        DBHelper dbHelper = new DBHelper(getActivity());
        dbCliente = new DBCliente(dbHelper);
        listaClientes = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaClientes);
        listaDados.setAdapter(adapter);

        atualizarLista();

        return (view);
    }

}