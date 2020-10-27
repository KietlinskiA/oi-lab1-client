package pl.kietlinski.oilab1client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kietlinski.oilab1client.model.Motto;
import pl.kietlinski.oilab1client.model.Question;
import pl.kietlinski.oilab1client.service.ClientServiceImpl;

@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientServiceImpl clientServiceImpl;

    @Autowired
    public ClientController(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }

    @GetMapping
    public String get() {
        return "index";
    }

    @GetMapping("/motto")
    public String getMotto(Model model) {
        Motto mottoFromServer = clientServiceImpl.getMottoFromServer();
        model.addAttribute("motto", mottoFromServer);
        return "motto";
    }


    @GetMapping("/quiz")
    public String getQuiz(Model model) {
        Question[] quizFromServer = clientServiceImpl.getQuizFromServer();
        model.addAttribute("questionList", quizFromServer);
        return "quiz";
    }

    @GetMapping("/checkAnswers")
    public String add(@RequestParam(required = false, defaultValue = "D") String question1,
                      @RequestParam(required = false, defaultValue = "D") String question2,
                      @RequestParam(required = false, defaultValue = "D") String question3,
                      @RequestParam(required = false, defaultValue = "D") String question4,
                      @RequestParam(required = false, defaultValue = "D") String question5,
                      Model model
    ) {
        int quizResultFromSerwer = clientServiceImpl.getQuizResultFromServer(question1, question2, question3, question4, question5);
        model.addAttribute("wynik", quizResultFromSerwer);
        return "result";
    }
}
