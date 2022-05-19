package br.univali.m2_mobile_cardapio;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    JSONObject mainObject= new JSONObject();
//    JSONArray arrayObjects = new JSONArray();
//
//    JSONObject obj = new JSONObject();
//
//        try {
//
//        obj.put("Nome", "José");
//        obj.put("Tempo", 5.5);
//        arrayObjects.add(obj);
//
//        obj= new JSONObject();
//        obj.put("Nome", "João");
//        obj.put("Tempo", 6.6);
//        arrayObjects.add(obj);
//
//        mainObject.put("pessoas", arrayObjects);
//        mainObject.put("totalPessoas", arrayObjects.size());
//        try {
//// Writing to a file
//            File file=new File("arquivo_write.json");
//            file.createNewFile();
//            FileWriter fileWriter = new FileWriter(file);
//            fileWriter.write( mainObject.toJSONString());
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException e) { e.printStackTrace(); }
//
//    } catch (JSONException e) {
//
//        e.printStackTrace();
//
//    }
//public static final String jsonPlanetas = "{\"planetas\": " +
//        " ["+
//        " {\"nome\":\"Mercurio\","+
//        "  \"posicao\":1,"+
//        "  \"habitavel\":false"+
//        " },"+
//        " {\"nome\":\"Terra\","+
//        "  \"posicao\":3,"+
//        "  \"habitavel\":true"+
//        " },";


    private TextView tv_mostra;
    private Button bt_mostra;

    private List<comida> foodList = new ArrayList<>();

//    private ScrollView sv= (ScrollView) findViewById(R.id.sv);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        sv = (ScrollView) findViewById(R.id.sv) ;
        tv_mostra = (TextView) findViewById(R.id.tv_mostra_test);
        bt_mostra = (Button) findViewById(R.id.bt_mostra_test);
        
        bt_mostra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Tarefa tarefa = new Tarefa();
                tarefa.execute("https://raw.githubusercontent.com/berbraga/comidas-com-url/main/imagens/comidas.json");


            }
        });


//        try {
//            JSONObject planetas = new JsonObject(jsonPlanetas);
//            JSONArray arrayPlanetas = planetas.getJSONArray("planetas");
//            for(int i=0;i< arrayPlanetas.length();i++){
//                JSONObject planeta = arrayPlanetas.getJSONObject(i);
//                Log.d("MainActivity",planeta.getString("nome"));
//                Log.d("MainActivity",Integer.toString(planeta.getInt("posicao")));
//                Log.d("MainActivity",Boolean.toString(planeta.getBoolean("habitavel")));
//            }
//
//        }catch(JSONException e){ e.printStackTrace(); }
//

//        "https://raw.githubusercontent.com/berbraga/comidas-com-url/main/imagens/comidas.json"
    }


    private class Tarefa extends AsyncTask<String, String, String>{

        /**
         * @param strings
         * @deprecated
         */
        @Override
        protected String doInBackground(String... strings) {
            String retorno="";
            try {
                retorno = conexao.getDados(strings[0]);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return retorno;

        }

        @Override
        protected void onPostExecute(String s) { //  onde sera retornado o return do doInBackground

            foodList = consumirJSON.JsonDados(s);
            exibirDados();

        }

        private void exibirDados() {
            if(foodList != null){
                for (comida food : foodList){

                    System.out.println(food.getNomeAlimento());

                    tv_mostra.append(food.getNomeAlimento()+"\n");


//                    TextView tv_titulo = new TextView(R.id.mainActivity);
//tv
                    //tv_mostra.append(food.getNomeAlimento()+"\n");
//                    setText(food.getNomeAlimento()+"\n"),setId("tv_titulo"+food.getNomeAlimento())
                }//setText(food.getNomeAlimento()+"\n");
            }

        }
    }


}







