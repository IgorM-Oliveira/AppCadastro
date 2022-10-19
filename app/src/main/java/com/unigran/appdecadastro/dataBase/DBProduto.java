package com.unigran.appdecadastro.dataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unigran.appdecadastro.entities.Produto;

import java.util.List;

public class DBProduto {
    private DBHelper dbHelper;
    private SQLiteDatabase conexao;

    public DBProduto(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public void inserir(Produto produto) {
        conexao = dbHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", produto.getNome());
        valores.put("marca", produto.getMarca());
        valores.put("quantidade", produto.getQuantidade());
        valores.put("preco", produto.getPreco());

        conexao.insertOrThrow("produtos", null, valores);

        conexao.close();
    }

    public void remover(Integer id) {
        conexao = dbHelper.getWritableDatabase();

        conexao.delete("produtos", "id=?", new String[]{id + ""});

        conexao.close();
    }

    public void listar(List<Produto> listaProdutos) {
        listaProdutos.clear();
        conexao = dbHelper.getReadableDatabase();

        String colunas[] = {"id", "nome", "marca", "quantidade", "preco"};
        Cursor query = conexao.query("produtos", colunas, null, null, null, null, "nome");

        while (query.moveToNext()) {
            Produto produto = new Produto();

            produto.setId(query.getInt(0));
            produto.setNome(query.getString(1));
            produto.setMarca(query.getString(2));
            produto.setQuantidade(query.getInt(3));
            produto.setPreco(query.getDouble(4));

            listaProdutos.add(produto);
        }

        conexao.close();
    }

}
