package ro.unibuc.hello.data;

import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;

@Component
public class ProgramareEntity
{
    @Id
    private String idCont;
    @Id
    public String idFilm;
    @Id
    public Date data;
    @Id
    public String loc;

    public ProgramareEntity() {}

    public ProgramareEntity(String idCont, String idFilm, Date data, String loc)
    {
        this.idCont = idCont;
        this.idFilm = idFilm;
        this.data = data;
        this.loc = loc;
    }

    public Date getData()
    {
        return data;
    }

    public String getLoc()
    {
        return loc;
    }
}
