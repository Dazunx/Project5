package com.example.service;

import com.example.music.MusicDAO;
import com.example.music.MusicVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MusicService {
    public int insertMusic(MusicVO vo);
    public int deleteMusic(int sid);
    public int updateMusic(MusicVO vo);
    public MusicVO getMusic(int sid);
    public List<MusicVO> getMusicList();
}
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