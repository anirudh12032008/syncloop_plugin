package packages.Spotify_Plugin.api;
import com.eka.middleware.service.DataPipeline;
import com.eka.middleware.service.ServiceUtils;
import com.eka.middleware.template.SnippetException;
import java.net.http.*;
import java.net.*;
import java.util.*;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
public final class episode_info{
	public static final void main(DataPipeline dataPipeline) throws SnippetException{
	try {
            String token = dataPipeline.getString("token");
            String xValue = dataPipeline.getString("episodes");

            String apiUrl = "https://api.spotify.com/v1/episodes/" + xValue;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Authorization", "Bearer " + token)
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
			JsonObject jsonResponse;
        try (JsonReader jsonReader = Json.createReader(new StringReader(response.body()))) {
            jsonResponse = jsonReader.readObject();
        }
            dataPipeline.put("apiResponse", jsonResponse);
            dataPipeline.put("statusCode", response.statusCode());
        } catch (Exception e) {
            dataPipeline.clear();
            dataPipeline.put("error", e.getMessage());
            new SnippetException(dataPipeline, "Snippet exception", new Exception(e));
        }
	}

}