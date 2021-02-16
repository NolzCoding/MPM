package io.github.NolzCoding.Untils;

import com.google.gson.Gson;
import io.github.NolzCoding.Untils.JSON.JSONFile;
import io.github.NolzCoding.Untils.JSON.JSONFileParent;
import io.github.NolzCoding.Untils.JSON.JSONSearch;

import java.io.BufferedInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileDownload {

    private Path path;

    private Gson gson = new Gson();

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public FileDownload(Path path) {
        this.path = path;
        System.out.println(path + "\\");
    }

    public String toBukkitURL(String name) {
        return "https://api.spiget.org/v2/search/resources/" + name;
    }

    private JSONFile searchForPlugin(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            return null;
        }
        String jsonString = response.body();
        jsonString = jsonString.replace("[", "");
        JSONFileParent fileParent = null;
        for (String string : jsonString.split("}")) {

            fileParent = gson.fromJson(string + "}" + "}", JSONFileParent.class);
            break;
        }
        if (fileParent != null) {
            return fileParent.getFile();
        }
        else {
            return null;
        }
    }

    public boolean downloadFile(String url, String name) {
        JSONFile jsonFile = searchForPlugin(url);
        if (jsonFile == null) {
            return true;
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOS = new FileOutputStream(path.toString() + "\\" + name + jsonFile.getType())) {
            byte[] data = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}