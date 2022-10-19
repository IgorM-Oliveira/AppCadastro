package com.unigran.appdecadastro.dataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unigran.appdecadastro.entities.Fornecedor;

import java.util.List;

public class DBFornecedor {
    private DBHelper dbHelper;
    private SQLiteDatabase conexao;

    public DBFornecedor(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public void inserir(Fornecedor fornecedor) {
        conexao = dbHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nomeFantasia", fornecedor.getNomeFantasia());
        valores.put("email", fornecedor.getEmail());
        valores.put("telefone", fornecedor.getTelefone());

        conexao.insertOrThrow("fornecedores", null, valores);
    }

    public void remover(Integer id) {
        conexao = dbHelper.getWritableDatabase();

        conexao.delete("fornecedores", "id=?", new String[]{id + ""});

        conexao.close();
    }

    public void listar(List<Fornecedor> listaFornecedores) {
        listaFornecedores.clear();
        conexao = dbHelper.getReadableDatabase();

        String colunas[] = {"id", "nomeFantasia", "email", "telefone"};
        Cursor query = conexao.query("fornecedores", colunas, null, null, null, null, "nomeFantasia");

        while (query.moveToNext()) {
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setId(query.getInt(0));
            fornecedor.setNomeFantasia(query.getString(1));
            fornecedor.setEmail(query.getString(2));
            fornecedor.setTelefone(query.getString(3));

            listaFornecedores.add(fornecedor);
        }

        conexao.close();
    }
}
