package pl.core.tooliqapp.toolCard;

public class Result {
    private String title;
    private String comment;

    public Result(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }
}
