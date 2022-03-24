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
    @Id
    public String data;
    @Id
    public String loc;

    public ProgramareEntity() {}

    public ProgramareEntity(String idCont, String idFilm, String data, String loc)
    {
        this.idCont = idCont;
        this.idFilm = idFilm;
        this.data = data;
        this.loc = loc;
    }

    public String getData()
    {
        return data;
    }

    public String getLoc()
    {
        return loc;
    }
}
