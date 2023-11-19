package com.example.proy1bueno.login_user.model;


import android.util.Log;

import com.example.proy1bueno.beans.User;
import com.example.proy1bueno.login_user.ContractLoginUser;
import com.example.proy1bueno.login_user.data.DataUser;
import com.example.proy1bueno.login_user.persenter.LoginUserPresenter;
import com.example.proy1bueno.utils.ApiService;
import com.example.proy1bueno.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserModel implements ContractLoginUser.Model {

    private static final String IP_BASE = "192.168.1.132:8080";
    private LoginUserPresenter presenter;
    public LoginUserModel(LoginUserPresenter presenter){
        this.presenter = presenter;
    }


    @Override
    public void loginAPI(User user, final ContractLoginUser.Model.OnLoginUserListener onLoginUserListener) {
        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);

// Realizar la solicitud al Servlet
        // Call<MyData> call = apiService.getMyData("1");
        Call<DataUser> call = apiService.getDataUser ("USER.LOGIN");
        call.enqueue(new Callback<DataUser>() {
            @Override
            public void onResponse(Call<DataUser> call, Response<DataUser> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquÃ­
                    DataUser dataUser = response.body();

                    //String message = myData.getMessage();

                    ArrayList<User> lstUsers = dataUser.getLstUsers();

                    onLoginUserListener.onFinished(lstUsers.get(0));

                    // Actualizar la interfaz de usuario con el mensaje recibido
                } else {
                    // Manejar una respuesta no exitosa
                    // Manejar una respuesta no exitosa
                    Log.e("Response Error", "CÃ³digo de estado HTTP: " + response.code());
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("Response Error", "Cuerpo de error: " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<DataUser> call, Throwable t) {
                // Manejar errores de red o del servidor
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }

}
