package ro.unibuc.hello.data;

import org.springframework.stereotype.Component;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;

@Component
public class ProgramareEntity {

    @Id
    private String idCont;
    @Id
    public String idFilm;

    public String idData;
    public String loc;
}
