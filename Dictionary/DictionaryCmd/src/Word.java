public class Word {

    // TODO: khai bao cac thuoc tinh cho Word

    private String word_target;
    private String word_explain;

    // TODO: khai bao cac phuong thuc getter, setter cho Student

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
    /**
     * Constructor khởi tạo có tham số.
     */

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }
    /**
     * Constructor khởi tạo không tham số.
     */

    public Word() {
    }


}
