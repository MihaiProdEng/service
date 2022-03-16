package ro.unibuc.hello.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountEntityTest
{
    AccountEntity myAccount = new AccountEntity("Mihai", "54321");

    @Test
    void testToString()
    {
        Assertions.assertEquals("Account[id='null', name='Mihai', password='54321']", myAccount.toString());
    }
}