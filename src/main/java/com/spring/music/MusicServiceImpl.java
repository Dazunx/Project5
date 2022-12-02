package com.spring.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService{

    @Autowired
    MusicDAO musicDAO;

    @Override
    public int insertMusic(MusicVO vo){
        return musicDAO.insertMusic(vo);
    }
    @Override
    public int deleteMusic(int sid){
        return musicDAO.deleteMusic(sid);
    }
    @Override
    public int updateMusic(MusicVO vo){
        return musicDAO.updateMusic(vo);
    }
    @Override
    public MusicVO getMusic(int sid){
        return musicDAO.getMusic(sid);
    }
    @Override
    public List<MusicVO> getMusicList(){
        return musicDAO.getMusicList();
    }
}