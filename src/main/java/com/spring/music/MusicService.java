package com.spring.music;

import java.util.List;

public interface MusicService {
    public int insertMusic(MusicVO vo);
    public int deleteMusic(int sid);
    public int updateMusic(MusicVO vo);
    public MusicVO getMusic(int sid);
    public List<MusicVO> getMusicList();
}