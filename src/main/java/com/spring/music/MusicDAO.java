package com.spring.music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MusicDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertMusic(MusicVO vo) {
        String sql = "insert into Music (title, artist, album, genre, chart) values ("
                + "'" + vo.getTitle() + "',"
                + "'" + vo.getArtist() + "',"
                + "'" + vo.getAlbum() + "',"
                + "'" + vo.getGenre() + "',"
                + "'" + vo.getChart() + "')";
        return jdbcTemplate.update(sql);
    }

    public int deleteMusic(int sid) {
        String sql = "delete from Music where sid= " + sid;
        return jdbcTemplate.update(sql);
    }

    public int updateMusic(MusicVO vo) {
        String sql = "update Music set title='" + vo.getTitle() + "',"
                + "title='" + vo.getTitle() + "',"
                + "artist='" + vo.getArtist() + "',"
                + "album='" + vo.getAlbum() + "',"
                + "genre='" + vo.getGenre() + "',"
                + "chart='" + vo.getChart() + "' where sid=" +vo.getSid();
        return jdbcTemplate.update(sql);
    }

    public MusicVO getMusic(int sid) {
        String sql= "select * from Music where sid= " +sid;
        return jdbcTemplate.queryForObject(sql, new MusicRowMapper());
    }

    public List<MusicVO> getMusicList(){
        String sql = "select * from Music order by sid asc";
        System.out.println("hi");
        return jdbcTemplate.query(sql, new MusicRowMapper());
    }
}

class MusicRowMapper implements RowMapper<MusicVO>{
    @Override
    public MusicVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        MusicVO vo = new MusicVO();
        vo.setSid(rs.getInt("sid"));
        vo.setTitle(rs.getString("title"));
        vo.setArtist(rs.getString("artist"));
        vo.setAlbum(rs.getString("album"));
        vo.setGenre(rs.getString("genre"));
        vo.setChart(rs.getString("chart"));
        return vo;
    }
}