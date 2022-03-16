package ro.unibuc.hello.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.hello.data.AccountEntity;
import ro.unibuc.hello.data.AccountRepository;
import ro.unibuc.hello.dto.Greeting;

@Controller
public class HelloWorldController
{
    @Autowired
    private AccountRepository accountRepository;
    private static final String helloTemplate = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name)
    {
        return new Greeting(counter.incrementAndGet(), String.format(helloTemplate, name));
    }

    @RequestMapping("/addAccount")
    @PostMapping("/addAccount")
    @ResponseBody
    public String addAccount(@RequestParam String name, @RequestParam String password)
    {
        AccountEntity Account = new AccountEntity(name, password);
        if (accountRepository.findAllByName(name).stream().count() == 0)
        {
            accountRepository.insert(Account);
            return accountRepository.findAllByName(name).toString();
        }
        else
        {
            return "Name allready in use";
        }
    }

    @RequestMapping("/Login")
    @GetMapping("/Login")
    @ResponseBody
    public String login(@RequestParam String name, @RequestParam String password)
    {
        AccountEntity Account = new AccountEntity(name, password);
        if (accountRepository.findAllByNameAndAndPassword(name, password).stream().count() == 1)
        {
            return "ESTI LOGAT FRATE";
        }
        else
        {
            return  "Invalid name + password combination";
        }
    }

    @RequestMapping("/allAccounts")
    @GetMapping("/allAccounts")
    @ResponseBody
    public String all() {
        return accountRepository.findAll().toString();
    }

    @RequestMapping("/update")
    @PutMapping("/update")
    @ResponseBody
    public String update(@RequestParam String name, @RequestParam String newName)
    {
        if(accountRepository.findAllByName(newName).stream().count() == 0)
        {
            accountRepository.changeName(newName, name);
            return accountRepository.findAllByName(newName).toString();
        }
        else
        {
            return "newName in use...";
        }
    }

    @RequestMapping("/DOOM")
    @ResponseBody
    public void Doom (){
        accountRepository.deleteAll();
    }
}
