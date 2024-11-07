package com.example.ung_dung_nge_nhac.repository;

import com.example.ung_dung_nge_nhac.model.song;

import java.util.List;

public interface IMusicAppRepo {
    List<song>  selectAllSong();
    boolean add(song songs);
}
