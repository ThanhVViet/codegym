package codegym.vn.entity;

import javax.persistence.*;

@Entity
@Table(name = "nasa")
public class Nasa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="`like`")
    private int like;
    @Column(name="dislike")
    private int dislike;

    @Column(name="author", columnDefinition = "nvarchar(100)")
    private String author;
    @Column(name="feedback", columnDefinition = "nvarchar(250)")
    private String feedback;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public Nasa(int id, String author, String feedback, int like, int dislike) {
        this.id = id;
        this.author = author;
        this.feedback = feedback;
        this.like = like;
        this.dislike = dislike;
    }

    public Nasa() {
    }
}
