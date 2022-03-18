package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.Column;


@Component
public class AccountEntity
{

    @Id
    public String id;

    @Column(unique=true)
    public String name;
    public String password;

    public AccountEntity(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString()
    {
        return String.format(
                "Account[id='%s', name='%s', password='%s']",
                id, name, password);
    }
}
