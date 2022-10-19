package com.unigran.appdecadastro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unigran.appdecadastro.R;
import com.unigran.appdecadastro.dataBase.DBFornecedor;
import com.unigran.appdecadastro.dataBase.DBHelper;
import com.unigran.appdecadastro.entities.Fornecedor;

import java.util.ArrayList;
import java.util.List;

public class ListarFornecedor extends Fragment {

    static DBFornecedor dbFornecedor;
    ListView listaDados;
    static List<Fornecedor> listaForneceres;
    static ArrayAdapter adapter;

    public ListarFornecedor() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected static void atualizarLista() {
        dbFornecedor.listar(listaForneceres);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listar_fornecedor, container, false);

        listaDados = view.findViewById(R.id.listViewFornecedor);

        DBHelper dbHelper = new DBHelper(getActivity());
        dbFornecedor = new DBFornecedor(dbHelper);
        listaForneceres = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaForneceres);
        listaDados.setAdapter(adapter);

        atualizarLista();

        return (view);
    }

}