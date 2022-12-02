package com.example.music;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MusicDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

/*
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
*/

    private final String MUSIC_INSERT = "insert into Music (title, artist, album, genre, chart) values (?,?,?,?,?)";
    private final String MUSIC_UPDATE = "update Music set title=?, artist=?, album=?, genre=?, chart=? where sid=?";
    private final String MUSIC_DELETE = "delete from Music  where sid=?";
    private final String MUSIC_GET = "select * from Music  where sid=?";
    private final String MUSIC_LIST = "select * from Music order by sid asc";

    public int insertMusic(MusicVO vo) {
        return jdbcTemplate.update(MUSIC_INSERT, new
                Object[]{vo.getTitle(), vo.getArtist(), vo.getAlbum()});
    }

    // 글 삭제
    public int deleteMusic(int sid) {
        return jdbcTemplate.update(MUSIC_DELETE,
                new Object[]{sid});
    }
    public int updateMusic(MusicVO vo) {
        return jdbcTemplate.update(MUSIC_UPDATE,
                new Object[]{vo.getTitle(), vo.getArtist(), vo.getAlbum()});
    }

    public MusicVO getMusic(int sid) {
        return jdbcTemplate.queryForObject(MUSIC_GET,
                new Object[] {sid},
                new BeanPropertyRowMapper<MusicVO>(MusicVO.class));
    }

    public List<MusicVO> getMusicList(){
        return jdbcTemplate.query(MUSIC_LIST, new RowMapper<MusicVO>() {
            public MusicVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                MusicVO vo = new MusicVO();
                vo.setSid(rs.getInt("sid"));
                vo.setTitle(rs.getString("title"));
                vo.setRegdate(rs.getDate("regdate"));
                vo.setArtist(rs.getString("artist"));
                return vo;
            }
        });
    }
}