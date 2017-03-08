package br.edu.ifpb.retrofit2app;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Parâmetros de conexão com o Servidor.
 *
 * @author Rhavy Maia Guedes
 */
public class ConnectionServer {

    // Url base de conexão.
    private static final String URL_BASE =
            "http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/";

    private static APIService service;
    private static ConnectionServer selfInstance = new ConnectionServer();

    public static ConnectionServer getInstance() {
        // Instância da ConnectionServer
        return selfInstance;
    }

    public APIService getService() {
        return service;
    }

    private ConnectionServer() {
        updateServiceAdress();
    }

    public void updateServiceAdress() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(APIService.class);
    }
}