package br.com.sattra.viacep;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import br.com.sattra.model.*;
//import com.github.uliss3s.ceputil.Util;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.*;

/**
 * Classe para recuperar informações do WS do viacep.com.br
 */
public class ClienteWs {

    private static final Set<String> CAMPOS = new HashSet<String>(Arrays.asList(
    "cep",
    "logradouro",
    "complemento",
    "bairro",
    "localidade",
    "uf",
    "unidade",
    "ibge",
    "gia"
    ));

    /**
     * Recupera objeto Endereco pelo CEP
     * @param cep String no formato 00000000
     * @return instancia de br.com.viacep.Endereco
     */
    public static Endereco getEnderecoPorCep(String cep) {

    	
        JsonObject jsonObject = getCepResponse(cep);
        Endereco endereco = null;

        JsonValue erro = jsonObject.get("erro");

        if (erro == null) {

        	 endereco = new Endereco();
        	 endereco.setCep(jsonObject.getString("cep"));
        	 endereco.setLogradouro(jsonObject.getString("logradouro"));
        	 endereco.setComplemento(jsonObject.getString("complemento"));
        	 endereco.setBairro(jsonObject.getString("bairro"));
        	 endereco.setLocalidade(jsonObject.getString("localidade"));
        	 endereco.setUf(jsonObject.getString("uf"));
        	 endereco.setUnidade(jsonObject.getString("unidade"));
        	 endereco.setIbge(jsonObject.getString("ibge"));
        	 endereco.setGia(jsonObject.getString("gia"));
        	
        }
       
        return endereco;
    }

    /**
     * Recupera Map<String,String> pelo CEP
     * @param cep String no formato 00000000
     * @return instancia de Map<String,String>
     */
    public static Map<String, String> getMapPorCep(String cep) {

        JsonObject jsonObject = getCepResponse(cep);

        JsonValue erro = jsonObject.get("erro");

        Map<String, String> mapa = null;
        if (erro == null) {
            mapa = new HashMap<String, String>();

            for (Iterator<Map.Entry<String,JsonValue>> it = jsonObject.entrySet().iterator(); it.hasNext();) {
                Map.Entry<String,JsonValue> entry = it.next();
                mapa.put(entry.getKey(), entry.getValue().toString());
            }
        }

        return mapa;
    }

    private static JsonObject getCepResponse(String cep) {

        JsonObject responseJO = null;

        try {
          

            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("https://viacep.com.br/ws/"+cep+"/json");
            HttpResponse response = httpclient.execute(httpGet);

            HttpEntity entity = response.getEntity();

            responseJO = Json.createReader(entity.getContent()).readObject();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return responseJO;
    }
}


