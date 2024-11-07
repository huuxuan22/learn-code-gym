package com.example.ung_dung_nge_nhac.service;

import com.example.ung_dung_nge_nhac.model.song;

import java.util.List;

public interface IMusicAppService {
    List<song> selectAllSong();
    boolean add(song songs);
}
