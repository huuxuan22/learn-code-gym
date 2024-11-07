package com.example.ung_dung_nge_nhac.service.impl;

import com.example.ung_dung_nge_nhac.model.song;
import com.example.ung_dung_nge_nhac.repository.IMusicAppRepo;
import com.example.ung_dung_nge_nhac.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicAppService implements IMusicAppService {
    @Autowired
    private IMusicAppRepo musicAppRepo;

    @Override
    public List<song> selectAllSong() {
        return musicAppRepo.selectAllSong();
    }

    @Override
    public boolean add(song songs) {
        return false;
    }
}
