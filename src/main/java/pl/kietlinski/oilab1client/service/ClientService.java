package pl.kietlinski.oilab1client.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.kietlinski.Motto;
import pl.kietlinski.oilab1client.model.Question;

@Service
public class ClientService {

    public Motto getMottoFromServer() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Motto> exchange = restTemplate.exchange(
                "http://localhost:8080/motto",
                HttpMethod.GET,
                null,
                Motto.class
        );
        return exchange.getBody();
    }

    public Question[] getQuizFromServer() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Question[]> exchange = restTemplate.exchange(
                "http://localhost:8080/quiz",
                HttpMethod.GET,
                null,
                Question[].class
        );
        return exchange.getBody();
    }

    public int getQuizResultFromServer(String question1, String  question2, String  question3, String  question4, String  question5) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = getUri(question1, question2, question3, question4, question5);
        ResponseEntity<Integer> exchange = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                Integer.class
        );
        return exchange.getBody();
    }

    public String getUri(String question1, String question2, String question3, String question4, String question5) {
        return UriComponentsBuilder
                    .fromUriString("http://localhost:8080/checkAnswers")
                    .queryParam("question1", question1)
                    .queryParam("question2", question2)
                    .queryParam("question3", question3)
                    .queryParam("question4", question4)
                    .queryParam("question5", question5)
                    .build()
                    .toUriString();
    }

}
