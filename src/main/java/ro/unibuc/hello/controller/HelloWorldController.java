package ro.unibuc.hello.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.hello.data.*;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWorldController
{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ProgramareRepository programareRepository;

    @Autowired
    MeterRegistry metricsRegistry;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/addAccount")
    @PostMapping("/addAccount")
    @ResponseBody
//    @Timed(value = "addAccount.time", description = "Time taken to return greeting")
    @Counted(value = "addAccount.count", description = "Times a new account was in the making")
    public String addAccount(@RequestParam String name, @RequestParam String password)
    {
        metricsRegistry.counter("my_non_aop_metric", "endpoint", "hello").increment(counter.incrementAndGet());
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
            return "ESTI LOGAT";
        }
        else
        {
            return  "Invalid name + password combination";
        }
    }

    @RequestMapping("/allAccounts")
    @GetMapping("/allAccounts")
    @ResponseBody
    public String allAccounts()
    {
        return accountRepository.findAll().toString();
    }

    @RequestMapping("/addMovie")
    @PostMapping("/addMovie")
    @ResponseBody
    public String addMovie(@RequestParam String movieName, @RequestParam String startTime)
    {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd HH:mm");
        try
        {
            Date date = formatter.parse(startTime);
            MovieEntity this_movie = new MovieEntity(movieName, date);

            movieRepository.insert(this_movie);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return movieRepository.findAll().toString();
    }

    @RequestMapping("/deleteMovies")
    @ResponseBody
    public String deleteMovies ()
    {
        movieRepository.deleteAll();
        return movieRepository.findAll().toString();
    }

    @RequestMapping("/addProgramare")
    @PostMapping()
    @ResponseBody
    public String addMovie(@RequestParam String accountName, @RequestParam String movieName , @RequestParam String date, @RequestParam String place)
    {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd HH:mm");
        try
        {
            Date movieDate = formatter.parse(date);
            ProgramareEntity this_programare = new ProgramareEntity(accountName, movieName, movieDate, place);
            programareRepository.insert(this_programare);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return programareRepository.findAllByIdCont(accountName).toString();
    }


    @RequestMapping("/allProgramari")
    @ResponseBody
    public String allProgramari () {
        return programareRepository.findAll().toString();
    }

    @RequestMapping("/DOOM")
    @ResponseBody
    public void Doom ()
    {
        accountRepository.deleteAll();
    }
}