//
//
//
////import androidx.appcompat.app.AppCompatActivity;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.io.ByteArrayOutputStream;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//
//public class MainActivity extends AppCompatActivity {
//
//    private class AsyncTaskJSONPost extends AsyncTask<Integer, Integer, String> {
//        @Override
//        protected String doInBackground(Integer... integers) {
//            String resourceURI="http://10.7.101.157:5500/dados_para_android.json";
//            // String resourceURI = "https://jsonplaceholder.typicode.com/posts";
//            String formatedURL=resourceURI;
//            URL url = null;
//            try {
//                url = new URL(formatedURL);
//                HttpURLConnection con = (HttpURLConnection) url.openConnection();
//                con.setConnectTimeout(5000);
//                con.setRequestMethod("GET");
//                InputStream is=con.getInputStream();
//                //byte[] conteudo = new byte[is.available()];
//                //is.read(conteudo);
//                //return new String(conteudo);
//                java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
//                String response = s.hasNext() ? s.next() : "";
//                return response;
//            } catch (Exception e) {
//                Log.e("HTTP", e.getMessage());
//                e.printStackTrace();
//            }
//            return "OFFLINE";
//        }
//        @Override
//        protected void onPostExecute (String result) {
//            TextView v=findViewById(R.id.mainActivity);
//            v.setText(result);
//            Log.i("result", result);
//        }
//    }
//
//    private class AsyncTaskShowImage extends AsyncTask<String, Integer, byte[]> {
//        @Override
//        protected byte[] doInBackground(String... urls) {
//            String resourceURI=urls[0];
//            String formatedURL=resourceURI;
//            URL url = null;
//            try {
//                url = new URL(formatedURL);
//                HttpURLConnection con = (HttpURLConnection) url.openConnection();
//                con.setConnectTimeout(5000);
//                con.setRequestMethod("GET");
//                InputStream is=con.getInputStream();
//
//                ByteArrayOutputStream os= new ByteArrayOutputStream();
//                byte[] buffer = new byte[1024];
//                int bytesRead;
//                while ((bytesRead = is.read(buffer)) != -1) {
//                    os.write(buffer, 0, bytesRead);
//                }
//                byte[] conteudoImg = os.toByteArray();
//                File f = new File(getApplicationContext().getFilesDir(),"imagem_exemplo.png");
//                FileOutputStream fos = new FileOutputStream(f);
//                fos.write(conteudoImg);
//                fos.close();
//                return conteudoImg;
//            } catch (Exception e) {
//                Log.e("HTTP", e.getMessage());
//                e.printStackTrace();
//                try{
//                    File f = new File(getApplicationContext().getFilesDir(),"imagem_exemplo.png");
//                    FileInputStream fos = new FileInputStream(f);
//                    byte[] conteudo = new byte[fos.available()];
//                    fos.read(conteudo);
//                    fos.close();
//                    return conteudo;
//                }catch (Exception e1){
//                    e1.printStackTrace();
//                }
//            }
//            return null;
//        }
//        @Override
//        protected void onPostExecute (byte[] result) {
//            ImageView iv=findViewById(R.id.imageView);
//            Bitmap bmp= BitmapFactory.decodeByteArray(result,0,result.length);
//            iv.setImageBitmap(bmp);
//        }
//    }
//
//
//    class Categoria{
//        private String name;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//    class Produto{
//        private double preco;
//        private String nome;
//        private boolean ativo;
//        private Categoria categoria;
//        private Categoria[] subcategorias = new Categoria[2];
//
//        public double getPreco() {
//            return preco;
//        }
//
//        public void setPreco(double preco) {
//            this.preco = preco;
//        }
//
//        public String getNome() {
//            return nome;
//        }
//
//        public void setNome(String nome) {
//            this.nome = nome;
//        }
//
//        public boolean isAtivo() {
//            return ativo;
//        }
//
//        public void setAtivo(boolean ativo) {
//            this.ativo = ativo;
//        }
//
//        public Categoria getCategoria() {
//            return categoria;
//        }
//
//        public void setCategoria(Categoria categoria) {
//            this.categoria = categoria;
//        }
//
//        public Categoria[] getSubcategorias() {
//            return subcategorias;
//        }
//
//        public void setSubcategorias(Categoria[] subcategorias) {
//            this.subcategorias = subcategorias;
//        }
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Log.i("File", this.getApplicationContext().getFilesDir().getAbsolutePath());
//        String json = "";
//        Gson gson = new GsonBuilder().create();
//        new AsyncTaskJSONPost().execute();
//        new AsyncTaskShowImage().execute("https://img.ibxk.com.br/2014/05/08/08145827911459.png");
//
//        /*
//         Categoria c1 = new Categoria();
//        c1.setName("Software");
//        Categoria c2 = new Categoria();
//        c2.setName("Biblioteca");
//        Categoria c3 = new Categoria();
//        c3.setName("API");
//        Produto p = new Produto();
//        p.setNome("JSON Conversor");
//        p.setPreco(500000);
//        p.setAtivo(true);
//        p.setCategoria(c1);
//        Categoria[] subcategorias={c2, c3};
//        p.setSubcategorias(subcategorias);
//
//
//        json=gson.toJson(p);
//        */
//        File file = new File(this.getApplicationContext().getFilesDir(), "myfile.json");
//        try {
//            if (!file.exists()) {
//                FileOutputStream fos = new FileOutputStream(file);
//                DataOutputStream dos = new DataOutputStream(fos);
//                dos.write(json.getBytes() );
//            }
//            FileInputStream fis= new FileInputStream(file);
//            DataInputStream din= new DataInputStream(fis);
//            byte[] data= new byte[din.available()];
//            din.readFully(data);
//            String content= new String(data);
//            Produto p = gson.fromJson(content, Produto.class);
//            Log.i("File",file.getAbsolutePath());
//            Log.i("File",content);
//        }catch(FileNotFoundException e){
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//


