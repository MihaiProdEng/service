package ro.unibuc.hello.data;

import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Component
public class ProgramareEntity
{
    @Id
    private String idCont;
    @Id
    public String idFilm;

    public String data;
    public String loc;

    public ProgramareEntity() {
    }

    public ProgramareEntity(String idFilm, String data, String loc) {
        this.idCont = idCont;
        this.idFilm = idFilm;
        this.data = data;
        this.loc = loc;
    }
}
