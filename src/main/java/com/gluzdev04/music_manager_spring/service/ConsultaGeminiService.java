package com.gluzdev04.music_manager_spring.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConsultaGeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    public String obterInformacao(String texto) {

        String urlApi = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request;

        try {
            ObjectMapper mapper = new ObjectMapper();

            ObjectNode rootNode = mapper.createObjectNode();
            ArrayNode contentsNode = rootNode.putArray("contents");
            ObjectNode contentItem = contentsNode.addObject();
            ArrayNode partsNode = contentItem.putArray("parts");
            ObjectNode textPart = partsNode.addObject();

            textPart.put("text", "Faça um resumo curto e informal sobre o artista/banda: " + texto);

            String jsonBody = mapper.writeValueAsString(rootNode);

            request = HttpRequest.newBuilder()
                    .uri(URI.create(urlApi))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return extrairTextoDaResposta(response.body());
            } else {
                System.out.println("Erro na chamada da API: " + response.statusCode());
                System.out.println("Resposta do Google: " + response.body());
                return "Erro na API: " + response.statusCode();
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar a IA", e);
        }
    }

    private static String extrairTextoDaResposta(String jsonResponse) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResponse);

            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (Exception e) {
            return "Não foi possível processar a resposta da IA.";
        }
    }
}