package pl.kietlinski.oilab1client.service;

import pl.kietlinski.oilab1client.model.Motto;
import pl.kietlinski.oilab1client.model.Question;

public interface ClientService {

    Motto getMottoFromServer();

    Question[] getQuizFromServer();

    int getQuizResultFromServer(String question1, String question2, String question3, String question4, String question5);

    String getUri(String question1, String question2, String question3, String question4, String question5);

}
