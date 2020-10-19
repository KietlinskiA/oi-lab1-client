
package pl.kietlinski.oilab1client.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "question",
    "answer1",
    "answer2",
    "answer3",
    "correctAnswer"
})
public class Question {

    @JsonProperty("id")
    private String id;
    @JsonProperty("question")
    private String question;
    @JsonProperty("answer1")
    private String answer1;
    @JsonProperty("answer2")
    private String answer2;
    @JsonProperty("answer3")
    private String answer3;
    @JsonProperty("correctAnswer")
    private String correctAnswer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("question")
    public String getQuestion() {
        return question;
    }

    @JsonProperty("question")
    public void setQuestion(String question) {
        this.question = question;
    }

    @JsonProperty("answer1")
    public String getAnswer1() {
        return answer1;
    }

    @JsonProperty("answer1")
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    @JsonProperty("answer2")
    public String getAnswer2() {
        return answer2;
    }

    @JsonProperty("answer2")
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    @JsonProperty("answer3")
    public String getAnswer3() {
        return answer3;
    }

    @JsonProperty("answer3")
    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    @JsonProperty("correctAnswer")
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    @JsonProperty("correctAnswer")
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
