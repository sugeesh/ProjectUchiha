package lk.aduwata.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Sugeesh Chandraweera
 */
@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CommentID")
    private Integer commentId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Date")
    private Date date;

    public Comment(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
