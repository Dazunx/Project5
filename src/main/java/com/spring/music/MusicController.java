package com.example.music;

import com.example.service.MusicServiceImpl;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/music")
public class MusicController {
    @Autowired
    MusicServiceImpl musicService;

    @RequestMapping(value = "/musiclist", method = RequestMethod.GET)
    public String musicList(Model model) {
        model.addAttribute("list",musicService.getMusicList());
        return list;
    }
    @Autowired
    MusicDAO musicDAO;

    @RequestMapping("/")
    public String home(){
        return "redirect:music/list";
    }

    @RequestMapping(value = "/music/list", method = RequestMethod.GET)
    public String musiclist(Model model){
        System.out.println("데이터 목록 출력!");
        model.addAttribute("list",musicDAO.getMusicList());
        return "posts";
    }

    @RequestMapping(value = "music/add", method = RequestMethod.POST)
    public String addPost(){
        return "addform";
    }
    @RequestMapping(value = "music/addok", method = RequestMethod.POST)
    public String addPostOK(MusicVO vo){
        int i= musicDAO.insertMusic(vo);
        if(i==0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공!!");
        return "redirect:list";
    }

    @RequestMapping(value = "music/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id"), Integer id,  Model model){
        MusicVO musicVO = musicService.getMusic(id);
        model.addAttribute("u",musicVO);
        return "editform";
    }

    @RequestMapping(value = "music/editok", method = RequestMethod.POST)
    public String editPostOK(MusicVO vo){
        int i= musicService.updateMusic(vo);
        if(i==0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공!!");
        return "redirect:list";
    }


    @RequestMapping(value = "music/deleteok/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id"), int id){
        int i= musicService.deleteMusic(id);
        if(i==0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공!!");
        return "redirect:../list";
    }

}

