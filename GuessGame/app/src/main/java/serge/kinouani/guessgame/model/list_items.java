package serge.kinouani.guessgame.model;


public class list_items {

  private int imageFile;
  private String answer1;
    private String answer2;
  private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public list_items(int imageFile, String answer1, String answer2, String question) {
        this.imageFile = imageFile;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.question = question;
    }

    public int getImageFile() {
        return imageFile;
    }

    public void setImageFile(int imageFile) {
        this.imageFile = imageFile;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }




}
