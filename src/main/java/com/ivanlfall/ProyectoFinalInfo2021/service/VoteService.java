package com.ivanlfall.ProyectoFinalInfo2021.service;

import com.ivanlfall.ProyectoFinalInfo2021.dto.VoteDto;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Entrepreneurship;
import com.ivanlfall.ProyectoFinalInfo2021.entity.User;
import com.ivanlfall.ProyectoFinalInfo2021.entity.Vote;
import com.ivanlfall.ProyectoFinalInfo2021.entity.mapper.VoteMapper;
import com.ivanlfall.ProyectoFinalInfo2021.repository.EntrepreneurshipRepository;
import com.ivanlfall.ProyectoFinalInfo2021.repository.UserRepository;
import com.ivanlfall.ProyectoFinalInfo2021.repository.VoteRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final EntrepreneurshipRepository entrepreneurshipRepository;
    private final UserRepository userRepository;

    public VoteService(VoteRepository voteRepository, EntrepreneurshipRepository entrepreneurshipRepository, UserRepository userRepository) {
        this.voteRepository = voteRepository;
        this.entrepreneurshipRepository = entrepreneurshipRepository;
        this.userRepository = userRepository;
    }

    public Vote generate(Long userId, Long entrepreneurshipId, VoteDto voteDto){
        Vote vote = VoteMapper.mapToModel(voteDto);
        Entrepreneurship entrepreneurship = entrepreneurshipRepository.findById(entrepreneurshipId)
                .orElseThrow(() -> new EntityNotFoundException("Entrepreneurship not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        vote.setEntrepreneurship(entrepreneurship);
        vote.setUser(user);

        return voteRepository.save(vote);
    }
    public List<Vote> getAllByUser(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Vote> votes = voteRepository.findAll().stream()
                .filter(vote -> vote.getUser().equals(user))
                .collect(Collectors.toList());
        return votes;
    }
}
