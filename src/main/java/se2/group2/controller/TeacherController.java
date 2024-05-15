package se2.group2.controller;

import se2.group2.entity.Teacher;
import se2.group2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public String listTeachers(Model model) {
        model.addAttribute("teachers", teacherRepository.findAll());
        return "teachers";
    }

    @GetMapping("/teachers/new")
    public String createTeacherForm(Model model) {
        // create teacher object to hold student form data
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "create_teacher";
    }

    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/edit/{id}")
    public String editTeacherForm(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", teacherRepository.findById(id).get());
        return "edit_teacher";
    }

    @PostMapping("/teachers/{id}")
    public String updateTeacher(@PathVariable Long id,
                                @ModelAttribute("teacher") Teacher teacher,
                                Model model) {

        // get teacher from database by id
        Teacher existingStudent = teacherRepository.findById(id).get();
        existingStudent.setId(id);
        existingStudent.setName(teacher.getName());
        existingStudent.setUsername(teacher.getUsername());
        existingStudent.setPassword(teacher.getPassword());
        existingStudent.setIsDisabled(teacher.getIsDisabled());


        // save updated teacher object
        teacherRepository.save(existingStudent);
        return "redirect:/teachers";
    }


    @GetMapping("/teachers/disable/{id}")
    public String disableTeacher(@PathVariable Long id) {
        final Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            final Teacher teacher = teacherOptional.get();
            teacher.setIsDisabled(true);
            teacherRepository.save(teacher);
        }
        return "redirect:/teachers";
    }

}
