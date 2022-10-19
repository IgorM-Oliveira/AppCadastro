package com.unigran.appdecadastro.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unigran.appdecadastro.R;
import com.unigran.appdecadastro.dataBase.DBCliente;
import com.unigran.appdecadastro.dataBase.DBHelper;
import com.unigran.appdecadastro.entities.Cliente;

public class CadastroCliente extends Fragment {

    public CadastroCliente() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_cliente, container, false);

        DBHelper dbHelper = new DBHelper(getActivity());
        DBCliente dbCliente = new DBCliente(dbHelper);
        EditText editTextNomeCliente = view.findViewById(R.id.editTextNomeCliente);
        EditText editTextEmailCliente = view.findViewById(R.id.editTextEmailCliente);
        EditText editTextTelefoneCliente = view.findViewById(R.id.editTextTelefoneCliente);
        Button buttonSalvarCliente = view.findViewById(R.id.buttonSalvarCliente);

        buttonSalvarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cliente cliente = new Cliente();

                cliente.setNome(editTextNomeCliente.getText().toString());
                cliente.setEmail(editTextEmailCliente.getText().toString());
                cliente.setTelefone(editTextTelefoneCliente.getText().toString());

                dbCliente.inserir(cliente);

                Toast.makeText(getActivity(), "Salvo com sucesso!", Toast.LENGTH_LONG).show();
                ListarCliente.atualizarLista();
            }
        });

        return (view);
    }
}