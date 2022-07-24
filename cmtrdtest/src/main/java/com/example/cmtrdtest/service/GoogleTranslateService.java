package com.example.cmtrdtest.service;


import org.apache.commons.lang3.StringUtils;
import lombok.SneakyThrows;
import okhttp3.*;
import org.springframework.stereotype.Service;



@Service
public class GoogleTranslateService {

    OkHttpClient client = new OkHttpClient();

    @SneakyThrows
    public String googleTranslate(String lang) {


        RequestBody body = new FormBody.Builder()
                .add("q", "Hello, world!")
                .add("target", lang)
                .add("source", "en")
                .build();

        Request request = new Request.Builder()
                .url("https://google-translate1.p.rapidapi.com/language/translate/v2")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("Accept-Encoding", "application/gzip")
                .addHeader("X-RapidAPI-Key", "5a87f997f9msh9fbed14d05a516bp1fee45jsn3ddd65da86ae")
                .addHeader("X-RapidAPI-Host", "google-translate1.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            return "translation is not successful";
        }

        return StringUtils.substringBetween(response.body().string(), "\"translatedText\":", "}");
    }
}