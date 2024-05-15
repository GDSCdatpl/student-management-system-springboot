package se2.group2.controller;

import se2.group2.entity.Account;
import se2.group2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/login")
    public String login(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);

        return "login";
    }

    @PostMapping("/login")
    public String checkAccount(@ModelAttribute("account") Account account) {
        List<Account> listAccount = accountRepository.findAll();

        for (Account acc : listAccount) {
            if (account.getUsername().equals("student") && account.getPassword().equals(acc.getPassword())) {
            	GlobalModel.INSTANCE.put("sid", acc.studentId);
                return "redirect:/student/courses";
            }

            if ((account.getUsername().equals("teacher") || account.getUsername().equals("admin"))
                    && account.getPassword().equals(acc.getPassword())) {
                return "redirect:/courses";
            }
        }
        return "redirect:/login";
    }


}
