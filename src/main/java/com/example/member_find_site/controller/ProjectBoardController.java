package com.example.member_find_site.controller;

import com.example.member_find_site.Service.PJBoardService;
import com.example.member_find_site.dto.PJBoardDTO;
import com.example.member_find_site.repository.PJBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectBoardController {
    private final PJBoardService pjBoardService;

    @GetMapping("/list")
    public String projectSelect() {



        return "/pages/pj_list";
    }

    @GetMapping("/write")
    public String projectWrite() {
        return "/pages/pj_write";
    }

    @PostMapping("/write")
    public String projectWrite(@ModelAttribute PJBoardDTO pjBoardDTO, MultipartFile file, Model model) throws Exception{

        pjBoardService.write(pjBoardDTO, file);

        return "/pages/pj_list";
    }
}
