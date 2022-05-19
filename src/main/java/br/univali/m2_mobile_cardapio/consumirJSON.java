package br.univali.m2_mobile_cardapio;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class consumirJSON {

    public static List<comida> JsonDados(String conteudo) {
        try{
            List<comida> comidaList = new ArrayList<>();
            JSONArray jsonArray = null;
            JSONObject jsonObject = null;

            jsonArray = new JSONArray(conteudo);

            for ( int i = 0;i < jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);

                comida food = new comida();

                food.setNomeAlimento(jsonObject.getString("nome"));
                food.setUrlFoto(jsonObject.getString("url"));
                food.setPreco(jsonObject.getString("preco"));

                comidaList.add(food);


            }
            return comidaList;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }






}
