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
import com.unigran.appdecadastro.dataBase.DBFornecedor;
import com.unigran.appdecadastro.dataBase.DBHelper;
import com.unigran.appdecadastro.entities.Fornecedor;

public class CadastroFornecedor extends Fragment {

    public CadastroFornecedor() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_fornecedor, container, false);

        DBHelper dbHelper = new DBHelper(getActivity());
        DBFornecedor dbFornecedor = new DBFornecedor(dbHelper);
        EditText editTextNomeFornecedor = view.findViewById(R.id.editTextNomeFornecedor);
        EditText editTextEmailFornecedor = view.findViewById(R.id.editTextEmailFornecedor);
        EditText editTextTelefoneFornecedor = view.findViewById(R.id.editTextTelefoneFornecedor);
        Button buttonSalvarFornecedor = view.findViewById(R.id.buttonSalvarFornecedor);

        buttonSalvarFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setNomeFantasia(editTextNomeFornecedor.getText().toString());
                fornecedor.setEmail(editTextEmailFornecedor.getText().toString());
                fornecedor.setTelefone(editTextTelefoneFornecedor.getText().toString());

                dbFornecedor.inserir(fornecedor);

                Toast.makeText(getActivity(), "Salvo com sucesso!", Toast.LENGTH_LONG).show();
                ListarFornecedor.atualizarLista();
            }
        });

        return (view);
    }
}