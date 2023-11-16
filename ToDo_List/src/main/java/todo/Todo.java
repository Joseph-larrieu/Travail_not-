package todo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Todo {
    @Id
    private Long ID;
    private Sring content;
    private boolean etat;
    private Date creation;


    public Todo(Long ID, Sring content, boolean etat, Date creation) {
        this.ID = ID;
        this.content = content;
        this.etat = etat;
        this.creation = creation;
    }

}
    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Sring getContent() {
        return this.content;
    }

    public void setContent(Sring content) {
        this.content = content;
    }

    public boolean isEtat() {
        return this.etat;
    }

    public boolean getEtat() {
        return this.etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Date getCreation() {
        return this.creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }
