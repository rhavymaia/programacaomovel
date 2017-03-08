package br.edu.ifpb.retrofit2app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Disponibiliza as assinaturas para acesso aos serviços do Sine.
 *
 * @author Rhavy Maia Guedes.
 */
public interface APIService {

    @GET("emprego?quantidade=10000")
    Call<List<Sine>> getSines();

    @GET("latitude/{latitude}/longitude/{longitude}/raio/100")
    Call<List<Sine>> getSinesComRaio(@Path("latitude") Long latitude, @Path("longitude") Long longitude);

    @GET("cod/{cod}")
    Call<List<Sine>> getSinePorCod(@Path("cod") String cod);
}