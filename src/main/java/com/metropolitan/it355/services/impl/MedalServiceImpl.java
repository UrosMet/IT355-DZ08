package com.metropolitan.it355.services.impl;

import com.metropolitan.it355.entity.Medal;
import com.metropolitan.it355.repository.MedalRepository;
import com.metropolitan.it355.services.MedalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MedalServiceImpl implements MedalService {

    final MedalRepository medalRepository;


    @Override
    public List<Medal> getAll() {
        return  medalRepository.findAll();
    }

    @Override
    public Medal getMedal(Integer id) {
        return medalRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Not Found"));
    }

    @Override
    public Medal addMedal(Medal medal) {
        return medalRepository.save(medal);
    }

    @Override
    public Medal editMedal(Medal medal) {
        return medalRepository.save(medal);
    }

    @Override
    public void deleteMedal(Integer id) {
        medalRepository.deleteById(id);
    }

    @Override
    public List<Medal> findAllByMedalNameContainingIgnoreCase(String string) {
        return medalRepository.findAllByMedalNameContainingIgnoreCase(string);
    }
}
