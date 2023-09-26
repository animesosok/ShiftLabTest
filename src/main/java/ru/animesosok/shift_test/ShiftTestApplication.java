package ru.animesosok.shift_test;

import org.apache.http.HttpEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpRequest;

@SpringBootApplication
public class ShiftTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiftTestApplication.class, args);
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Создаем объект HttpPost для указания метода POST и URL
            HttpPost httpPost = new HttpPost("http://localhost:8080/api/v1/intervals/merge?kind=letters");

            // Устанавливаем заголовок Content-Type для JSON
            httpPost.setHeader("Content-Type", "application/json");

            // Создаем JSON-строку для отправки
            String jsonInputString = "[[1, 3], [2,4], [10, 23]]";

            // Устанавливаем JSON-тело запроса
            StringEntity jsonEntity = new StringEntity(jsonInputString);
            httpPost.setEntity(jsonEntity);

            // Выполняем запрос и получаем ответ
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                // Получаем код ответа
                int statusCode = response.getStatusLine().getStatusCode();
                System.out.println("Response Code: " + statusCode);

                // Получаем тело ответа
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    String responseString = EntityUtils.toString(responseEntity);
                    System.out.println("Response Body: " + responseString);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
