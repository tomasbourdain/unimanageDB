package pt.iade.unimanager_db.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cursos")
public class Course {
    @Id @GeneratedValue
        (strategy = GenerationType.IDENTITY)
@Column(name="cur_id")
private int id;
@Column(name="cur_nome")
private String name;
@OneToMany @JoinColumn(name=
"pla_cur_id")
@JsonIgnoreProperties("course")
private List<Plan> plans;
public Course(int id,String name) {
    this.id=id;
    this.name=name;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String setName(String name){ 
        return this.name = name;
    }

}
